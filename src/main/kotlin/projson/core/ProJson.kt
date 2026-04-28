package projson.core

import projson.model.JsonArray
import projson.model.JsonNull
import projson.model.JsonObject
import projson.model.JsonPrimitive
import projson.model.JsonValue

/**
 * Esta classe é o motor principal da biblioteca ProJson, que transforma objetos em um JsonValue,
 * permite customizar a forma como os resultados são apresentados através de plugins e anotações,
 * permite fazer referencia a objetos evitando assim repetições, atribui um id único a cada objeto.
 */
class ProJson {

    private val refs = mutableMapOf<Any, String>()

    fun toJson(obj: Any?): JsonValue {
        if (obj == null)
            return JsonNull()
        if (obj is JsonValue)
            return obj
        if (obj is Boolean || obj is Number || obj is String)
            return JsonPrimitive(obj)
        if (obj is Map<*, *>) {
            val jobj = JsonObject()
            obj.forEach { (key, value) ->
                jobj.setProperty(key.toString(), toJson(value))
            }
            return jobj
        }
        if (obj is Collection<*>) {
            val array = JsonArray()
            obj.forEach { item ->
                array.add(toJson(item))
            }
            return array
        }
        val kClass = obj.javaClass
        if(kClass.isAnnotationPresent(JsonString::class.java)) {
            val annotation = kClass.getAnnotation(JsonString::class.java)
            val serializerClass = annotation.DateToText
            val serializerInstance = serializerClass.java.getDeclaredConstructor().newInstance() as DateToText
            val stringResult = serializerInstance.toJsonString(obj)
            return JsonPrimitive(stringResult)
        }
        return objectToJson(obj)
    }

    private fun objectToJson(obj: Any): JsonObject {
        if(refs.contains(obj)) {
            val refObj = JsonObject()
            refObj.setProperty("\$ref", JsonPrimitive(refs[obj]))
            return refObj
        }

        val novoId = java.util.UUID.randomUUID().toString()
        refs[obj] = novoId

        val jobj = JsonObject()
        val kClass = obj.javaClass
            jobj.setProperty("\$id", JsonPrimitive(novoId))
        jobj.setProperty("\$type", JsonPrimitive(kClass.simpleName))

        kClass.declaredFields.forEach { field ->
            field.isAccessible = true
            if (field.isAnnotationPresent(JsonIgnore::class.java))
                return@forEach
            val fieldValue = field.get(obj)
            val jsonProperty = field.getAnnotation(JsonProperty::class.java)
            val finalName = jsonProperty?.name ?: field.name
            jobj.setProperty(finalName, toJson(fieldValue))}
        return jobj
    }
}
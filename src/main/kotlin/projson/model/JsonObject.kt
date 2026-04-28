package projson.model

/**
 * Representa os objetos JSON numa estrutura de pares de chave-valor, onde cada chave é uma String e cada valor é
 * um JasonValue.
 */

class JsonObject: JsonValue() {

    private val properties = mutableMapOf<String, JsonValue?>()

    fun setProperty(name: String, value: JsonValue?) {
        properties[name] = value
    }

    fun removeProperty(name: String) {
        properties.remove(name)
    }

    fun getProperty(name: String): JsonValue? = properties[name]

    override fun toJsonString(indent: String): String {
        val nextIndent = indent + "  "
        val content = properties.map { (key, value) ->
            "\n$nextIndent\"$key\": ${value?.toJsonString(nextIndent) ?: "null"}"
        }.joinToString(", ")

        return "{$content\n$indent}"
    }

    override fun toString(): String = toJsonString()

}
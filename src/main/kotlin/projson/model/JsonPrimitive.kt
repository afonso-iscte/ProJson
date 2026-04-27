package projson.model

/**
 * Representa valores básicos do JSON em Strings, Números, Boleanos, etc..
 */

class JsonPrimitive(val value: Any?): JsonValue() {

    override fun toJsonString(indent: String): String {
        if(value is String)
            return "\"$value\""
        if(value == null)
            return "null"
        else
            return value.toString()
    }

    override fun toString(): String = toJsonString()
}
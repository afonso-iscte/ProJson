package projson.model

/**
 * Representa o valor null em formato JSON.
 */

class JsonNull : JsonValue() {
    override fun toJsonString(indent: String): String = "null"

    override fun toString(): String = toJsonString()
}
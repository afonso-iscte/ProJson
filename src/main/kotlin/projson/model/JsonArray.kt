package projson.model

/**
 * Representa um array JSON, onde podem ser armazenados diversos JsonValue.
 */

class JsonArray: JsonValue() {
    private val array = mutableListOf<JsonValue?>()

    fun add(value: JsonValue?) {
        array.add(value)
    }

    override fun toJsonString(indent: String): String {
        val lista = array.joinToString(", ") {it?.toJsonString()?: "null"}
        return "[$lista]"
    }

    override fun toString(): String = toJsonString()
}
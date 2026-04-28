package projson.model

/**
 * Representa um array JSON, onde podem ser armazenados diversos JsonValue.
 */

class JsonArray: JsonValue() {
    private val array = mutableListOf<JsonValue?>()

    fun add(value: JsonValue?) {
        array.add(value)
    }

    fun remove(index: Int) {
        array.removeAt(index)
    }

    fun set(index: Int, value: JsonValue) {
        if (index in array.indices) array[index] = value
    }

    override fun toJsonString(indent: String): String {
        val lista = array.joinToString(", ") {it?.toJsonString()?: "null"}
        return "[$lista]"
    }

    override fun toString(): String = toJsonString()
}
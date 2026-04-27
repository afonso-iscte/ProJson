package projson.model

/**
 * Classe abstrata que representa a base de todos os outros elementos JSON.
 */

abstract class JsonValue {

    abstract fun toJsonString(indent: String = ""): String

    override fun toString(): String = toJsonString()
}
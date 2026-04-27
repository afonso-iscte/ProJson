package projson.core

/**
 * Interface que permite que uma classe seja representada como uma string.
 */

interface DateToText {
    fun toJsonString(obj: Any): String
}
package projson.model

import projson.core.DateToText

/**
 * Plugin que permite representar objetos do tipo Date no formato String.
 */

class DateAsText: DateToText {
    override fun toJsonString(obj: Any): String {
        val date = obj as Date
        return "${date.day}/${date.month}/${date.year}"
    }
}
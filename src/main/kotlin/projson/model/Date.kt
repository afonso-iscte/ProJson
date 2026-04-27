package projson.model

import projson.core.JsonString

/**
 * Classe de dados que representa uma data simples.
 */

//@JsonString(DateAsText::class)
data class Date(
    val day: Int,
    val month: Int,
    val year: Int
)
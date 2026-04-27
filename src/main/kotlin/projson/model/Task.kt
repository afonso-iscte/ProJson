package projson.model

import projson.core.Reference

/**
 * Representa uma tarefa que pode ter dependências de outras tarefas.
 */

class Task(
    val description: String,
    val deadline: Date?,
    @Reference
    val dependencies: List<Task>
)
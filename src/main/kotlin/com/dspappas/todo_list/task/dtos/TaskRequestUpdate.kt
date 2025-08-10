package com.dspappas.todo_list.task.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class TaskRequestUpdate(

    @field: NotEmpty(message = "'Name' is required")
    val name: String,

    @field: NotNull(message = "'Is Completed' is required")
    val isCompleted: Boolean
)

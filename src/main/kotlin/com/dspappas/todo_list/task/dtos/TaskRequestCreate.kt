package com.dspappas.todo_list.task.dtos

import jakarta.validation.constraints.NotEmpty

data class TaskRequestCreate(

    @field: NotEmpty(message = "'Name' is required")
    val name: String
)

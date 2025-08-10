package com.dspappas.todo_list.task.dtos

import java.util.UUID

data class TaskResponse(

    val id: UUID,
    val name: String,
    val isCompleted: Boolean
)

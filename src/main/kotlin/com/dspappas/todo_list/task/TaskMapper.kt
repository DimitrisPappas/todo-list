package com.dspappas.todo_list.task

import com.dspappas.todo_list.task.dtos.TaskResponse
import org.springframework.stereotype.Component

@Component
class TaskMapper() {

    fun fromRequestToEntity(
        name: String,
        isCompleted: Boolean
    ): Task {
        return Task(
            name = name,
            isCompleted = isCompleted
        )
    }

    fun fromEntityToResponse(
        entity: Task
    ): TaskResponse {
        return TaskResponse(
            id = entity.id,
            name = entity.name,
            isCompleted = entity.isCompleted
        )
    }

    fun fromEntityListToResponseList(
        entityList: List<Task>
    ): List<TaskResponse> {
        return entityList.map { e -> fromEntityToResponse(e) }
    }
}
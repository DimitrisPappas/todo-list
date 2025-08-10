package com.dspappas.todo_list.task

import com.dspappas.todo_list.task.dtos.TaskRequestCreate
import com.dspappas.todo_list.task.dtos.TaskRequestUpdate
import com.dspappas.todo_list.task.dtos.TaskResponse
import org.springframework.stereotype.Component

@Component
class TaskMapper() {

    fun fromRequestCreateToEntity(
        request: TaskRequestCreate
    ): Task {
        return Task(
            name = request.name
        )
    }

    fun fromRequestUpdateToEntity(
        request: TaskRequestUpdate,
        task: Task
    ): Task {
        task.name = request.name
        task.isCompleted = request.isCompleted
        return task
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
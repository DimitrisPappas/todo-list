package com.dspappas.todo_list.task

import com.dspappas.todo_list.task.dtos.TaskRequestCreate
import com.dspappas.todo_list.task.dtos.TaskResponse
import jakarta.validation.Valid
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

private const val BASE_PATH = "api/v1/tasks"
private val log = KotlinLogging.logger {  }

@RestController
@RequestMapping(BASE_PATH)
class TaskController(
    private val taskService: TaskService,
    private val taskMapper: TaskMapper
) {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<TaskResponse>> {
        val result = taskService.getTasks()
        val response = taskMapper.fromEntityListToResponseList(result)
        log.info { "Successfully fetched all tasks" }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{taskId}")
    fun getTask(
        @PathVariable("taskId") taskId: UUID
    ): ResponseEntity<TaskResponse> {
        val result = taskService.getTaskById(taskId)
        val response = taskMapper.fromEntityToResponse(result)
        log.info { "Successfully fetched task with id $taskId" }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/name/{taskName}")
    fun getTask(
        @PathVariable("taskName") taskName: String
    ): ResponseEntity<TaskResponse> {
        val result = taskService.getTaskByName(taskName)
        val response = taskMapper.fromEntityToResponse(result)
        log.info { "Successfully fetched task with name $taskName" }
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createTask(
        @Valid @RequestBody request: TaskRequestCreate
    ): ResponseEntity<TaskResponse> {
        val result = taskService.createTask(request)
        val response = taskMapper.fromEntityToResponse(result)
        log. info { "Successfully create task" }
        return ResponseEntity.accepted().body(response)
    }

}
package com.dspappas.todo_list.task

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    fun getTasks(): List<Task> {
        return taskRepository.findAll()
    }

    fun getTaskById(id: UUID): Task {
        return taskRepository.findById(id).orElseThrow {
            RuntimeException("Task not found")
        }
    }

    fun getTaskByName(name: String): Task {
        return taskRepository.findByName(name).orElseThrow {
            RuntimeException("Task not found")
        }
    }
}
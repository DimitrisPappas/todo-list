package com.dspappas.todo_list.task

import com.dspappas.todo_list.task.dtos.TaskRequestCreate
import com.dspappas.todo_list.task.dtos.TaskRequestUpdate
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TaskService(
    private val taskRepository: TaskRepository,
    private val taskMapper: TaskMapper
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

    fun createTask(request: TaskRequestCreate): Task {
        val task = taskMapper.fromRequestCreateToEntity(request)
        return taskRepository.saveAndFlush(task)
    }

    @Transactional
    fun updateTask(request: TaskRequestUpdate, id: UUID): Task {
        val existing = getTaskById(id)
        val updated = taskMapper.fromRequestUpdateToEntity(request, existing)
        return taskRepository.saveAndFlush(updated)
    }

    @Transactional
    fun deleteTask(id: UUID) {
        return taskRepository.deleteById(id)
    }
}
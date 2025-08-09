package com.dspappas.todo_list.task

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskRepository : JpaRepository<Task, UUID> {

    fun findByName(name: String): Optional<Task>
}
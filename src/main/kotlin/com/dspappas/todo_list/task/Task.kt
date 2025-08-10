package com.dspappas.todo_list.task

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tasks")
class Task(

    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    var id: UUID = UUID.randomUUID(),

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "is_completed", nullable = false)
    var isCompleted: Boolean = false
) {
}
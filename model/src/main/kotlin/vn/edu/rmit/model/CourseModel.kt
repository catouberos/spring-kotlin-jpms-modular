package vn.edu.rmit.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "course")
class CourseModel(
    @Id
    var id: Long,
)

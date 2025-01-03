package vn.edu.rmit.repository

import org.springframework.data.jpa.repository.JpaRepository
import vn.edu.rmit.model.CourseModel

interface CourseRepository : JpaRepository<CourseModel, Long> {
    fun existsById(id: Long?): Boolean

    fun existsByName(name: String?): Boolean
}

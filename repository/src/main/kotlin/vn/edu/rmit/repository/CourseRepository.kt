package vn.edu.rmit.repository

import org.springframework.data.jpa.repository.JpaRepository
import vn.edu.rmit.model.CourseModel

interface CourseRepository : JpaRepository<CourseModel, Long>

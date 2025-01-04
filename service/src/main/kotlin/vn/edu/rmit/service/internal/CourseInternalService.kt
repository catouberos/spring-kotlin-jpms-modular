package vn.edu.rmit.service.internal

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import vn.edu.rmit.dto.course.CourseResponseDto
import vn.edu.rmit.dto.course.internal.CourseInternalDto
import vn.edu.rmit.dto.course.internal.CourseInternalNullableDto

interface CourseInternalService {
    fun find(id: Long): CourseResponseDto

    fun findAll(pageable: Pageable): Page<CourseResponseDto>

    fun save(dto: CourseInternalDto): CourseResponseDto

    fun exists(dto: CourseInternalNullableDto): Boolean

    fun delete(id: Long): Boolean
}

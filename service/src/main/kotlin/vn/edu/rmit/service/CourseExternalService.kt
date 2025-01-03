package vn.edu.rmit.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import vn.edu.rmit.dto.CourseCreateDto
import vn.edu.rmit.dto.CourseMinimalDto
import vn.edu.rmit.dto.CourseResponseDto
import vn.edu.rmit.dto.CourseUpdateDto

interface CourseExternalService {
    fun get(dto: CourseMinimalDto): CourseResponseDto

    fun getPageable(pageable: Pageable): Page<CourseResponseDto>

    fun create(dto: CourseCreateDto): CourseResponseDto

    fun update(dto: CourseUpdateDto): CourseResponseDto

    fun delete(dto: CourseMinimalDto): Boolean
}

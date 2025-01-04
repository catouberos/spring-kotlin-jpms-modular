package vn.edu.rmit.dto.course

import java.io.Serializable

data class CourseResponseDto(
    val id: Long,
    val name: String,
) : Serializable

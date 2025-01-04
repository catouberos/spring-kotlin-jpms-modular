package vn.edu.rmit.service.internal

import vn.edu.rmit.dto.course.CourseCreateDto
import vn.edu.rmit.dto.course.CourseResponseDto
import vn.edu.rmit.dto.course.internal.CourseInternalDto
import vn.edu.rmit.model.CourseModel

fun CourseInternalDto.toModel() =
    CourseModel(
        name = name,
    )

fun CourseModel.toResponseDto() =
    CourseResponseDto(
        id = id,
        name = name,
    )

fun CourseCreateDto.toInternalDto() =
    CourseInternalDto(
        name = name,
    )

fun CourseResponseDto.toInternalDto() =
    CourseInternalDto(
        id = id,
        name = name,
    )

package vn.edu.rmit.service.internal

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import vn.edu.rmit.dto.CourseCreateDto
import vn.edu.rmit.dto.CourseMinimalDto
import vn.edu.rmit.dto.CourseResponseDto
import vn.edu.rmit.dto.CourseUpdateDto
import vn.edu.rmit.dto.internal.CourseInternalDto
import vn.edu.rmit.dto.internal.CourseInternalNullableDto
import vn.edu.rmit.model.CourseModel
import vn.edu.rmit.repository.CourseRepository
import vn.edu.rmit.service.CourseExternalService

@Service
internal class CourseServiceImpl(
    private val repository: CourseRepository,
) : CourseExternalService,
    CourseInternalService {
    // INTERNAL implementations
    override fun find(id: Long): CourseResponseDto {
        if (!exists(CourseInternalNullableDto(id = id))) {
            error("Course with ID $id doesn't exists")
        }
        val model = repository.findById(id).get()
        return model.toResponseDto()
    }

    override fun findAll(pageable: Pageable): Page<CourseResponseDto> = repository.findAll(pageable).map { it.toResponseDto() }

    override fun save(dto: CourseInternalDto): CourseResponseDto {
        val response = repository.save(dto.toModel())
        return response.toResponseDto()
    }

    override fun exists(dto: CourseInternalNullableDto): Boolean =
        when {
            dto.id !== null && repository.existsById(dto.id) -> true
            dto.name !== null && repository.existsByName(dto.name) -> true
            else -> false
        }

    override fun delete(id: Long): Boolean {
        if (!exists(CourseInternalNullableDto(id = id))) {
            error("Course with ID $id doesn't exists")
        }
        repository.deleteById(id)
        return true
    }

    // EXTERNAL implementations
    override fun get(dto: CourseMinimalDto): CourseResponseDto = find(dto.id)

    override fun getPageable(pageable: Pageable): Page<CourseResponseDto> = findAll(pageable)

    override fun create(dto: CourseCreateDto): CourseResponseDto {
        if (!exists(CourseInternalNullableDto(name = dto.name))) {
            error("Course with name ${dto.name} already exists")
        }

        return save(dto.toInternalDto())
    }

    override fun update(dto: CourseUpdateDto): CourseResponseDto {
        if (!exists(CourseInternalNullableDto(id = dto.id))) {
            error("Course with ID ${dto.id} doesn't exists")
        }

        // partial update
        val model = get(dto = CourseMinimalDto(id = dto.id))

        return save(
            model
                .copy(
                    name = dto.name ?: model.name,
                ).toInternalDto(),
        )
    }

    override fun delete(dto: CourseMinimalDto): Boolean = delete(dto.id)
}

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

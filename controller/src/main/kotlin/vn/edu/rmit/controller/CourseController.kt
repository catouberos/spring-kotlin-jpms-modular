package vn.edu.rmit.controller

import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vn.edu.rmit.dto.CourseResponseDto
import vn.edu.rmit.service.CourseExternalService

@RequestMapping("/api/course")
@RestController
class CourseController(
    private val service: CourseExternalService,
) {
    @GetMapping("/list")
    fun list(pageable: Pageable): ResponseEntity<PagedModel<CourseResponseDto>> {
        val response = service.getPageable(pageable)

        return ResponseEntity.ok(PagedModel(response))
    }
}

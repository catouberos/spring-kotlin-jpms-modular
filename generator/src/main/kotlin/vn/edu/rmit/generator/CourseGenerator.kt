package vn.edu.rmit.generator

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import vn.edu.rmit.dto.course.CourseCreateDto
import vn.edu.rmit.service.CourseExternalService

@Component
internal class CourseGenerator(
    private val service: CourseExternalService,
) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        this.initialiseCourse()
    }

    fun initialiseCourse() {
        val course: List<CourseCreateDto> =
            listOf(
                CourseCreateDto(name = "Piano"),
                CourseCreateDto(name = "Wing Chun"),
            )

        course.forEach {
            service.create(it)
        }
    }
}

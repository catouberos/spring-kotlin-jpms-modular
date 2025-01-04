package vn.edu.rmit.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableCaching
@EnableJpaRepositories("vn.edu.rmit.repository")
@EntityScan("vn.edu.rmit.model")
@SpringBootApplication(
    scanBasePackages = [
        "vn.edu.rmit.controller",
        "vn.edu.rmit.service",
        "vn.edu.rmit.repository",
        "vn.edu.rmit.model",
        "vn.edu.rmit.generator",
    ],
)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

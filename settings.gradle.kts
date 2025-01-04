rootProject.name = "spring-mm"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

include("application", "model", "repository", "service", "dto", "controller", "generator")

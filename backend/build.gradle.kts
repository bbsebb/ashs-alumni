plugins {
    id("java")
    id("org.springframework.boot") version "3.5.4" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}


allprojects {
    group = "fr.hoenheimsports"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}
val mapstructVersion = "1.6.3"
val lombokMapstructBindingVersion = "0.2.0"

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    dependencies {

        // Dépendances communes Spring Boot (pour les modules qui en ont besoin)
        if (name.contains("infrastructure") || name == "app") {

            implementation("org.springframework.boot:spring-boot-starter-web")
            implementation("org.springframework.boot:spring-boot-starter-test")
            implementation("org.springframework.boot:spring-boot-starter-actuator")
            implementation("org.flywaydb:flyway-core")
            implementation("org.flywaydb:flyway-database-postgresql")
            implementation("org.springframework.boot:spring-boot-starter-data-jpa")
            implementation("org.springframework.boot:spring-boot-starter-validation")
            runtimeOnly("org.postgresql:postgresql")
            runtimeOnly("io.micrometer:micrometer-registry-prometheus")
            runtimeOnly("org.springframework.boot:spring-boot-docker-compose")
            compileOnly("org.projectlombok:lombok")
            annotationProcessor("org.projectlombok:lombok")
            // MapStruct
            implementation("org.mapstruct:mapstruct:$mapstructVersion")
            annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

            // Bridge Lombok <-> MapStruct
            annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBindingVersion")

            testImplementation("org.springframework.boot:spring-boot-testcontainers")

            testImplementation("org.testcontainers:junit-jupiter")
            testImplementation("org.testcontainers:postgresql")

            implementation("org.springframework.boot:spring-boot-starter-security")
            implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
            testImplementation("org.springframework.security:spring-security-test")
        }

        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testImplementation("org.assertj:assertj-core:3.24.2")
        testImplementation("org.mockito:mockito-core:5.5.0")
        testImplementation("org.mockito:mockito-junit-jupiter:5.5.0")
    }

    tasks.test {
        useJUnitPlatform()
    }
}
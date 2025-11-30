plugins {
    id("java")
    id("org.springframework.boot")
}

group = "fr.hoenheimsports"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val mapstructVersion = "1.6.3"
val lombokMapstructBindingVersion = "0.2.0"
val testcontainersVersion = "1.20.4"
dependencies {
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.12")
    implementation("com.github.loki4j:loki-logback-appender:2.0.1")
    // MapStruct
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

    // Bridge Lombok <-> MapStruct
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBindingVersion")

    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.testcontainers:junit-jupiter:${testcontainersVersion}")
    testImplementation("org.testcontainers:postgresql:${testcontainersVersion}")
// Il est souvent nécessaire de forcer le noyau aussi pour éviter les conflits
    testImplementation("org.testcontainers:testcontainers:${testcontainersVersion}")
    testImplementation("net.java.dev.jna:jna:5.14.0")
    testImplementation("net.java.dev.jna:jna-platform:5.14.0")

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("com.c4-soft.springaddons:spring-addons-oauth2-test:6.1.0")


    // https://mvnrepository.com/artifact/com.twilio.sdk/twilio
    implementation("com.twilio.sdk:twilio:10.9.2")
}

tasks.test {
    useJUnitPlatform()
}
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

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    dependencies {


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
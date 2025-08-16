plugins {
    id("org.springframework.boot")
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":module-former-teammate:domain"))
    implementation(project(":module-former-teammate:infrastructure"))
}


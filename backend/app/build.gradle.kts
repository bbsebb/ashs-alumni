plugins {
    id("java")
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":former-teammate-infrastructure"))
    implementation(project(":user-infrastructure"))
    implementation(project(":former-teammate-domain"))
    implementation(project(":user-domain"))

}
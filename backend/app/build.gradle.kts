plugins {
    id("org.springframework.boot")
}


dependencies {

    implementation(project(":module-former-teammate:domain"))
    implementation(project(":module-former-teammate:infrastructure"))
}


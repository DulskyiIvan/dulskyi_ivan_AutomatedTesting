plugins {
    id("java")
    id("io.qameta.allure") version "4.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

allure {
    version.set("2.35.1")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.seleniumhq.selenium:selenium-java:4.43.0")
    testImplementation("io.rest-assured:rest-assured:5.5.0")
    implementation("io.qameta.allure:allure-java-commons:2.27.0")
    testImplementation("io.qameta.allure:allure-rest-assured:2.27.0")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2")
}

tasks.test {
    useJUnitPlatform()
}
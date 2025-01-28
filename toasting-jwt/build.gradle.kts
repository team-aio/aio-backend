import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.25"
}

bootJar.enabled = false
jar.enabled = true

group = "team"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.4")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.auth0:java-jwt:4.4.0")
    testImplementation("io.kotest:kotest-runner-junit5:5.6.2") // Kotest Runner
    testImplementation("io.kotest:kotest-assertions-core:5.6.2") // Kotest Assertions
    testImplementation("io.kotest:kotest-property:5.6.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

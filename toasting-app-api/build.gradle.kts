import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = true

springBoot {
    mainClass.set("team.toasting.ToastingApplicationKt")
}

dependencies {
    implementation(project(":toasting-display-swagger"))
    implementation(project(":toasting-core-security"))
    implementation(project(":toasting-core-api-response"))
    implementation(project(":toasting-domain-jpa"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

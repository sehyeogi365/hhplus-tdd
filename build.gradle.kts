plugins {
    java
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

fun getGitHash(): String {
    return providers.exec {
        commandLine("git", "rev-parse", "--short", "HEAD")
    }.standardOutput.asText.get().trim()
}

group = "io.hhplus.tdd"
version = getGitHash()

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2024.0.0")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly ("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testRuntimeOnly ("org.junit.platform:junit-platform-launcher")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")

}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("user.timezone", "UTC")
}

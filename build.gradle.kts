
plugins {
    id("org.springframework.boot") version Version.spring
    id("io.spring.dependency-management") version Version.spring_dependency_management
    kotlin("jvm") version Version.kotlin

    // https://kotlinlang.org/docs/reference/compiler-plugins.html#spring-support
    kotlin("plugin.spring") version Version.kotlin

    // See https://kotlinlang.org/docs/reference/compiler-plugins.html#spring-support
    kotlin("plugin.allopen") version Version.kotlin

    kotlin("kapt") version Version.kotlin
}

group = "juv.kotlinboot"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<Jar> {
    archiveBaseName.set("juv-kotlin-boot")
    archiveVersion.set("0.0.0-RELEASE")
}

dependencies {
    implementation(Library.Build.kotlin_stdlib.groupId())
    implementation(Library.Build.spring_boot_starter_web.groupId())

    testImplementation(Library.Test.spring_boot_starter_test.groupId())

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
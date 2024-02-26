plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "com.moneyforward.challenge"
version = "1.0-SNAPSHOT"

val jackson_version: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jackson_version")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.moneyforward.challenge.ApplicationKt")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

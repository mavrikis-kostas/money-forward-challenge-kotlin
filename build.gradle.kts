plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "com.moneyforward.challenge"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}

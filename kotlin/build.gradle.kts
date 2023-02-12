plugins {
    kotlin("jvm") version "1.8.10"
}

repositories {
    mavenCentral()
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}

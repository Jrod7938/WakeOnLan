plugins {
    kotlin("jvm") version "2.0.20"
    application
}

group = "com.wol"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

application {
    mainClass.set("com.wol.MainKt")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "com.wol.MainKt"
        )
    }

    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
}

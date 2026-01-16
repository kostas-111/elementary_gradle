plugins {
    java
    checkstyle
    application
}

group = "ru.job4j"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testImplementation("org.junit.vintage:junit-vintage-engine:5.9.0")
    testImplementation("org.assertj:assertj-core:3.23.1")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.10.3")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass = "ru.job4j.Main"
}

checkstyle {
    toolVersion = "10.3.3"
    configFile = file("checkstyle.xml")
    isIgnoreFailures = false
    isShowViolations = true
}
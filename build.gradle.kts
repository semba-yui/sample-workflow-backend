import net.ltgt.gradle.errorprone.errorprone

plugins {
    `java-platform`
    id("jacoco-report-aggregation")
    id("checkstyle")
    alias(libs.plugins.spring.boot.plugin) apply false
    alias(libs.plugins.spring.dependency.management) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.errorprone) apply false
}

repositories {
    mavenCentral()
}

allprojects {
    repositories { mavenCentral() }
}

subprojects {

    group = rootProject.property("projectGroup")!!
    version = rootProject.property("projectVersion")!!

    // version catalog が参照できないため、id や version を個別で定義してあげる必要がある
    plugins.apply("java-library")
    plugins.apply("checkstyle")
    plugins.apply("jacoco")
    plugins.apply("pmd")
    plugins.apply("com.diffplug.spotless")
    plugins.apply("net.ltgt.errorprone")

    dependencies {
        add("errorprone", "com.google.errorprone:error_prone_core:2.38.0")
    }

    checkstyle {
        toolVersion = "10.23.1"
        configFile = rootProject.file("config/checkstyle/custom_checks.xml")
    }

    extensions.configure<JavaPluginExtension> {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        java {
            googleJavaFormat("1.26.0")
            removeUnusedImports()
            trimTrailingWhitespace()
            endWithNewline()
            licenseHeaderFile(
                rootProject.file("config/LICENSE_HEADER.txt")
            )
        }
        kotlin {
            ktfmt("0.47")
            licenseHeaderFile(rootProject.file("config/LICENSE_HEADER.txt"))
        }
        format("md") {
            target("**/*.md")
            endWithNewline()
        }
    }

    tasks.withType<JavaCompile>().configureEach {
        options.errorprone {
            isEnabled.set(true)
            disableWarningsInGeneratedCode.set(true)
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
        finalizedBy("jacocoTestReport")
    }
}

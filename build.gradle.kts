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

    // この時点の subprojects では version catalog が直接参照できないため、version を個別で定義してあげる必要がある
    // See: https://github.com/gradle/gradle/issues/16634#issuecomment-809345790
    plugins.apply("java-library")
    plugins.apply("checkstyle")
    plugins.apply("jacoco")
    plugins.apply("pmd")
    plugins.apply(rootProject.libs.plugins.spotless.get().pluginId)
    plugins.apply(rootProject.libs.plugins.errorprone.get().pluginId)

    dependencies {
        // ここも同様に version catalog が直接参照できない
        add(
            "errorprone",
            "${rootProject.libs.errorprone.core.get().group}:${rootProject.libs.errorprone.core.get().name}:${rootProject.libs.errorprone.core.get().version}"
        )
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

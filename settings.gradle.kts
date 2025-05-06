rootProject.name = "sample-workflow-backend"

include("kernel")
include("context-core:domain")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
    }
}

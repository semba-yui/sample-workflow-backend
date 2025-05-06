plugins {
    `java-library`
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    compileOnly(project(":kernel"))
    compileOnly(libs.spring.core)
    compileOnly(libs.mapstruct)
    compileOnly(libs.lombok)
    annotationProcessor(libs.mapstruct.ap)
    annotationProcessor(libs.lombok)
    testImplementation(libs.junit.jupiter)
}

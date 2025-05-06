plugins {
    `java-library`
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    testImplementation(libs.junit.jupiter)
}

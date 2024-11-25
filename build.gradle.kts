plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
    id("io.freefair.lombok") version "5.3.0"
    kotlin("plugin.noarg") version "1.9.25"
    kotlin("plugin.jpa") version "1.9.25"
    kotlin("plugin.allopen") version "1.9.25"
    kotlin("plugin.lombok") version "1.9.25"
    kotlin("kapt") version "1.9.25"
}

group = "kr.goldenmine"
version = "0.0.1-SNAPSHOT"

val mysqlVersion = "8.0.33"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation(group="org.springframework.boot", name="spring-boot-starter-data-jpa")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson
    implementation(group="com.squareup.retrofit2", name="converter-gson", version="2.11.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.11.0")
    implementation("com.squareup.retrofit2:converter-jaxb:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.7.2")
//    implementation("org.springframework.boot:spring-boot-starter-actuator")

    annotationProcessor("org.projectlombok:lombok:1.18.24")
    compileOnly("org.projectlombok:lombok:1.18.24")

    implementation(group="mysql", name="mysql-connector-java", version=mysqlVersion)

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

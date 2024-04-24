import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
}

group = "com.daelim"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")


    implementation("org.jetbrains.kotlin:kotlin-reflect")


//	runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

//	swagger-ui
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

//  graphql
    implementation ("org.springframework.boot:spring-boot-starter-graphql")
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:15.1.0")
    implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:11.1.0")

//	util
    implementation("net.datafaker:datafaker:2.1.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

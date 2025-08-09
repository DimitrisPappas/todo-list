plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("plugin.jpa") version "1.9.25"
}

group = "com.dspappas"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

val postgresVersion = "42.7.2"
val flywayVersion = "9.22.1"
val kotlinLoggingVersion = "3.0.5"

dependencies {
	// Core
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Web
	implementation("org.springframework.boot:spring-boot-starter-web") // Spring Web
	implementation("org.springframework.boot:spring-boot-starter-validation") // Validation
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// PostgresSQL Driver, JPA, H2
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("org.postgresql:postgresql:$postgresVersion")
	runtimeOnly("com.h2database:h2")

	// Flyway
	implementation("org.flywaydb:flyway-core:$flywayVersion")

	// Logging
	implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVersion")

	// Tests
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")


}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

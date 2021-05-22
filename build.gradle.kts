import io.kotless.plugin.gradle.dsl.kotless
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

plugins {
    kotlin("jvm") version "1.5.0"
    id("io.kotless") version "0.1.6"
}

group = "me.raychenon"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.kotless", "kotless-lang", "0.1.6")
}

tasks.withType<KotlinJvmCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        languageVersion = "1.3"
        apiVersion = "1.3"
    }
}

kotless {
    config {
        bucket = "jm.kotless.bucket"

        terraform {
            profile = "jm.kotless.user"
            region = "eu-west-1"
        }
    }
    webapp {
        lambda {
            kotless {
                packages = setOf("me.raychenon")
            }
        }
    }
}

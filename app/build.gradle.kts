plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.owasp.dependencycheck") version "8.5.2"
    jacoco
}

android {
    namespace = "com.google.samples.apps.sunflower"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.google.samples.apps.sunflower"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.6"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "UNSPLASH_ACCESS_KEY",
            "\"" + (project.findProperty("unsplash_access_key") ?: "") + "\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
        debug {
            isTestCoverageEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig = true
    }
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

// Jacoco Task
tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest")
    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }
    val fileTree = fileTree("${buildDir}/tmp/kotlin-classes/debug")
    classDirectories.setFrom(files(fileTree))
    sourceDirectories.setFrom(files("src/main/java", "src/main/kotlin"))
    executionData.setFrom(files("${buildDir}/jacoco/testDebugUnitTest.exec"))
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.3")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.6")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

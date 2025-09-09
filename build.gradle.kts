/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    jacoco
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Gradle Plugin Android
        classpath("com.android.tools.build:gradle:8.1.0")
        // Kotlin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        // Hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.49")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

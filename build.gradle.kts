// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.androidx.room) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.detekt) apply false
}

apply(from = "scripts/gradle/detekt/detekt.gradle")
apply(from = "scripts/gradle/lint/lint.gradle")

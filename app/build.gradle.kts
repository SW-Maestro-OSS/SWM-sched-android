plugins {
    kotlin("android")
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "org.soma.conference.android"

    defaultConfig {
        applicationId = "org.soma.conference.android"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.appVersion.get()
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":shared"))
    implementation(project(":feature:home"))

    implementation(libs.hilt)
    kapt(libs.hilt.kapt)
    implementation(libs.bundles.basic.test)
}
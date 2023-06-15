plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "org.soma.conference.android.shared"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.bundles.androidx.ui.foundation)
    implementation(libs.material)
}
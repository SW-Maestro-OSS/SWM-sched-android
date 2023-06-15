plugins {
    kotlin("android")
    id("com.android.library")
    kotlin("kapt")
}
android {
    namespace = "org.soma.conference.android.home"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":common-ui"))

    implementation(libs.bundles.androidx.ui.foundation)
    implementation(libs.constraintlayout)
    implementation(libs.hilt)
    kapt(libs.hilt.kapt)
    implementation(libs.bundles.basic.test)
}

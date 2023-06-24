plugins {
    kotlin("android")
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}
android {
    namespace = "org.soma.conference.android.home"

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":common-ui"))

    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation(libs.bundles.androidx.ui.foundation)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.hilt)
    kapt(libs.hilt.kapt)
    implementation(libs.bundles.basic.test)
}

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.tiowichoapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tiowichoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Core AndroidX
    implementation(libs.androidx.core.ktx.v1150)
    implementation(libs.androidx.lifecycle.runtime.ktx.v287)
    implementation(libs.androidx.activity.compose.v193)

    // Compose Core
    implementation(libs.ui)
    implementation(libs.androidx.ui.tooling.preview.v175)
    implementation(libs.androidx.runtime.livedata.v153)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest.v175)

    // Material Design
    implementation(libs.androidx.material)
    implementation(libs.androidx.material.icons.extended.v175)
    implementation(libs.material3)
    implementation(libs.androidx.material.v160alpha05)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Retrofit for API
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Coil for image loading
    implementation(libs.coil.compose)

    // QR Scanner
    implementation(libs.coil.compose.v270)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v121)
    androidTestImplementation(libs.androidx.espresso.core.v361)
    androidTestImplementation(libs.ui.test.junit4)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.animated.navigation.bar)
    implementation(libs.core)
    implementation (libs.zxing.android.embedded)
}


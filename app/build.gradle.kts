plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.hours_tracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hours_tracker"
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
}

dependencies {
    // Compose UI
    implementation("androidx.compose.ui:ui:1.5.0") // Replace with the latest version
    implementation("androidx.compose.material3:material3:1.0.1") // Replace with the latest version
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0") // For preview support

    // ViewModel and Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0") // Replace with the latest version
    implementation("androidx.activity:activity-compose:1.7.0") // For Compose integration with Activities

    // Optional: For testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0") // Replace with the latest version
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.0") // Replace with the latest version
}

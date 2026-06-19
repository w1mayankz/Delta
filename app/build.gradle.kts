plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    // Delta App ID
    namespace = "com.w1mayank.delta"
    compileSdk = 35 // Android 15

    defaultConfig {
        applicationId = "com.w1mayank.delta"
        minSdk = 31 // CRITICAL: Forces Android 12+ for native Liquid Glass
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    kotlinOptions {
        jvmTarget = "1.8"
    }
    
    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

dependencies {
    // The Core Android Lifecycles
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Jetpack Compose UI (The absolute latest stable UI toolkit)
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3") // Modern Shadows & Squircles
    
    // WebKit Engine for Delta
    implementation("androidx.webkit:webkit:1.10.0")

    // Icons
    implementation("androidx.compose.material:material-icons-extended")
}

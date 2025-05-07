import java.util.Base64
import java.io.File

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.atvantiq.androidcicd"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.atvantiq.androidcicd"
        minSdk = 24
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            // Read the base64-encoded keystore from environment variable
            val keystoreBase64 = System.getenv("KEYSTORE_FILE")
            storeFile = if (keystoreBase64 != null) {
                // Create a temporary file to store the decoded keystore
                val tempKeystoreFile = File.createTempFile("keystore", ".jks")
                tempKeystoreFile.writeBytes(keystoreBase64.decodeBase64())
                tempKeystoreFile
            } else {
                null
            }
            storePassword = System.getenv("SIGNING_STORE_PASSWORD")
            keyAlias = System.getenv("SIGNING_KEY_ALIAS")
            keyPassword = System.getenv("SIGNING_KEY_PASSWORD")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Helper extension function to decode base64
fun String.decodeBase64(): ByteArray {
    return Base64.getDecoder().decode(this)
}

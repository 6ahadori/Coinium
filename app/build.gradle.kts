plugins {
    id(Plugins.Android.application)
    id(Plugins.Kotlin.jetbrains)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = ConfigurationData.applicationId
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        applicationId = ConfigurationData.applicationId
        minSdk = ConfigurationData.minSdk
        targetSdk = ConfigurationData.targetSdk
        versionCode = ConfigurationData.versionCode
        versionName = ConfigurationData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.material)
    implementation(Libs.Lifecycle.runtimeKtx)

    implementation(platform(Libs.Compose.composeBOM))
    implementation(Libs.Compose.composeActivity)
    implementation(Libs.Compose.composeUi)
    implementation(Libs.Compose.composeUiPreview)
    debugImplementation(Libs.Compose.composeUiTooling)
    debugImplementation(Libs.Compose.composeUiTestManifest)

    implementation(Libs.Navigation.runtimeKtx)
    implementation(Libs.Navigation.navigationCompose)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.junitExt)
    androidTestImplementation(Libs.Test.espressoCore)

}


kapt {
    correctErrorTypes = true
}
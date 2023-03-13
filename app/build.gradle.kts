plugins {
    id(Plugins.Android.application)
    id(Plugins.Kotlin.jetbrains) version Versions.kotlinVersion
    id(Plugins.Kotlin.kapt)
    id(Plugins.Hilt.daggerHilt)
    id(Plugins.Google.mapsPlatformSecrets)
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
    implementation(Libs.Kotlin.stdlibJdk8)
    implementation(Libs.Kotlin.stdlib)

    implementation(Libs.AndroidX.core)
    implementation(Libs.Lifecycle.runtimeKtx)
    implementation(Libs.Lifecycle.viewModelKtx)
    implementation(Libs.Lifecycle.runtimeCompose)

    implementation(platform(Libs.Compose.composeBOM))
    implementation(Libs.Compose.composeActivity)
    implementation(Libs.Compose.composeUi)
    implementation(Libs.Compose.composeUiPreview)
    debugImplementation(Libs.Compose.composeUiTooling)
    debugImplementation(Libs.Compose.composeUiTestManifest)
    debugImplementation(Libs.Compose.composeMaterial)
    debugImplementation(Libs.Compose.composeCoil)

    implementation(Libs.Navigation.runtimeKtx)
    implementation(Libs.Navigation.navigationCompose)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.junitExt)
    androidTestImplementation(Libs.Test.espressoCore)

    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)

    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.gsonConverter)
    implementation(Libs.Retrofit.gson)
    implementation(Libs.Retrofit.loggingInterceptor)
}


kapt {
    correctErrorTypes = true
}
object Plugins {
    object Android {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val jetbrains = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
    }

    object Hilt {
        const val daggerHilt = "com.google.dagger.hilt.android"
    }

}

object Versions {
    const val gradlePluginVersion = "7.4.1"
    const val kotlinVersion = "1.8.0"
    const val hiltVersion = "2.44"
}

object Libs {

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.9.0"
        const val appcompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.8.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Compose {
        const val kotlinCompilerExtensionVersion = "1.4.2"
        const val composeBOM = "androidx.compose:compose-bom:2023.01.00"
        const val composeUi = "androidx.compose.ui:ui"
        const val composeUiPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling"
        const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
        const val composeMaterial = "androidx.compose.material:material"
        const val composeActivity = "androidx.activity:activity-compose:1.6.1"
        const val composeCoil = "io.coil-kt:coil-compose:2.2.2"
    }

    object Navigation {
        const val navigationCompose = "androidx.navigation:navigation-compose:2.5.3"
        const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:2.5.3"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.5"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.5.1"
        const val truth = "com.google.truth:truth:1.1.3"
        const val mockitoCore = "org.mockito:mockito-core:5.2.0"
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:4.1.0"
        const val mockk = "io.mockk:mockk:5.2.0"
        const val fragmentTesting = "androidx.fragment:fragment-testing:1.5.5"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:2.44"
        const val compiler = "com.google.dagger:hilt-compiler:2.44"
        const val fragment = "androidx.hilt:hilt-navigation-fragment:1.0.0"
        const val testing = "com.google.dagger:hilt-android-testing:2.44"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:2.44"
    }

    object Coroutine {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    }

    object Lifecycle {
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        const val savedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1"
        const val compiler = "androidx.lifecycle:lifecycle-compiler:2.5.1"
        const val process = "androidx.lifecycle:lifecycle-process:2.5.1"
        const val coreTesting = "androidx.arch.core:core-testing:2.1.0"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:2.5.0"
        const val compiler = "androidx.room:room-compiler:2.5.0"
        const val ktx = "androidx.room:room-ktx:2.5.0"
        const val testing = "androidx.room:room-testing:2.5.0"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val gson = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.10.0"
    }

    object Lottie {
        const val lottie = "com.airbnb.android:lottie:5.2.0"
    }
}
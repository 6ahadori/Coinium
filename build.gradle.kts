plugins {
    id(Plugins.Android.application) version Versions.gradlePluginVersion apply false
    id(Plugins.Android.library) version Versions.gradlePluginVersion apply false
    id(Plugins.Kotlin.jetbrains) version Versions.kotlinVersion apply false
    id(Plugins.Hilt.daggerHilt) version Versions.hiltVersion apply false
    id(Plugins.Google.mapsPlatformSecrets) version Versions.secretVersion apply false
}
plugins {
    alias(libs.plugins.android.application)
//    alias(libs.plugins.hilt)

}


android {
    namespace = "com.example.androidexam"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidexam"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.google.gson)
    implementation (libs.gson)
    implementation(libs.swiperefreshlayout)
    implementation(libs.threetenabp)

    implementation(libs.paging.runtime)

//    implementation(libs.hilt.android)
//    annotationProcessor(libs.hilt.compiler)


    // ViewModel
    implementation(libs.lifecycle.viewmodel.ktx)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)

//    implementation(libs.rxjava)

//    implementation("com.facebook.shimmer:shimmer:0.5.0")

}
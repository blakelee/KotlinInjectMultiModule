plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidKotlinMultiplatformLibrary)
}

kotlin {
  androidLibrary {
    namespace = "com.hostly.test"
    compileSdk = 36
    minSdk = 26

    this@kotlin.iosArm64()
    this@kotlin.iosSimulatorArm64()
  }
}
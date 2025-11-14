import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.util.prefixIfNot
import java.util.Locale

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidKotlinMultiplatformLibrary)
  alias(libs.plugins.ksp)
}

kotlin {
  androidLibrary {
    namespace = "com.hostly.shared.impl"
    compileSdk = 36
    minSdk = 26
  }

  val xcfName = "shared:implKit"

  iosArm64 {
    binaries.framework {
      baseName = xcfName
    }
  }

  iosSimulatorArm64 {
    binaries.framework {
      baseName = xcfName
    }
  }

  sourceSets {
    commonMain {
      dependencies {
        api(projects.shared.public)

        implementation(libs.kotlin.inject.runtime)
        implementation(libs.anvil.runtime)
        implementation(libs.anvil.runtime.optional)
      }
    }
  }
}

val kspTargets by lazy {
  val extension: KotlinMultiplatformExtension = kotlin
  extension.targets.names.map { it.capitalizeUS() }
    .map {
      val name = if (it == "Metadata") "CommonMainMetadata" else it
      name.prefixIfNot("ksp")
    }
}

dependencies {
  kspTargets.forEach { target ->
    addProvider(target, libs.kotlin.inject.compiler)
    addProvider(target, libs.anvil.compiler)
  }
}

internal fun String.capitalizeUS() = replaceFirstChar {
  if (it.isLowerCase()) it.titlecase(Locale.US) else it.toString()
}
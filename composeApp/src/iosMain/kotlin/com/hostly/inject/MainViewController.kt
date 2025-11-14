package com.hostly.inject

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
  val appComponent = createAppComponent()
  App(appComponent)
}
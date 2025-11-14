package com.hostly.inject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
  val appComponent = AndroidAppComponent::class.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
          App(appComponent)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
  App(AndroidAppComponent::class.create())
}
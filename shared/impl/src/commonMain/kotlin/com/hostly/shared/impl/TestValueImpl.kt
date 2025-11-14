package com.hostly.shared.impl

import com.hostly.shared.TestValue
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@Inject
@ContributesBinding(AppScope::class)
class TestValueImpl : TestValue {
  override val value: String = "Hello World"
}
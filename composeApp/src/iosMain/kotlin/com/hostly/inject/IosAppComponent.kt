package com.hostly.inject

import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn
import kotlin.reflect.KClass

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
abstract class IosAppComponent : AppComponent

@Suppress("NO_ACTUAL_FOR_EXPECT")
@MergeComponent.CreateComponent
expect fun KClass<IosAppComponent>.createComponent(): IosAppComponent

fun createAppComponent(): AppComponent {
  return IosAppComponent::class.createComponent()
}
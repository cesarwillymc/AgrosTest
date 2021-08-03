
package com.cesarwillymc.agrostest.module

import com.cesarwillymc.agrostest.app.MyApp
import com.cesarwillymc.agrostest.module.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(application: MyApp)
}

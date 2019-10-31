package com.devsanmiaderibigbe.evilinsults.di.component

import android.content.Context
import com.devsanmiaderibigbe.evilinsults.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : AppComponent
    }
    fun homeComponents() : HomeComponent.Factory

}
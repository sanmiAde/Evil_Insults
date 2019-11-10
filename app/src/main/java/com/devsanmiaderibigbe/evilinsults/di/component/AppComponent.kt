package com.devsanmiaderibigbe.evilinsults.di.component

import android.app.Application
import android.content.Context
import com.devsanmiaderibigbe.evilinsults.di.NetworkModule
import com.devsanmiaderibigbe.evilinsults.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ApplicationScope
@Component(modules = [NetworkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Application) : AppComponent
    }
    fun homeComponents() : HomeComponent.Factory

}
package com.devsanmiaderibigbe.evilinsults

import android.app.Application
import com.devsanmiaderibigbe.evilinsults.di.component.AppComponent
import com.devsanmiaderibigbe.evilinsults.di.component.DaggerAppComponent

class MyApplication : Application() {

    val appComponent : AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}
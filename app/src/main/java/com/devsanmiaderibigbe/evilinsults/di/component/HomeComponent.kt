package com.devsanmiaderibigbe.evilinsults.di.component

import com.devsanmiaderibigbe.evilinsults.MainActivity
import dagger.Subcomponent

@Subcomponent
interface HomeComponent {

    @Subcomponent.Factory
    interface  Factory {
        fun create() : HomeComponent
    }

    fun inject(activity: MainActivity)
}
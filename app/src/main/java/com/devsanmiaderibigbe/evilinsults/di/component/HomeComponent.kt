package com.devsanmiaderibigbe.evilinsults.di.component

import com.devsanmiaderibigbe.evilinsults.ui.MainActivity
import com.devsanmiaderibigbe.evilinsults.ui.MainFragment
import dagger.Subcomponent

@Subcomponent
interface HomeComponent {

    @Subcomponent.Factory
    interface  Factory {
        fun create() : HomeComponent
    }

    fun inject(activity: MainActivity)
    fun inject (mainFragment: MainFragment)
}
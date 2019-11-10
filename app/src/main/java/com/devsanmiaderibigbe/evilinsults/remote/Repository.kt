package com.devsanmiaderibigbe.evilinsults.remote

import com.devsanmiaderibigbe.evilinsults.remote.model.EvilInsult
import com.devsanmiaderibigbe.evilinsults.remote.model.Resource
import io.reactivex.Single

interface Repository {

    fun getInsult()  : Single<EvilInsult>
}
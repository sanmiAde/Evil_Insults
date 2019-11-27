package com.devsanmiaderibigbe.evilinsults.remote

import com.devsanmiaderibigbe.evilinsults.remote.model.AsoebiStyles
import com.devsanmiaderibigbe.evilinsults.remote.model.EvilInsult
import io.reactivex.Single

class RepositoryImp(val evilInsultService: EvilInsultService) : Repository {
    override fun getAsobiStyles(): Single<AsoebiStyles> {
        return evilInsultService.getAsoebiStyles(30, 0)
    }

    override fun getInsult(): Single<EvilInsult> {
        return evilInsultService.getInsult()
    }
}
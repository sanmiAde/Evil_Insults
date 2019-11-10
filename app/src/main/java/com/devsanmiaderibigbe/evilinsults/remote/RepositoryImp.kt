package com.devsanmiaderibigbe.evilinsults.remote

import com.devsanmiaderibigbe.evilinsults.remote.model.EvilInsult
import io.reactivex.Single

class RepositoryImp(val evilInsultService: EvilInsultService) : Repository {
    override fun getInsult(): Single<EvilInsult> {
        return evilInsultService.getInsult()
    }
}
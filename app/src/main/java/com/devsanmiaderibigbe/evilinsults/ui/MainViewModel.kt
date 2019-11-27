package com.devsanmiaderibigbe.evilinsults.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devsanmiaderibigbe.evilinsults.remote.Repository
import com.devsanmiaderibigbe.evilinsults.remote.model.AsoebiStyles
import com.devsanmiaderibigbe.evilinsults.remote.model.EvilInsult
import com.devsanmiaderibigbe.evilinsults.remote.model.Resource
import com.devsanmiaderibigbe.evilinsults.utils.AppScheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository: Repository, val appScheduler: AppScheduler) : ViewModel() {
    private val disposable = CompositeDisposable()
    private val _evilInsultResult = MutableLiveData<Resource<EvilInsult>>()
    private val _asoebiStyles = MutableLiveData<Resource<AsoebiStyles>>()

    init {
        getAsoebiStyles()
    }

    val evilInsultResult: LiveData<Resource<EvilInsult>>
        get() = _evilInsultResult

    val asoebiStylesResult : LiveData<Resource<AsoebiStyles>>
        get() = _asoebiStyles

    fun getInsult() {
        _evilInsultResult.value = Resource.loading(null)
        disposable.add(
            repository.getInsult().observeOn(appScheduler.main()).subscribe({
                _evilInsultResult.value = Resource.success(it)
            }, {
                _evilInsultResult.value = Resource.error(it.localizedMessage, null)
            })
        )
    }

    fun getAsoebiStyles() {
        _asoebiStyles.value = Resource.loading(null)
        disposable.add(
            repository.getAsobiStyles().observeOn(appScheduler.main()).subscribe({
                _asoebiStyles.value = Resource.success(it)
            },

                {
                    _asoebiStyles.value = Resource.error(it.localizedMessage, null)
                })
        )
    }
}

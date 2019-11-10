package com.devsanmiaderibigbe.evilinsults.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.devsanmiaderibigbe.evilinsults.MyApplication
import com.devsanmiaderibigbe.evilinsults.R
import com.devsanmiaderibigbe.evilinsults.di.component.HomeComponent
import com.devsanmiaderibigbe.evilinsults.remote.model.Status
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var  homeComponent: HomeComponent
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        initDaggerInjection()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initClickListners()

    }

    private fun initDaggerInjection() {
        homeComponent = (application as MyApplication).appComponent.homeComponents().create()
        homeComponent.inject(this)
    }

    private fun initClickListners(){
        btn_get_insult.setOnClickListener {
            viewModel.getInsult()
            viewModel.evilInsultResult.observe(this, Observer {
                when(it.status){
                    Status.SUCCESS -> {
                        txt_insult.text = it.data?.insult
                    }
                    Status.ERROR -> txt_insult.text = it.message
                    Status.LOADING -> {}
                }
            })
        }
    }
}

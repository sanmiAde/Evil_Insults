package com.devsanmiaderibigbe.evilinsults.remote

import com.devsanmiaderibigbe.evilinsults.remote.model.AsoebiStyles
import com.devsanmiaderibigbe.evilinsults.remote.model.EvilInsult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface EvilInsultService {

    @GET("/generate_insult.php")
    fun getInsult(@Query("lang")lang: String="en", @Query("type") type :String ="json" ) : Single<EvilInsult>

    @GET("/aseobi-styles")
    fun getAsoebiStyles(@Query("\$limit") limit : Int, @Query("\$skip") skip : Int) : Single<AsoebiStyles>
}
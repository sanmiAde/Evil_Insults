package com.devsanmiaderibigbe.evilinsults.remote.model

import com.squareup.moshi.Json

class EvilInsult(

    @Json(name = "number")
    val number: String,
    @Json(name = "language")
    val language: String,
    @Json(name = "insult")
    val insult: String,
    @Json(name = "created")
    val created: String,
    @Json(name = "shown")
    val shown: String,
    @Json(name = "createdby")
    val createdby: String,
    @Json(name = "active")
    val active: String,
    @Json(name = "comment")
    val comment: String
)
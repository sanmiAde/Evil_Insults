package com.devsanmiaderibigbe.evilinsults.remote.model

import com.squareup.moshi.Json


class Asoebi {

    @Json(name = "id")
    var id: String? = null
    @Json(name = "name")
    var name: String? = null
    @Json(name = "description")
    var description: String? = null
    @Json(name = "imageURL")
    var imageURL: String? = null
    @Json(name = "sharingLink")
    var sharingLink: String? = null

}
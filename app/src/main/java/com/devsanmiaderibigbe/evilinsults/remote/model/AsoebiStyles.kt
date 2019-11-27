package com.devsanmiaderibigbe.evilinsults.remote.model

import com.squareup.moshi.Json


class AsoebiStyles {

    @Json(name = "\$prev")
    var `$prev`: String? = null
    @Json(name = "\$next")
    var `$next`: String? = null
    @Json(name = "data")
    var data: List<Asoebi>? = null

}
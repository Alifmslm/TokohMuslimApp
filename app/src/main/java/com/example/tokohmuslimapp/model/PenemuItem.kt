package com.example.tokohmuslimapp.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PenemuItem (

    var id : Int = 0,
    @Json(name = "gambar")
    var gambar : String?,
    @Json(name = "judul")
    var judul : String?,
    @Json(name = "nama")
    var nama : String?,
    @Json(name = "desk")
    var desk : String?,

 ): Parcelable
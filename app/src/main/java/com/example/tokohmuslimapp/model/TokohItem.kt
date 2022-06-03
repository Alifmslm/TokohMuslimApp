package com.example.tokohmuslimapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Entity(tableName = "item")
@Parcelize
data class TokohItem (
        @PrimaryKey(autoGenerate = true)

        var id : Int = 0,
        @Json(name = "gambar")
        var gambar : String?,
        @Json(name = "judul")
        var judul : String?,
        @Json(name = "nama")
        var nama : String?,
        @Json(name = "desk")
        var desk : String?,
        var type : String?

):Parcelable



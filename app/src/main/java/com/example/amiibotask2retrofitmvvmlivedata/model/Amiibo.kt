package com.example.amiibotask2retrofitmvvmlivedata.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class     Amiibo {
    @SerializedName("amiiboSeries")
    @Expose
    var amiiboSeries: String? = null
    @SerializedName("character")
    @Expose
    var character: String? = null
    @SerializedName("gameSeries")
    @Expose
    var gameSeries: String? = null
    @SerializedName("head")
    @Expose
    var head: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
}
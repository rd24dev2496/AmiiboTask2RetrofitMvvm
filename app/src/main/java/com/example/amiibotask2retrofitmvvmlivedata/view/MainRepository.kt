package com.example.amiibotask2retrofitmvvmlivedata.view
import com.example.amiibotask2retrofitmvvmlivedata.util.RetrofitService

class MainRepository constructor(private  val retrofitService: RetrofitService) {
    fun getAllAmiibo()=retrofitService.getAllAmiibo()
}
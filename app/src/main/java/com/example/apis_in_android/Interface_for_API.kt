package com.example.apis_in_android

import retrofit2.Call
import retrofit2.http.GET

interface Interface_for_API {

    @GET("products") // writing the end address of the API call
    fun getProductData() : Call<MyJsonData>
}
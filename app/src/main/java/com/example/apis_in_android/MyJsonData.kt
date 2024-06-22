package com.example.apis_in_android

data class MyJsonData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)
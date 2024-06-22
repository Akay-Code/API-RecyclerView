package com.example.apis_in_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //step1 installed retrofit dependecy
        //step2 made data class from JSON
        //step3 make interface for API
        //step4 initiate retrofit in main activity

        recyclerView = findViewById(R.id.myRecyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Interface_for_API::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyJsonData?> {
            override fun onResponse(call: Call<MyJsonData?>, response: Response<MyJsonData?>) {
                // if API call is a success , then use this data and show in app

                val responseBody = response.body()
                val productList = responseBody?.products!!

                myAdapter = MyAdapter(this@MainActivity , productList)
                recyclerView.adapter = myAdapter

                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                myAdapter.mySetItemClickListener(object : MyAdapter.MyClickListener{
                    override fun onItemClicking(position: Int) {
                        val intent = Intent(this@MainActivity, ProductDesc::class.java)
                        intent.putExtra("data", productList[position] )
                        startActivity(intent)
                    }
                })
            }

            override fun onFailure(p0: Call<MyJsonData?>, p1: Throwable) {
                //if API call fails
                Log.d("Main Activity" , "onFailure" + p1.message)
            }
        })
    }
}


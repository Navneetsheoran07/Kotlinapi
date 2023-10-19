package com.sheoran.kotlinapi

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {


    @GET(Constants.todos)
    fun demoData():Call<DemoDataModel?>
}
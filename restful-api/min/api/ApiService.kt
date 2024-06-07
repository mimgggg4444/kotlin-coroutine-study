package com.min.api

import com.min.model.ContectReq
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("contect")
    fun sendContect(@Body contectReq: ContectReq): Call<Void>

    companion object {
//        private const val BASE_URL = "http://2-tjgbbvkgmv.dynamic-m.com:41228/"
//add code
        // 문제 해결 - 결국 위의 baseurl은 제대로 작동되지 않는코드였음. swagger ui에서 idx를 통해 값 제대로 들어갔는지 확인


        private const val BASE_URL = "http://2-tjgbbvkgmv.dynamic-m.com:41228/api/v1/test/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
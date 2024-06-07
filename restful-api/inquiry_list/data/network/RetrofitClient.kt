package com.min.inquiry_list.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/// 오브젝트 형식으로 레트로 클라이언트 가져옴.
object RetrofitClient {
    private const val BASE_URL = "http://2-tjgbbvkgmv.dynamic-m.com:41228/"

    fun create(service: Class<InquiryApi>): InquiryApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(service)
    }
}


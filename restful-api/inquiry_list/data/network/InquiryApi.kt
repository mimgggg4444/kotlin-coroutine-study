package com.min.inquiry_list.data.network

import com.min.inquiry_list.data.model.InquiryResponse
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/// 어노테이션 가져오기, 삭제하기
//@get, @delete -> 사용해서 가져오기

interface InquiryApi {
    @GET("api/v1/test/contect")
    fun getInquiryList(
        @Query("CONTENT_FLAG") contentFlag: Int,
        @Query("count") count: Int,
        @Query("page") page: Int
// call 에서 inquiry response에서 call의 배열이 없는건가? -> retrofit client를 만들어서 코드를 가져올 수 있었음. 위와 같은 기능으로 오류 해결
    ): Call<InquiryResponse>

    @GET("api/v1/test/contect/{idx}")
    fun getInquiryDetail(
        @Path("idx") idx: Int,
        @Query("isCheck") isCheck: Int
    ): Call<InquiryResponse>

    @DELETE("api/v1/test/contect/{idx}")
    fun deleteInquiry(@Path("idx") idx: Int): Call<Void>


}
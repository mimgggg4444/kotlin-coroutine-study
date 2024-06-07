package com.min.inquiry_list.data.ui.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.min.inquiry_list.R
import com.min.inquiry_list.data.model.InquiryResponse
import com.min.inquiry_list.data.network.InquiryApi
import com.min.inquiry_list.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import kotlin.math.log

class InquiryListActivity : AppCompatActivity() {
    private lateinit var inquiryListAdapter: InquiryListAdapter
    private lateinit var inquiryList: RecyclerView
    private lateinit var inquiryApi: InquiryApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inquiry_list)


//        inquiry api를 제대로 가져왔다고 확인하는 함수 실행됨.
        inquiryApi = RetrofitClient.create(InquiryApi::class.java)

        inquiryList = findViewById(R.id.inquiry_list)
        inquiryListAdapter = InquiryListAdapter(this)
        inquiryList.adapter = inquiryListAdapter
        inquiryList.layoutManager = LinearLayoutManager(this)

        fetchInquiryList()
    }

    private fun fetchInquiryList() {
        // contentflag 0으로 설정해야 보이는 것들. -> 데이터를 가져와서 list 리사이클러 뷰로 보이게 하는걸 성공.
            inquiryApi.getInquiryList(0, 100, 1).enqueue(object : Callback<InquiryResponse> {
            override fun onResponse(call: Call<InquiryResponse>, response: Response<InquiryResponse>) {
                if (response.isSuccessful) {
                    val inquiryResponse = response.body()
                    inquiryResponse?.let {
                        if (it.code == 1) {
                            inquiryListAdapter.updateInquiryList(it.data)
                        } else {
                            Log.e("InquiryList", "Error code: ${it.code}, message: ${it.msg}")

                        }
                    }
                } else {
                    Log.e("InquiryList", "Response failed: ${response.code()}")
                }
            }

//                2024-06-07 11:30:23.822 15689-15689 InquiryList             com.min.inquiry_list                 E  Request failed: CLEARTEXT communication to 2-tjgbbvkgmv.dynamic-m.com not permitted by network security policy
//                java.net.UnknownServiceException: CLEARTEXT communication to 2-tjgbbvkgmv.dynamic-m.com not permitted by network security policy


            override fun onFailure(call: Call<InquiryResponse>, t: Throwable) {
                Log.e("InquiryList", "Request failed: ${t.message}", t)
            }
        })
    }



}
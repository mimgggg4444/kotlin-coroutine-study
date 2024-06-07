package com.min.inquiry_list.data.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.min.inquiry_list.R
import com.min.inquiry_list.data.model.Inquiry
import com.min.inquiry_list.data.model.InquiryResponse
import com.min.inquiry_list.data.network.InquiryApi
import com.min.inquiry_list.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*


1. 삭제 기능. 처리, 취소 기능 isSussesful로 check되어있는지 확인.
-> 처리가 되어있다면 , 취소가
-> 취소가 되어있다면 , 처리가 되어있게.=
--> ischecked 정보는 어디에 저장이 되는가? 데이터베이스안에 데이터를 추가적으로 저장해야하는가?

데이터가 문의 내용

2.
삭제 눌렀을대 해당 list가 삭제될 수 있게 하기.

3.
-> list 에서 디테일 정보에서 모든 정보를 확인할 수 있게. 입력이 아닌 입력된 데이터가 보여질 수있게 하기.


 */

/// 위 클래스는 눌렀을대 자세한 정보를 출력하는 디테일 엑티비티 입니다.
/// setcontent view를 통해서 xml의 개요를 받아옵니다.
class InquiryDetailActivity : AppCompatActivity() {
    private lateinit var inquiry: Inquiry
    private lateinit var inquiryApi: InquiryApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inquiry_detail)


// retrofit client가 안보임. 없는걸로 판단됨. -> 없는걸로 판단되어서 만듦. response값을 return함.
        inquiryApi = RetrofitClient.create(InquiryApi::class.java)

        val idx = intent.getIntExtra("idx", -1)
        fetchInquiryDetail(idx)
    }


//    inquiry list activity 도 문제가 있음.
//    override해서 함수 사용하는 부분 확인 필요.
    private fun fetchInquiryDetail(idx: Int) {
//    inquiry response를 위해서 callback security를 사용해야하는가?
    // 인쿼리리스폰스를 콜백으로 가져올 수 있음.
        inquiryApi.getInquiryDetail(idx, 1).enqueue(object : Callback<InquiryResponse> {
            // override에서 문제 발생. onResponse가 없다고 예상됨.
            override fun onResponse(call: Call<InquiryResponse>, response: Response<InquiryResponse>) {
                if (response.isSuccessful) {
                    val inquiryResponse = response.body()
                    inquiryResponse?.let {
                        if (it.code == 1) {
//                            !!를 추가함으로서 -> 어떻게 되는지 확인 TODO
                            inquiry = it.data.firstOrNull()!!
                            displayInquiryDetails()
                        } else {
                            // 오류 처리
                        }
                    }
                } else {
                    // 오류 처리
                }
            }
            //이하동문
            override fun onFailure(call: Call<InquiryResponse>, t: Throwable) {
                // 오류 처리
            }
        })
    }

    private fun displayInquiryDetails() {
        // 문의 내용 상세 정보를 화면에 표시하는 코드 작성
        // inquiry 객체의 속성들을 사용하여 화면에 표시
    }

    // 처리 기능 메서드
    private fun processInquiry() {
        // 문의 내용 처리 기능 구현
    }

    // 취소 기능 메서드
    private fun cancelInquiry() {
        // 문의 내용 취소 기능 구현
    }

    // 삭제 기능 메서드 -> 삭제 기능. 선택된 해당 리스트를 삭제할 수 있어야함.
    private fun deleteInquiry() {
        inquiry?.let {
            inquiryApi.deleteInquiry(it.idx).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        // 삭제 성공 처리
                        finish()
                    } else {
                        // 오류 처리
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    // 오류 처리
                }
            })
        }
    }
}
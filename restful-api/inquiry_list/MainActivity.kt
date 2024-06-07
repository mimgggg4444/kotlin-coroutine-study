package com.min.inquiry_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.min.inquiry_list.data.ui.list.InquiryListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //intro 화면, 문의내용 list, 문의내용 상세보기(처리,취소,삭제)
        // 문의내용-http://2-tjgbbvkgmv.dynamic-m.com:41228/api/v1/test/contect/1?isCheck=1
//문의내용정보가져오기-http://2-tjgbbvkgmv.dynamic-m.com:41228/api/v1/test/contect?CONTENT_FLAG=3&count=10&page=1
        //문의하기삭제 idx로 삭제

        //1. 문의 내용 list - 리사이클러뷰 회사명 리스트로 나올 수 있게.
        //2. 문의 내용 클릭 -> 문의내용상세보기 -  내용. 회사명, 이름, 문의종류, 처리결과, 날짜 위와 같은 정보 표시 후 처리기능, 취소기능, 삭제기능.

        //질문
        /// 데이터 형 작성됨. ->
        /// android kotlin 언어로 제작.



        // add code
        // 문의 내용 리스트 화면으로 이동하는 버튼 클릭 이벤트 등록
        val inquiryListButton: Button = findViewById(R.id.inquiry_list_button)
        inquiryListButton.setOnClickListener {
            val intent = Intent(this, InquiryListActivity::class.java)
            startActivity(intent)
        }



    }
}
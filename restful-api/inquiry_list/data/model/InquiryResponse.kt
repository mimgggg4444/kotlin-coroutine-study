package com.min.inquiry_list.data.model

data class InquiryResponse(


    // 인쿼리리스폰스 데이터 클래스로 가져오는 구문.
    val code: Int,
    val msg: String,
    val data: List<Inquiry>
)


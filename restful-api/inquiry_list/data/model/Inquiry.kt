package com.min.inquiry_list.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

/// 데이터 클래스 정의해둠.
///밑의 데이터 전부 정의됨

//* 데이터 변수명이 swagger ui와 일치 하지 않아서 생겼던 문제일 가능성. -> 고치고 해결되는거 확인 요청


data class Inquiry(
    @SerializedName("PERSON_NAME") val personName: String,
    @SerializedName("CONTENT_FLAG") val contentFlag: Int,
    @SerializedName("ACCESS_ROUTE") val accessRoute: String,
    @SerializedName("CREATED_AT") val createdAt: String,
    @SerializedName("IS_AGREEMENT") val isAgreement: Int,
    @SerializedName("CONTECT_FLAG_TEXT") val contectFlagText: String,
    @SerializedName("PHONE") val phone: String,
    @SerializedName("EMAIL") val email: String,
    @SerializedName("COMPANY_NAME") val companyName: String,
    @SerializedName("ACCESS_ROUTE_TEXT") val accessRouteText: String,
    @SerializedName("ADDRESS") val address: String,
    @SerializedName("IS_CHECK") val isCheck: Int,
    @SerializedName("UPDATED_AT") val updatedAt: String?,
    @SerializedName("IDX") val idx: Int,
    @SerializedName("MEMO") val memo: String
) : Serializable

//serializable -> import해서 가져오기
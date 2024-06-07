package com.min.model


data class ContectReq(
    val contectFlag: Int,
    val contectFlagText: String,
    val companyName: String,
    val personName: String,
    val phone: String,
    val address: String,
    val email: String,
    val memo: String,
    val accessRoute: List<Int>,
    val accessRouteText: String,
    val isAgreement: Int,
    val isCheck: Int
)
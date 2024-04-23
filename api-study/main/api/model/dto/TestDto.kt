package com.daelim.springtest.main.api.model.dto

data class TestDto(
    val id: String,
    val nickname: String,

)

data class TestDtoRequest(
    val id: String
)

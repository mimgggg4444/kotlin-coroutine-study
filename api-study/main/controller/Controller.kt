package com.daelim.springtest.main.controller

import com.daelim.springtest.main.api.model.dto.TestDto
import com.daelim.springtest.main.api.model.dto.TestDtoRequest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import kotlin.random.Random


@RestController
class Controller {
    private val tests = mutableListOf<TestDto>()

    @PostMapping("/test")


    fun postNickname(@RequestBody testDtoRequest: TestDtoRequest): ResponseEntity<Any> {
        val existingTest = tests.find { it.id == testDtoRequest.id }
        if (existingTest != null) {
            return ResponseEntity.badRequest().body("ID already exists")
        }

        val adjectives = arrayOf("용감한", "귀여운", "멋진", "친절한", "똑똑한")
        val nouns = arrayOf("사자", "토끼", "여우", "너구리", "펭귄")


        val randomNickname = "${adjectives[Random.nextInt(adjectives.size)]} ${nouns[Random.nextInt(nouns.size)]}"

        val testDto = TestDto(
            id = testDtoRequest.id,
            nickname = randomNickname
        )
        tests.add(testDto)
        return ResponseEntity.ok().body(testDto)
    }

    @GetMapping("/test")
    fun getAllTestDto(
    ): ResponseEntity<List<TestDto>> {
        val response = tests
        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/test/{id}")
    fun getTestDto(
        @PathVariable("id") userId: String
    ): ResponseEntity<TestDto> {
        val response = tests.firstOrNull { it.id == userId }
        return ResponseEntity.ok().body(response)
    }

}

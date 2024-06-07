package com.min

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import com.min.api.ApiService
import com.min.model.ContectReq
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var contectFlagRadioGroup: RadioGroup
    private lateinit var contectFlagTextEditText: EditText
    private lateinit var companyNameEditText: EditText
    private lateinit var personNameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var memoEditText: EditText
    private lateinit var accessRoute1: CheckBox
    private lateinit var accessRoute2: CheckBox
    private lateinit var accessRoute3: CheckBox
    private lateinit var accessRoute4: CheckBox
    private lateinit var accessRouteTextEditText: EditText
    private lateinit var agreementCheckBox: CheckBox
    private lateinit var isCheckEditText: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contectFlagRadioGroup = findViewById(R.id.contectFlagRadioGroup)
        contectFlagTextEditText = findViewById(R.id.contectFlagTextEditText)
        companyNameEditText = findViewById(R.id.companyNameEditText)
        personNameEditText = findViewById(R.id.personNameEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        addressEditText = findViewById(R.id.addressEditText)
        emailEditText = findViewById(R.id.emailEditText)
        memoEditText = findViewById(R.id.memoEditText)
        accessRoute1 = findViewById(R.id.accessRoute1)
        accessRoute2 = findViewById(R.id.accessRoute2)
        accessRoute3 = findViewById(R.id.accessRoute3)
        accessRoute4 = findViewById(R.id.accessRoute4)
        accessRouteTextEditText = findViewById(R.id.accessRouteTextEditText)
        agreementCheckBox = findViewById(R.id.agreementCheckBox)
        isCheckEditText = findViewById(R.id.isCheckEditText)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener {
            sendContect()

            //add code
            Log.e("main", "전송버튼이 클릭됨")

        }
    }

    private fun sendContect() {
        val contectFlag = when (contectFlagRadioGroup.checkedRadioButtonId) {
            R.id.contectFlag1 -> 1
            R.id.contectFlag2 -> 2
            R.id.contectFlag3 -> 3
            R.id.contectFlag4 -> 4
            R.id.contectFlag5 -> 5
            else -> 0
        }
        val contectFlagText = contectFlagTextEditText.text.toString()
        val companyName = companyNameEditText.text.toString()
        val personName = personNameEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val address = addressEditText.text.toString()
        val email = emailEditText.text.toString()
        val memo = memoEditText.text.toString()


        // 다른거 선택했을때
        val accessRoute = mutableListOf<Int>()
        if (accessRoute1.isChecked) accessRoute.add(1)
        if (accessRoute2.isChecked) accessRoute.add(2)
        if (accessRoute3.isChecked) accessRoute.add(3)
        if (accessRoute4.isChecked) accessRoute.add(4)


        val accessRouteText = accessRouteTextEditText.text.toString()
        val isAgreement = if (agreementCheckBox.isChecked) 1 else 0
        val isCheck = isCheckEditText.text.toString().toIntOrNull() ?: 0

        val contectReq = ContectReq(
            contectFlag,
            contectFlagText,
            companyName,
            personName,
            phone,
            address,
            email,
            memo,
            accessRoute,
            accessRouteText,
            isAgreement,
            isCheck
        )
        // 전송되는 정보 로그 출력
        //add code
        Log.d("MainActivity", "전송되는 정보:")
        Log.d("MainActivity", "contectFlag: $contectFlag")
        Log.d("MainActivity", "contectFlagText: $contectFlagText")
        Log.d("MainActivity", "companyName: $companyName")
        Log.d("MainActivity", "personName: $personName")
        Log.d("MainActivity", "phone: $phone")
        Log.d("MainActivity", "address: $address")
        Log.d("MainActivity", "email: $email")
        Log.d("MainActivity", "memo: $memo")
        Log.d("MainActivity", "accessRoute: $accessRoute")
        Log.d("MainActivity", "accessRouteText: $accessRouteText")
        Log.d("MainActivity", "isAgreement: $isAgreement")
        Log.d("MainActivity", "isCheck: $isCheck")

        val apiService = ApiService.create()
        apiService.sendContect(contectReq).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // 전송 성공 로그 출력
                    //add code
                    Log.d("MainActivity", "전송에 성공했습니다.")
                    //add code
                } else {
                    // 전송 실패 로그 출력

                    Log.e("MainActivity", "전송에 실패했습니다. 응답 코드: ${response.code()}")
                }


            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // 실패 처리
                //add code
                Log.e("MainActivity", "전송에 실패했습니다. 오류: ${t.message}")

            }
        })
    }
}
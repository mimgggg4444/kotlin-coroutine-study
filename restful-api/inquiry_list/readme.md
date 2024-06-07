


각 함수당 문제가 있는 부분.
1. network inquiry api -> 문제 해결 완
   1.     ): Call<InquiryResponse> -> Unresolved reference: InquiryResponse 그렇다는 의미는 Call에 unresolved reference가 없음

3. inquiry detail activity 3,4번과 같은 문제. 해결방법은? -> 해결 import를 다른 걸 import해와서 생긴 문제.
   4.         inquiryApi = RetrofitClient.create(InquiryApi::class.java) -> 디펜던시에서 retrofitclient를 추가할 수 있음. 문제 그렇게 해결 

4. inquiry list activity -> 
   5.             // override에서 문제 발생. onResponse가 없다고 예상됨. -> override를 없앰으로서 문제가 해결되는가?
            override fun onResponse(call: Call<InquiryResponse>, response: Response<InquiryResponse>) {


이제 실제 코드 실행 ->


   
그렇다면 문제가 있는 부분에서 어떻게 변환되어야 문제를 해결할 수 있는가?


log를 통해서 데이터를 가져오는지 확인.
인터넷 퍼미션,  manifest에 activity 추가홰주는 문제 -> 2개다 해결. 

새로운 문제 -> 데이터가 화면에 보이지 않는문제 발생. 문제 해결위해서 로그를 통한 제대로 로그 출력 메시지 확인.
네트워크 보안 정책. network파일을 만들어서 정의 해줘야함. http통신할때 


-> list가 안보임 -> 회사명이 공란이라서. 혹은 텍스트 디자인 문제? 어떤게 문제?

list가 안보이니, 각 블록에 백그라운드 컬러를 줘서 보이게 설정하는 방법. 즉, list가 있다면 백그라운드 컬러가 보일것임.

///
android retrofit을 사용방법.


<clear> 데이터 양식이 맞지 않아서 생겼던 문제. -> 데이터가 출력됨. 이제 해야할건

-----> 맞는 데이터를 입력하고 클릭했을때 디테일 정보 + 처리, 취소, 삭제 의 데이터가 입력되는걸 확인하기




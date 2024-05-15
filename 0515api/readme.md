### 해외축구

- https://docs.football-data.org/general/v4/coding/python.html#_plain_request
```
src
└── main
├── kotlin
│   └── com
│       └── example
│           ├── config
│           │   └── FootballDataConfig.kt
│           ├── service
│           │   └── FootballDataService.kt
│           └── controller
│               └── FootballDataController.kt
└── resources
└── application.properties
```
---
---

### 로또
- https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=1119
- "www.dhlottery.co.kr/common.do" @GET method = "getLottoNumber" drwNo = "\(조회하고자 하는 회차 번호)"


example - {"totSellamnt":111840714000,"returnValue":"success","drwNoDate":"2024-05-11","firstWinamnt":1396028764,"drwtNo6":45,"drwtNo4":13,"firstPrzwnerCo":19,"drwtNo5":20,"bnusNo":3,"firstAccumamnt":26524546516,"drwNo":1119,"drwtNo2":9,"drwtNo3":12,"drwtNo1":1}


---
---
### 꽃가루
-GET
/getPinePollenRiskIdxV3
꽃가루농도위험지수(소나무)조회

GET
/getWeedsPollenRiskndxV3
꽃가루농도위험지수(잡초류)조회

GET
/getOakPollenRiskIdxV3
꽃가루농도위험지수(참나무)조회

###



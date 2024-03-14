# KotlinCoroutineChronicles
코틀린 코루틴의 정석 책 내용 요약 정리


---
아래는 주어진 목차를 Markdown 형식으로 표현한 것입니다:

```markdown
# 목차

## 1장 스레드 기반 작업의 한계와 코루틴의 등장

### 1.1. JVM 프로세스와 스레드
### 1.2. 단일 스레드의 한계와 멀티 스레드 프로그래밍
#### 1.2.1. 단일 스레드 애플리케이션의 한계
#### 1.2.2. 멀티 스레드 프로그래밍을 통한 단일 스레드의 한계 극복
### 1.3. 스레드, 스레드풀을 사용한 멀티 스레드 프로그래밍
#### 1.3.1. Thread 클래스를 사용하는 방법과 한계
#### 1.3.2. Executor 프레임웍을 통해 스레드풀 사용하기
#### 1.3.3. 이후의 멀티 스레드 프로그래밍과 한계
### 1.4. 기존 멀티 스레드 프로그래밍의 한계와 코루틴
#### 1.4.1. 기존 멀티 스레드 프로그래밍의 한계
#### 1.4.2. 코루틴은 스레드 블로킹 문제를 어떻게 극복하는가?
### 1.5. 요약

## 2장 코루틴 개발 환경 설정

### 2.1. 인텔리제이 아이디어 설치 및 둘러보기
#### 2.1.1. 인텔리제이 아이디어 설치하기
### 2.2. 코틀린 프로젝트 생성하고 화면 구성 살펴보기
#### 2.2.1. 프로젝트 생성하기
#### 2.2.2. IDE 구성 살펴보기
### 2.3. 첫 코루틴 실행하기
#### 2.3.1. 코루틴 라이브러리 추가하기
#### 2.3.2. 첫 코루틴 실행하기
### 2.4. 코루틴 디버깅 환경 설정하기
#### 2.4.1. 실행 중인 스레드 출력하기
#### 2.4.2. 실행 중인 코루틴 이름 출력하기
#### 2.4.3. launch 사용해 코루틴 추가로 실행하기
#### 2.4.4. CoroutineName 사용해 코루틴에 이름 추가하기
### 2.5. 요약

## 3장 CoroutineDispatcher

### 3.1. CoroutineDispatcher란 무엇인가?
#### 3.1.1. CoroutineDispatcher의 동작 살펴보기
#### 3.1.2. CoroutineDispatcher의 역할
### 3.2. 제한된 디스패처와 무제한 디스패처
### 3.3. 제한된 디스패처 생성하기
#### 3.3.1. 단일 스레드 디스패처 만들기
#### 3.3.2. 멀티 스레드 디스패처 만들기
### 3.4. CoroutineDispatcher 사용해 코루틴 실행하기
#### 3.4.1. launch의 파라미터로 CoroutineDispatcher 사용하기
#### 3.4.2. 부모 코루틴의 CoroutineDispatcher 사용해 자식 코루틴 실행하기
### 3.5. 미리 정의된 CoroutineDispatcher
#### 3.5.1. Dispatchers.IO
#### 3.5.2. Dispatchers.Default
#### 3.5.3. limitedParallelism 사용해 Dispatchers.Default 스레드 사용 제한하기
#### 3.5.4. 공유 스레드풀을 사용하는 Dispatchers.IO와 Dispatchers.Default
#### 3.5.5. Dispatchers.Main
### 3.6. 요약

## 4장 코루틴 빌더와 Job

### 4.1. join을 사용한 코루틴 순차 처리
#### 4.1.1. 순차 처리가 안 될 경우의 문제
#### 4.1.2. join 함수 사용해 순차 처리하기
### 4.2. joinAll을 사용한 코루틴 순차 처리
#### 4.2.1. joinAll 함수
#### 4.2.2. joinAll 함수 사용해 보기
### 4.3. CoroutineStart.LAZY 사용해 코루틴 지연 시작하기
#### 4.3.1. 지연 시작을 살펴보기 위한 준비
#### 4.3.2. CoroutineStart.LAZY 사용해 코루틴 지연 시작하기
### 4.4. 코루틴 취소하기
#### 4.4.1. cancel 사용해 Job 취소하기
#### 4.4.2. cancelAndJoin을 사용한 순차 처리
### 4.5. 코루틴의 취소 확인
#### 4.5.1. delay를 사용한 취소 확인
#### 4.5.2. yield를 사용한 취소 확인
#### 4.5.3. CoroutineScope.isActive를 사용한 취소 확인
### 4.6. 코루틴의 상태와 Job의 상태 변수
#### 4.6.1. Job의 상태를 출력하는 함수 만들기
#### 4.6.2. 생성 상태의 코루틴
#### 4.6.3. 실행 중 상태

의 코루틴
#### 4.6.4. 실행 완료 상태의 코루틴
#### 4.6.5. 취소 중인 코루틴
#### 4.6.6. 취소 완료된 코루틴
#### 4.6.7. 상태 정리
### 4.7. 요약

## 5장 async와 Deferred

### 5.1. async 사용해 결괏값 수신하기
#### 5.1.1. async 사용해 Deferred 만들기
#### 5.1.2. await를 사용한 결괏값 수신
### 5.2. Deferred는 특수한 형태의 Job이다
### 5.3. 복수의 코루틴으로부터 결괏값 수신하기
#### 5.3.1. await를 사용해 복수의 코루틴으로부터 결괏값 수신하기
#### 5.3.2. awaitAll을 사용한 결괏값 수신
#### 5.3.3. 컬렉션에 대해 awaitAll 사용하기
### 5.4. withContext
#### 5.4.1. withContext로 async-await 대체하기
#### 5.4.2. withContext의 동작 방식
#### 5.4.3. withContext 사용 시 주의점
### 5.5. 요약

## 6장 CoroutineContext

### 6.1. CoroutineContext의 구성 요소
### 6.2. CoroutineContext 구성하기
#### 6.2.1. CoroutineContext가 구성 요소를 관리하는 방법
#### 6.2.2. CoroutineContext 구성
#### 6.2.3. CoroutineContext 구성 요소 덮어씌우기
#### 6.2.4. 여러 구성 요소로 이뤄진 CoroutineContext 합치기
#### 6.2.5. CoroutineContext에 Job 생성해 추가하기
### 6.3. CoroutineContext 구성 요소에 접근하기
#### 6.3.1. CoroutineContext 구성 요소의 키
#### 6.3.2. 키를 사용해 CoroutineContext 구성 요소에 접근하기
### 6.4. CoroutineContext 구성 요소 제거하기
#### 6.4.1. minusKey 사용해 구성 요소 제거하기
#### 6.4.2. minusKey 함수 사용 시 주의할 점
### 6.5. 요약

## 7장 구조화된 동시성

### 7.1. 실행 환경 상속
#### 7.1.1. 부모 코루틴의 실행 환경 상속
#### 7.1.2. 실행 환경 덮어씌우기
#### 7.1.3. 상속되지 않는 Job
#### 7.1.4. 구조화에 사용되는 Job
### 7.2. 코루틴의 구조화와 작업 제어
#### 7.2.1. 취소의 전파
#### 7.2.2. 부모 코루틴의 자식 코루틴에 대한 완료 의존성
### 7.3. CoroutineScope 사용해 코루틴 관리하기
#### 7.3.1. CoroutineScope 생성하기
#### 7.3.2. 코루틴에게 실행 환경을 제공하는 CoroutineScope
#### 7.3.3. CoroutineScope에 속한 코루틴의 범위
#### 7.3.4. CoroutineScope 취소하기
#### 7.3.5. CoroutineScope 활성화 상태 확인하기
### 7.4. 구조화와 Job
#### 7.4.1. runBlocking과 루트 Job
#### 7.4.2. Job 구조화 깨기
#### 7.4.3. Job 사용해 일부 코루틴만 취소되지 않게 만들기
#### 7.4.4. 생성된 Job의 부모를 명시적으로 설정하기
#### 7.4.5. 생성된 Job은 자동으로 실행 완료되지 않는다
### 7.5. 요약

## 8장 예외 처리

### 8.1. 코루틴의 예외 전파
#### 8.1.1. 코루틴에서 예외가 전파되는 방식
#### 8.1.2. 예제로 알아보는 예외 전파
### 8.2. 예외 전파 제한
#### 8.2.1. Job 객체를 사용한 예외 전파 제한
#### 8.2.2. SupervisorJob 객체를 사용한 예외 전파 제한
#### 8.2.3. supervisorScope를 사용한 예외 전파 제한
### 8.3. CoroutineExceptionHandler를 사용한 예외 처리
#### 8.3.1. CoroutineExceptionHandler 생성
#### 8.3.2. CoroutineExceptionHandler 사용
#### 8.3.3. 처리되지 않은 예외만 처리하는 CoroutineExceptionHandler
#### 8.3.4. CoroutineExceptionHandler가 예외를 처리하도록 만들기
#### 8.3.5. CoroutineExceptionHandler는 예외 전파를 제한하지 않는다
### 8.4. try catch문을 사용한 예외 처리
#### 8.4.1. try catch문을 사용해 코루틴 예외 처리하기
#### 8.4.2. 코루틴 빌더 함수에 대한 try catch문은 코루틴의 예외를 잡지 못한다
### 8.5. async의 예외 처리
#### 8.5.1. async의 예외 노출
#### 8.5.2. async의 예외 전파
### 8.6. 전파되지 않는 예외
#### 8.6.1. 전파되지 않는 CancellationException
#### 8.6.2. 코루틴

 취소 시 사용되는 JobCancellationException
#### 8.6.3. withTimeOut 사용해 코루틴의 실행 시간 제한하기
### 8.7. 요약

## 9장 일시 중단 함수

### 9.1. 일시 중단 함수와 코루틴
#### 9.1.1. 일시 중단 함수란 무엇인가?
#### 9.1.2. 일시 중단 함수는 코루틴이 아니다
#### 9.1.3. 일시 중단 함수를 별도의 코루틴상에서 실행하기
### 9.2. 일시 중단 함수의 사용
#### 9.2.1. 일시 중단 함수의 호출 가능 지점
#### 9.2.2. 일시 중단 함수에서 코루틴 실행하기
### 9.3. 요약

## 10장 코루틴의 이해

### 10.1. 서브루틴과 코루틴
#### 10.1.1. 루틴과 서브루틴
#### 10.1.2. 서브루틴과 코루틴의 차이
### 10.2. 코루틴의 스레드 양보
#### 10.2.1. delay 일시 중단 함수를 통해 알아보는 스레드 양보
#### 10.2.2. join과 await의 동작 방식 자세히 알아보기
#### 10.2.3. yield 함수 호출해 스레드 양보하기
### 10.3. 코루틴의 실행 스레드
#### 10.3.1. 코루틴의 실행 스레드는 고정이 아니다
#### 10.3.2. 스레드를 양보하지 않으면 실행 스레드가 바뀌지 않는다
### 10.4. 요약

## 11장 코루틴 심화

### 11.1. 공유 상태를 사용하는 코루틴의 문제와 데이터 동기화
#### 11.1.1. 가변 변수를 사용할 때의 문제점
#### 11.1.2. JVM의 메모리 공간이 하드웨어 메모리 구조와 연결되는 방식
#### 11.1.3. 공유 상태에 대한 메모리 가시성 문제와 해결 방법
#### 11.1.4. 공유 상태에 대한 경쟁 상태 문제와 해결 방법
### 11.2. CoroutineStart의 다양한 옵션들 살펴보기
#### 11.2.1. CoroutineStart.DEFAULT
#### 11.2.2. CoroutineStart.ATOMIC
#### 11.2.3. CoroutineStart.UNDISPATCHED
### 11.3. 무제한 디스패처
#### 11.3.1. 무제한 디스패처란?
#### 11.3.2. 무제한 디스패처의 특징
### 11.4. 코루틴의 동작 방식과 Continuation
#### 11.4.1. Continuation Passing Style
#### 11.4.2. 코루틴의 일시 중단과 재개로 알아보는 Continuation
#### 11.4.3. 다른 작업으로부터 결과 수신해 코루틴 재개하기
### 11.5. 요약

## 12장 코루틴 단위 테스트

### 12.1. 단위 테스트 기초
#### 12.1.1. 단위 테스트란 무엇인가?
#### 12.1.2. 테스트 환경 설정하기
#### 12.1.3. 간단한 테스트 만들고 실행하기
#### 12.1.4. @BeforeEach 어노테이션을 사용한 테스트 환경 설정
#### 12.1.5. 테스트 더블을 사용해 의존성 있는 객체 테스트하기
### 12.2. 코루틴 단위 테스트 시작하기
#### 12.2.1. 첫 코루틴 테스트 작성하기
#### 12.2.2. runBlocking을 사용한 테스트의 한계
### 12.3. 코루틴 테스트 라이브러리
#### 12.3.1. 코루틴 테스트 라이브러리 의존성 설정하기
#### 12.3.2. TestCoroutineScheduler 사용해 가상 시간에서 테스트 진행하기
#### 12.3.3. TestCoroutineScheduler를 포함하는 StandardTestDispatcher
#### 12.3.4. TestScope 사용해 가상 시간에서 테스트 진행하기
#### 12.3.5. runTest 사용해 테스트 만들기
### 12.4. 코루틴 단위 테스트 만들어 보기
#### 12.4.1. 코루틴 단위 테스트를 위한 코드 준비하기
#### 12.4.2. FollowerSearcher 클래스 테스트 작성하기
### 12.5. 코루틴 테스트 심화
#### 12.5.1. 함수 내부에서 새로운 코루틴을 실행하는 객체에 대한 테스트
#### 12.5.2. backgroundScope를 사용해 테스트 만들기
### 12.6. 요약
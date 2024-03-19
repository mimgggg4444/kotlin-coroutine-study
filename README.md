# KotlinCoroutineChronicles
코틀린 코루틴의 정석 책 내용 요약 정리


---



# 목차
<div id="#"></div>
<a href="#1">1장 스레드 기반 작업의 한계와 코루틴의 등장</a>
<a href="#2">2장 코루틴 개발 환경 설정</a>
<a href="#3">3장 CoroutineDispatcher</a>
<a href="#4">4장 코루틴 빌더와 Job</a>
<a href="#5">5장 async와 Deferred</a>
<a href="#6">6장 CoroutineContext</a>
<a href="#7">7장 구조화된 동시성</a>
<a href="#8">8장 예외 처리</a>
<a href="#9">9장 일시 중단 함수</a>
<a href="#10">10장 코루틴의 이해</a>
<a href="#11">11장 코루틴 심화</a>
<a href="#12">12장코루틴 단위 테스트</a>








## 1장 스레드 기반 작업의 한계와 코루틴의 등장
<div id="1"></div>

### 1.1. JVM 프로세스와 스레드
JVM(Java Virtual Machine)은 자바 애플리케이션을 실행하는 프로세스 내에서 다수의 스레드를 관리하여 동시성을 제공합니다.

### 1.2. 단일 스레드의 한계와 멀티 스레드 프로그래밍
#### 1.2.1. 단일 스레드 애플리케이션의 한계
단일 스레드 애플리케이션은 한 번에 하나의 작업만 처리할 수 있어, I/O 또는 CPU 집약적 작업 시 응답성이 떨어집니다.


#### 1.2.2. 멀티 스레드 프로그래밍을 통한 단일 스레드의 한계 극복
멀티 스레드 프로그래밍을 통해 여러 작업을 동시에 처리함으로써 애플리케이션의 처리량과 응답성을 향상시킬 수 있습니다.

### 1.3. 스레드, 스레드풀을 사용한 멀티 스레드 프로그래밍
#### 1.3.1. Thread 클래스를 사용하는 방법과 한계
Thread 클래스를 직접 확장하거나 Runnable 인터페이스를 구현하여 사용할 수 있으나, 스레드 관리와 리소스 활용에 한계가 있습니다.

```kotlin
Thread thread = new Thread(() -> System.out.println("Thread running"));
thread.start();
//위 코드는 새 스레드를 생성하여 "Thread running"을 출력합니다.

```

#### 1.3.2. Executor 프레임웍을 통해 스레드풀 사용하기
Executor 프레임워크를 사용하면 스레드풀을 통해 스레드의 생성과 관리를 효율적으로 할 수 있습니다.
```kotlin
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.execute(() -> System.out.println("Running in a thread pool"));
executor.shutdown();
//이 코드는 스레드풀에서 작업을 실행합니다.

```
#### 1.3.3. 이후의 멀티 스레드 프로그래밍과 한계
멀티 스레드 프로그래밍은 동시성을 제공하지만, 스레드간의 동기화 및 데드락과 같은 복잡성을 관리해야 하는 한계가 있습니다.

### 1.4. 기존 멀티 스레드 프로그래밍의 한계와 코루틴
#### 1.4.1. 기존 멀티 스레드 프로그래밍의 한계
기존의 멀티 스레드 프로그래밍은 리소스 관리, 복잡한 동기화 문제 등으로 인해 효율성과 생산성이 떨어질 수 있습니다.

#### 1.4.2. 코루틴은 스레드 블로킹 문제를 어떻게 극복하는가?
코루틴은 비동기 프로그래밍을 단순화하며, 경량 스레드처럼 동작하되 스레드의 블로킹 없이 비동기 작업을 효율적으로 관리합니다.

```kotlin
suspend fun loadData
```




## 2장 코루틴 개발 환경 설정
<div id="2"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 2.1. 인텔리제이 아이디어 설치 및 둘러보기

#### 2.1.1. 인텔리제이 아이디어 설치하기
### 2.2. 코틀린 프로젝트 생성하고 화면 구성 살펴보기
#### 2.2.1. 프로젝트 생성하기
#### 2.2.2. IDE 구성 살펴보기
### 2.3. 첫 코루틴 실행하기
#### 2.3.1. 코루틴 라이브러리 추가하기
```gradle
dependencies {
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.X.X'
}
```
#### 2.3.2. 첫 코루틴 실행하기
```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking { 
    launch { 
        delay(1000L)
        println("World!") 
    }
    println("Hello,")
}
```
### 2.4. 코루틴 디버깅 환경 설정하기
#### 2.4.1. 실행 중인 스레드 출력하기
```kotlin
println(Thread.currentThread().name)
```
#### 2.4.2. 실행 중인 코루틴 이름 출력하기
```kotlin
println(coroutineContext[CoroutineName]?.name)
```
#### 2.4.3. launch 사용해 코루틴 추가로 실행하기
```kotlin
launch {
    // 코루틴 내 작업
}
```
#### 2.4.4. CoroutineName 사용해 코루틴에 이름 추가하기

```kotlin
launch(CoroutineName("MyCoroutine")) {
    // Named coroutine for debugging
}
```

## 3장 CoroutineDispatcher
<div id="3"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 3.1. CoroutineDispatcher란 무엇인가?
- `CoroutineDispatcher`는 코루틴이 어떤 스레드에서 실행될지를 결정하는 코틀린의 구성 요소입니다.

#### 3.1.1. CoroutineDispatcher의 동작 살펴보기
- `CoroutineDispatcher`는 코루틴으로 작업을 어떤 스레드로 보낼지 결정하고, 스케줄링하는 원리를 관장합니다.

#### 3.1.2. CoroutineDispatcher의 역할
- `CoroutineDispatcher`의 주요 역할은 코루틴의 실행을 특정 스레드나 스레드 풀에 할당하는 것으로 이는 코루틴의 병렬성과 성능에 영향을 미칩니다.

### 3.2. 제한된 디스패처와 무제한 디스패처
- 제한된 디스패처는 고정된 수의 스레드를 사용하는 반면, 무제한 디스패처는 필요에 따라 스레드를 무제한으로 생성할 수 있습니다.

### 3.3. 제한된 디스패처 생성하기
- 일부 작업에 대해 구체적인 스레드 수나 스레드 풀을 제한하기 위해, 코틀린은 특정 스레드 사이즈를 가진 디스패처를 생성할 수 있게 합니다.

#### 3.3.1. 단일 스레드 디스패처 만들기
```kotlin
val singleThreadContext = newSingleThreadContext("MySingleThread")
//- 이 코드는 코루틴이 실행될 단일 스레드 컨텍스트를 생성합니다.

```
#### 3.3.2. 멀티 스레드 디스패처 만들기
```kotlin
val multiThreadContext = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
- 이 코드는 고정된 네 개의 스레드를 가진 디스패처를 만들어 멀티 스레드 코루틴을 가능하게 합니다.
```
### 3.4. CoroutineDispatcher 사용해 코루틴 실행하기
- `CoroutineDispatcher`를 사용해 코루틴을 실행하면, 작업의 실행 위치(스레드)를 세밀하게 제어할 수 있습니다.

#### 3.4.1. launch의 파라미터로 CoroutineDispatcher 사용하기
```kotlin
launch(singleThreadContext) {
    // 이 코루틴은 singleThreadContext에 지정된 단일 스레드에서 실행됩니다.
}
// - 이 코드는 `launch`에 `singleThreadContext`를 제공하여 해당 코루틴을 특정 스레드에서 실행하도록 합니다.

```
#### 3.4.2. 부모 코루틴의 CoroutineDispatcher 사용해 자식 코루틴 실행하기
```kotlin
val job = launch(coroutineContext) {
    launch {
        // 이 자식 코루틴은 부모와 동일한 CoroutineDispatcher를 사용합니다.
    }
}
//- 여기서 `coroutineContext`는 부모 코루틴의 컨텍스트를 자식에게 상속시켜 동일한 디스패처에서 실행되도록 합니다.

```
### 3.5. 미리 정의된 CoroutineDispatcher
- Kotlin은 `Dispatchers` 객체를 통해 미리 정의된 여러 디스패처를 제공합니다, 아래와 같이 특정한 사용 케이스에 적합합니다.

#### 3.5.1. Dispatchers.IO
- 입출력 중심의 작업을 위한 디스패처입니다, 파일, 네트워크 작업 등에 최적화되어 있습니다.

#### 3.5.2. Dispatchers.Default
- CPU 사용량이 많은 작업을 위한 디스패처로, 기본적으로 사용 가능한 CPU 코어 수에 비례하는 스레드 풀을 사용합니다.

#### 3.5.3. limitedParallelism 사용해 Dispatchers.Default 스레드 사용 제한하기
```kotlin
val limitedDispatcher = Dispatchers.Default.limitedParallelism(2)
//- 이 코드는 `Dispatchers.Default`의 병렬성을 제한하여 동시에 실행될 수 있는 스레드의 최대 개수를 설정합니다.
```

#### 3.5.4. 공유 스레드풀을 사용하는 Dispatchers.IO와 Dispatchers.Default
- `Dispatchers.IO`와 `Dispatchers.Default`는 두 범주의 작업을 위해 최적화된 공유 스레드풀을 사용하여 자원을 효율적으로 관리합니다.

#### 3.5.5. Dispatchers.Main
- 주로 UI 작업을 위해 사용되는 메인 디스패처로, 안드로이드와 같은 일부 환경에서 메인 스레드에서 실행되는 작업에 적합합니다.


## 4장 코루틴 빌더와 Job
<div id="4"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 4.1. join을 사용한 코루틴 순차 처리
- `join` 함수를 이용하면 한 코루틴이 완료되기를 기다린 후 다음 코루틴을 실행하여 작업을 순차적으로 처리할 수 있습니다.

#### 4.1.1. 순차 처리가 안 될 경우의 문제
- 코루틴이 동시에 실행될 경우 서로의 결과에 의존하는 작업들이 예상되는 순서대로 완료되지 않을 수 있는 문제가 발생할 수 있습니다.

#### 4.1.2. join 함수 사용해 순차 처리하기
```kotlin
val job = launch {
    // 어떤 처리를 합니다.
}
job.join() // 위에서 시작한 코루틴이 완료될 때까지 기다립니다.
- 위 코드는 `launch`를 통해 시작된 코루틴이 완료될 때까지 현재 스레드 또는 코루틴을 차단하는 `join()` 함수를 호출하여 순차적인 실행을 보장합니다.
```
### 4.2. joinAll을 사용한 코루틴 순차 처리
- `joinAll` 함수는 여러 코루틴이 모두 완료될 때까지 대기할 수 있도록 하여, 복수의 코루틴을 효과적으로 순차적으로 처리합니다.

#### 4.2.1. joinAll 함수
- `joinAll`은 매개변수로 받은 모든 코루틴이 완료될 때까지 현재 스레드 또는 코루틴을 차단합니다.

#### 4.2.2. joinAll 함수 사용해 보기
```kotlin
val job1 = launch { /* ... */ }
val job2 = launch { /* ... */ }
joinAll(job1, job2)
- 위 코드는 `job1`과 `job2` 두 코루틴이 모두 완료될 때까지 대기하도록 하여 두 작업이 모두 끝난 후에 다음 작업을 수행하게 합니다.
```
### 4.3. CoroutineStart.LAZY 사용해 코루틴 지연 시작하기
- `CoroutineStart.LAZY` 옵션을 사용하면 코루틴을 즉시 시작하지 않고, 필요한 시점까지 실행을 지연시킬 수 있습니다.

#### 4.3.1. 지연 시작을 살펴보기 위한 준비
- 지연 시작하려는 코루틴을 정의하고 `CoroutineStart.LAZY`를 파라미터로 넘겨서 초기화하지 않습니다.

#### 4.3.2. CoroutineStart.LAZY 사용해 코루틴 지연 시작하기
```kotlin
val lazyJob = launch(start = CoroutineStart.LAZY) { /* ... */ }
lazyJob.start() // 이 호출을 통해 명시적으로 코루틴 시작
- 이 코드는 `launch` 시 `CoroutineStart.LAZY`을 설정하여 코루틴을 즉시 시작하지 않습니다. `start()` 메소드로 코루틴을 수동으로 시작합니다.
```
### 4.4. 코루틴 취소하기
- 코루틴은 `cancel` 메소드를 사용해 언제든지 취소할 수 있으며, 이는 코루틴이 더 이상 필요하지 않을 때 사용됩니다.

#### 4.4.1. cancel 사용해 Job 취소하기
```kotlin
val job = launch { /* ... */ }
job.cancel() // 코루틴을 취소합니다.
- 이 코드는 실행 중이거나 아직 시작되지 않은 코루틴을 취소하는 `cancel` 메소드를 호출합니다.
```
#### 4.4.2. cancelAndJoin을 사용한 순차 처리
```kotlin
val job = launch { /* ... */ }
job.cancelAndJoin() // 코루틴을 취소하고, 완전히 종료될 때까지 기다립니다.
- `cancelAndJoin`은 `cancel`과 `join`을 동시에 수행하여 코루틴을 취소하고 완전히 종료될 때까지 기다리는 효과가 있습니다.
```
### 4.5. 코루틴의 취소 확인
- 코루틴 내부에서는 주기적으로 취소가 발생했는지를 확인하고 적절하게 대응하는 것이 중요합니다.

#### 4.5.1. delay를 사용한 취소 확인
```kotlin
launch {
    try {
        delay(Long.MAX_VALUE) // 오랜 시간 동안 대기
    } catch (e: CancellationException) {
        // 취소 시 예외 처리
    }
}
- `delay` 함수는 코루틴이 취소되었을 때 `CancellationException`을 발생시켜 취소 상태를 확인할 수 있습니다.
```
#### 4.5.2. yield를 사용한 취소 확인
```kotlin
launch {
    while (isActive) { // 코루틴이 활성 상태인지 확인
        yield() // 취소를 확인하고 처리합니다.
        // ...
    }
}
```
- `yield`는 현재 코루틴이 다른 코루틴에게 실행을 양보하고 취소되었으면 `CancellationException`을 발생시켜 처리할 기회를 제공합니다.

#### 4.5.3. CoroutineScope.isActive를 사용한 취소 확인
```kotlin
launch {
    if (!isActive) return@launch // 코루틴이 활성 상태가 아니라면 종료합니다.
    // ...
}
- `isActive`는 현재 코루틴의 상태가 활성 상태인지 아닌지를 반환합니다. 이를 이용해 코루틴 내부에서 취소 여부를 확인하고 대응할 수 있습니다.
```
### 4.6. 코루틴의 상태와 Job의 상태 변수
- `Job`의 생명 주기는 여러 상태를 가지며, 이를 확인하여 코루틴의 실행 상태를 관리할 수 있습니다.

#### 4.6.1. Job의 상태를 출력하는 함수 만들기
```kotlin
fun printJobStatus(job: Job) {
    println("IsActive: ${job.isActive}, IsCompleted: ${job.isCompleted}, IsCancelled: ${job.isCancelled}")
}
- 이 함수는 `Job` 인스턴스를 매개변수로 받아 현재 활성(active), 완료(completed), 취소(cancelled) 상태를 출력합니다.
```
#### 4.6.2. 생성 상태의 코루틴
- 코루틴이 시작되지 않아 초기 상태에 있는 것을 나타냅니다.

#### 4.6.3. 실행 중 상태의 코루틴
- 코루틴이 실행 중이며 작업이 진행되고 있는 상태입니다.

#### 4.6.4. 실행 완료 상태의 코루틴
- 코루틴의 모든 작업이 완료되어 더 이상 진행되지 않는 상태를 의미합니다.

#### 4.6.5. 취소 중인 코루틴
- 코루틴이 취소 요청을 받았으나 아직 완전히 취소 처리가 완료되지 않은 중간 상태입니다.

#### 4.6.6. 취소 완료된 코루틴
- 코루틴이 취소 요청을 처리하고 모든 관련 리소스가 정리된 상태입니다.

#### 4.6.7. 상태 정리
- `Job`의 상태를 통해 코루틴의 생명 주기를 정리하고 의도한 동작이 일어나도록 관리할 수 있습니다.


## 5장 async와 Deferred
<div id="5"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 5.1. async 사용해 결괏값 수신하기
- `async`는 코루틴을 비동기적으로 실행하여 결과를 `Deferred` 객체로 반환하고, 나중에 그 결과를 받을 수 있게 해주는 함수입니다.

#### 5.1.1. async 사용해 Deferred 만들기
```kotlin

val deferredResult = async { computeSomething() }
//- 이 코드는 `computeSomething()` 함수를 비동기적으로 실행하고, 반환된 값을 나중에 받기 위한 `Deferred` 객체를 만듭니다.
```
#### 5.1.2. await를 사용한 결괏값 수신
```kotlin

val result = deferredResult.await()
- `await()` 함수를 호출하여 `Deferred` 객체가 가지고 있는 결과값을 비동기적으로 받습니다; 결과가 준비될 때까지 대기합니다.
```
### 5.2. Deferred는 특수한 형태의 Job이다
- `Deferred`는 `Job`의 하위 타입으로, 작업이 완료될 때까지의 결과를 담고 있으며, 해당 결과를 `await()`을 통해 얻을 수 있습니다.

### 5.3. 복수의 코루틴으로부터 결괏값 수신하기
- 여러 `async` 코루틴이 실행되고 있을 때, 각각의 결과 값을 하나로 모아 수신할 수 있습니다.

#### 5.3.1. await를 사용해 복수의 코루틴으로부터 결괏값 수신하기
```kotlin
val deferredOne = async { computeOne() }
val deferredTwo = async { computeTwo() }
val resultOne = deferredOne.await() 
val resultTwo = deferredTwo.await()
//- 위 코드에서 `computeOne()`과 `computeTwo()`는 동시에 비동기적으로 실행되며, 각각의 결과는 `await()`을 통해 수신됩니다.
```
#### 5.3.2. awaitAll을 사용한 결괏값 수신
```kotlin
val results = awaitAll(deferredOne, deferredTwo)
//- `awaitAll` 함수를 사용해 복수의 `Deferred` 객체로부터 모든 결과를 수신할 때까지 대기하고, 결과들을 리스트로 반환받습니다.
```
#### 5.3.3. 컬렉션에 대해 awaitAll 사용하기
```kotlin
val deferredList = listOf(async { computeOne() }, async { computeTwo() })
val results = deferredList.awaitAll()
//- `awaitAll`은 `Deferred` 객체의 리스트에 대해서도 사용할 수 있으며, 모든 객체의 결과를 수신할 때까지 대기합니다.
```
### 5.4. withContext
- `withContext`는 지정한 컨텍스트(예: 디스패처)에서 코루틴을 실행하고 결과를 직접 반환하는 기능을 제공합니다.

#### 5.4.1. withContext로 async-await 대체하기
```kotlin
val result = withContext(Dispatchers.Default) { computeSomething() }
//- `withContext(Dispatchers.Default)`를 사용하면 `computeSomething()`이 기본 디스패처에서 실행되고, 실행이 완료되면 결과를 바로 반환합니다.
```
#### 5.4.2. withContext의 동작 방식
- `withContext`는 주어진 컨텍스트로 코루틴을 전환하고, 블록 내의 코드를 실행한 다음 그 결과를 반환하며 원래 컨텍스트로 돌아갑니다.

#### 5.4.3. withContext 사용 시 주의점
- `withContext`를 사용할 때는 코드 블록이 무거울 경우 현재 실행되는 다른 코루틴들이 차단될 수 있으니, 스레드 관리에 주의해야 합니다.


## 6장 CoroutineContext
<div id="6"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 6.1. CoroutineContext의 구성 요소
- `CoroutineContext`는 코루틴의 실행 상태와 스케줄링 등을 제어하는 여러 구성 요소(예: `Job`, `Dispatcher`)를 포함합니다.

### 6.2. CoroutineContext 구성하기
- 코루틴의 행동을 지정하기 위해 `CoroutineContext`를 구성하며, 다양한 요소들을 조합하여 커스텀 코루틴 컨텍스트를 만듭니다.

#### 6.2.1. CoroutineContext가 구성 요소를 관리하는 방법
- `CoroutineContext`는 내부적으로 `Element`들을 맵처럼 관리하며, 각 요소는 고유한 키를 통해 식별됩니다.

#### 6.2.2. CoroutineContext 구성
```kotlin
val context = Dispatchers.Default + CoroutineName("MyCoroutine")
//- 이 코드는 기본 스레드 디스패처와 코루틴 이름을 포함하는 새로운 `CoroutineContext`를 생성합니다.
```
#### 6.2.3. CoroutineContext 구성 요소 덮어씌우기
```kotlin
val context = Dispatchers.Default + CoroutineName("MyCoroutine") + CoroutineName("NewCoroutineName")
//- `CoroutineContext`에 같은 종류의 요소를 추가하면, 마지막에 추가한 요소로 이전 요소가 덮어씌워집니다.
```
#### 6.2.4. 여러 구성 요소로 이뤄진 CoroutineContext 합치기
```kotlin
val contextA = Dispatchers.Default + Job()
val contextB = CoroutineName("MyCoroutine")
val combinedContext = contextA + contextB
//- `contextA`와 `contextB`를 `+` 연산자를 사용해 합쳐 새로운 `CoroutineContext`를 생성합니다.
```
#### 6.2.5. CoroutineContext에 Job 생성해 추가하기
```kotlin
val contextWithJob = Dispatchers.Default + Job()
//- `Dispatchers.Default`에 `Job()`을 추가해 코루틴의 취소 및 생명주기 관리를 위한 `Job` 요소를 `CoroutineContext`에 추가합니다.
```
### 6.3. CoroutineContext 구성 요소에 접근하기
- `CoroutineContext`에 저장된 개별 요소에 접근하기 위해 `get` 연산자와 함께 해당 요소의 키를 사용합니다.

#### 6.3.1. CoroutineContext 구성 요소의 키
- 각 `CoroutineContext.Element`에는 고유한 타입의 `Key`가 있으며, 이 키를 통해 `Context` 내 요소에 접근할 수 있습니다.

#### 6.3.2. 키를 사용해 CoroutineContext 구성 요소에 접근하기
```kotlin
val dispatcher = combinedContext[CoroutineDispatcher.Key]
//- `combinedContext`로부터 `CoroutineDispatcher.Key`를 사용해 디스패처 요소에 접근합니다.
```
### 6.4. CoroutineContext 구성 요소 제거하기
- `CoroutineContext`에서 특정 요소를 제거하기 위해 `minusKey` 연산자와 해당 요소의 키를 사용합니다.

#### 6.4.1. minusKey 사용해 구성 요소 제거하기
```kotlin
val newContext = combinedContext - CoroutineName.Key
//- 위 코드는 `combinedContext`에서 `CoroutineName` 요소를 제거하여 `newContext`를 생성합니다.
```
#### 6.4.2. minusKey 함수 사용 시 주의할 점
- `minusKey`를 사용해 요소를 제거할 때 없는 키를 지정한다 하더라도 오류가 발생하지 않으며, 그대로 원래의 `CoroutineContext`를 반환합니다.


## 7장 구조화된 동시성
<div id="7"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 7.1. 실행 환경 상속
- 코루틴은 기본적으로 부모 코루틴의 `CoroutineContext`를 상속받으며, 이를 통해 실행 환경을 공유합니다.

#### 7.1.1. 부모 코루틴의 실행 환경 상속
```kotlin
val parentJob = Job()
val scope = CoroutineScope(Dispatchers.Default + parentJob)
scope.launch {
    // 이 코루틴은 부모의 CoroutineScope와 CoroutineContext를 상속받습니다.
}
// - 부모 코루틴으로부터 실행 환경을 상속받아 같은 컨텍스트와 스코프 내에서 작업을 수행합니다.
```
#### 7.1.2. 실행 환경 덮어씌우기
```kotlin
scope.launch(Dispatchers.IO) {
    // 이 코루틴은 부모의 CoroutineScope를 상속받았지만, 디스패처는 IO로 덮어씌워 사용합니다.
}
//- 특정 코루틴에서 실행 환경(예: 디스패처)을 변경하여 부모 코루틴의 환경을 덮어쓸 수 있습니다.
```
#### 7.1.3. 상속되지 않는 Job
- 부모 코루틴에서 `launch` 등을 사용해 생성된 자식 코루틴의 `Job`은 별도의 인스턴스이며, 부모와 독립적으로 관리됩니다.

#### 7.1.4. 구조화에 사용되는 Job
```kotlin
val parentJob = Job()
val childJob = scope.launch(parentJob) {
    // ...
}
//- 부모 코루틴의 `Job`을 자식 코루틴에게 직접 전달하여 구조화된 동시성을 통해 작업 관리를 수행합니다.
```
### 7.2. 코루틴의 구조화와 작업 제어
- 코루틴의 구조화는 작업의 제어를 용이하게 하며, 취소 및 완료 등의 동작을 코루틴 트리에 전파합니다.

#### 7.2.1. 취소의 전파
- 부모 코루틴이 취소되면 그 자식 코루틴들 역시 취소되어 취소가 모든 하위 코루틴에 전파됩니다.

#### 7.2.2. 부모 코루틴의 자식 코루틴에 대한 완료 의존성
- 부모 코루틴은 자신의 모든 자식 코루틴들이 완료될 때까지 자동으로 기다림으로써 작업의 단계적 완료를 보장합니다.

### 7.3. CoroutineScope 사용해 코루틴 관리하기
- `CoroutineScope`를 생성하여 코루틴의 생명주기를 관리하고, 스코프 내 코루틴들 사이의 종속성을 설정합니다.

#### 7.3.1. CoroutineScope 생성하기
```kotlin
val scope = CoroutineScope(Dispatchers.Default)
//- `CoroutineScope` 객체를 생성하여 코루틴을 그룹화하고, 제어 및 관리의 기점으로 사용합니다.
```
#### 7.3.2. 코루틴에게 실행 환경을 제공하는 CoroutineScope
- 생성된 `CoroutineScope`는 코루틴에 컨텍스트와 생명주기를 전달하여 실행 환경을 제공합니다.

#### 7.3.3. CoroutineScope에 속한 코루틴의 범위
- `CoroutineScope` 내에서 생성된 코루틴은 해당 스코프에 종속되어 스코프의 생명주기에 맞춰 실행됩니다.

#### 7.3.4. CoroutineScope 취소하기
```kotlin
scope.cancel()
//- `scope.cancel()`을 호출하여 `CoroutineScope` 내 모든 코루틴을 취소하고 자원을 해제할 수 있습니다.
```
#### 7.3.5. CoroutineScope 활성화 상태 확인하기
```kotlin
if (scope.isActive) {
    // CoroutineScope 내 코루틴들이 아직 활성화 상태인지 확인
}
//- `CoroutineScope`의 `isActive` 속성을 통해 스코프의 활성 상태를 확인할 수 있습니다.
```
### 7.4. 구조화와 Job
- `Job`은 코루틴의 생명주기를 대표하며, 구조화된 동시성을 통해 코루틴 구조와 종속성을 관리합니다.

#### 7.4.1. runBlocking과 루트 Job
```kotlin
runBlocking {
    // 이 블록 내에서 생성된 코루틴들은 runBlocking의 Job을 상속받습니다.
}
//- `runBlocking` 내에서 시작된 코루틴은 `runBlocking`의 `Job`을 상속받아 계층적 구조를 형성합니다.
```
#### 7.4.2. Job 구조화 깨기
- 자식 코루틴을 다른 스코프로 이동하거나 고립시켜 부모-자식 관계를 끊을 수 있으며, 이 경우 부모 코루틴의 취소가 자식 코루틴에 영향을 미치지 않습니다.

#### 7.4.3. Job 사용해 일부 코루틴만 취소되지 않게 만들기
```kotlin
val independentJob = Job()
scope.launch(independentJob) {
    // 이 코루틴은 스코프가 취소되어도 취소되지 않습니다.
}
//- 별도의 `Job` 객체를 사용하여 `CoroutineScope`의 취소로부터 독립된 코루틴을 실행할 수 있습니다.
```
#### 7.4.4. 생성된 Job의 부모를 명시적으로 설정하기
- 코루틴의 `Job` 파라미터를 명시적으로 설정함으로써 부모-자식 관계를 설정하고, 구조화된 작업 흐름을 만들 수 있습니다.

#### 7.4.5. 생성된 Job은 자동으로 실행 완료되지 않는다
- 코루틴이 `Job`과 함께 시작되었을 때, 이 작업의 완료는 자동으로 발생하지 않으며 개발자가 관리해야 합니다.


## 8장 예외 처리
<div id="8"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 8.1. 코루틴의 예외 전파
코루틴에서 발생한 예외는 기본적으로 코루틴 계층을 따라 상위로 전파되며, 이를 통해 오류를 처리할 수 있습니다.

#### 8.1.1. 코루틴에서 예외가 전파되는 방식
코루틴 내부에서 발생한 예외는 부모 코루틴까지 전파되고, 최종적으로 이를 처리하지 않으면 애플리케이션을 종료시킬 수 있습니다.

#### 8.1.2. 예제로 알아보는 예외 전파
```kotlin
launch {
    throw Exception("This exception will be propagated to the parent coroutine")
}
//- 이 코드에서 `launch` 내부에서 발생하는 예외는 외부로 전파되어 코루틴의 부모에게 도달합니다.
```
### 8.2. 예외 전파 제한
특정 구성 요소를 사용해 코루틴에서 발생하는 예외의 전파를 제한하고, 더 상위로의 전파를 방지할 수 있습니다.

#### 8.2.1. Job 객체를 사용한 예외 전파 제한
```kotlin
val job = Job()
launch(job) { // 예외 처리를 담당하는 코드 } job.invokeOnCompletion { exception -> if (exception is MyException) handleException(exception) }
//- `Job` 객체와 `invokeOnCompletion`을 사용하여 특정 예외를 처리하고 전파를 제한할 수 있습니다.
```
#### 8.2.2. SupervisorJob 객체를 사용한 예외 전파 제한
```kotlin
val job = SupervisorJob()
launch(job) { // 자식 코루틴에서 발생한 예외는 다른 자식 코루틴에 영향을 미치지 않습니다. }
//- `SupervisorJob`을 사용하면 자식 코루틴 중 하나에서 발생한 예외가 다른 자식들에게 영향을 주지 않습니다.
```
#### 8.2.3. supervisorScope를 사용한 예외 전파 제한
```kotlin
supervisorScope {
    launch {
        // 이 블록 내부에서 발생한 예외는 해당 스코프 내 다른 코루틴에 영향을 주지 않습니다.
    }
}
//- `supervisorScope`는 내부 코루틴의 예외가 동일 스코프의 다른 코루틴에게 영향을 주지 않도록 합니다.
```
### 8.3. CoroutineExceptionHandler를 사용한 예외 처리
코루틴에서 발생하는 예외를 전역적으로 잡아 처리하기 위해 `CoroutineExceptionHandler`가 사용됩니다.

#### 8.3.1. CoroutineExceptionHandler 생성
```kotlin
val handler = CoroutineExceptionHandler { _, exception -> handleException(exception) }
//- `CoroutineExceptionHandler`를 생성해 코루틴 내부에서 처리되지 않은 예외를 잡아 처리할 수 있습니다.
```
#### 8.3.2. CoroutineExceptionHandler 사용
```kotlin
launch(handler) {
    // 예외가 여기서 발생하면 CoroutineExceptionHandler가 처리합니다.
}
//- `CoroutineExceptionHandler`를 코루틴 컨텍스트에 추가하여 예외를 처리합니다.
```
#### 8.3.3. 처리되지 않은 예외만 처리하는 CoroutineExceptionHandler
`CoroutineExceptionHandler`는 코루틴 내에서 처리되지 않은 예외에 대해서만 동작합니다.

#### 8.3.4. CoroutineExceptionHandler가 예외를 처리하도록 만들기
코루틴 컨텍스트에 `CoroutineExceptionHandler`를 명시적으로 추가하여 예외 처리를 위임합니다.

#### 8.3.5. CoroutineExceptionHandler는 예외 전파를 제한하지 않는다
`CoroutineExceptionHandler`는 예외를 잡기는 하지만 자동으로는 예외의 전파를 중단시키지 않습니다.

### 8.4. try catch문을 사용한 예외 처리
코루틴 내부에서 발생하는 예외는 전통적인 try-catch 문을 사용하여 직접 잡고 처리할 수 있습니다.

#### 8.4.1. try catch문을 사용해 코루틴 예외 처리하기
```kotlin
launch {
    try {
        // 예외가 발생할 수 있는 코드
    } catch (e: Exception) {
        handleException(e)
    }
}
//- 이 코드는 코루틴 내에서 발생할 수 있는 예외를 try-catch문을 이용해 직접 잡고 처리합니다.
```
#### 8.4.2. 코루틴 빌더 함수에 대한 try catch문은 코루틴의 예외를 잡지 못한다
코루틴 빌더 함수 외부에 있는 try-catch문은 해당 코루틴 내부에서 발생한 예외를 잡지 못합니다.

### 8.5. async의 예외 처리
`async` 빌더로 작성한 코루틴은 예외를 `Deferred` 객체를 통해 전파하고, 이는 `await` 호출 시점에 노출됩니다.

#### 8.5.1. async의 예외 노출
```kotlin
val deferred = async {
    throw Exception("Error in async")
}
try {
    deferred.await()
} catch (e: Exception) {
    handleException(e)
}
//- `async` 코루틴의 예외는 `await` 호출 시 노출되고, 이를 통해 예외를 처리할 수 있습니다.
```
#### 8.5.2. async의 예외 전파
`async`로 생성된 `Deferred` 객체에서 `await`은 코루틴 내부에서 발생한 예외를 호출자에게 전파합니다.

### 8.6. 전파되지 않는 예외
특정 예외는 코루틴 실행을 제어하기 위한 목적으로 사용될 때 전파되지 않습니다.

#### 8.6.1. 전파되지 않는 CancellationException
`CancellationException`은 코루틴의 정상적인 취소를 나타내며, 이는 일반적으로 코루틴의 부모에게 전파되지 않습니다.

#### 8.6.2. 코루틴취소 시 사용되는 JobCancellationException
`JobCancellationException`은 코루틴의 취소를 나타내는 예외로, 이 역시 취소를 나타내는 데 사용됩니다.

#### 8.6.3. withTimeOut 사용해 코루틴의 실행 시간 제한하기
```kotlin

withTimeout(1000L) {
    // 시간이 초과되면 TimeoutCancellationException이 발생해 코루틴이 취소됩니다.
}
//- `withTimeout`은 정해진 시간 내에 코루틴이 완료되지 않으면 `TimeoutCancellationException`을 발생시켜 코루틴을 취소합니다.
```


## 9장 일시 중단 함수
<div id="9"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 9.1. 일시 중단 함수와 코루틴
#### 9.1.1. 일시 중단 함수란 무엇인가?
핵심내용: 일시 중단 함수는 실행을 일시 중단할 수 있고, 나중에 다시 재개할 수 있는 특별한 종류의 함수입니다.
코드 예시:
```kotlin
suspend fun fetchData(): Data {
    // 데이터를 비동기적으로 가져오는 로직
}

//설명: suspend 키워드를 사용하여 정의된 fetchData 함수는 비동기 작업을 수행하는 동안 실행을 일시 중단하고, 작업 완료 후 재개됩니다.
```
#### 9.1.2. 일시 중단 함수는 코루틴이 아니다
핵심내용: 일시 중단 함수 자체는 코루틴이 아니지만, 코루틴 내에서 실행될 수 있습니다.
코드 예시:
```kotlin
GlobalScope.launch {
    val data = fetchData() // 일시 중단 함수 호출
}
//설명: fetchData 일시 중단 함수는 GlobalScope.launch 코루틴 내에서 호출됩니다. 이는 일시 중단 함수가 코루틴 내부에서 실행될 수 있음을 보여줍니다.
```
#### 9.1.3. 일시 중단 함수를 별도의 코루틴상에서 실행하기
핵심내용: 일시 중단 함수는 코루틴 빌더를 사용하여 별도의 코루틴으로 실행될 수 있습니다.
코드 예시:
```kotlin
launch {
    val data = async { fetchData() }.await()
}

//설명: async 빌더는 fetchData 함수를 별도의 코루틴으로 실행하며, await를 통해 그 결과를 기다립니다.
```

### 9.2. 일시 중단 함수의 사용

#### 9.2.1. 일시 중단 함수의 호출 가능 지점
핵심내용: 일시 중단 함수는 다른 일시 중단 함수나 코루틴 내부에서만 호출될 수 있습니다.
코드 예시:
```kotlin
suspend fun process() {
    val data = fetchData() // 다른 일시 중단 함수 내에서 호출
}
//설명: process 일시 중단 함수 내에서 fetchData 일시 중단 함수를 호출하는 예시입니다.
```
#### 9.2.2. 일시 중단 함수에서 코루틴 실행하기
핵심내용: 일시 중단 함수 내에서도 코루틴을 실행하여 비동기 작업을 수행할 수 있습니다.
코드 예시:
```kotlin
suspend fun loadData() {
    coroutineScope {
        val data = async { fetchData() }
        // 데이터 처리 로직
    }
}
//설명: coroutineScope 블록 내에서 async를 사용하여 fetchData 함수를 비동기적으로 실행하는 방법을 보여줍니다.
```

## 10장 코루틴의 이해
<div id="10"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 10.1. 서브루틴과 코루틴
- 서브루틴은 특정 코드 블록을 실행한 다음 완료될 때까지 흐름을 차단하는 함수의 한 형태이며, 코루틴은 코드 실행 중 중단과 재개가 가능한 일반화된 서브루틴입니다.

#### 10.1.1. 루틴과 서브루틴
- 일반적으로 루틴은 프로그램의 실행 흐름을 구성하는 코드 블록이며, 서브루틴은 자신이 호출된 지점으로부터 실행을 시작하고 반환하는 루틴입니다.

#### 10.1.2. 서브루틴과 코루틴의 차이
- 서브루틴은 단방향의 실행 흐름을 가지며 호출 시점부터 종료까지 블록킹 방식으로 실행되지만, 코루틴은 양방향의 실행 흐름을 가질 수 있으며 중단과 재개가 가능합니다.

### 10.2. 코루틴의 스레드 양보
- 코루틴에서 스레드를 양보한다는 것은 현재 코루틴의 실행을 일시 중지하고 다른 코루틴이나 태스크가 실행될 수 있도록 스케줄러에게 기회를 준다는 의미입니다.

#### 10.2.1. delay 일시 중단 함수를 통해 알아보는 스레드 양보
```kotlin
launch {
    delay(1000) // 현재 코루틴을 1초간 중단하고, 그 동안 다른 코루틴이 작업을 할 수 있게 합니다.
}
//- `delay` 함수는 코루틴을 일시 중단하고 현재 스레드를 다른 대기중인 코루틴에게 양보합니다.
```
#### 10.2.2. join과 await의 동작 방식 자세히 알아보기
```kotlin
launch {
    val job = launch { /*...*/ }
    job.join() // job 코루틴이 완료될 때까지 현재 코루틴을 중단합니다.
}
//- `join`은 다른 코루틴(`job`)이 완료될 때까지 현재 코루틴을 중단시키며, `await`은 `async`에서 시작된 코루틴의 결과값을 기다립니다.
```
#### 10.2.3. yield 함수 호출해 스레드 양보하기
```kotlin
launch {
    yield() // 다른 코루틴에게 실행을 양보하고 나중에 이어서 실행됩니다.
}
//- `yield`는 현재 코루틴이 실행 중인 스레드를 양보하고, 코루틴 디스패처에 의해 나중에 재개될 수 있도록 스케줄을 조정합니다.
```
### 10.3. 코루틴의 실행 스레드
- 코루틴의 실행 스레드는 고정되어 있지 않으며, 컨텍스트 또는 디스패처에 따라 실행 스레드가 변경될 수 있습니다.

#### 10.3.1. 코루틴의 실행 스레드는 고정이 아니다
```kotlin
withContext(Dispatchers.IO) {
    // 이 블록은 IO 최적화된 스레드에서 실행됩니다.
}
//- 코루틴 컨텍스트를 변경하여 `withContext`를 사용하면 코루틴이 실행되는 스레드를 변경할 수 있습니다.
```
#### 10.3.2. 스레드를 양보하지 않으면 실행 스레드가 바뀌지 않는다
- 일반적으로 코루틴 안에서 스레드를 명시적으로 양보하지 않는 한, 코루틴은 시작된 스레드에서 계속 실행됩니다.


## 11장 코루틴 심화
<div id="11"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 11.1. 공유 상태를 사용하는 코루틴의 문제와 데이터 동기화
- 공유 상태를 사용할 때 코루틴 사이에서 발생할 수 있는 데이터 충돌과 메모리 가시성 문제는 동기화 기법을 사용해 해결할 수 있습니다.

#### 11.1.1. 가변 변수를 사용할 때의 문제점
- 여러 코루틴이 동일한 가변 변수에 동시에 접근하면 예상치 못한 결과를 초래할 수 있는 경쟁 상태(race condition)가 발생할 수 있습니다.

#### 11.1.2. JVM의 메모리 공간이 하드웨어 메모리 구조와 연결되는 방식
- JVM은 하드웨어 메모리 구조와 자신의 메모리 모델을 매핑하여, 코드에서 작성한 메모리 연산이 하드웨어에서 어떻게 수행될지 결정합니다.

#### 11.1.3. 공유 상태에 대한 메모리 가시성 문제와 해결 방법
- 멀티스레드 환경에서 메모리 가시성 문제는 `volatile` 키워드 사용, synchronized 블록, 또는 동시성 라이브러리를 적용해 해결할 수 있습니다.

#### 11.1.4. 공유 상태에 대한 경쟁 상태 문제와 해결 방법
- 경쟁 상태는 코루틴의 동기화 기법(예: Mutex, 채널)을 사용하여, 한 시점에 하나의 코루틴만이 자원에 접근하도록 하여 해결할 수 있습니다.

### 11.2. CoroutineStart의 다양한 옵션들 살펴보기
- `CoroutineStart`는 코루틴이 어떻게 시작될지 조절하는 옵션으로, 코루틴의 실행 시점과 방식을 제어합니다.

#### 11.2.1. CoroutineStart.DEFAULT
- 코루틴을 기본적으로 즉시 스케줄링하여 실행하지만, 코루틴 디스패처가 멈춤 표시되면 실행이 지연될 수 있습니다.

#### 11.2.2. CoroutineStart.ATOMIC
- 코루틴을 즉시 실행하지만, 시작 후 취소가 불가능한 상태로 만듭니다, 즉 취소가 지연됩니다.

#### 11.2.3. CoroutineStart.UNDISPATCHED
- 코루틴을 현재 스레드에서 즉시 실행하고, 첫 번째 일시 중단 지점까지 디스패치하지 않고 진행합니다.

### 11.3. 무제한 디스패처
- `Dispatcher.Unconfined`는 코루틴을 호출한 스레드에서 시작하지만, 첫 일시 중단 포인트 이후에는 재개된 호출 스레드에서 실행됩니다.

#### 11.3.1. 무제한 디스패처란?
- 무제한 디스패처는 코루틴이 시작되는 스레드를 제한하지 않고, 코루틴이 어떤 스레드에서 재개될지를 운영체제의 스레드 스케줄러에 의해 결정하게 합니다.

#### 11.3.2. 무제한 디스패처의 특징
- `Dispatcher.Unconfined`는 특정 스레드 상황에 구애받지 않으며, 코루틴이 실행될 때 스레드를 전환할 필요가 없을 때 유용합니다.

### 11.4. 코루틴의 동작 방식과 Continuation
- 코루틴은 Continuation-Passing Style을 사용하여 코루틴의 중단과 재개를 가능하게 하며, 일시 중단 함수를 통해 비동기 작업을 효과적으로 처리합니다.

#### 11.4.1. Continuation Passing Style
- CPS(Continuation-Passing Style)는 프로그램의 제어 흐름을 명시적인 Continuation으로 전달하는 프로그래밍 스타일입니다.

#### 11.4.2. 코루틴의 일시 중단과 재개로 알아보는 Continuation
- 코루틴의 일시 중단과 재개는 코루틴이 현재 지점에서 중단될 수 있는 흐름과 이를 다시 재개할 방법을 `Continuation`으로 관리합니다.

#### 11.4.3. 다른 작업으로부터 결과 수신해 코루틴 재개하기
```kotlin
suspend fun doSomething(): Int {
    return withContext(Dispatchers.IO) {
        // 길이 있는 작업 수행
        42 // 결과 반환
    }
}

launch {
    val result = doSomething() // doSomething이 완료된 후 결과를 받아와 코루틴이 재개됩니다.
}
//- 위 예제에서 `doSomething()` 함수는 `withContext`를 사용하여 IO 디스패처에서 긴 작업을 수행하며, 완료되면 결과 값을 반환하고 코루틴을 재개합니다. `launch` 코루틴 빌더내에서 `doSomething()`의 결과를 기다리므로, 해당 함수가 완료될 때까지 현재 코루틴은 재개되지 않습니다.
```

## 12장 코루틴 단위 테스트
<div id="12"></div>
<a href="#" onclick="window.scrollTo(0, 0); return false;">맨 위로 올라가기</a>

### 12.1. 단위 테스트 기초
- 단위 테스트는 소프트웨어의 가장 작은 실행 단위인 함수나 메서드의 정확성을 검증하는 테스트입니다.

#### 12.1.1. 단위 테스트란 무엇인가?
- 단위 테스트는 개별 모듈이 나타내야 하는 기능이 올바르게 작동하는지 확인하는 자동화된 스크립트입니다.

#### 12.1.2. 테스트 환경 설정하기
- 테스트에 필요한 라이브러리를 프로젝트에 추가하고, 테스트할 클래스와 메서드를 정의합니다.

#### 12.1.3. 간단한 테스트 만들고 실행하기
```kotlin
@Test
fun `returns true when input is valid`() {
    assertTrue(MyClass().validate("valid input"))
}
//- 위 테스트 코드는 `MyClass`의 `validate` 함수가 "valid input"에 대해 `true`를 반환하는지 검사합니다.
```
#### 12.1.4. @BeforeEach 어노테이션을 사용한 테스트 환경 설정
- `@BeforeEach` 어노테이션이 붙은 메서드는 각 테스트 실행 전에 호출되어 공통의 초기화 작업을 수행합니다.

#### 12.1.5. 테스트 더블을 사용해 의존성 있는 객체 테스트하기
- 의존성을 가진 객체를 대신할 수 있는 가짜 객체(테스트 더블)를 사용하여 격리된 환경에서 단위 테스트를 수행합니다.

### 12.2. 코루틴 단위 테스트 시작하기
- 코틀린 코루틴을 사용한 코드의 단위 테스트는 runBlocking을 사용하여 동기적으로 테스트할 수 있습니다.

#### 12.2.1. 첫 코루틴 테스트 작성하기
```kotlin
@Test
fun testCoroutine() = runBlocking {
    val result = mySuspendFunction()
    assertEquals(expectedValue, result)
}
//- 이 코드는 `mySuspendFunction` 함수가 예상된 값(`expectedValue`)을 반환하는지 테스트합니다.
```
#### 12.2.2. runBlocking을 사용한 테스트의 한계
- `runBlocking`을 사용할 때 테스트는 함수 내 코드의 완료를 기다릴 수 있지만, 실제 애플리케이션 환경과 달리 메인 스레드를 차단합니다.

### 12.3. 코루틴 테스트 라이브러리
- 코루틴을 사용하는 코드를 테스트하기 위해 코틀린은 전용 테스트 라이브러리를 제공합니다.

#### 12.3.1. 코루틴 테스트 라이브러리 의존성 설정하기
- 프로젝트의 `build.gradle` 파일에 코루틴 테스트 라이브러리를 테스트 의존성으로 추가하여 사용할 수 있습니다.

#### 12.3.2. TestCoroutineScheduler 사용해 가상 시간에서 테스트 진행하기
- `TestCoroutineScheduler`를 사용하면 코루틴의 지연 실행을 개발자가 제어할 수 있으며 테스트 실행 속도를 향상시킬 수 있습니다.

#### 12.3.3. TestCoroutineScheduler를 포함하는 StandardTestDispatcher
- `StandardTestDispatcher`는 코루틴의 실행을 `TestCoroutineScheduler`와 연결하여 가상 시간에 따라 코루틴을 스케줄링합니다.

#### 12.3.4. TestScope 사용해 가상 시간에서 테스트 진행하기
- `TestScope`는 `TestCoroutineDispatcher`를 포함하며 코루틴 테스트를 위한 가상 시간을 제공합니다.

#### 12.3.5. runTest 사용해 테스트 만들기
```kotlin
@Test
fun testWithRunTest() = runTest {
    val result = mySuspendFunction()
    assertEquals(expectedValue, result)
}
//- `runTest`는 `runBlocking`의 향상된 버전으로 가상 시간을 사용하여 테스트를 쉽게 실행하고 관리할 수 있습니다.
```
### 12.4. 코루틴 단위 테스트 만들어 보기
- 코루틴을 구현한 코드를 단위 테스트 작성을 통해 검증하면서 코루틴의 라이프사이클과 오류 처리를 이해할 수 있습니다.

#### 12.4.1. 코루틴 단위 테스트를 위한 코드 준비하기
- 테스트 대상이 될 코루틴 기반의 클래스와 함수를 정의합니다.

#### 12.4.2. FollowerSearcher 클래스 테스트 작성하기
- `FollowerSearcher` 같은 클래스는 코루틴에 기반한 네트워크 호출 등을 모방하여 테스트 코드를 작성합니다.

### 12.5. 코루틴 테스트 심화
- 심화된 코루틴 테스트는 코루틴의 이해도를 높이고, 복잡한 비동기 작업에 대한 테스팅 전략을 개발할 수 있게 합니다.

#### 12.5.1. 함수 내부에서 새로운 코루틴을 실행하는 객체에 대한 테스트
- 객체가 내부적으로 코루틴을 실행할 때, 테스트 상에서 해당 코루틴이 완료될 때까지 기다릴 수 있어야 합니다.

#### 12.5.2. backgroundScope를 사용해 테스트 만들기
- `backgroundScope`라는 별도의 스코프를 사용해 비동기 작업을 시작하고, 테스트에서 이를 관리합니다.



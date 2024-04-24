```
              +----------------------+
              |    DemoApplication   |
              +----------------------+
                         |
                         v
              +----------------------+
              |   SecurityConfig     |
              +----------------------+
                         |
                         v
              +----------------------+
              |     Controller       |
              +----------------------+
                         |
                         v
              +----------------------+
              |        DTO           |
              +----------------------+
                         |
                         v
              +----------------------+
              |       Service        |
              +----------------------+
                         |
                         v
              +----------------------+
              |     Repository       |
              +----------------------+
                         |
                         v
              +----------------------+
              |        Model         |
              +----------------------+
                         |
                         v
                 +----------------+
                 | 데이터베이스 또는  |
                 |  다른 데이터 저장소 |
                 +----------------+
```

---
---

- `controller`: 클라이언트 요청을 처리하고 응답을 반환하는 프레젠테이션 계층의 컨트롤러 코드가 있습니다.
  ```kotlin
  @RestController
  @RequestMapping("/users")
  class UserController(private val userService: UserService) {
      @PostMapping
      fun createUser(@RequestBody user: User): ResponseEntity<User> {
          val createdUser = userService.createUser(user)
          return ResponseEntity.ok(createdUser)
      }
  }
  ```

- `dto`: 클라이언트와 서버 간에 데이터를 전송하기 위한 데이터 전송 객체(DTO)를 정의합니다.
  ```kotlin
  data class UserDto(
      val id: Long,
      val name: String,
      val email: String
  )
  ```

- `service`: 애플리케이션의 비즈니스 로직을 구현하는 서비스 계층의 코드가 포함되어 있습니다.
  ```kotlin
  @Service
  class UserService(private val userRepository: UserRepository) {
      fun createUser(user: User): User {
          // 비즈니스 로직 구현
          return userRepository.save(user)
      }
  }
  ```

- `repository`: 데이터베이스 또는 다른 데이터 저장소에 대한 액세스 및 영속성 작업을 수행합니다.
  ```kotlin
  @Repository
  interface UserRepository : JpaRepository<User, Long> {
      fun findByEmail(email: String): User?
  }
  ```


- `model`: 애플리케이션의 핵심 도메인 개념을 나타내는 데이터 모델을 정의합니다.
  ```kotlin
  data class User(
      val id: Long,
      val name: String,
      val email: String,
      val roles: Set<Role>
  )
  ```






---
---
- **GET**: 데이터 조회용
- **POST**: 새로운 데이터 생성용
- **PUT**: 기존 데이터의 전체 업데이트용
- **PATCH**: 기존 데이터 업데이트용
- **DELETE**: 데이터 삭제용

### 자원 (Resource) : URI

- 모든 자원에 고유한 ID가 존재하고, 이 자원은 Server에 존재한다.
- 자원을 구별하는 ID는 ‘/products/:id’와 같은 HTTP URI 다.
- Client는 URI를 이용해서 자원을 지정하고 해당 자원의 상태(정보)에 대한 조작을 Server에 요청한다.

### 행위 (Verb) : HTTP Method

- HTTP 프로토콜의 Method를 사용한다.
- HTTP 프로토콜은 GET, POST, PUT, DELETE 와 같은 메서드를 제공한다.

### 표현 (Representation of Resource)

- Client가 자원의 상태(정보)에 대한 조작을 요청하면 Server는 이에 적절한 응답(Representation)을 보낸다.
- JSON 혹은 XML를 통해 데이터를 주고 받는 것이 일반적이다.

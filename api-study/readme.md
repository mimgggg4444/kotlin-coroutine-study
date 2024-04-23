
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

## ✏️ Daily Study
### [↩ Go Back Main README](https://github.com/3rd-PJ-Spring/Checkpoint?tab=readme-ov-file#%EF%B8%8F-daily-study)
<details>
  <summary><b>🐢tony24123's footprint</b></summary>
	<details>
		<summary><b>ㅤ25/01/23/목:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/22/수:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/21/화:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/20/월:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/17/금: 인증인가 JWT 토큰 학습</b></summary>

<h2>1. 인증 방식</h2>
<h3>1.1 세션 기반 인증</h3>
ex) 도서관에서 회원증을 발급받아 회원 정보를 도서관 컴퓨터에 저장하고, 회원증을 통해 모든 정보를 가져오는 방식.<br>
- 클라이언트는 서버로부터 발급된 세션 ID를 이용해 인증을 진행.<br>
- 서버가 사용자 정보를 관리하고 저장.<br>
<h3>단점</h3>
여러 서버에서 동일한 사용자의 정보를 공유해야 하므로 서버 간 동기화가 필요하다.<br>
하나의 정보 변경 시 많은 서버가 영향을 받음.<br>
서버가 사용자의 인증 정보를 저장하므로 서버 부하가 증가.<br>
<h3>1.2 토큰 기반 인증</h3>
ex) 여권에 모든 정보를 담고, 입국심사 시 여권만으로 진위 여부를 확인하는 방식.
- 서버는 클라이언트에게 토큰을 발급하고, 클라이언트는 이 토큰을 사용해 인증을 받음.<br>
- 서버는 사용자 정보를 저장하지 않으며, 클라이언트는 인증 정보를 담은 토큰을 소지.<br>
<h3>장점:</h3>
서버 부담이 적고, 확장성이 뛰어나다. 여러 서버 간에 동일한 토큰을 사용하여 인증 가능.<br>
서버가 인증 정보를 저장하지 않기 때문에 서버 부하가 적음.<br>
토큰이 JSON 형식으로 되어 있어 모바일 앱에서 사용하기 용이.<br>
<h3>단점</h3>
위조 가능성: 토큰이 탈취되거나 위조되면, 인증의 진위 여부를 확인하는 것이 어려워짐.<br>
토큰 크기가 세션 ID보다 큼.<br>
<h2>2. 인증과 인가의 차이점</h2>
인증: 사용자가 누구인지 확인하는 과정 ex) 로그인<br>
인가: 인증을 받은 사용자가 어떤 권한을 가질지 결정하는 과정 ex) 댓글을 쓸 수 있는지, 관리자 권한이 있는지 등<br>
<h2>3. HTTP의 특징</h2>
- HTTP는 상태가 없는 프로토콜로, 브라우저나 서버가 이전 요청의 정보를 기억하지 않는다.<br>
- 이를 해결하기 위해 세션이나 토큰을 사용하여 인증 정보를 저장하고 관리함.<br>
<h2>4. 인증 방식의 흐름</h2>
<h3>4.1 세션 인증 방식</h3>
- 클라이언트: 로그인 요청<br>
-> 서버: 로그인 성공 시 세션 정보를 생성하여 서버에 저장<br>
-> 클라이언트: 댓글쓰기 요청 시, 서버에서 세션 정보를 확인하여 인증<br>
<h3>4.2 토큰 인증 방식</h3>
- 클라이언트: 로그인 요청<br>
-> 서버: 로그인 성공 시 토큰을 발급<br>
-> 클라이언트: 댓글쓰기 요청 시, 발급받은 토큰을 서버에 제시하고, 서버는 토큰 진위 여부만 확인<br>
<h2>5. JWT (JSON Web Token)</h2>
JWT: 사용자의 정보를 담은 토큰. 서버는 JWT를 발급하고 클라이언트는 이 토큰을 통해 인증을 받음.<br>
-구성-<br>
Header: 토큰 타입(예: JWT)과 암호화 알고리즘 정보<br>
Payload: 사용자 정보(예: 사용자 ID)<br>
Signature: Header와 Payload를 결합하여 생성된 서명으로, 토큰의 위조 여부를 판단<br>
<h3>장점</h3>
- 서버 부담 감소: 서버가 사용자 정보를 저장할 필요가 없음.<br>
- 확장성: 여러 서버에서 동일한 토큰으로 인증 가능.<br>
- 모바일 친화적: JSON 형식으로 되어 있어 모바일 환경에 적합.<br>
<h3>단점</h3>
- 토큰 크기: 세션 ID보다는 크기가 큼.<br>
- 보안 문제: 토큰이 탈취되면 차단이 어렵고, 위조될 위험이 있음.<br>
<h3>오늘의 학습 내용 요약</h3>
- 세션 기반 인증과 토큰 기반 인증의 차이점을 이해하고, 각 방식의 장단점을 비교할 수 있었습니다.<br>
- JWT의 구성 요소와 그 장점 및 단점에 대해 학습했습니다.<br>
- 인증과 인가는 서로 다른 개념이며, 인증 후 인가 과정을 통해 사용자에게 권한을 부여하는 방식임을 명확히 이해했습니다.<br>
	</details>
	<details>
		<summary><b>ㅤ25/01/16/목:Spring Security와 로그인 처리</b></summary>	
<h2>📚 오늘의 공부 기록: Spring Security와 로그인 처리</h2>
<h3>1. 패스워드 암호화 (PasswordEncoder)</h3>
Spring에서는 **PasswordEncoder**를 사용해 비밀번호를 안전하게 암호화 및 관리할 수 있습니다.<br>
<h3>🔑 주의사항</h3>
같은 이름의 Bean을 두 번 등록하면 Spring에서 에러가 발생합니다.<br>
해결 방법: @Bean에 고유한 이름을 부여합니다.<br>

```java
@Bean(name = "shopPasswordEncoder")
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```
<h4>🛠️ 비밀번호 암호화 처리 흐름</h4>
- 클라이언트가 보낸 비밀번호를 서비스에서 암호화합니다.<br>
-> 요청 데이터를 엔터티(Entity)로 변환한 후 비밀번호를 암호화된 값으로 재설정합니다.<br>
-> DB에 암호화된 비밀번호를 저장합니다.<br>
<h3>2. 로그인 처리 (인증 처리)</h3>
   <h4>🔒 로그인 과정</h4>
- 클라이언트가 아이디와 비밀번호 전달<br>
  -> DB에서 아이디로 회원 정보 조회<br>
  -> 아이디가 존재하지 않으면 예외 처리<br>
  -> DB에 저장된 비밀번호를 가져와 사용자가 입력한 비밀번호와 비교<br>
  -> Spring의 PasswordEncoder.matches() 메서드를 사용해 암호화된 비밀번호 비교<br>
  -> 비밀번호가 일치하면 로그인 성공<br>
   <h4>🔑 로그인 API 설계</h4>
-  POST 요청 사용 권장: 보안상 @PostMapping을 사용해 데이터를 전달합니다.<br>
<h3>3. 코드 정리</h3> 
<h3>요청 DTO</h3>

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    @NotBlank(message = "아이디 입력은 필수입니다.")
    private String username;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    private String password;
}
```
<h3>Service</h3>
   비즈니스 로직: 아이디로 회원 조회 → 비밀번호 비교 → 성공 시 JSON 반환.<br>
   
```java
@Transactional(readOnly = true)
public Map<String, Object> authenticate(LoginRequest loginRequest) {
    String username = loginRequest.getUsername();

    User foundUser = userRepository.findByUserName(username)
            .orElseThrow(() -> new MemberException(ErrorCode.MEMBER_NOT_FOUND, "존재하지 않는 회원입니다."));

    String inputPassword = loginRequest.getPassword();
    String storedPassword = foundUser.getPassword();

    if (!passwordEncoder.matches(inputPassword, storedPassword)) {
        throw new MemberException(ErrorCode.INVALID_PASSWORD);
    }

    return Map.of(
        "message", "로그인에 성공했습니다.",
        "username", foundUser.getUsername()
    );
}
```
<h3>Repository</h3>
- 아이디로 회원 조회 쿼리<br>

```java
Optional<User> findByUserName(String username);
```
- MyBatis 쿼리 매핑<br>

```java
<select id="findByUserName" resultType="com.example.instagramclone.shop.user.User">
    SELECT * FROM user WHERE username = #{username}
</select>
```
<h3>Controller</h3>
- 클라이언트 요청을 처리하고 서비스 계층 호출<br>

```java
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
    Map<String, Object> responseMap = userService.authenticate(loginRequest);
    return ResponseEntity.ok().body(responseMap);
}
```
<h3>클라이언트 요청 처리 (JavaScript)</h3>

```java
async function fetchToLogin(userData) {
    await fetch("/user/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(userData),
    });
    console.log("로그인!");
    alert("로그인 성공");
    document.querySelector(".bj-login-form").reset();
}

function initLogin() {
    const $form = document.querySelector(".bj-login-form");
    $form.addEventListener("submit", (e) => {
        e.preventDefault();

        const username = document.querySelector('input[name="username"]').value;
        const password = document.querySelector('input[name="password"]').value;

        const payload = { username, password };
        fetchToLogin(payload);
    });
}

document.addEventListener("DOMContentLoaded", initLogin);
```
<h3>>정리된 흐름</h3>
   <h4>비밀번호 암호화:<br>
   Spring의 PasswordEncoder로 안전하게 관리.</h4>
   <h4>로그인 요청 처리:<br>
   아이디로 회원 조회 → 비밀번호 비교 → 성공 시 JSON 반환.</h4>
   <h4>클라이언트 요청 처리:<br>
   JavaScript로 로그인 폼 데이터 전송 및 성공 메시지 표시.</h4>
<h3>추가 공부 필요 사항</h3>
- Spring Security 기본 구성과 사용자 정의 보안 설정.
	</details>
	<details>
		<summary><b>ㅤ25/01/15/수: 회원가입 처리 작업 내용 정리</b></summary>
<h2>백엔드 작업</h2>
<h3>SignUpRequest 클래스 생성</h3>

```java
    @NotBlank(message = "필수 입력창입니다.")
    private String newName;

    @NotBlank(message = "필수 입력창입니다.")
    private String newEmail;
    
    @NotBlank(message = "필수 입력창입니다.")
    private String newPassword;
```   
- 회원가입 시 클라이언트로부터 전달받을 데이터를 정의.<br>
<h3>UserController 작업</h3>

```java
//회원가입 요청 받아오기
@PostMapping("/signup")
public ResponseEntity<?> signUp(@RequestBody @Valid signUpRequest signUpRequest){
log.info("request for signup : {}", signUpRequest.getNewName());
userService.signUp(signUpRequest);
        return ResponseEntity
                .ok()
                .body("user registered!");
    }
```
- @PostMapping을 통해 클라이언트로부터 전달받은 SignUpRequest 데이터를 수신<br>
-> 수신한 데이터를 UserService에 전달<br>
<h3>UserService 작업</h3>

```java
//회원가입 중간 처리
public void signUp(signUpRequest signUpRequest){
//데이터베이스에 저장
userRepository.insert(signUpRequest.toEntity());
}
```
- 회원가입 과정에서 데이터 변환 및 중간 처리를 담당<br>
- 데이터베이스에 저장하기 위해 엔터티로 변환 과정을 수행<br>
-> 변환된 엔터티를 UserRepository에 전달<br>
<h3>엔터티 변환 및 데이터베이스 저장</h3>

```java
<mapper namespace="com.example.instagramclone.shop.repository.UserRepository">
    <insert id="insert" keyProperty="id" useGeneratedKeys="true">
        INSERT INTO user
        (username, password, email)
        VALUES
        (#{username}, #{password}, #{email})
    </insert>
```
- SignUpRequest 데이터를 엔터티로 변환<br>
-> UserRepository에서 UserMapper.xml에 정의된 insert 메서드를 호출하여 데이터베이스에 저장<br>
-> 데이터 저장 후 회원가입 절차 완료<br>
<h2>프론트엔드 작업</h2>
<h3>회원가입 폼 제출 이벤트 생성</h3>

```java
//초기화 함수
function initSignUp() {
    //form submit 이벤트
    const $form = document.querySelector('.signup-form');
    $form.addEventListener('submit', e => {
        e.preventDefault();
        const username = document.querySelector('input[name="username"]').value;
        const password = document.querySelector('input[name="password"]').value;
        const email = document.querySelector('input[name="email"]').value;
        // const passwordConfirm = document.querySelector('input[name="password-confirm"]').value;        
        const payload = {
            newName : username ,
            newEmail : email ,
            newPassword: password
        };
```        
- 폼에 submit 이벤트 리스너를 등록<br>
- 새로고침 방지를 위해 e.preventDefault() 호출<br>
<h3>사용자 입력값 수집</h3>
- 폼에서 입력된 값을 객체로 생성<br>
-> 이때 객체의 키 값은 SignUpRequest에서 정의한 데이터 구조와 동일하게 매핑해야 함<br>
<h3>백엔드로 데이터 전송</h3>

```java
//회원가입 정보를 서버에 전송
async function fetchToSignUp(userData){
await fetch('/user/signup', {
method: 'POST',
headers: { 'Content-Type': 'application/json'},
body: JSON.stringify(userData)
});
console.log("회원가입 성공!");
alert("회원가입 성공");
document.querySelector('.signup-form').reset();
}
```
-> fetch를 사용하여 비동기 방식으로 데이터 전송<br>
-> UserController의 @PostMapping URL과 일치하도록 설정<br>
-> 데이터를 JSON 형식으로 변환 후 서버에 전달<br>
<h3>향후 업데이트 사항</h3>
- 입력값 검증, 데이터 암호화, 보안 및 예외 처리 로직을 추가하여 안정성을 강화<br>
- 작업으로 회원가입된 사용자 정보로 로그인 기능 구현 예정.<br>
   </details>
   <details>
       <summary><b>ㅤ25/01/14/화: 로그인, 회원가입 화면구성 완료 기능구현 로드맵 그리기</b></summary>
<h2>블랙잭 프로젝트: 로그인 및 회원가입 기능 추가 계획</h2>
<h3>프로젝트 개요</h3>
기존 블랙잭 게임 프로젝트에 로그인 및 회원가입 기능을 추가<br>
Spring을 이용해 서버와 연결하고, 서버 실행 상태에서 화면이 동작하도록 설정<br>
간단한 회원가입 로직, 데이터베이스와 연결하여 동작을 검증 필요<br>
<h3>현재 진행 상황</h3>
<h4>로그인 및 회원가입 화면 구성</h4>
- 로그인 및 회원가입 HTML/CSS 페이지 완료<br>
- Spring 서버를 통해 화면이 동작하도록 설정<br>
<h4>회원가입 로직</h4>
- 간단한 회원가입 로직 작성 완료<br>
- 입력값을 읽고 서버에서 처리할 준비 상태<br>
<h3>향후 추가해야 할 주요 기능</h3>
<h4>회원가입 기능 구현</h4>
- 회원가입 창에서 입력된 값을 읽어 데이터베이스에 저장<br>
- Spring MVC와 MyBatis를 활용해 데이터베이스 연동<br>
<h4>로그인 기능 구현</h4>
- 로그인 창에서 입력된 정보를 데이터베이스와 대조<br>
- 입력 정보가 데이터베이스에 저장된 회원 정보와 일치하면 로그인 성공 처리<br>
- 로그인 성공 시 사용자의 정보를 세션에 저장<br>
- 로그인 성공 후 사용자 데이터 렌더링<br>
- 로그인 성공 시 사용자의 정보를 화면에 표시<br>
예: "현재 보유 칩: 1000개"를 게임 화면 상단에 표시<br>
<h3>구현 완료시 기능 업데이트 (회원가입 검증 및 보안 강화)</h3>
<h4>회원가입 검증 단계</h4>
- 아이디, 비밀번호, 이메일 형식 검증<br>
- 중복 아이디 체크<br>
- 비밀번호 확인 필드 일치 여부 검증<br>
- 검증 실패 시 사용자에게 적절한 에러 메시지 표시<br>
- 사용자 토큰 부여<br>
- 로그인 성공 시 사용자에게 JWT(토큰)를 부여하여 인증 상태 유지<br>
- Spring Security와 JWT를 활용해 인증/인가 처리<br>
- 토큰 기반 인증으로 세션의 유지 문제 해결<br>
<h3>개발 순서 정리</h3>
<h4>회원가입 기능 :</h4> HTML 폼 데이터 수집 -> Spring 컨트롤러에서 데이터 처리 -> MyBatis를 사용해 데이터베이스에 저장<br>
<h4>로그인 기능 :</h4>  HTML 폼 데이터 수집 -> 데이터베이스에서 정보 조회 -> 세션 저장 및 로그인 완료 처리 -> 화면 렌더링 <br>
-> 사용자 정보를 게임 화면에 표시 -> 회원가입 검증 -> 입력값 유효성 검사 및 에러 처리 -> 보안 강화 -> 비밀번호 암호화 -> JWT 기반 인증/인가 처리<br>
	</details>
	<details>
		<summary><b>ㅤ25/01/13/월:RESTful Service 복습</b></summary>
<h2>RESTful</h2>
<h3>REST 정의 및 원칙</h3>
REST (Representational State Transfer): 자원의 상태를 표현하고 전송하는 아키텍처 스타일.<br>
<h3>-6가지 원칙-</h3>
1. 클라이언트-서버: 클라이언트는 UI를, 서버는 데이터와 로직을 처리하며 독립적으로 동작.<br>
2. Stateless: 서버는 클라이언트의 상태를 유지하지 않으며, 각 요청은 독립적으로 처리.<br>
3. 캐시 기능: 서버 응답을 캐싱하여 성능을 향상. HTTP 헤더로 캐시 가능 여부 명시.<br>
4. 계층화 시스템: 중간 계층(프록시, 로드 밸런서 등)을 통해 통신 가능.<br>
5. 통합 인터페이스: 일관된 URL 형식과 HTTP 메서드 사용.<br>
6. Optional: 필요 시 실행 가능한 코드를 클라이언트로 전송 가능.<br>
<h3>RESTful 서비스의 장점</h3>
- 확장성: 클라이언트와 서버의 역할이 분리되어 시스템 확장이 용이.<br>
- 유연성: 다양한 데이터 포맷(JSON, XML 등)을 지원.<br>
- 성능 향상: 캐시 활용으로 네트워크 비용 절감.<br>
- 일관성: HTTP 표준을 준수해 사용자와 개발자 모두 이해하기 쉬움.<br>
<h3>Spring RESTful API 관련 주요 애노테이션</h3>
@RestController: JSON, XML 직렬화 기본 포함.<br>
@RequestBody: JSON → Java 객체로 변환.<br>
@ResponseBody: 객체 → JSON으로 변환해 반환. (단, 상태 코드 처리가 불가능.)<br>
ResponseEntity: 상태 코드, 헤더, 본문 제어가 가능한 유연한 HTTP 응답 객체.<br>
<h3>주요 HTTP 상태 코드</h3>
200: 요청 성공<br>
201: 리소스 생성 성공<br>
400: 잘못된 요청<br>
401: 인증 실패<br>
403: 권한 부족<br>
404: 리소스 없음<br>
500: 서버 내부 오류<br>
<h4>tip - @RestController의 반환값은 대부분 ResponseEntity로 고정해서 사용하는 것이 유용.</h4>
	</details>
	<details>
		<summary><b>ㅤ25/01/10/금: RequestDto 복습 </b></summary>
<h2>DTO</h2>
<h3>DTO(Data Transfer Object)는 클라이언트와 서버 간 데이터를 전송하는 데 사용되는 객체로, 데이터베이스 엔티티(Entity)와는 구분된다</h3>
<h4>-목적-</h4> 
데이터 전송 간 필요한 정보만 제공하고,<br> 민감한 데이터를 보호하거나 데이터 포맷을 변환하는 데 사용.<br>
<h4>-장점-</h4>
데이터 보안 강화 (민감 정보 마스킹 가능)<br>
클라이언트 요구사항에 맞춘 데이터 제공<br>
API 설계의 유연성 및 유지보수성 증가<br>

```java
package com.example.instagramclone.shop.user;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long userId;           // 유저 ID
    private String name;           // 유저 이름
    private String userEmail;      // 이메일 (마스킹 처리)
    private String userPassword;   // 비밀번호 (마스킹 처리)
    private String date;           // 가입일자 (포맷 변경)

    // User 엔티티를 DTO로 변환하는 생성자
    public UserDto(User u) {
        this.userId = u.getId();
        this.name = u.getUsername();
        this.userEmail = u.getEmail().length() > 5 ? u.getEmail().substring(0, 5) + "..." : u.getEmail();
        this.userPassword = u.getPassword().length() > 6 ? u.getPassword().substring(0, u.getPassword().length() - 2) + "**" : u.getPassword();
        this.date = u.getCreateAt().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
```

<h3>개선 전 코드</h3>

```java
@GetMapping
public ResponseEntity<List<User>> getAllUser() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users); // User 엔티티 리스트를 반환
}

```
보안 문제: 이메일과 비밀번호가 그대로 노출<br>
데이터 포맷 문제: 가입일자 등 클라이언트가 보기 어려운 형식 그대로 반환됨<br>
응답 데이터 구조의 가독성 부족: 클라이언트는 불필요한 데이터를 처리해야 할 수도 있음<br>
```java
@GetMapping
public ResponseEntity<List<UserDto>> UserList() {
    List<User> users = userService.getAllUsers();

    if (users.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 데이터가 없을 때 처리
    }

    List<UserDto> userDtos = users.stream()
                                  .map(UserDto::new)  // User -> UserDto 변환
                                  .collect(Collectors.toList());

    return ResponseEntity.ok(userDtos);  // 변환된 DTO 리스트 반환
}

```
<h3>보안성 강화</h3>
이메일과 비밀번호가 마스킹 처리되어 클라이언트에게 민감 정보가 그대로 노출되지 않음.<br>
<h3>클라이언트 요구사항에 맞춘 데이터 반환</h3>
가입일자는 yyyy/MM/dd 형식으로 변경되어 클라이언트가 즉시 사용 가능<br>
불필요한 데이터가 제거된 DTO를 반환하여 데이터 효율성 증가<br>
<h3>응답 데이터의 명확성</h3>
DTO를 통해 API 응답 구조가 정리되고, 클라이언트와의 데이터 교환이 명확해짐<br>
<h3>유지보수 용이성</h3>
데이터 전송 구조를 엔티티와 분리했으므로, 엔티티 변경이 클라이언트 응답에 영향을 미치지 않음<br>
필요 시 DTO의 필드나 변환 로직만 수정하여 쉽게 확장 가능<br>
<h3>가독성 및 간결성</h3>
Stream API를 활용한 map 메서드로 DTO 변환이 간결하게 처리됨<br>
기존의 엔티티 리스트를 반환하는 코드보다 더 명확한 의도를 전달<br>
ㅤㅤ
	</details>
	<details>
		<summary><b>ㅤ25/01/09/목:회원 관리 시스템 구현 백엔드 흐름 연습해보기</b></summary>
<h2>회원 관리 시스템 구현 흐름</h2>
<h3>1. User Entity 생성</h3>
목표: 회원 정보를 저장할 엔티티 클래스 생성<br>
속성: id, username, password, email, createAt<br>
설명: 회원 정보가 담길 엔티티를 생성하여 데이터베이스 테이블과 매핑<br>
```java
package com.example.instagramclone.shop.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createAt;
}

```
<h3>UserRepository 생성 (@Mapper)</h3>
목표: MyBatis를 사용하여 데이터베이스와 연결할 리포지토리 생성<br>
설명: @Mapper 어노테이션을 이용해 MyBatis와의 연결을 설정하고, insertUser()와 같은 데이터베이스 작업을 위한 메서드 정의<br>
```java
package com.example.instagramclone.shop.repository;


import com.example.instagramclone.domain.post.entity.Post;
import com.example.instagramclone.shop.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {
    //유저 생성
    void insert(User user);

    //유저 조회
    Optional<User> findById(Long id);

    //전체 유저 조회
    List<User> findAll();
}

```
<h3>UserMapper.xml 생성</h3>
목표: SQL 쿼리 작성 및 매핑<br>
설명: UserRepository에서 정의한 메서드에 대한 SQL 쿼리를 resources/mapper/UserMapper.xml 파일에 작성하여 데이터베이스와 연동<br>
```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.instagramclone.shop.repository.UserRepository">

    <insert id="insert" keyProperty="id" useGeneratedKeys="true">
        INSERT INTO user
        (username, password, email)
        VALUES
        (#{username}, #{password}, #{email})
    </insert>

    <select id="findById" resultType="com.example.instagramclone.shop.user.User">
        SELECT
        *
        FROM user
        WHERE id = #{id}
    </select>

    <select id="findAll" resultType="com.example.instagramclone.shop.user.User">
        SELECT
        *
        FROM user
    </select>

</mapper>
```
<h3>UserService 생성</h3>
목표: 비즈니스 로직 처리<br>
설명: UserService 클래스에서 회원 생성, 조회, 전체 유저 조회 등의 비즈니스 규칙을 구현<br>
UserRepository와의 연결을 통해 데이터를 처리하는 역할을 담당<br>
```java
package com.example.instagramclone.shop.service;

import com.example.instagramclone.shop.repository.UserRepository;
import com.example.instagramclone.shop.user.User;
import com.example.instagramclone.shop.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    //유저 생성
    public void createUser(User user) {
        userRepository.insert(user);
    }

    //유저 조회
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }

    //전체 유저 조회
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserDto(u))
                .collect(Collectors.toList());
    }
}

```
<h3>UserController 생성</h3>
목표: 사용자 요청 처리<br>
설명: @PostMapping, @GetMapping 등을 사용하여 HTTP 요청을 받아 UserService를 호출, 요청 처리 후 그 결과를 클라이언트에 응답<br>
```java
package com.example.instagramclone.shop.controller;


import com.example.instagramclone.shop.repository.UserRepository;
import com.example.instagramclone.shop.service.UserService;
import com.example.instagramclone.shop.user.User;
import com.example.instagramclone.shop.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String  create(@RequestBody User user) {
        userService.createUser(user);
        return "insert success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

//    @GetMapping
//    public ResponseEntity<?> UserList() {
//        List<UserDto> users = new ArrayList<>(userService.getAllUsers())
//                .stream()
//                .map(u-> new UserDto(u))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok().body(users);
//    }

}

```
<h3>핵심 흐름: User Entity -> UserRepository -> UserMapper.xml -> UserService -> UserController</h3>
각 계층을 통해 데이터베이스와 상호작용하고, 비즈니스 로직을 처리하며, 최종적으로 사용자에게 데이터를 응답
	</details>
	<details>
		<summary><b>ㅤ25/01/08/수:의존성 주입, 스프링 빈 관리</b></summary>	
		ㅤㅤㅤ<h3> 의존성 주입 </h3>
             의존성 주입: 객체 간의 의존성을 관리할 수 있는 설계 패턴<br> 
             객체는 필요한 의존성을 외부에서 주입받음.<br>
             -> 결합도는 낮추고 , 코드의 재사용성과 유지보수가 높아짐<br>
             크게 생성자 주입, 세터 주입, 필드 주입 3가지 방법 사용 가능<br>
             <h4>생성자 주입</h4>
             - 3가지 방법 중에 가장 좋은 방법<br>
             - 모든 의존성을 주입받아야 하므로 객체가 일관되게 생성된다.<br>
             - 애플리케이션 시작 시점에 문제 발견이 가능하다.<br>              
             <h4>세터 주입 </h4>
             - 세터 주입을 사용하면 유지보수측면에서 생성자 주입보다 어려울 수 있다.<br>
             - NULL체크도 해줘야한다.<br>
             - 중간에 객체가 변경될 수 있다.<br>
             - 런타임 시점까지 문제 발생이 되지않아서 애플리케이션 실행이 예기치 않게 실패할 수 있다.<br>
             <h4>필드 주입</h4>
             - 테스트와 유지보수 특면에서 어려운 점이 많아 비추천<br>
              <h3>스프링 빈 관리</h3>
             - 스프링이 대신해서 관리를 해줌 <br>
              <h4>자바 클래스 방식</h4>
              ex)@Configuration //스프링이 클래스를 관리<br>
                 @ Bean //어떤 객체를 관리할지 메서드로 설정<br>
              <h4>애너테이션 방식</h4>
              <h4>`@Component`</h4>
              - 가장 일반적인 스프링 빈을 정의하는 애너테이션<br>
              - 주로 특수한 역할이 없는 일반적인 빈에 사용된다.<br>
              <h4>`@Service`</h4>
              - 비즈니스 로직을 담고 있는 서비스 클래스에 사용<br>
              - `@Service` 애너테이션을 통해 해당 클래스가 서비스 계층을 담당함을 명시적 나타낸다.<br>
              <h4>`@Repository`</h4>              
              - 데이터 접근 계층(DAO) 클래스에 사용<br>
              -  데이터베이스와의 통신을 담당하는 클래스를 나타내며, 데이터 접근 예외를 처리.<br>         
              <h4>`@Controller`</h4>              
              - 애플리케이션에서 컨트롤러 역할을 하는 클래스에 사용<br>
              - 웹 요청을 처리하고, 모델 데이터를 뷰로 전달하는 역할.<br>
              <h4>@Autowired</h4>
              의존성 주입을 수행하기 위한 애너테이션<br>
              <h4>@Qualifier</h4>
              @Autowired와 함께 사용하여, 같은 타입의 빈이 여러 개 있을 때 어떤 빈을 주입할지 명시적으로 지정하는 방법             
      </details>
      <details>
          <summary><b>ㅤ25/01/07/화: 프로젝트 방향성 회의</b></summary>	
          ㅤㅤㅤ<h3>프로젝트 진행 방향 결정</h3>
               <h4>회의 내용</h4>
               <h4>문제 상황</h4> 
                1.개발 능력 향상을 위해 추가 공부가 필요하다 판단됨<br>
                2.프로젝트 분량 조절에 아쉬움이 각자 남을수있음<br>
               <h4>회의 결과</h4>
                개인 공부에 더 집중하기로 결정<br>
                ->향후 프로젝트들에 있어 가장 큰 도움이 될이라 판단<br>              
                체계적인 관리를 위해 루틴을 정함<br>  
                -> 매일 오후 5시 공부 내용 푸쉬<br>  
                <h3>나의 공부 방향</h3>
                <h4>백엔드(자바,스프링,데이터베이스)에 집중해보고 싶음</h4>
                <h4>쇼핑몰 기본적인 로직 구현해보기 </h4>
                ex)상품 등록 , 상품 담기 , 상품 조회 , 상품 삭제 , 로그인 기능
      </details>
      <details>
          <summary><b>ㅤ25/01/06/월: </b></summary>	
          ㅤㅤㅤ내용
      </details>
</details>

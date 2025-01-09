## ✏️ Daily Study
### [↩ Go Back Main README](https://github.com/3rd-PJ-Spring/Checkpoint?tab=readme-ov-file#%EF%B8%8F-daily-study)
<details>
  <summary><b>👩‍🦲Mabbakk's footprint</b></summary>
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
		<summary><b>ㅤ25/01/17/금:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/16/목:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/15/수:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/14/화:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/13/월:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/10/금:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
  <summary><b>ㅤ25/01/09/목: 인스타 클론 - 회원가입 BE 2</b></summary>

## 1. 입력값 DTO 생성 및 엔터티 변환
### SignUpRequest 클래스
회원가입 입력값을 처리하기 위해 **SignUpRequest** DTO를 작성한다.
입력값을 Member 엔터티로 변환하는 `toEntity()` 메서드를 생성한다.

```java
public Member toEntity() {
    String email = null;
    String phone = null;

    if (this.emailOrPhone.contains("@")) { //이메일과 휴대전화번호를 구분해주는- 이메일에는 있으나 전화번호에는 없는 절대적 특수기호인 @를 구분 기준으로 한다.
        email = this.emailOrPhone;
    } else {
        phone = this.emailOrPhone.replaceAll("[^0-9]", ""); // 번호 입력 시 -가 포함되어있으면 제거 후 DB로 전화번호만을 저장한다.
    }

    return Member.builder()
                .email(email)
                .phone(phone)
                .username(this.username)
                .name(this.name)
                .password(this.password)
                .build();
}
```

## 2. MemberService 작성
MemberService를 작성하여 회원가입 요청을 처리하도록 한다.

### 주요 코드
```java
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public void signUp(SignUpRequest signUpRequest) {
        memberRepository.insert(signUpRequest.toEntity()); // signUp 함수에 작성한 signUpRequest (DTO)를 넣고 이의 입력값을 entity로 변환하여 저장한다.
    }
}
```

## 3. AuthController 생성
`AuthController`를 작성하여 REST API 엔드포인트를 구현한다.

### 주요 코드
```java
@RestController
@RequestMapping("/api/auth")
@Slf4j  // 로그 생성
@RequiredArgsConstructor  // 의존성 주입
public class AuthController {

    private final MemberService memberService;   // MemberSevice 주입

    @PostMapping("/signup")   // 회워가입은 데이터를 생성하는 것이므로 POST
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        log.info("request for signup: {}", signUpRequest.getUsername());
        memberService.signUp(signUpRequest);

        return ResponseEntity
                .ok()
                .body(Map.of( 
                        "message", "회원가입이 완료되었습니다.",
                        "username", signUpRequest.getUsername()
                ));
    }
}
```
위에서 ResponseEntity의 타입으로 Map을 사용한 이유?<br>
1. Map은 (키-값) 쌍으로 데이터를 표현할 수 있고, 여러 필드를 간결하게 묶어 보낼 수 있다.
2. Map은 List와 달리 동적인 구조를 가지고 있어 상황에 따라 필드를 유연하게 조정할 수 있다.<br>
그리고 일단 많은 REST API 설계에서 JSON 응답을 선호하며, Map은 이를 쉽게 표현할 수 있는 방법이다.

## 4. 비밀번호 암호화

회원가입 시 비밀번호는 반드시 암호화하여 저장해야 한다.
DB에 저장된 비밀번호가 암호화되지 않은 경우 아래 SQL 명령어를 사용해 기존 데이터를 삭제후 암호화 작업을 진행한다.

```sql
DELETE FROM users;
COMMIT;
```

### 추가 작업
`PasswordEncoder`를 사용해 비밀번호 암호화를 적용한다.

```java
public void signUp(SignUpRequest signUpRequest) {
    Member member = signUpRequest.toEntity();
    member.setPassword(passwordEncoder.encode(member.getPassword()));
    memberRepository.insert(member);
}
```

## 5. Postman 테스트

1. Postman에서 `POST /api/auth/signup` 엔드포인트를 테스트한다.
2. 요청 바디는 JSON 형식으로 작성하며, DTO에 명시된 필드명을 정확히 입력해야 한다.

### 요청 예시
```json
{
    "username": "testuser",
    "name": "Test User",
    "emailOrPhone": "010-1234-5678",
    "password": "password123"
}
```

3. 응답 확인:
    - 성공 메시지와 함께 입력된 사용자 이름이 반환된다.
    - DB에서 데이터가 올바르게 저장되었는지 확인한다.
</details>
	<details>
		<summary><b>ㅤ25/01/08/수: 프로젝트 방향 설정 및 래퍼런스 서치, 회원가입 BE</b></summary>	
		ㅤㅤㅤ<h3>1. 프로젝트 방향 설정</h3>
						<h4>·어떤 홈페이지를 만들 것인가?</h4>
						쇼핑몰 홈페이지 구현.<br>
						<h4>·어떤 레이아웃과 디자인으로 진행할 것인가?</h4>
						→ 이미지 참조<br>
						<h4>·어떤 기능을 구현할 것인가?</h4>
						FE 기능 구현을 우선적 목표로 한다.<br>
						+ 홈페이지에 필요한 정보를 포함하여 전체 디자인.<br>
						그 후 가능하다면 BE도 진행. (회원가입 및 로그인)<br>
						<h3>3. 회원가입 FE/BE_1</h3>
						<div style="text-align: center;">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/219069cc37d73b2531b87a866ee27095d709b899/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_1.png">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_2.png">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_3.png">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_4.png">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_5.png">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_6.png">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_7.png">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_8.png">
							<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/Mabbakk/250108(%EC%88%98)/%233_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%B0%A9%ED%96%A5%20%EC%84%A4%EC%A0%95%20%EB%B0%8F%20%EB%9E%98%ED%8D%BC%EB%9F%B0%EC%8A%A4%20%EC%84%9C%EC%B9%98%2C%20%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20BE%20_9.png">
						</div>
	</details>
	<details>
		<summary><b>ㅤ25/01/07/화: 팀플 회의_방향 설정 및 목표 설정</b></summary>	
		  <h3>1. 전체적인 방향 설정 </h3>
            <h4>개인의 역량을 높일 수 있도록 철저하고 꾸준한 공부 그리고 그에 대한 결과물 데모버전 도출.</h4>
                (공통 주제 설정 : 기본 홈페이지)<br></br>
		<h3> 2. 목표 설정 </h3>
      <h4>· 내가 구현하고 싶은 기능 ? → 프론트엔드</h4>
      <h4>· 부족한 부분 ? → 숙달되지 않은 자바스크립트 이벤트 구현</h4>
      <h4>· 구현하고자 하는 기능 ? → 회원가입 (로그인) 기능 ...등 추가 구상</h4>
	</details>
	<details>
		<summary><b>ㅤ25/01/06/월: 인스타그램 클론 연습 강의 복습</b></summary>	
		ㅤㅤㅤ<h4>피드 목록 조회 API 만들기 까지 복습 (FE/BE)</h4>
	</details>

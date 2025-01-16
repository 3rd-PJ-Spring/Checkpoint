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
		<summary><b>ㅤ25/01/16/목: 개인 사이트 제작 - 회원가입 구현 1</b></summary>

#### DB 설계 - Entity 생성 - Repository 생성 - xml 파일 생성 후 예외처리 완료<br>
##### postman에서 회원가입 테스트 중 500 에러 발생하여 해결 중.. DB 관련 문제로 추정 <br>
금일 내 원인 파악 후 에러 해결, 중복 확인 전 빈 입력값 검증까지 완료할 것.
	</details>
	<details>
		<summary><b>ㅤ25/01/15/수: 개인 사이트 제작 1</b></summary>

### 새 프로젝트 생성 후 사이트 제작 시작.<br><hr>
#### FE - HTML / CSS 코드 작성 중
#### BE -  회원가입 / 로그인 기능 구현 예정
#### 인스타 클론 - 회원가입 BE 추가 공부 내용 내일 업로드 예정
	
</details>
	<details>
		<summary><b>ㅤ25/01/14/화: 인스타 클론 - 회원가입 BE 4</b></summary>

## 회원가입 이메일, 전화번호 패턴 검증

### 입력값 공백 제거
입력값에 **스페이스바**로 입력된 **공백**도 제거하려면, 입력값을 읽어오는 코드에 `.trim()`을 추가하면 된다.

```jsx
// 입력값 읽어오기
const inputValue = $input.value.trim();
```

### 상세 체크 (패턴 검증 및 중복 검증)
빈 값 체크 후, 상세 검증을 진행한다. <br> 먼저 이메일과 전화번호에 대한 검증을 수행해보자.

```jsx
// 1. 빈 값 체크
if (!inputValue) {
    isValid = false;
    showError($formField, ValidationRules[fieldName]?.requiredMessage); // 에러 메시지 렌더링
} else {
    // 2. 상세 체크 (패턴검증, 중복검증)
    if (fieldName === 'email') {
        validateEmailOrPhone($formField, inputValue);
    } else if (fieldName === 'password') {
        // 비밀번호 강도 체크 (DB 검증 불필요)
    }
}
```

### 이메일 또는 전화번호 검증 함수
`validateEmailOrPhone` 함수를 작성하여 이메일과 전화번호를 상세 검증하도록 하자.

```jsx
async function validateEmailOrPhone($formField, inputValue) {
    if (inputValue.includes('@')) {
        // 이메일 체크
        if (!ValidationRules.email.pattern.test(inputValue)) {
            showError($formField, ValidationRules.email.message);
        } else {
            // 서버 통신을 통한 중복 체크
        }
    } else {
        // 전화번호 체크
        const numbers = inputValue.replace(/[^0-9]/g, ''); // 숫자만 추출
        if (!ValidationRules.phone.pattern.test(numbers)) {
            showError($formField, ValidationRules.phone.message);
        } else {
            // 서버 통신을 통한 중복 체크
        }
    }
}
```

### 디바운스 적용
입력 중간에 에러 메시지가 계속 표시되면 사용자 경험이 저하될 수 있다.<br>
이를 방지하기 위해 **debounce**를 적용하여 입력이 멈춘 뒤에 검증이 실행되도록 하자.

#### debounce 함수 작성
`util/debounce.js` 파일에 다음과 같이 디바운스 함수를 작성한다 :

```jsx
/**
 * 디바운스 함수
 * @param {Function} fn - 실행할 함수
 * @param {number} delay - 지연시간 (ms)
 * @returns {Function} 디바운스된 함수
 */
export function debounce(fn, delay) {
    let timer = null;
    return function (...args) {
        const context = this;
        clearTimeout(timer);
        timer = setTimeout(() => {
            fn.apply(context, args);
        }, delay);
    };
}

/**
 * 쓰로틀 함수
 * @param {Function} fn - 실행할 함수
 * @param {number} limit - 제한시간 (ms)
 * @returns {Function} 쓰로틀된 함수
 */
export function throttle(fn, limit) {
    let inThrottle;
    return function (...args) {
        const context = this;
        if (!inThrottle) {
            fn.apply(context, args);
            inThrottle = true;
            setTimeout(() => {
                inThrottle = false;
            }, limit);
        }
    };
}
```

#### debounce 함수 사용
`signup.js` 파일에서 디바운스 함수를 import하여 사용한다:

```jsx
import { debounce } from '../util/debounce.js';
```

`validateField` 함수에만 디바운스를 적용하여 입력값 검증이 입력이 멈춘 후에 실행되도록 설정하자. <br>
에러 메시지 제거는 디바운스 없이 바로 처리하도록 구현한다.
<hr>
	</details>
	<details>
		<summary><b>ㅤ25/01/13/월: 인스타 클론 - 회원가입 BE 3</b></summary>

# 회원가입 빈 입력값 검증 (FE)

## 13-1. 코드 리팩토링

일단 `signup.js` 파일로 이동해서 기존 코드를 리팩토링 해보자.

입력값들을 바로 받아오지 말고 태그들을 읽어와서 이들을 객체로 만들 것이다.

value를 바로 읽지 말고 DOM만 가져와보자.

```jsx
// form submit 이벤트
const $form = document.querySelector('.auth-form');

// 입력 태그들을 읽어서 객체로 관리
const $inputs = {
    emailOrPhone: $form.querySelector('input[name="email"]'),
    name: $form.querySelector('input[name="name"]'),
    username: $form.querySelector('input[name="username"]'),
    password: $form.querySelector('input[name="password"]'),
};
```

각 네 개의 데이터들이 들어있는 상위 클래스를 가져온 후 **$form** 객체로 선언한다.

여기서 `.querySelector`는 문서 전체(`document.`)에서 태그를 검색하면 **성능이 좋지 않다**. <br>
문서 전체 내에서 탐색하는 건 범위가 굉장히 넓기 때문에 **좁은 범위**, 즉 위에 만들어 놓은 `$inputs`가 들어있는 `$form` 안에서 찾도록 코드를 수정한다.

[  `document.querySelector` → `$form.querySelector`  ]

다음으로 잠시 주석 처리를 해야 할 부분이 있다.

서버로 전송하기 전에 검사부터 해야 하기 때문이다.

이제 본격적으로 입력값 검증을 시작해보자.

---

## 13-2. 입력값 검증 이벤트

위에 작성한 `$inputs` 안의 네 개의 input에 전부 이벤트를 걸어줘야 한다.

아래처럼 이벤트를 걸어줄 수도 있겠지만, 우리는 반복문을 써볼 거다.

```jsx
$inputs.emailOrPhone.addEventListener('input', handler);
$inputs.name.addEventListener('input', handler);
$inputs.username.addEventListener('input', handler);
$inputs.password.addEventListener('input', handler);
```

결국에는 `$inputs` 안에 있는 value들만 뽑아주면 되는데, 초기 기본 코드 원리는 다음과 같다.

```jsx
for (const key in $inputs) { // key에는 $inputs의 emailOrPhone, name ...이 들어온다.
    // $inputs의 value를 가져오려면 아래와 같이 작성한다.
    $inputs[key].addEventListener()
}
```

위에서 조금 더 함수화 해보자.

```jsx
// 4개의 입력창에 입력 이벤트 바인딩

// $inputs의 value들만 꺼내서 반복문을 돌리면 $input 태그들이 하나씩 출력된다.
Object.values($inputs).forEach(($input) => { 
    
    // console.log($input); 을 실행하여 브라우저에 $input 값들이 출력되는지 확인.
    
    $input.addEventListener('input', e => {  // handler
        
        // 입력값 검증을 수행하는 함수 호출.
        validateField($input); 
    });
});
```

`values`는 위의 `$input` 태그들의 value(입력값)들만 꺼내올 수 있게 된다!

---

## 13-3. 입력값 검증 함수 정의

이제 맨 아래 메인 실행 코드 위에 함수를 정의해주자.

```jsx
// 함수 정의
// 입력값을 검증하고 에러 메시지를 렌더링하는 함수
function validateField($input) {
    
    // 1. 빈 값 체크
    // 입력값 읽어오기
    const inputValue = $input.value;
    
    // 2. 이게 어떤 태그인지 알아오기
    const fieldName = $input.name;
    
    // 3. 로그 찍어보기
    console.log(fieldName, inputValue);
}
```

1. 빈 값 체크를 하기 위해서는 **입력값**을 읽어와야 한다.
   **$input**의 **value**들을 읽어오는 `inputValue` 함수를 정의해주자.
2. 입력값을 읽어오면 이 값이 어떤 태그인지 알아야 한다. (입력값의 타켓을 구분 및 명시)

signup.jsp 파일에 들어가서 태그들을 살펴보자. **type**은 같으나, **name**이 다른 걸 알 수 있다!

고로, **name**으로 각 태그들을 구분해주자.

```jsx
// 1. 빈 값 체크
// 2. 이게 어떤 태그인지 알아오기
const fieldName = $input.name;

// 3. 입력값 읽어오기
const inputValue = $input.value;

if(!inputValue) {
    console.log(fieldName, 'is empty!');
}
```

입력창에 값을 적었다가 삭제했을 때 로그가 뜨면 정상이다.

---

## 13-4. 빈 값 검증

어느 태그에 입력값이 어떤 식으로 출력되는지 알았으니 이제 **입력값 검증**을 추가하자.

만약 입력창에 아무런 값도 없을 때(=빈 값) 어떻게 해야 할까? 우선 `if` 문을 작성하고 잘 작동하는지 로그를 찍어보자.

```jsx
if(!inputValue) {
    // console.log(fieldName, 'is empty!');
    showError();  // 에러 메시지 렌더링
}
```

에러 메시지를 표시하는 함수를 추가로 작성하자.

---

## 13-5. 에러 클래스 부여

다음 코드를 추가하자.

```jsx
/**
 * 에러 메시지를 표시하고, 필드에 error 클래스를 부여
 */
function showError($formField, message) {
    $formField.classList.add('error');
    const $errorSpan = document.createElement('span');
    $errorSpan.classList.add('error-message');
    $errorSpan.textContent = message;
    $formField.append($errorSpan);
}
```

---

## 13-6. 에러 메시지 제거

마지막으로 에러 메시지가 중복되지 않도록 제거하는 함수를 작성한다.

```jsx
/**
 * 에러 및 비밀번호 피드백을 제거한다.
 */
function removeErrorMessage($formField) {
    $formField.classList.remove('error');
    const error = $formField.querySelector('.error-message');
    if (error) error.remove();
}
```

이를 입력 이벤트 핸들러와 blur 이벤트 핸들러에 통합한다.

```jsx
// 4개의 입력창에 입력 이벤트 바인딩
Object.values($inputs).forEach(($input) => {
    $input.addEventListener('input', () => {
        removeErrorMessage($input.closest('.form-field'));
        validateField($input);
    });

    $input.addEventListener('blur', () => {
        validateField($input);
    });
});
```

---

회원가입 입력값 검증이 완료되었다!<br>
이제 다음 단계로 에러 메시지를 객체로 설계 해보자.
	</details>
	<details>
		<summary><b>ㅤ25/01/10/금: 인스타 클론 - 회원가입 BE 3</b></summary>

## 비밀번호 암호화 및 회원가입 API 요청 정리

## 11. 비밀번호 암호화

### 11-1. 데이터 삭제
데이터베이스에 암호화되지 않은 비밀번호가 저장되어 있다면 먼저 해당 데이터를 삭제한다.
SQL 워크벤치에서 아래 명령어를 실행한다:

```sql
DELETE FROM users;
COMMIT;
```

### 11-2. Spring Security로 비밀번호 암호화
Spring Security를 사용하여 강력한 암호화 알고리즘을 구현할 수 있다.

#### PasswordEncoderConfig 파일 생성
`main/java` 폴더 안에 `config` 폴더를 생성하고, `PasswordEncoderConfig` 파일을 작성한다.

```java
package com.example.instagramclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

- `@Configuration`: 해당 클래스를 Spring이 관리하는 클래스로 지정한다.
- `@Bean`: 메서드의 리턴값을 애플리케이션 전체에서 사용 가능한 Singleton Bean으로 관리한다.

#### @Configuration과 @Bean의 동작 원리
- **SingleTon**: Spring은 기본적으로 하나의 객체를 전역적으로 공유함.
- **CGLIB**: Spring이 @Configuration 클래스 내부에서 SingleTon을 보장하기 위해 사용하는 기술임.<br><br>
#### 결론 
- @Configuration 로 인해 동일한 @Bean 메서드가 여러 번 호출되더라도 하나의 Singleton 인스턴스만 반환.
- CGLIB 작동 시 @Bean 메서드를 호출할 때마다 새로운 객체 생성 X, 이미 생성된 객체를 반환.

#### MemberService에 PasswordEncoder 주입
생성한 `PasswordEncoder`를 `MemberService` 클래스에 주입받아 비밀번호를 암호화한다.

```java
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public void signUp(SignUpRequest signUpRequest) {
        // 비밀번호 암호화
        String rawPassword = signUpRequest.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // 회원 정보를 엔터티로 변환 및 암호화된 비밀번호 설정
        Member newMember = signUpRequest.toEntity();
        newMember.setPassword(encodedPassword);

        // 데이터베이스 저장
        memberRepository.insert(newMember);
    }
}
```

### 11-3. Postman으로 테스트
1. 서버를 재실행한다.
2. Postman에서 회원가입 요청을 보내고, 데이터베이스에 저장된 비밀번호가 암호화되었는지 확인.

---

## 12. 회원가입 API 요청

### 12-1. 프론트엔드 코드 작성
`JS` 폴더의 `signUp.js` 파일에 회원가입 API 요청 메서드를 작성한다.

#### DOMContentLoaded 이벤트

```javascript
document.addEventListener('DOMContentLoaded', initSignUp);

function initSignUp() {  // 이벤트 함수
    // 입력값 읽어오기
}
```

#### 사용자 입력값 읽어오기
`signUp.jsp` 파일의 입력값을 가져온다.

```javascript
const emailOrPhone = document.querySelector('input[name="email"]').value;
const name = document.querySelector('input[name="name"]').value;
const username = document.querySelector('input[name="username"]').value;
const password = document.querySelector('input[name="password"]').value;

const payload = {
    emailOrPhone: emailOrPhone,
    name: name,
    username: username,
    password: password
};
```
key 값을 꼭 저렇게 설정해야 할까?
: SignUpRequest에서 설정된 필드명이기 때문이다. 서버가 요청한 값대로 전달해야 한다.

#### 폼의 submit 이벤트 처리

submit 이벤트는 새로고침이 일어나기 때문에 e.preventDefault(); 를 추가해주어 이를 방지한다.
```javascript
const $form = document.querySelector('.auth-form');

$form.addEventListener('submit', e => {
    e.preventDefault(); // 새로고침 방지

    // 입력값 읽기
    const emailOrPhone = document.querySelector('input[name="email"]').value;
    const name = document.querySelector('input[name="name"]').value;
    const username = document.querySelector('input[name="username"]').value;
    const password = document.querySelector('input[name="password"]').value;

    const payload = {
        emailOrPhone: emailOrPhone,
        name: name,
        username: username,
        password: password
    };

    console.log(payload);

    // 서버로 데이터 전송
    fetchToSignUp(payload);
});
```

#### 서버로 데이터 전송

```javascript
async function fetchToSignUp(userData) {
    const response = await fetch('/api/auth/signup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(userData)
    });

    if (response.ok) {
        window.location.href = '/'; // 로그인 페이지로 이동
    } else {
        alert('회원가입에 실패했습니다.');
    }
}
```

### 12-2. 테스트
1. 서버를 재실행.
2. 회원가입 입력값을 작성 후 데이터를 제출.
3. 데이터베이스에 정상적으로 저장되었는지 확인.

---

위 과정을 통해 비밀번호 암호화 및 회원가입 API 요청 처리 완료!<br>
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

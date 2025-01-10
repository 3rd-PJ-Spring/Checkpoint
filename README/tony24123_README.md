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

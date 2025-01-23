## ✏️ Daily Study
### [↩ Go Back Main README](https://github.com/3rd-PJ-Spring/Checkpoint?tab=readme-ov-file#%EF%B8%8F-daily-study)
<details>
  <summary><b>🐹chchch928's footprint</b></summary>
	<details>
		<summary><b>ㅤ25/01/23/목:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/22/수: 로그인 및 회원가입 기능 구현3</b></summary>	

- 에러메세지가 두번 발생하는 상황 해결
		ㅤㅤㅤ
	</details>
	<details>
		<summary><b>ㅤ25/01/21/화: 로그인 및 회원가입 기능 구현2 </b></summary>	

- 로그인 dto, 서비스로직 구현, 컨트롤러 작성 및 비밀번호 암호화 
- 로그인 예외처리
- 회원가입 및 로그인 테스트
ㅤㅤㅤ

</details>
	<details>
		<summary><b>ㅤ25/01/20/월: 로그인 및 회원가입 기능 구현1 </b></summary>
		ㅤㅤ

- 기능을 구현할 환경을 설정 
- 로그인 페이지 및 회원가입 페이지의 jsp와 css 구성
- 회원가입 예외처리 
- 회원가입 dto생성 , 엔터티 생성, 서비스 로직 구현, 컨트롤러 작성을 통해 회원가입의 기본 기능 구현
- 회원가입 시 중복된데이터 및 빈 입력시, 입력창아래에 에러메시지 출력
ㅤ
</details>
	<details>
		<summary><b>ㅤ25/01/17/금: 게시판 기능 구현하기1 </b></summary>	
		ㅤㅤㅤ
<h3> 게시판 요구사항 분석 및 기본적인 틀 구성 </h3>

(1) 게시판 요구사항 분석 (로그인 기능, 게시글 작성, 게시글 목록보기, 게시글 수정, 게시글 삭제)

```txt
<게시판 프로젝트 요구사항 분석>

1. 목표 정의
- 사용자가 게시판을 작성하고 수정, 삭제 할 수 있는 어플리케이션 개발 역량을 키우고자 한다.

2. 사용자 유형 정의
- 주 사용자: 일반 사용자 (게시글 작성, 읽기)
- 관리자: 게시글 관리 (부적절한 게시글 삭제)

3. 사용자 스토리 작성
(1) 일반 사용자
- 나는 회원가입을 하고 로그인을 한 후에 게시글을 작성한다.
- 나는 게시판에 있는 게시글의 목록을 보고싶다.

(2) 관리자 
- 나는 부적절한 게시글을 삭제하고 싶다.

4. 기능 요구사항 정의

(1) 일반 사용자
- 회원가입 및 로그인
- 게시글 작성, 읽기, 수정, 삭제

(2) 관리자
- 게시글 관리 (삭제처리)

5. 비기능 요구사항 정의
- 보안: 비밀번호 암호화 및 인증 토큰을 사용
- 사용성: 직관적인 UI 사용

6. 우선순위 지정
- 최우선: 회원가입 및 로그인, 게시글 작성 및 읽기
- 중요: 게시글 수정 및 삭제
- 추가: 댓글 기능, 관리자 기능, 디자인 개선
```

(2) 게시판을 구성하는 필수적인 구조를 만들고, 그 구조에 맞는 jsp파일과 css파일 생성
(3) 게시판 이름(PINGPOST), 로고 만들기

</details>
	<details>
		<summary><b>ㅤ25/01/16/목: 인스타그램 피드 메서드 테스트 </b></summary>

<h3> 1. 피드가 제대로 생성되는지 확인해보기 위해 테스트 </h3>

(1) 테스트를 실행해보기 위해서 설정한다.
- PostRepository 에서 test를 만든다.
- 스프링이 관리하고 있는 빈들을 모두 불러오기 위해서 @SpringBootTest를 붙이면, PostRepository를 @Autowired로 주입받을 수 있다.

(2) 피드를 제대로 생성되는지 확인하기 위해
- 테스트를 위해 @Test를 붙이고,  @Displayname("테스트이름")로 테스트를 설명하는 이름을 붙인다.
- test를 반복해서 실행하면 실제로 데이터베이스에 계속 쌓이기때문에 이를 방지하기 위해서 테스트 종료 후 데이터를 초기상태로 원상복구해주는 @Transactional을 붙여준다.
- GWT 패턴인 given(테스트를 위해 주어지는 데이터), when(실제 실행될 테스트 핵심코드), then(테스트 검증)으로 구성한다.
- given에서는 테스트를 위해 내용, 작성자 데이터를 임의로 작성한다.
-  when에서는 postRepository에  아까 가져온 데이터인 givenPost를 넣어주면서 피드 게시물을 저장할 saveFeed 명령을 내린다.
- then에서는 생성된 피드 게시물의 id를 가져오고 id가 잘찍히는지 확인을 위해 콘솔을 출력해보고, postId가 null이 아니라고 단언을 하면 postId가 생기면 테스트가 통과하고  postId가 생기지 않는다면 테스트가 통과하지 않는 것으로 직관적으로 알 수 있다.

```java
package com.example.instagramclone.repository;
import com.example.instagramclone.domain.post.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링이 관리하고 있는 빈들을 모두 불러옴
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;
    // 테스트는 케이스별 메서드를 한개씩 만듬
    @Test
    // 테스트를 설명하는 이름 - 단언 (Assertion)
    @DisplayName("피드의 내용을 2200자 내로 작성하면 피드가 반드시 생성된다.")
    void saveFeedTest() {

        // GWT 패턴
        // given - 테스트를 위해 주어지는 데이터
        Post givenPost = Post.builder()
                .content("테스트 컨텐츠입니다")
                .writer("임시작성자")
                .build();

        // when - 실제 실행될 테스트 핵심 코드
        postRepository.saveFeed(givenPost);

        // then - 테스트 검증 (단언)
        Long postId = givenPost.getId(); // 생성된 피드게시물의 id를 가져옴
        // System.out.println("postId = " + postId);

	// postId가 null이 아닐 것이라고 확신한다.
        assertThat(postId).isNotNull();
    }
}
```

<h3> 2. 피드 생성 단위를 테스트하기 </h3>

(1) 모든 피드를 조회하는 테스트 만들기
- 아까와 같이 GWT패턴으로 모든 피드를 조회하는 findAllTest를 만든다.
- given에서는 for문으로 3개의 피드를 입력해보도록 데이터를 임의로 만들고 저장한다.
- when에서는 실제로 조회를 해보기 위해서 findAll로 feedList를 받아온다.
- then에서는 forEach문으로 콘솔을 출력해서 확인하고, assertThat으로 feedList의 크기가 3개라고 하고, feedList의 첫번째 게시물의 작성자가 임시작성자2가 맞는지 단언한다.

```java
@Test
    @DisplayName("피드를 3개 작성하고 피드 목록조회하면 리스트의 크기는 3이어야 한다.")
    void findAllTest() {
        //given
        for (int i = 0; i < 3; i++) {
            Post givenPost = Post.builder()
                    .content("테스트 컨텐츠입니다" + i)
                    .writer("임시작성자" + i)
                    .build();
            postRepository.saveFeed(givenPost);
        }
        //when
        List<Post> feedList = postRepository.findAll();
        //then
        // feedList.forEach(System.out::println);
        assertThat(feedList.size()).isEqualTo(3);
        assertThat(feedList.get(0).getWriter()).isEqualTo("임시작성자2");
    }
```

(2) 이미지가 피드에 잘 생성되는지 테스트하기
- 아까와 같이 GWT 패턴으로 이미지를 저장하고 조회하는 saveImagesAndFindImages를 만든다.
- given에서는 피드를 한개 생성하고 saveFeed로 피드를 저장한다. 그리고 피드에서 postId를 받아온다.
- 그리고 받아온 postId, imageOrder, imageUrl로 구성된 첨부 이미지를 두개 생성해본다.
- when에서는 saveFeedImage를 활용해서 각각 이미지를 저장하고 findImagesByPostId로 imageList를 조회해본다.
- then에서는 imageList를 forEach문으로 콘솔로 출력해본다.
  -그리고 imageList의 크기가 2이고, imageList의 0번인덱스의 imageOrder가 1이고, imageList의 1번 인덱스의 imageUrl에 아꺼 지정한 second가 포함되어 있는지 단언한다.


```java
 @Test
    @DisplayName("""
            피드를 하나 생성하고 해당 피드에 이미지를
            2개 첨부했을 때 이미지 생성과 함께 해당 이미지 목록이 조회된다.
            """)
    void saveImagesAndFindImages() {
        
	//given
        // 피드를 한 개 생성
        Post feed = Post.builder()
                .writer("하츄핑")
                .content("ㅎㅎㅎㅎ")
                .build();
        postRepository.saveFeed(feed);
        
	// 첨부 이미지를 2개 생성
        Long postId = feed.getId();
        
	PostImage image1 = PostImage.builder()
                .postId(postId) // 원본 피드 번호
                .imageOrder(1)
                .imageUrl("/uploads/first-image.jpg")
                .build();
        
	PostImage image2 = PostImage.builder()
                .postId(postId)
                .imageOrder(2)
                .imageUrl("/uploads/second-image.jpg")
                .build();
        
	//when
        postRepository.saveFeedImage(image1);
        postRepository.saveFeedImage(image2);
        List<PostImage> imageList = postRepository.findImagesByPostId(postId);
        
	//then
        imageList.forEach(System.out::println);
        assertThat(imageList.size()).isEqualTo(2);
        assertThat(imageList.get(0).getImageOrder()).isEqualTo(1);
        assertThat(imageList.get(1).getImageUrl()).contains("second");
    }
```

</details>
	<details>
		<summary><b>ㅤ25/01/15/수: 인스타그램 기본 예외처리 글로벌 핸들러 설정/ 피드 및 피드 이미지 테이블 생성, SQL 매퍼 추가</b></summary>	

<h3>1. 기본 예외처리 글로벌 핸들러 설정 </h3>

(1) API에서 나올 에러들을 상수로 표현할 열거형 ErrorCode 만들기
- Httpstatus와 message가 있는 알 수 없는 서버 오류를 추가한다.
- HttpStatus와 message를 각각 필드로 생성한다.
- status와 message를 뽑아와야 하므로 @Getter와 final인 필드의 생성자를 자동으로 만들어주는 @RequiredArgsConstructor를 설정한다.

```java
// API에서 나오는 여러가지 에러상황들을 상수로 표현
@RequiredArgsConstructor
@Getter

public enum ErrorCode {

    // 알 수 없는 서버오류
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 오류입니다. 점검 후 조치하겠습니다."),
    ;
    
    private final HttpStatus status;
    private final String message;
}
```

(2) 에러가 발생했을때 구체적으로 클라이언트에게 전송해 줄 json인 ErrorResponse 만들기
- 에러가 발생한 시간, 상태코드, 이름, 원인메세지, 발생한 경로를 각각 필드로 생성한다.

```java
@Getter
@Builder
// 에러가 발생했을 때 클라이언트에게 전송할 구체적인 에러내용들을 담은 JSON
public class ErrorResponse {
    private final LocalDateTime timestamp; // 에러가 발생한 시간
    private final int status;  // 에러 상태코드
    private final String error; // 에러 이름
    private final String message; // 에러 원인 메시지
    private final String path;   // 에러가 발생한 경로
}
```

(3) API에서 발생한 모든 에러들을 모아서 일괄 처리할 AOP 클래스인 GlobalExceptionHandler 만들기
- 어플리케이션의 모든 컨트롤러에서 발생하는 예외를 전역적으로 처리하는 @ControllerAdvice와 로그를 찍기위해서 @Slf4j을 설정한다.
- 우리가 처리할 수 없는 에러들을 처리하기 위해 @ExceptionHandler로 모든 에러의 부모를 가져와 handleGlobalException 메서드를 생성하고 그 메서드에 필요한 예외객체와 요청에 대한 정보를 가져온다.
- @Builder로 만든 ErrorResponse을 가져와서 에러가 발생한 시간을 현재로 지정하고, ErrorCode에서 만든 메세지를 가져오고, request 객체에서 경로를 가져오고, ErrorCode에서 에러의 이름을 가져오고, ErrorCode에서 status의 값을 가져온다.
- 에러의 정보가 담긴 ResponseEntity에서 status에는 500 상태코드를, 응답 본문에는 ErrorResponse 객체를 보내준다.

```java
// API에서 발생한 모든 에러들을 모아서 일괄 처리
@ControllerAdvice
@Slf4j

public class GlobalExceptionHandler {
    
// 알 수 없는 기타 등등 에러를 일괄 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e, HttpServletRequest request) {
        log.error("Unexpected error occurred: {}", e.getMessage(), e);
        
// 에러 응답 객체 생성
        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .path(request.getRequestURI())
                .error(ErrorCode.INTERNAL_SERVER_ERROR.name())
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value())
                .build();
        return ResponseEntity
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .body(response);
    }
}
```

<h3> 2. 피드 및 피드 이미지 테이블 생성, SQL매퍼 추가 </h3>

(1) ddl.sql에 게시물 테이블, 게시물 이미지 테이블 만들기
- 게시물 테이블에는 피드 게시물의 식별자인 id, 피드 내용인 content, 게시물 작성자의 이름인 writer, 조회수인 view_count, 생성시간인 created_at, 갱신시간인 updated_at으로 구성한다.
- 게시물 이미지 테이블에는 각 이미지를 구분하는 식별자인 id, 어떤 피드에 속해있는지 구분해주는 post_id,
  서버 어느 곳애 저장되었는지 보여주는 image_url, 이미지의 순서를 알려주는 image_order, 생성시간인 created_at으로 구성하고 post_id를 외래키로 설정해서 게시물 테이블의 id를 참조해서 피드가 삭제되면 이미지도 자동으로 삭제할 수 있게 만든다.

```sql
-- 게시물 테이블
CREATE TABLE posts
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    content    TEXT,
    writer     VARCHAR(100) NOT NULL,
    view_count INT       DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 게시물 이미지 테이블
CREATE TABLE post_images
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id     BIGINT       NOT NULL,
    image_url   VARCHAR(255) NOT NULL,
    image_order INT          NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE
);
```

(2) 게시물 테이블과 게시물 이미지 테이블에 맞는 엔터티 클래스인 Post, PostImage를 설계한다.
- DB의 게시물 테이블과 동일하게 Post 클래스를 만든다. (다만, 자바의 관례에 맞게)
- DB의 게시물 이미지 테이블과 동일하게 PostImage 클래스를 만든다.
```java
package com.example.instagramclone.domain.post.entity;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Post {
    private Long id;
    private String content;
    private String writer;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
```

```java
package com.example.instagramclone.domain.post.entity;
import lombok.*;
import java.time.LocalDateTime;
@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostImage {
    private Long id;
    private Long postId;
    private String imageUrl;
    private int imageOrder;
    private LocalDateTime createdAt;
}
```

(3) DB와 엔터티 클래스를 연결시켜줄 repository 레이어인 PostRepository를 만든다.
- mybatis에서는 인터페이스 설계대로 만들어주기 때문에 인터페이스로 만들어주고 @Mapper를 붙인다
- 피드 게시물을 저장하는 기능, 피드 이미지를 저장하는 기능, 특정 피드에 첨부된 이미지 목록을 조회하는 기능, 전체 피드 게시물 목록을 조회하는 기능이 실행되도록 구성한다.

```java
package com.example.instagramclone.repository;
import com.example.instagramclone.domain.post.entity.Post;
import com.example.instagramclone.domain.post.entity.PostImage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface PostRepository {
    // 피드 게시물 저장
    void saveFeed(Post post);
    // 피드 이미지 저장
    void saveFeedImage(PostImage postImage);
    // 특정 피드에 첨부된 이미지 목록 조회
    List<PostImage> findImagesByPostId(Long postId);
    // 전체 피드 게시물 목록 조회
    List<Post> findAll();
}
```

(4) 위에서 실행되도록 한 기능들을 구현해 줄 PostMapper.xml을 만든다
- 설정할 때 mapper 폴더 아래에 xml을 구성하기로 했으므로 resources의 mapper에 PostMapper.xml을 만든다
- mapper의 namespace에 아까 만든 인터페이스랑 연결하기 위해서 패키지명과 인터페이스명을 넣어준다
- 피드 게시물 저장을 구현하기 위해서 insert문에 id는 saveFeed, keyProperty로 id를 지정해주면 저장되자마자 id가 리턴되는 역할을 해준다. 그리고 content와 writer값을 넣어준다. (나머지는 자동생성되므로 넣을 필요없다.) INSERT INTO의 뒤에는 데이터베이스의 컬럼명으로,  VALUES 뒤에는 #{자바이름}으로 넣어주어야 한다.
- 피드 이미지 저장 구현도 마찬가지로 구성하고, post_id와 image_url, image_order 값을 넣어준다.
- 특정 피드에 첨부된 이미지 목록을 조회하기 위해서는 select문에 return이 있으므로 return은 resultType으로 클래스 이름인 PostImage를 적는다. (yml에서 미리 이름을 설정해두었기때문에 패키지 이름은 적을 필요가 없다.) 그리고 원본 피드의 id를 기준으로 찾아야 하므로 WHERE post_id = #{postId}로, ORDER BY를 이용해서 이미지 순서대로 정렬한다.
- 전체 피드 게시물 목록조회도 마찬가지로 구현하고, 모두 조회하는 것이므로 WHERE절은 없고 최신 피드가 위로 올라가야하므로 ORDER BY를 이용해서 생성시간이 내림차순이 되게 설정한다.


```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.instagramclone.repository.PostRepository">
    <!-- insert만 특별하게 auto_increment로 지정한 key를 지정해줌   -->
    <insert id="saveFeed" keyProperty="id" useGeneratedKeys="true">
        INSERT INTO posts
            (content, writer)
        VALUES
            (#{content}, #{writer})
    </insert>
    <insert id="saveFeedImage" keyProperty="id" useGeneratedKeys="true">
        INSERT INTO post_images
            (post_id, image_url, image_order)
        VALUES
            (#{postId}, #{imageUrl}, #{imageOrder})
    </insert>
    <select id="findImagesByPostId" resultType="PostImage">
        SELECT
            *
        FROM post_images
        WHERE post_id = #{postId}
        ORDER BY image_order
    </select>
    <select id="findAll" resultType="Post">
        SELECT
            *
        FROM posts
        ORDER BY created_at DESC
    </select>
</mapper>
```
</details>
	<details>
		<summary><b>ㅤ25/01/14/화: 인스타그램 피드 생성 모달 종료시 경고 중첩 모달 만들기 / 백엔드 파일 업로드 설정 추가 및 로컬 리소스 접근 설정 추가</b></summary>	

<h3> 1. 피드 생성 모달 종료시 경고 중첩 모달만들기</h3>

(1) 피드 생성 모달 종료시 경고 중첩모달 띄우기
- create-feed-modal.js에서 DOM에 nested-modal(중첩모달), delete-button(중첩모달 내 삭제버튼), cancel-button(중첩모달 내 취소버튼)을 추가한다.
- setUpModalEvents에 nested-modal을 가져오고 모달닫기(closeModal)에 step2부터 모달을 닫지말고 중첩된 모달을 띄우도록 한다.

```js
const elements = {
  $nestedModal: $modal.querySelector('.nested-modal'),
  $deleteBtn: $modal.querySelector('.delete-button'),
  $cancelBtn: $modal.querySelector('.cancel-button'),
};

function setUpFileUploadEvents() {
// 피드 생성 모달 관련 이벤트 함수
    function setUpModalEvents() {

        const {$closeBtn, $backdrop, $backStepBtn, $nextStepBtn, $nestedModal} = elements;

        // 모달 닫기
        const closeModal = e => {
            e.preventDefault();

            // step2부터는 모달을 닫으면 안됨. 대신 새로운 모달을 띄워야 함
            if (currentStep >= 2) {
                // 중첩 모달 띄우기
                $nestedModal.style.display = 'flex';
                return;
            }
        }
    }
}

```

(2) 중첩모달 클릭이벤트 처리
- 피드 내용입력 이벤트인 setupNestedModalEvents 함수를 만들고, DOM에서 $nestedModal, $deleteBtn, $cancelBtn 를 가져온다.
- 취소버튼을 눌렀을 때 중첩모달이 사라지게 하고, 삭제버튼을 눌렀을 때 다시 초기상태로 돌아가게 한다.
- 이벤트 바인딩 관련함수에 setupNestedModalEvents 추가

``` js
// 피드 모달 닫을 때 삭제 취소 관련
function setupNestedModalEvents() {
  const { $nestedModal, $deleteBtn, $cancelBtn } = elements;
  // 취소처리 - 중첩모달만 닫기
  $cancelBtn.addEventListener('click', () => { 
    $nestedModal.style.display = 'none';
  });
  // 삭제처리 - 모든 모달을 닫고 초기상태로 귀환
  $deleteBtn.addEventListener('click', () => { 
    // 새로고침시 모든것이 초기로 돌아감
    window.location.reload();
  });
}

// 이벤트 바인딩 관련 함수
function bindEvents() {
  setupNestedModalEvents(); // 중첩 모달 관련 이벤트
}
```

<h3> 2. 백엔드 파일 업로드 설정 추가 및 로컬 리소스 접근 설정 추가</h3>

(1) application.yml 설정
- server port번호는 8900
- spring.datasource는 데이터베이스 연결을 설정
- mvc.view는 jsp파일을 열어주는 세팅
- servlet은 파일 업로드 관련 설정
- mybatis는 말그대로 mybatis를 설정
- logging.level은 로그를 찍을때 루트패키지의 어디까지 볼지를 설정
- file.upload.location은 피드에 올릴 이미지들을 저장할 장소를 지정

(2) 파일 업로드를 위한 폴더를 생성할 FileUploadConfig 생성
- 스프링 loC컨테이너를 구성하기 위한 설정 파일임을 알리기 위해서 @Configuration을 설정하고 값을 가져올 @Getter, 값을 설정해 줄 @Setter도 설정한다.
- 업로드할 루트 디렉토리 location을 만들고, 아까 application.yml에서 설정한 루트를 가져오기 위해 @Value("${file.upload.location}")을 설정한다.
- @PostConstruct로 설정클래스가 생성되고 자동으로 호출할 init 메서드를 설정한다.
- init 메서드에 아까 지정한 location 경로에 해당하는 폴더를 나타내는 객체로 생성하고 폴더가 존재하지 않는다면 새 폴더를 생성한다.

```java
package com.example.instagramclone.config;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.io.File;

// 파일 업로드 루트 디렉토리 가져오기 및 생성
@Configuration
@Getter @Setter

public class FileUploadConfig {
    @Value("${file.upload.location}")
    private String location; // 업로드할 루트 디렉토리

    @PostConstruct // 이 설정클래스가 생성된 이후 자동으로 호출
    public void init() {
        File directory = new File(location);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
```

(3) 로컬에 있는 파일을 서버에서도 열 수 있도록 하는 WebResourceConfig 생성
- 파일의 위치가 필요하기 때문에 아까와 동일하게 설정파일로 만들어주는 @Configuration을 넣고 @RequiredArgConstruct로 fileUploadConfig를 가져온다. (FileUploadConfig에 붙인 @Configuration에 @Component가 숨겨져 있으므로)
- 로컬 URL을 서버 URL로 변환시키기 위해서  WebResourceConfig 클래스에 WebMvcConfigurer를 implements하고 addResourceHandler에 설정한 대로 로컬경로에서 해당하는 파일을 찾아서 서버에게 반환 시켜준다.

```java
package com.example.instagramclone.config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 로컬에 저장된 파일을 서버에서 열 수 있도록 설정
@Configuration
@RequiredArgsConstructor

public class WebResourceConfig implements WebMvcConfigurer {
    private final FileUploadConfig fileUploadConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**") // 서버 URL
                .addResourceLocations("file:" + fileUploadConfig.getLocation()); // 로컬 URL
    }
}
```

</details>
	<details>
		<summary><b>ㅤ25/01/13/월: 인스타그램 캐러셀 이동시 UI 업데이트 / 이미지 파일 업로드 드래그앤 드롭 이벤트 / 피드내용 글자 수를 갱신처리</b></summary>	

<h3> 1. 캐러셀 이동시 UI 업데이트 </h3>

(1) 슬라이드의 index에 따라 이전, 다음 슬라이드 버튼 활성화 여부를 설정한다.
- 만일 초기화면일 경우, 이전 버튼이 버튼이 보이지 않도록 설정한다.
- 만일 슬라이드의 마지막 화면일 경우, 다음 버튼이 보이지 않도록 설정한다.

(2) 슬라이드의 index에 따라 인디케이터도 움직이도록 설정한다.
- 인디케이터에 active 클래스만 붙여주면 인디케이터가 활성화되도록 설정되어 있다
- 인디케이터들을 다 잡아오기 위해서 indicatorContainer의 자식들을 $indicators 라고 지정한다.
- ForEach문으로 각각의 인디케이터($ind)와 인덱스 (i)를 가져온다.
- 각각의 인디케이터에 toggle 이벤트를 통해 가져온 i가 현재 슬라이드 위치와 같으면 active클래스가 활성화되도록 설정한다.

```js
 class CarouselManager {
    goToSlide(index) {

        // 이전, 다음 슬라이드 버튼 활성화 여부
        this.prevBtn.style.display = index === 0 ? 'none' : 'flex';
        this.nextBtn.style.display = index === this.slides.length - 1 ? 'none' : 'flex';

        // 인디케이터 변화 업데이트
        const $indicators = [...this.indicatorContainer.children];
        $indicators.forEach(($ind, i) => {
            $ind.classList.toggle('active', i === index);
        });
    }
};

```

<h3> 2. 이미지 파일 업로드 드래그앤 드롭 이벤트 </h3>

(1) 파일 드래그 이벤트를 설정한다.
- create-feed-modal.js에서 DOM 객체 영역에 $uploadArea를 불러오고,
  setUpFileUploadEvent에서 elements에 드래그할 영역인 $uploadArea를 가져온다.
- css로 dragover라는 클래스를 만들어 파일을 넣을려고 할때, 업로드 영역에 변화가 생기도록 만든다.
- $uploadArea에 드래그 했을때 dragover라는 클래스를 주고, $uploadArea에서 드래그 한 것이 벗어났을때 dragover라는 클래스를 제거함으로써 파일이 들어오고 나가는 것을 ui적으로 표현해준다.

```js
// 파일 드래그& 드롭 이벤트
    // 드래그 영역에 진입했을 때
    $uploadArea.addEventListener('dragover', (e) => {
        e.preventDefault();
        $uploadArea.classList.add('dragover');
    });

    // 드래그 영역에서 나갔을 때
    $uploadArea.addEventListener('dragleave', (e) => {
        e.preventDefault();
        $uploadArea.classList.remove('dragover');
    });
```

(2) 파일 드롭 이벤트를 설정한다.
- 파일을 업로드 영역에 떨어뜨렸을 때, 발생하는 이벤트를 만들고 떨어뜨린 파일 정보를 불러오도록 만든다.
- 마지막으로 조건문을 만들어 파일을 검증한다.

```js
 // 드래그 영역에 드롭했을 때
    $uploadArea.addEventListener('drop', (e) => {
        e.preventDefault(); // 드롭했을 때 이미지 새탭이 열리거나 파일이 다운로드되는 것을 방지

        // 파일 정보 얻어오기
        const files = [...e.dataTransfer.files];
        // 파일 검증
        if (files.length > 0) handleFiles(files);
    });
```

<h3> 3. 피드 내용 글자 수 갱신처리  </h3>

(1) 이벤트 바인딩을 할 준비를 한다.
- DOM들을 저장할 객체에 contextTextarea, charCounter를 가져온다.
- 이벤트 바인딩 관련함수에 텍스트 입력 관련 이벤트인 setupTextareaEvents(); 를 넣는다.

(2) 피드 내용 입력 이벤트인 setupTextareaEvents를 만든다.
- 아까 DOM으로 가져온 contextTextarea, charCounter를 elements로 가져온다.
- 한글자 한글자 입력할때마다 event가 터지도록 input이벤트를 걸어 글자수를 가져온다.
- 가져온 글자수를 바로바로 보이도록 charCounter에 갱신시킨다.
- 2200글자가 넘으면 더이상 입력을 못하도록 exceed라는 charCounter에 클래스를 걸어 빨간색으로 표시하고 더이상 글자가 출력되지 않도록 contentTextarea의 value를 slice한다.

```js
function setupTextareaEvents() {
    const { $contentTextarea, $charCounter } = elements;
    $contentTextarea.addEventListener('input', () => {
        const length = $contentTextarea.value.length;
        $charCounter.textContent = `${length.toString()} / 2,200`;
        if (length > 2200) {
            $charCounter.classList.add('exceed');
            $contentTextarea.value = $contentTextarea.value.slice(0, 2200);
        } else {
            $charCounter.classList.remove('exceed');
        }
    });
}
```
</details>
	<details>
		<summary><b>ㅤ25/01/10/금: 인스타그램 포스트 이미지 개수만큼 캐러셀 인디케이터 생성 / 캐러셀 이동 이벤트 구현</b></summary>

<h3>1. 이미지 개수만큼 캐러셀 인디케이터 생성하기</h3>

(1) Carousel Manager.js에서 인디케이터를 생성하는 함수 makeIndicator를 만들고 index를 받아온다.
- feed.jsp에서 구현한대로 $indicator 변수는 span요소를 생성하고, indicator 클래스를 준다.
- 첫번째 사진에 indicator이 진하게 표시 되는 것을 구현하기 위해서 feed.jsp에서 만들어 놓은 active 클래스를 활용한다.
- container carousel-indicator를 추출해서 indicatorContainer로 가져와서, indicatorContainer에 $indicator를 추가한다.

```js
   // 인디케이터 영역
    this.indicatorContainer = this.container.querySelector('.carousel-indicators');

  // 인디케이터 생성하는 함수
  makeIndicator(index){
    const $indicator = document.createElement('span');
    $indicator.classList.add('indicator');
    if (index === 0) $indicator.classList.add('active');
    this.indicatorContainer.append($indicator);
  }

```
(2) setUpPreview 슬라이드 이미지 렌더링 하는 곳에 indicator를 생성한다.
- 기존 forEach에 index가 무엇인지 알려주기 위해 index를 추가하고, 실제 인스타와 동일하게 사진 하나만 올릴때는 indicator가 나오지 않게하기 위해서는 if문으로 slide의 길이가 1개 초과할때만 indicator가 생성되도록 한다.

```js
   // 슬라이드 이미지 생성
    this.slides.forEach((file, index) => { 
      // 인디케이터 생성
      if (this.slides.length > 1) this.makeIndicator(index);
    });
```

<h3>2. 캐러셀 이동 이벤트</h3>

(1) 슬라이드를 X축을 이용한 goToslide 함수를 만든다.

- 트랙을 이동하도록 track의 style에서 transform을 이용해서 translateX로 해당 인덱스의 x축을 이동한다.
- index가 범위 밖의 이동을 금지하도록 return하고 현재 슬라이드의 인덱스를 추적하고 관리하기 위해 현재의 인덱스를 갱신하도록 한다.

```js
// 슬라이드 X축 이동함수
    goToSlide(index) {
        if (index < 0 || index > this.slides.length - 1) return;

        // 현재 인덱스 갱신
        this.currentIndex = index;
        // 트랙 이동
        this.track.style.transform = `translateX(-${index * 100}%)`;
    }

```

(2) 슬라이드에서 이전,다음버튼을 누르면 이전, 다음 사진으로 넘어가도록 이벤트를 건다.
- create-post-modal.jsp와 feed.jsp에서 만들어 놓은 carousel-prev, carousel-next를 CarouselManager.js에 이전, 다음 슬라이드 버튼 변수로 가져온다.
- 이전 버튼을 클릭했을때 이전 사진으로 넘어가도록 이후버튼을 클릭했을 때는 이후 사진으로 넘어가도록 goToSlide 함수를 활용한다.

```js
 constructor(container){

        // 인디케이터 영역
        this.indicatorContainer = this.container.querySelector(
            '.carousel-indicators'
        );

        // 이전, 다음 슬라이드 버튼
        this.prevBtn = this.container.querySelector('.carousel-prev');
        this.nextBtn = this.container.querySelector('.carousel-next');

	// 이벤트 바인딩
    this.prevBtn.addEventListener('click', (e) => {
      this.goToSlide(this.currentIndex - 1);
    });
    this.nextBtn.addEventListener('click', (e) => {
      this.goToSlide(this.currentIndex + 1);
    });
}
```

</details>
<details>
		<summary><b>ㅤ25/01/09/목: 인스타그램 스텝 이동 버튼 바인딩 / 이미지 캐러셀 클래스 설계</b></summary>	

<h3>1.스텝 이동 버튼 이벤트 바인딩 </h3>

(1) currentStep 변수 설정하기
- create-feed-modal.js에서 setUpModalEvents 함수의 elements에 백스텝버튼과 넥스트 스텝버튼 가져오기
- step 모듈 내에서 전역관리 할 수 있도록 currentStep 지정
- goTostep 함수에서 currentStep이 step으로 작동하도록 하고, 스탭 1,2,3밖에 존재하지 않으므로 1,2,3 이외의 숫자가 step이 되지 않도록 if문을 통해  조건에 해당하지 않는 것들은 return

(2) 모달, 이전 다음 스텝에 해당하는 이벤트 발생시키기
- 백스텝 버튼을 클릭했을때 현재 스텝에서 -1, 넥스트버튼을 클릭했을때 현재스텝이 만일 현재의 스텝이 3보다 작을 경우에는 다음 스텝으로 넘어가도록 하고, 3보다 커질 경우에는 서버로 게시물을 공유하도록 한다.

```js
let currentStep = 1;

function goToStep(step) {

    if (step < 1 || step > 3) return;

    currentStep = step;
}

function setUpModalEvents() {
const { $closeBtn, $backdrop, $backStepBtn, $nextStepBtn} = elements;

// 모달 이전, 다음 스텝 클릭이벤트
    $backStepBtn.addEventListener('click', () => goToStep(currentStep - 1));
    $nextStepBtn.addEventListener('click', () => {
        if (currentStep < 3) {
            goToStep(currentStep + 1);
        } else {
            alert('서버로 게시물을 공유합니다.');
            // 차후에 서버 AJAX 통신 구현...        
        }
    })
};

```

<h3>2. 이미지 캐러셀 클래스 설계</h3>

(1) 객체지향 프로그램으로 만들기 위해 Carousel Manager.js 따로 만들기
- 생성자인 constructor를 만들고 container를 외부에서 가져오도록 한다. (캐러셀은 공통적으로 존재하기 때문에 가져올 수 없고 캐러셀의 상위에 있는 부모로 구분하기 위해)
- 생성자에서 container를 받아와서 실제 이미지가 배치될 공간인 track을 carousel-track의 클래스로 가져오고,  실제 이미지 파일을 배열할 slides를 생성자에 추가한다.
- 초기의 이미지 파일 배열을 받아오는 init 메서드를 생성한다. (files를 받아서 slides를 files로 초기화 )
- 슬라이드를 이미지 렌더링할 setUpPreview메서드를 만든다
- setUpPreview에서 slides 배열을 forEach문으로 순회하면서 이미지 element를 생성하고 전달받은 file객체를 브라우저에서 표시할 수 있는 URL로 변환한다.
- 미리 준비한 css를 활용해 이미지를 div태그에 감싸는 컨테이너를 생성하고 그 감싼 이미지들을 track에 추가시킨다.
- init메서드에 setUpPreview 함수를 적용한다.
- 이미지가 누적되는 것을 방지하기 위해 setUpPreview의 가장 처음에 이미지 트랙을 초기화한다.
- CarouselManager를 내보내야 하므로 export한다.

```js
class CarouselManager {
  // 생성자
  constructor(container) {
    // 캐러셀을 감싸는 전체 부모태그
    this.container = container;
    // 이미지 트랙(실제 이미지가 배치될 공간)
    this.track = this.container.querySelector('.carousel-track');
    
    // 실제 이미지 파일 배열
    this.slides = [];
  }
  // 초기 이미지파일 배열 받기
  init(files) {
    this.slides = files;
    // 슬라이드 띄우기
    this.setUpPreview();
  }
  // 슬라이드 이미지 렌더링
  setUpPreview() {
    // 이미지 트랙 리셋
    this.track.innerHTML = '';
    this.slides.forEach(file => { 
      // 이미지 생성
      const $img = document.createElement('img');
      // raw file을 image url로 변환
      $img.src = URL.createObjectURL(file);
      // 이미지를 감쌀 박스 생성
      const $slideDiv = document.createElement('div');
      $slideDiv.classList.add('carousel-slide');
      $slideDiv.append($img);
      this.track.append($slideDiv);
    });
  }
}
export default CarouselManager;
``` 

(2) setUpFileUploadEvents에 이미지 슬라이드를 생성
- setUpFileUploadEvents에 CarouselManager를 불러와야 하므로 import한다 (이때 자동완성시에 js가 붙지않으므로 주의!)
- new CarouselManger가 반복되면 계속 슬라이드가 누적 되는 것을 방지하기 위해 step2Carousel,step3Carousel을 둘다 전역변수로 빼준다.
- 만일 이미 step2캐러설과 step3Carousel이 생성되어 있다면, init만 호출해서 슬라이드 목록만 업데이트 되도록 한다.
- 그리고 만일 최초 생성이라면 새로 만든다.
- preview-container가 클래스인 컨테이너를 제어해야 하므로 carouselManger의 함수에서 사용되도록step2Carousel로 가져온다.
- step2Carousel에 init된 파일을 보낸다.
- step3Carousel도 step2Carousel과 마찬가지로 캐러셀을 설정하고 step3는 preview-container가 아닌 write-container로만 변경해주면 된다.

```js

import CarouselManager from "../ui/CarouselManager.js";

// 캐러셀 전역관리
let step2Carousel = null;
let step3Carousel = null;

function setUpFileUploadEvents() {

        // 이미 생성되어 있다면, 그냥 init()만 다시 호출해서 '슬라이드 목록'만 업데이트
        if (step2Carousel && step3Carousel) {
            step2Carousel.init(validFiles);
            step3Carousel.init(validFiles);
        }
        // 최초 생성이라면 새로 만든다.
        else {
            step2Carousel = new CarouselManager(
                $modal.querySelector('.preview-container')
            );
            step3Carousel = new CarouselManager(
                $modal.querySelector('.write-container')
            );

            step2Carousel.init(validFiles);
            step3Carousel.init(validFiles);
        }

        // 모달 step 2로 이동
        goToStep(2);
    };
```

</details>
	<details>
		<summary><b>ㅤ25/01/08/수: 인스타그램 이미지 파일 검증 및 모달 스텝이동 / 이동버튼 이벤트 바인딩하기</b></summary>	

<h3>1. 이미지 파일 검증: 10메가 용량을 넘는 파일과 이미지가 아닌 파일은 필터링으로 제외한다.</h3>

(1) 일단 필터링을 사용하기 위해서는 파일정보를 배열로 만들고 함수를 handleFiles라는 함수를 적용시켜 files를 검증할 준비를 한다.
- 현재 console에서 Prototype상 유사배열이기때문에 배열로 변경한다.  -> [...e.target.files]
- 만일 파일 업로드했다면 handleFiles라는 함수로 그 파일을 검증하게 한다.

setUpFileUploadEvents의 함수에서

```js
// 파일 선택이 끝났을 때 파일정보를 읽는 이벤트
  $fileInput.addEventListener('change', e => {
    const files =[...e.target.files];
if(files.length >0) handleFiles(files)
  });
```

(2) 파일을 검사하고 다음단계로 이동하는 handleFiles라는 함수를 만들어 files를 검사한다.
- 파일의 수가 10개 넘는다면 알림창을 통해 '최대 10개의 파일만 선택가능하다'고 알려주고 리턴으로 내보낸다

```js
 // 파일을 검사하고 다음 단계로 이동하는 함수
  const handleFiles = files => {
      // 파일의 개수가 10개가 넘는지 검사
      if (files.length > 10) {
          alert('최대 10개의 파일만 선택 가능합니다.');
          return;
      }
  }
```

(3) 파일이 이미지인지 확인하는 함수를 validFiles라는 함수를 만들어 filter를 적용한다.
- 1차검증으로 filter로 파일의 타입이 만일 image로 시작하지 않으면 알림창을 통해 파일이름과 함께 '이미지가 아닙니다'로 알려주고 false값으로 내보내고 맞다면 true값으로 내보낸다.
- 그리고 2차검증으로 filter로 파일의 사이즈가 10메가바이트를 초과한다면 알림창을 통해 파일이름과 함께 '10MB를 초과합니다'로 알려주고 false값으로 내보내고 맞다면 true로 내보낸다.

```js
 // 파일이 이미지인지 확인
    const validFiles = files.filter(file => {
      if (!file.type.startsWith('image')) {
        alert(`${file.name}은(는) 이미지가 아닙니다.`);
        return false;
      }
      return true;
    }).filter(file => { 
      if (file.size > 10 * 1024 * 1024) {
        alert(`${file.name}은(는) 10MB를 초과합니다.`);
        return false;
      }
      return true;
    });
```

<h3>2. 모달 스텝이동하기</h3>

(1) 모달 바디 스텝을 이동하는 함수 goToStep을 만든다.
- 각 스탭인 업로드 (step1),미리보기 및 편집(step2),내용작성(step3)의 컨테이너들의 클래스로 step을 달아주었기 때문에 모달에서 step 클래스를 갖고있는 요소들을 모두 가져온다.
-  active 클래스를 display:flex로 만들었기 때문에 각 스탭 컨테이너에 active클래스를 부여하면 출력되고 active를 제거하면 출력되지 않는 시스템이다.
   -해당 스탭에 맞는 active를 가져오기 위해서는 가져온 요소들을 모두 배열로 변환한다
- forEach문으로 step클래스가 있는 컨테이너에 $stepContainer를 부여하고 toggle을 이용해서 해당 step과 index+1이 같아질때만 $stepContainer에 active 클래스를 붙이도록한다.


```js
function goToStep(step) {
  // 기존 스텝 컨테이너의 active를 제거하고 해당 step컨테이너에 active부여
  [...$modal.querySelectorAll('.step')].forEach(($stepContainer, index) => { 
    $stepContainer.classList.toggle('active', step === index + 1);
  });
}

```

(2). handleFiles 함수의 마지막에 goToStep(2)로 스탭을 지정하고 , 각 스텝에 맞는 버튼을 가져오기

- 모달관련 DOM들을 저장할 객체인 elements에 $backStepBtn, $nextStepBtn, $modalTitle을 가져오고 goToStep함수에도  추가한다.
- 다음번 change 이벤트 발동을 위해 fileInput의 값을 초기화한다. (change 이벤트는 변화가 있을때만 발동하는데 같은 파일을 두번올리면 변화가 없다고 판단)
- 각 스탭에 맞는 버튼을 설정한다.
- 스탭1에서는 두버튼 다 보이지 않게하고 modal제목을 편집으로 설정, 스탭2에서는 두버튼 다 보이고 modal제목을 편집으로 설정, 스탭3에서는 next버튼의 내용을 공유하기, modal제목을 새 게시물 만들기로 설정한다.
- 여기서 주의해야 할점은 스탭3에서 next버튼의 내용을 변경했기때문에 스탭3에서 스탭2로 되돌아갈때를 염려해서 스탭2의 next버튼 내용을 기존내용으로 다시 설정해줘야 한다는 것이다.


```js
const elements = {
    $closeBtn: $modal.querySelector('.modal-close-button'),
    $backdrop: $modal.querySelector('.modal-backdrop'),
    $uploadBtn: $modal.querySelector('.upload-button'),
    $fileInput: $modal.querySelector('#fileInput'),
    $backStepBtn: $modal.querySelector('.back-button'),
    $nextStepBtn: $modal.querySelector('.next-button'),
    $modalTitle: $modal.querySelector('.modal-title'),
};

function goToStep(step) {
  const { $backStepBtn, $nextStepBtn, $modalTitle, $fileInput } = elements;

  // 각 스텝별 버튼 활성화/비활성화 처리
    if (step === 1) {
        $fileInput.value = ''; // 다음번 change이벤트 발동을 위한 리셋
        $nextStepBtn.style.display = 'none';
        $backStepBtn.style.visibility = 'hidden';
        $modalTitle.textContent = '새 게시물 만들기';
    } else if (step === 2) {
        $nextStepBtn.style.display = 'block';
        $backStepBtn.style.visibility = 'visible';
        $modalTitle.textContent = '편집';
        $nextStepBtn.textContent = '다음';
    } else if (step === 3) {
        $nextStepBtn.textContent = '공유하기';
        $modalTitle.textContent = '새 게시물 만들기';
    }
}

```
ㅤㅤㅤ


</details>
<details>
		<summary><b>ㅤ25/01/07/화: 인스타그램 업로드한 이미지 파일읽기 </b></summary>

<h3>1. 파일을 여러개 선택하게 하고 이미지 파일만 올릴 수 있도록 제약한다. 그리고 기존의 input버튼 모양이 아닌 다른 모양으로 설정할 수 있도록 한다.</h3>

- create-post-modal.jsp로 들어가서 모달바디의 업로드 부분에 input의 type이 file이고
  id가 fileInput 뒤에 multiple을 걸어서 다중선택이 가능한 것을 확인한다.
- input의 accept부분에 올릴 수 있는 파일을 제약하도록 지정할 수 있다 (예를 들어 image/*할 경우에는 image파일만 올릴 수 있다)
- input의 스타일로 하면 보기좋지 않으므로 style = display : none으로 변경하고 새 버튼을 만든다.

```js
 <input 
            type="file" 
            id="fileInput" 
            multiple
            accept="image/*"
            style="display: none;"
          >
 <button class="upload-button">컴퓨터에서 선택</button>

```

<h3>2. 파일 업로드 버튼을 누르면 파일 선택창이 열리도록 하게한다.</h3>

- 새 버튼으로 적용 시키기 위해서 elements에 $uploadBtn과 $fileInput을 추가한다.
- 파일을 업로드 시키는 기능을 만들기위해서 create-feed-modal.js에서 파일 업로드 관련 이벤트 함수를 만든다.
- elements로 $uploadBtn과 $fileInput을 가져오고, 업로드 버튼을 누르면 파일 선택창이 대신 눌리도록 조작한다.
- 파일 선택이 끝났을 때 파일정보를 읽는 이벤트를 만든다.
- bindEvents 함수에 파일 업로드한 함수가 실행되도록 setUpFileUploadEvents를 추가한다.
- 파일 선택이 완료되었을 때 서버로 보내기 위해서는 change 이벤트를 걸어 추가한 파일 정보를 읽어온다.


```js
let elements = {
  $closeBtn: $modal.querySelector('.modal-close-button'),
  $backdrop: $modal.querySelector('.modal-backdrop'),
  $uploadBtn: $modal.querySelector('.upload-button'),
  $fileInput: $modal.querySelector('#fileInput'),
};

// 파일 업로드 관련 이벤트 함수
function setUpFileUploadEvents() {
  const { $uploadBtn, $fileInput } = elements;
  // 업로드 버튼을 누르면 파일선택창이 대신 눌리도록 조작
  $uploadBtn.addEventListener('click', e => $fileInput.click());
  // 파일 선택이 끝났을 때 파일정보를 읽는 이벤트
  $fileInput.addEventListener('change', e => {
    console.log(e.target.files);
    
  });
}

function bindEvents() {
  setUpModalEvents();
  setUpFileUploadEvents();
}
```
</details>

<details>
  <summary><b>ㅤ25/01/06/월: 인스타그램 초기세팅 / 피드 모달 열고 닫기 공부 </b></summary>

<h3>1. 초기 세팅 : 데이터베이스 생성</h3>

- yml로 가서 spring:datasource:url을 데이터베이스를 생성한 이름과 동일하게

<h3>2. 프로젝트 초기 실행방법</h3>

- routecontroller로 index jsp를 읽도록 만든다.

```java
@Controller
public class RouteController {

    @GetMapping("/")
    public String index() {
        return "index";
       
    }


}
```

- index jsp에는 모든 css, index.js, 각 섹션에 해당하는 components jsp들을 읽어온다.

<h3>3. 피드 생성 모달 열기</h3>

- js의 component 아래에 create-feed-modal.js를 만들고 그곳에 initCreateFeedModal 함수 생성하고 외부에 내보내야하므로 export 사용

```js
// 모달 관련 JS 함수 - 외부에 노출
function initCreateFeedModal() {
    console.log('모달관련 함수실행!')
}
export default initCreateFeedModal;
```

- index.js에 모든 태그가 렌더링되면 실행되는 것을 만든다.
- 모든 태그가 렌더링 되면 실행되는 이벤트: DOMContentLoaded

```js
import initStories from './components/stories.js';
import initCreateFeedModal from './components/create-feed-modal.js';
// 모든 태그가 렌더링되면 실행
document.addEventListener('DOMContentLoaded', () => {
  initStories(); // 스토리 관련 js
  initCreateFeedModal(); // 피드 생성 관련 js
}); 
```
- 
- create-feed-modal.js에 피드생성 모달을 전역관리

```js
let $modal = null;
$modal = document.getElementById('createPostModal')
```

- 피드 생성 모달 열기 이벤트 생성
- menu-item이라는 클래스가 다른 곳에도 존재하기 때문에 한곳에만 해당하는 클래스인 fa-square-plus를 가져와 closest로 menu-item에 접근해서 클릭이벤트 생성해서 click시에
  openModal함수가 발생하도록 코딩

```js
 document
        .querySelector('.fa-square-plus')
        .closest('.menu-item')
        .addEventListener('click', openModal);
        
```

- create-feed-modal의 js에 initCreateFeedModal 속에 openModal 함수생성

```js
const openModal = e => { 
    e.preventDefault();
    // 모달 열기
    $modal.style.display = 'flex';
  };
```

- 코드가 길어지기 때문에 함수를 분리한다.
  ->  이벤트 바인딩 관련함수 function bindEvents와 피드생성 모달관련 이벤트 함수 setUpModalEvent 생성한다.
  그리고 bindEvents에 setUpModalEvents 함수를 실행하도록 하고 initCreateFeedModal 함수에 적어놨던 것들을 모두 빼서 setUpModalEvents에 넣는다.
- 그리고 initCreateFeedModal함수에 bindEvents를 넣는다.
- 모달 관련 돔들을 저장할 객체를 만든다.
- 일단 당장의 기능을 만드는데 사용해야할 요소들을 가져온다. (필요할때마다 가져오기)
- 모달을 닫기 위해서는 x버튼을 눌렀을 때와 뒤 검은배경을 눌렀을때 닫혀야 하므로 두개의 요소 가져온다

```js
// 모달 관련 DOM들을 저장할 객체
const elements = {
    $closeBtn: $modal.querySelector('.modal-close-button'),
    $backdrop: $modal.querySelector('.modal-backdrop'),
};
```

- setUpModalEvents 함수에 필요한 요소 두개 가져온다.

```js
const { $closeBtn, $backdrop } = elements;
```

- x 버튼을 눌렀을때와 백드롭 눌렀을때 이벤트 생성

```js
	// X버튼 눌렀을 때
    $closeBtn.addEventListener('click', closeModal);

    // 백드롭 눌렀을 때
    $backdrop.addEventListener('click', closeModal);

```

- 모달 닫기 함수 만들기

```js
  const closeModal = e => {
    e.preventDefault();
    $modal.style.display = 'none';  
};

```

- 모달이 열렸을 때 스크롤하면 백드롭화면 움직이는 것 방지하기위해 openModal 과 closeModal 함수에 기능추가

openModal에

```js
 document.body.style.overflow = 'hidden';  // 배경 바디 스크롤 방지
```

closeModal에

```js
document.body.style.overflow = 'auto'; // 배경 바디 스크롤 방지 해제
```

</details>
</details>
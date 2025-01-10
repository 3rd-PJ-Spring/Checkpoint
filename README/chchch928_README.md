## ✏️ Daily Study
### [↩ Go Back Main README](https://github.com/3rd-PJ-Spring/Checkpoint?tab=readme-ov-file#%EF%B8%8F-daily-study)
<details>
  <summary><b>🐹chchch928's footprint</b></summary>
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
		<summary><b>ㅤ25/01/10/금: 인스타그램 포스트 이미지 개수만큼 캐러셀 인디케이터 생성하고 캐러셀 이동 이벤트 구현</b></summary>

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
		<summary><b>ㅤ25/01/09/목: 인스타그램 스텝 이동 버튼 바인딩 및 이미지 캐러셀 클래스 설계</b></summary>	

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
		<summary><b>ㅤ25/01/08/수: 인스타그램 이미지 파일 검증 및 모달 스텝이동하고 이동버튼 이벤트 바인딩하기</b></summary>	

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
  <summary><b>ㅤ25/01/06/월: 인스타그램 초기세팅 및 피드 모달 열고 닫기 공부 </b></summary>

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
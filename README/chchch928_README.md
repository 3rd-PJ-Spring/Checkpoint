## ✏️ Daily Study
### [↩ Go Back Main READMD](https://github.com/3rd-PJ-Spring/Checkpoint?tab=readme-ov-file#%EF%B8%8F-daily-study)
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
		<summary><b>ㅤ25/01/10/금:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/09/목:</b></summary>	
		ㅤㅤㅤ내용
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

```
            @GetMapping("/")
            public String index() {
            return "index";
            }
```

- index jsp에는 모든 css, index.js, 각 섹션에 해당하는 components jsp들을 읽어온다.

<h3>3. 피드 생성 모달 열기</h3>

- js의 component 아래에 create-feed-modal.js를 만들고 그곳에 initCreateFeedModal 함수 생성하고 외부에 내보내야하므로 export 사용

```
// 모달 관련 JS 함수 - 외부에 노출
function initCreateFeedModal() {
    console.log('모달관련 함수실행!')
}
export default initCreateFeedModal;
```

- index.js에 모든 태그가 렌더링되면 실행되는 것을 만든다.
- 모든 태그가 렌더링 되면 실행되는 이벤트: DOMContentLoaded

```
import initStories from './components/stories.js';
import initCreateFeedModal from './components/create-feed-modal.js';
// 모든 태그가 렌더링되면 실행
document.addEventListener('DOMContentLoaded', () => {
  initStories(); // 스토리 관련 js
  initCreateFeedModal(); // 피드 생성 관련 js
}); 
```

- create-feed-modal.js에 피드생성 모달을 전역관리

```
let $modal = null;
$modal = document.getElementById('createPostModal')
```

- 피드 생성 모달 열기 이벤트 생성
- menu-item이라는 클래스가 다른 곳에도 존재하기 때문에 한곳에만 해당하는 클래스인 fa-square-plus를 가져와 closest로 menu-item에 접근해서 클릭이벤트 생성해서 click시에
  openModal함수가 발생하도록 코딩

```
 document
        .querySelector('.fa-square-plus')
        .closest('.menu-item')
        .addEventListener('click', openModal);
        
```

- create-feed-modal의 js에 initCreateFeedModal 속에 openModal 함수생성

```
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

```
// 모달 관련 DOM들을 저장할 객체
const elements = {
    $closeBtn: $modal.querySelector('.modal-close-button'),
    $backdrop: $modal.querySelector('.modal-backdrop'),
};
```

- setUpModalEvents 함수에 필요한 요소 두개 가져온다.

```
const { $closeBtn, $backdrop } = elements;
```

- x 버튼을 눌렀을때와 백드롭 눌렀을때 이벤트 생성

```
	// X버튼 눌렀을 때
    $closeBtn.addEventListener('click', closeModal);

    // 백드롭 눌렀을 때
    $backdrop.addEventListener('click', closeModal);

```

- 모달 닫기 함수 만들기

```
  const closeModal = e => {
    e.preventDefault();
    $modal.style.display = 'none';  
};

```

- 모달이 열렸을 때 스크롤하면 백드롭화면 움직이는 것 방지하기위해 openModal 과 closeModal 함수에 기능추가

openModal에

```
 document.body.style.overflow = 'hidden';  // 배경 바디 스크롤 방지
```

closeModal에

```
document.body.style.overflow = 'auto'; // 배경 바디 스크롤 방지 해제
```

</details>
</details>
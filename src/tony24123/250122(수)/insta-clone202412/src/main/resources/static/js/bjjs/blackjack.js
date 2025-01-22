//Full array of possible cards
let cards = [
  {
    suit: 1,
    name: "2",
    src: "Clubs-2.png",
    value: 2,
  },
  {
    suit: 1,
    name: "3",
    src: "Clubs-3.png",
    value: 3,
  },
  {
    suit: 1,
    name: "4",
    src: "Clubs-4.png",
    value: 4,
  },
  {
    suit: 1,
    name: "5",
    src: "Clubs-5.png",
    value: 5,
  },
  {
    suit: 1,
    name: "6",
    src: "Clubs-6.png",
    value: 6,
  },
  {
    suit: 1,
    name: "7",
    src: "Clubs-7.png",
    value: 7,
  },
  {
    suit: 1,
    name: "8",
    src: "Clubs-8.png",
    value: 8,
  },
  {
    suit: 1,
    name: "9",
    src: "Clubs-9.png",
    value: 9,
  },
  {
    suit: 1,
    name: "10",
    src: "Clubs-10.png",
    value: 10,
  },
  {
    suit: 1,
    name: "ace",
    src: "Clubs-Ace.png",
    value: 11,
  },
  {
    suit: 1,
    name: "jack",
    src: "Clubs-Jack.png",
    value: 10,
  },
  {
    suit: 1,
    name: "king",
    src: "Clubs-King.png",
    value: 10,
  },
  {
    suit: 1,
    name: "queen",
    src: "Clubs-Queen.png",
    value: 10,
  },
  {
    suit: 2,
    name: "2",
    src: "Diamond-2.png",
    value: 2,
  },
  {
    suit: 2,
    name: "3",
    src: "Diamond-3.png",
    value: 3,
  },
  {
    suit: 2,
    name: "4",
    src: "Diamond-4.png",
    value: 4,
  },
  {
    suit: 2,
    name: "5",
    src: "Diamond-5.png",
    value: 5,
  },
  {
    suit: 2,
    name: "6",
    src: "Diamond-6.png",
    value: 6,
  },
  {
    suit: 2,
    name: "7",
    src: "Diamond-7.png",
    value: 7,
  },
  {
    suit: 2,
    name: "8",
    src: "Diamond-8.png",
    value: 8,
  },
  {
    suit: 2,
    name: "9",
    src: "Diamond-9.png",
    value: 9,
  },
  {
    suit: 2,
    name: "10",
    src: "Diamond-10.png",
    value: 10,
  },
  {
    suit: 2,
    name: "ace",
    src: "Diamond-Ace.png",
    value: 11,
  },
  {
    suit: 2,
    name: "jack",
    src: "Diamond-Jack.png",
    value: 10,
  },
  {
    suit: 2,
    name: "king",
    src: "Diamond-King.png",
    value: 10,
  },
  {
    suit: 2,
    name: "queen",
    src: "Diamond-Queen.png",
    value: 10,
  },
  {
    suit: 3,
    name: "2",
    src: "Hearts-2.png",
    value: 2,
  },
  {
    suit: 3,
    name: "3",
    src: "Hearts-3.png",
    value: 3,
  },
  {
    suit: 3,
    name: "4",
    src: "Hearts-4.png",
    value: 4,
  },
  {
    suit: 3,
    name: "5",
    src: "Hearts-5.png",
    value: 5,
  },
  {
    suit: 3,
    name: "6",
    src: "Hearts-6.png",
    value: 6,
  },
  {
    suit: 3,
    name: "7",
    src: "Hearts-7.png",
    value: 7,
  },
  {
    suit: 3,
    name: "8",
    src: "Hearts-8.png",
    value: 8,
  },
  {
    suit: 3,
    name: "9",
    src: "Hearts-9.png",
    value: 9,
  },
  {
    suit: 3,
    name: "10",
    src: "Hearts-10.png",
    value: 10,
  },
  {
    suit: 3,
    name: "ace",
    src: "Hearts-Ace.png",
    value: 11,
  },
  {
    suit: 3,
    name: "jack",
    src: "Hearts-Jack.png",
    value: 10,
  },
  {
    suit: 3,
    name: "king",
    src: "Hearts-King.png",
    value: 10,
  },
  {
    suit: 3,
    name: "queen",
    src: "Hearts-Queen.png",
    value: 10,
  },
  {
    suit: 4,
    name: "2",
    src: "Spades-2.png",
    value: 2,
  },
  {
    suit: 4,
    name: "3",
    src: "Spades-3.png",
    value: 3,
  },
  {
    suit: 4,
    name: "4",
    src: "Spades-4.png",
    value: 4,
  },
  {
    suit: 4,
    name: "5",
    src: "Spades-5.png",
    value: 5,
  },
  {
    suit: 4,
    name: "6",
    src: "Spades-6.png",
    value: 6,
  },
  {
    suit: 4,
    name: "7",
    src: "Spades-7.png",
    value: 7,
  },
  {
    suit: 4,
    name: "8",
    src: "Spades-8.png",
    value: 8,
  },
  {
    suit: 4,
    name: "9",
    src: "Spades-9.png",
    value: 9,
  },
  {
    suit: 4,
    name: "10",
    src: "Spades-10.png",
    value: 10,
  },
  {
    suit: 4,
    name: "ace",
    src: "Spades-Ace.png",
    value: 11,
  },
  {
    suit: 4,
    name: "jack",
    src: "Spades-Jack.png",
    value: 10,
  },
  {
    suit: 4,
    name: "king",
    src: "Spades-King.png",
    value: 10,
  },
  {
    suit: 4,
    name: "queen",
    src: "Spades-Queen.png",
    value: 10,
  },
];

let currentUserName; //현재 로그인 된 유저 아이디디
let currentUserId; //현재 로그인 된 유저
let newRandomCard;
let newCardArr = []; //게임 진행 중에 뽑힌 카드가 쌓인 배열
let alReadyCard = 0;
let bettingChip = 10;
let myCoin;
let currentCardValue = 0; //뽑힌 카드의 값
let dealerTotalSum = 0;
let playerTotalSum = 0;
let isDoubleClick = false;

let result; //게임 결과

let gameRound = 0; // 게임 회차를 추적

const $dealerCard = document.querySelector(".dealer-card");
const $playerCard = document.querySelector(".player-card");
const $bettingChip = document.querySelector(".betting-chip");
const $myCoin = document.querySelector(".mygamechip");

const $hit = document.querySelector(".hit-button");
const $double = document.querySelector(".double-button");
const $stand = document.querySelector(".stand-button");
const $split = document.querySelector(".split-button");

//모달
const $closeModalBtn = document.querySelector(".close-btn");
const $modalOverlay = document.getElementById("modalOverlay");
const $modalText = document.querySelector(".modal-text");

//hit 클릭이벤트 카드 한장 뽑기
$hit.addEventListener("click", hitClickHandler);

function hitClickHandler(e) {
  getCardOne(); //플레이어에게 카드 한장 주기

  if (playerTotalSum > 21) {
    console.log("플레이어가 21을 초과했습니다.");
    removeClickEvent();
    setTimeout(compareTotalSum, 1500); // 게임 결과를 비교하고 종료
    return; // 딜러의 카드를 추가하지 않음
  }

  //딜러차례 16이하라면 카드 한장 가져감
  if (dealerTotalSum < 17) {
    addCardDealer();
  }

  //딜러카드가 21넘으면 바로 비교후 종료
  if (dealerTotalSum > 21) {
    console.log("딜러 카드가 21을 초과했습니다.");
    removeClickEvent();
    setTimeout(compareTotalSum, 1500); // 게임 결과를 비교하고 종료
    return; // 딜러의 카드를 추가하지 않음
  }
}

//double 클릭이벤트 베팅칩 두배 증가
$double.addEventListener("click", doubleClickHandler);

//클릭이벤트 한번 실행후 이벤트 제거(다시 못누르도록)
function doubleClickHandler(e) {
  bettingChip *= 2; //현재 배팅값 두배 올리기
  chipSetting();
  getCardOne(); //플레이어카드 한장받기

  //플레이어 카드가 21 넘으면 게임종료
  if (playerTotalSum > 21) {
    console.log("플레이어가 21을 초과했습니다.");
    removeClickEvent();
    setTimeout(compareTotalSum, 1500); // 게임 결과를 비교하고 종료
    return; // 딜러의 카드를 추가하지 않음
  }

  //딜러 차례 16이하라면 한장 가져감
  if (playerTotalSum <= 21 && dealerTotalSum < 17) {
    addCardDealer();
  }
  //딜러카드가 21넘으면 바로 비교후 종료
  if (dealerTotalSum > 21) {
    console.log("딜러 카드가 21을 초과했습니다.");
    removeClickEvent();
    setTimeout(compareTotalSum, 1500); // 게임 결과를 비교하고 종료
    return; // 딜러의 카드를 추가하지 않음
  }
  $double.removeEventListener("click", doubleClickHandler);
}

//stand 클릭이벤트 (딜러의 카드 합이 16 넘을때까지 카드 추가)
$stand.addEventListener("click", standClickHandler);

function standClickHandler(e) {
  //모든버튼막기
  removeClickEvent();

  while (dealerTotalSum < 17) {
    addCardDealer();
  }
  setTimeout(compareTotalSum, 1000); // 게임 결과를 비교하고 종료
}

//랜덤카드 만들기
function RandomCard() {
  let randomCardShape = Math.floor(Math.random() * 4) + 1; //랜덤 문양

  let randomCardNum = Math.floor(Math.random() * 13) + 1; // 랜덤 숫자

  //newCardList = 랜덤문양 카드 모두 담은 배열
  let newCardList = cards.filter((card) => card.suit === randomCardShape);
  //newRandomCard = 랜덤으로 골라낸 카드
  newRandomCard = newCardList[randomCardNum - 1];

  return newRandomCard;
}

//카드 비교 함수
function compareCard() {
  if (!newCardArr.includes(newRandomCard)) {
    //배열에 새로운 랜덤카드랑 같은카드가 없을때 푸시
    console.log(newRandomCard);
    newCardArr.push(newRandomCard);
  } else {
    //랜덤카드가 이미 뽑았던 카드라면 alReadyCard의 값을 99로 리턴한다
    console.log("이미 카드가 있습니다.");
    alReadyCard = 99;
    return alReadyCard;
  }
  //카드 value값 가져오기
  currentCardValue = newRandomCard.value;
}

//플레이어 카드 한장 가져오기
function getCardOne() {
  for (i = 0; i < 1; i++) {
    RandomCard();
    compareCard();
    if (alReadyCard === 99) {
      i--;
      alReadyCard = 0;
      continue;
    }

    const $img = document.createElement("img");
    $img.src = `/images/bjimg/blackjack/${newRandomCard.src}`;
    $playerCard.appendChild($img);
  } //end for
  playerTotalSum += currentCardValue;
}

//딜러 카드 16보다 작아서 카드 주기
function addCardDealer() {
  if (dealerTotalSum <= 16) {
    for (i = 0; i < 1; i++) {
      RandomCard();
      compareCard();
      if (alReadyCard === 99) {
        i--;
        alReadyCard = 0;
        continue;
      }
      const $img = document.createElement("img");
      $img.src = `/images/bjimg/blackjack/${newRandomCard.src}`;
      $dealerCard.appendChild($img);
    }
  }
  dealerTotalSum += currentCardValue;
}

//게임초기세팅
function startTabel() {
  for (i = 0; i <= 3; i++) {
    RandomCard();
    compareCard();
    //카드를 비교했을때 기존에 뽑은 카드가 뽑혔다면 다시 뽑고 alReadyCard의 값을 0으로 되돌린다.
    if (alReadyCard === 99) {
      i--;
      alReadyCard = 0;
      continue;
    }
    //딜러랑 플레이어에게 한장씩 차례로 카드뿌리기
    if (i % 2 === 0) {
      //딜러에게 카드를 부여합니다.
      const $img = document.createElement("img");
      $img.src = `/images/bjimg/blackjack/${newRandomCard.src}`;
      //첫장은 뒷면
      if (i === 0) {
        $img.src = "/images/bjimg/blackjack/card_back.png";
      }
      $dealerCard.appendChild($img);
      dealerTotalSum += currentCardValue; //딜러 카드 총합 구하기
      //딜러 합 21 초과 즉시 게임종료
      if (dealerTotalSum > 21) {
        console.log("딜러 카드가 21을 초과했습니다.");
        removeClickEvent();
        setTimeout(compareTotalSum, 1500); // 게임 결과를 비교하고 종료
        return; // 딜러의 카드를 추가하지 않음
      }
    } else {
      //플레이어에게 카드를 부여합니다.
      const $img = document.createElement("img");
      $img.src = `/images/bjimg/blackjack/${newRandomCard.src}`;
      $playerCard.appendChild($img);
      playerTotalSum += currentCardValue; //플레이어 카드 총합 구하기
      //플레이어 카드가 21 넘으면 게임종료
      if (playerTotalSum > 21) {
        console.log("플레이어가 21을 초과했습니다.");
        removeClickEvent();
        setTimeout(compareTotalSum, 1500); // 게임 결과를 비교하고 종료
        return; // 딜러의 카드를 추가하지 않는다
      }
    }
  }
  //newCardArr는 반복 실행을 통해 4장의 카드를 뽑고 종료된다
  chipSetting(); //베팅 설정
  console.log(newCardArr);
}

// 두 플레이어 카드 총합 비교 (승부)
function compareTotalSum() {
  $dealerCard.firstElementChild.src = `/images/bjimg/blackjack/${newCardArr[0].src}`; // 뒤집어진 카드 다시 이미지 설정
  if (
    (dealerTotalSum > playerTotalSum && dealerTotalSum <= 21) ||
    playerTotalSum > 21
  ) {
    openRoundModal();
    // console.log("딜러 승");
    myCoin = myCoin - bettingChip;
    result = "Lose";    
  } else if (
    (dealerTotalSum < playerTotalSum && playerTotalSum <= 21) ||
    dealerTotalSum > 21
  ) {
    openRoundModal();
    // console.log("플레이어 승");
    myCoin = myCoin + bettingChip;
    result = "Win";
  } else {
    openRoundModal();
    // console.log("무승부");
    result = "Draw";
  }
  console.log(newCardArr);
  console.log(result);
  console.log(`현재 로그인된 유저 : ${currentUserName},${myCoin}`);
  

  //데이터베이스에 현재 보유 칩 업데이트 요청
  fetchToData();

  //데이터베이스에 전적 기록 요청
  fetchToSaveData();

  //*다음판을 위한 초기화
  setTimeout(resetGame, 1500);
}

//베팅설정
async function chipSetting() {
  // $myCoin.textContent = myCoin - bettingChip;
  const currentUserDto = await fetchUserData();
  
  console.log(currentUserDto.gameChips);
  console.log(currentUserName);

  $myCoin.textContent = currentUserDto.gameChips - bettingChip; //데이터베이스에 유저 보유칩
  $bettingChip.textContent = bettingChip;
}

//서버로부터 로그인한 유저 보유칩 개수를 불러오는 함수
async function fetchUserData() {
  //토큰 가져오기
  const token = localStorage.getItem("accessToken");
  //서버 요청시 토큰을 헤더에 포함해서 요청해야 함
  const response = await fetch("/api/user/currentUser", {
    method: "GET",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  if (!response.ok) alert("정보를 갱신하는데 실패했습니다.");
  //jsonData = 현재 로그인한 유저 이름 + 보유 게임칩
  const jsonData = await response.json();
  currentUserId = jsonData.userId; //로그인된 유저 고유아이디
  currentUserName = jsonData.username; //로그인된 유저 이름름
  myCoin = jsonData.gameChips; //로그인된 유저 칩 보유량
  // console.log(jsonData);
  return jsonData;
}

//*게임 시작
function startGame() {
  fetchUserData();
  if (gameRound < 5) {
    console.log(`현재 보유칩은 : ${myCoin}입니다.`);

    startTabel(); // 첫 번째 판 시작
    gameRound++; // 게임 회차 증가
    console.log(`${gameRound}번째판 시작`);
  } else {
    console.log(`게임 종료. 총 점수:${myCoin}`);
    // 게임 종료 처리 (예: 초기화, 종료 메시지 등)
    //모달창 실행
    removeClickEvent();

    openModal();
  }
}

//*새로운판 시작
function resetGame() {
  dealerTotalSum = 0;
  playerTotalSum = 0;
  $dealerCard.innerHTML = ""; // 딜러 카드 초기화
  $playerCard.innerHTML = ""; // 플레이어 카드 초기화
  newCardArr = []; // 카드 배열 초기화
  alReadyCard = 0; // 카드 중복 방지 초기화
  bettingChip = 10;
  result = ""; //결과 초기화

  $hit.addEventListener("click", hitClickHandler);
  $double.addEventListener("click", doubleClickHandler);
  $stand.addEventListener("click", standClickHandler);

  startGame(); // 세 번째 판까지 자동으로 시작
}

// 게임 종료 모달창
function openModal() {
  $modalOverlay.style.display = "flex";
  if (myCoin >= 530) {
    $modalText.textContent = `축하합니다. 총 보유 코인 : ${myCoin}개로 상품 획득에 성공하셨습니다!`;
  } else {
    $modalText.textContent = `총 보유 코인 : ${myCoin}개로 상품 획득에 실패하였습니다.
     재도전을 원하신다면 링크를 공유해주세요!`;
  }

  //모달 닫기 버튼 클릭 시 모달 닫기
  $closeModalBtn.addEventListener("click", () => {
    $modalOverlay.style.display = "none";
  });
  // ESC 키로 모달 닫기
  document.addEventListener("keydown", (event) => {
    if (event.key === "Escape") {
      $modalOverlay.style.display = "none";
    }
  });

  // 모달 외부 클릭 시 모달 닫기
  $modalOverlay.addEventListener("click", (event) => {
    if (event.target === $modalOverlay) {
      $modalOverlay.style.display = "none";
    }
  });
}

//라운드 종료 모달
function openRoundModal() {
  $modalOverlay.style.display = "flex";

  if (
    (dealerTotalSum > playerTotalSum && dealerTotalSum <= 21) ||
    playerTotalSum > 21
  ) {
    $modalText.textContent = `패배하셨습니다. 딜러 카드 합 : ${dealerTotalSum} > 플레이어 카드 합 : ${playerTotalSum} || 베팅코인 ${bettingChip}개를 잃었습니다.`;
  } else if (
    (dealerTotalSum < playerTotalSum && playerTotalSum <= 21) ||
    dealerTotalSum > 21
  ) {
    $modalText.textContent = `승리하셨습니다. 딜러 카드 합 : ${dealerTotalSum} < 플레이어 카드 합 : ${playerTotalSum} || 베팅코인 ${bettingChip}개를 획득합니다.`;
  } else {
    $modalText.textContent = `무승부입니다. 딜러 카드 합 : ${dealerTotalSum} = 플레이어 카드 합 : ${playerTotalSum} || 베팅코인 ${bettingChip}개를 다시 돌려받습니다.`;
  }

  //모달 닫기 버튼 클릭 시 모달 닫기
  $closeModalBtn.addEventListener("click", () => {
    $modalOverlay.style.display = "none";
  });
  // ESC 키로 모달 닫기
  document.addEventListener("keydown", (event) => {
    if (event.key === "Escape") {
      $modalOverlay.style.display = "none";
    }
  });

  // 모달 외부 클릭 시 모달 닫기
  $modalOverlay.addEventListener("click", (event) => {
    if (event.target === $modalOverlay) {
      $modalOverlay.style.display = "none";
    }
  });
}

//버튼 클릭 이벤트 제거 함수
function removeClickEvent() {
  $hit.removeEventListener("click", hitClickHandler);
  $double.removeEventListener("click", doubleClickHandler);
  $stand.removeEventListener("click", standClickHandler);
}

// 마우스의 움직임을 추적하는 함수
const $handBox = document.getElementById("handToMouse");

document.addEventListener("mousemove", function (e) {
  // 마우스 좌표 얻기
  const mouseX = e.clientX;
  const mouseY = e.clientY;

  // 이미지 박스를 마우스 위치로 이동
  $handBox.style.left = mouseX - 65 + "px";
  $handBox.style.top = mouseY - 90 + "px";
});

startGame();

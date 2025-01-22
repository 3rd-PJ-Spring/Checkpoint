async function fetchToLogin(userData) {
  const response = await fetch("/api/user/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(userData),
  });

  const data = await response.json();
  //로그인이 성공할 시 처리
  if(response.ok){

    // 브라우저 저장소에 토큰을 저장시킴
    localStorage.setItem('accessToken', data.accessToken);
    //홈화면으로 이동
    window.location.href = '/bj';
  }else {
    alert("로그인 실패!");
  }
  // document.querySelector(".bj-login-form").reset();
}

function initLogin() {
  const $form = document.querySelector(".bj-login-form");
  $form.addEventListener("submit", (e) => {
    e.preventDefault();

    const username = document.querySelector('input[name ="username"]').value;
    const password = document.querySelector('input[name ="password"]').value;

    const payload = {
      username: username,
      password: password,
    };

    //
    fetchToLogin(payload);
  });
}

document.addEventListener("DOMContentLoaded", initLogin);

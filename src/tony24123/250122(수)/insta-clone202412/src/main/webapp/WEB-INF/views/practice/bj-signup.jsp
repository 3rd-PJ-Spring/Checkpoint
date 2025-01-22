<%-- src/main/webapp/WEB-INF/views/index.jsp --%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackjack 회원가입</title>
    <link rel="stylesheet" href="/css/bjcss/reset.css" />
    <link rel="stylesheet" href="/css/bjcss/bj-signup.css" />
    <script src="/js/bjjs/blackjack-sign-up.js" defer></script>
  </head>
  <body>
    <header class="register-header">
      <h1><a href="../index.html">Blackjack</a></h1>
    </header>
    <main class="register-container">
      <section class="register-form">
        <h2>회원가입</h2>
        <form class="signup-form">
          <div class="form-group">
            <label for="username">아이디</label>
            <input
              type="text"
              id="username"
              name="username"
              placeholder="아이디를 입력하세요"
              required
            />
          </div>
          <div class="form-group">
            <label for="password">비밀번호</label>
            <input
              type="password"
              id="password"
              name="password"
              placeholder="비밀번호를 입력하세요"
              required
            />
          </div>
          <div class="form-group">
            <label for="password-confirm">비밀번호 확인</label>
            <input
              type="password"
              id="password-confirm"
              name="password-confirm"
              placeholder="비밀번호를 다시 입력하세요"
              required
            />
          </div>
          <div class="form-group">
            <label for="email">이메일</label>
            <input
              type="email"
              id="email"
              name="email"
              placeholder="이메일을 입력하세요"
              required
            />
          </div>
          <button type="submit" class="register-btn">회원가입</button>
        </form>
        <div class="login-link">
          <p>
            이미 계정이 있으신가요?
            <a href="http://localhost:8900/bj/login">로그인</a>
          </p>
        </div>
      </section>
    </main>
  </body>
</html>

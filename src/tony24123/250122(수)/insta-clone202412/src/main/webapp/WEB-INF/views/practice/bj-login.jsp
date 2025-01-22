<%-- src/main/webapp/WEB-INF/views/index.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blackjack 로그인</title>
    <link rel="stylesheet" href="/css/bjcss/reset.css">
    <link rel="stylesheet" href="/css/bjcss/bj-login.css">
    <script src="/js/bjjs/Blackjack-login.js" defer></script>
</head>
<body>
    <header class="login-header">
        <h1><a href="../index.html">Blackjack</a></h1>
    </header>
    <main class="login-container">
        <section class="login-form">
            <h2>로그인</h2>
            <form class="bj-login-form">
                <div class="form-group">
                    <label for="username">아이디</label>
                    <input type="text" id="username" name="username" placeholder="아이디를 입력하세요" required>
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required>
                </div>
                <button type="submit" class="login-btn">로그인</button>
            </form>
            <div class="register-link">
                <p>계정이 없으신가요? <a href="http://localhost:8900/bj/signUp">회원가입</a></p>
            </div>
        </section>
    </main>
</body>
</html>
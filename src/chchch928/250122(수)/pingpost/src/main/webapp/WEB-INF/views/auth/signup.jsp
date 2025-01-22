<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="css/auth/pages/signup.css">

    <script type="module" src="/js/auth/signup.js" defer></script>
</head>
<body>
<div class="signup-container">
    <div class="card">
        <div class = "image-container">
            <img src="/images/auth/pingpong.gif">
        </div>
        <h2>회원가입</h2>
        <form class = "auth-form">
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
            </div>
            <div class="form-group">
                <label for="username">별명</label>
                <input type="text" id="username" name="username" placeholder="별명을 입력하세요">
            </div>
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" id="email" name="email" placeholder="이메일을 입력하세요">
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요">
            </div>
<%--            <div class="form-group">--%>
<%--                <label for="confirm-password">비밀번호 확인</label>--%>
<%--                <input type="password" id="confirm-password" name="confirm-password" placeholder="비밀번호를 다시 입력해주세요">--%>
<%--            </div>--%>
            <button type="submit" class="btn">회원가입</button>
        </form>
        <div class="separator">이미 계정이 있습니까?</div>
        <a href="/" class="btn-link">로그인</a>
    </div>
</div>
</body>
</html>

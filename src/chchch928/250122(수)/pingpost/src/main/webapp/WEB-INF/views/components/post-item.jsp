<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="post-item">
    <h3>${post.title}</h3>
    <p>작성자: ${post.author}</p>
    <p>${post.content}</p>
    <span>작성일: ${post.createdDate}</span>
</div>
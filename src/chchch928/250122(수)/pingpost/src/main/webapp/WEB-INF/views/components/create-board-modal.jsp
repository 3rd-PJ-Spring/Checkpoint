<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class = "modal-cointainer" id ="createPostModal">

    <div class="modal-header">새 게시물 작성</div>
    <div class="modal-body">
        <form action="/createPost" method="post">
            <label for="title">제목:</label>
            <br><br>
            <input type="text" id="title" name="title" required>
            <br><br>
            <label for="content" id="context-area" >내용:</label>
            <br><br>
            <textarea id="content" name="content" rows="4" required></textarea>
            <br><br>
            <button type="submit" id ="submit-button">저장</button>


        </form>
    </div>
    <div class="modal-footer">
        <button>닫기</button>
    </div>


</div>


<script src="../../../resources/static/js/index.js" defer></script>
<script src="../../../resources/static/js/components/create-board-modal.js" defer></script>
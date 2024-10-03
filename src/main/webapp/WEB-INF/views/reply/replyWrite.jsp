<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="comment-form">
    <h3>댓글 작성하기</h3>
    <form action="/board/reply/save" method="post">
        <input type="hidden" name="boardId" value="${board.id}">
        <textarea name="content" rows="5" cols="50" placeholder="댓글을 작성하세요"></textarea>
        <br>
        <button type="submit">댓글 작성</button>
    </form>
</div>
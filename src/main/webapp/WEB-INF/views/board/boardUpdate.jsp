<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="../layout/header.jsp" %>

<main>
    <div class="board-update">
        <form action="/board/update" method="post">
            <input type="hidden" name="id" value="${board.id}">
            <div class="form-group">
                <label for="title">제목</label>
                <input class="write-title" type="text" id="title" name="title" value="${board.title}" placeholder="내용을 입력하세요" required>
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea class="write-content" id="content" name="content" rows="10" placeholder="내용을 입력하세요" required>${board.content}</textarea>
            </div>
            <br>
            <div class="actions">
                <button type="submit">수정 완료</button>
                <button type="button" onclick="location.href='/board/'">취소</button>
            </div>
        </form>
    </div>
</main>

<%@ include file="../layout/footer.jsp" %>
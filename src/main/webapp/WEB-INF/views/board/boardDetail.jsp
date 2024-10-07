<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="../layout/header.jsp" %>

<main>
    <div class="board-detail">
        <h2>${board.title}</h2>
        <div class="board-meta">
            <span>작성자: ${board.user.nickname}</span> |
            <span>작성 날짜: ${board.createdDate}</span> |
            <span>번호: ${board.id}</span>
        </div>

        <hr>

        <div class="board-content">
            ${board.content}
        </div>

        <hr>

        <br>

        <div class="actions">
            <button onclick="location.href='/board/update?id=${board.id}'">수정하기</button>
            <form action="/board/delete/${board.id}" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                <input type="hidden" name="_method" value="delete">
                <button type="submit">삭제하기</button>
            </form>
            <button onclick="location.href='/board/'">목록으로</button>
        </div>
    </div>
</main>

<%@ include file="../layout/footer.jsp" %>
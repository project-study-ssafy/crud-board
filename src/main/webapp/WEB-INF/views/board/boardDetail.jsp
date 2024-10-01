<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="header.jsp" %>

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

        <div class="comments-section">
            <h3>댓글</h3>
            <c:if test="${empty board.replies}">
                <p>아직 댓글이 없습니다.</p>
            </c:if>
            <c:forEach var="reply" items="${board.replies}">
                <div class="comment">
                    <strong>${reply.user.nickname}</strong> - ${reply.createdDate}
                    <p>${reply.content}</p>
                </div>
            </c:forEach>
        </div>

        <hr>

        <div class="comment-form">
            <h3>댓글 작성하기</h3>
            <form action="/reply/save" method="post">
                <input type="hidden" name="boardId" value="${board.id}">
                <textarea name="content" rows="5" cols="50" placeholder="댓글을 작성하세요"></textarea>
                <br>
                <button type="submit">댓글 작성</button>
            </form>
        </div>

        <br>

        <div class="actions">
            <button onclick="location.href='/board/board'">목록으로</button>
        </div>
    </div>
</main>

<%@ include file="footer.jsp" %>
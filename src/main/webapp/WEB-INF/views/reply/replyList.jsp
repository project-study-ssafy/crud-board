<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="comments-section">
    <h3>댓글</h3>
    <c:if test="${empty board.replies}">
        <p>아직 댓글이 없습니다.</p>
    </c:if>
    <c:if test="${!empty board.replies}">
        <c:forEach var="reply" items="${board.replies}">
            <div class="comment">
                <strong>${reply.user.nickname}</strong> - ${reply.createDate}
                <p>${reply.content}
                </p>
                <form action="/board/reply/delete/${reply.id}" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                    <input type="hidden" name="boardId" value="${board.id}">
                    <input type="hidden" name="replyId" value="${reply.id}">
                    <input type="hidden" name="_method" value="delete">
                    <button type="submit">삭제하기</button>
                </form>
            </div>
        </c:forEach>
    </c:if>
</div>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="../layout/header.jsp" %>
<main>
    <div class="board-detail">
        <div class="board-header">
            <span style="font-size: 25px"><strong>${board.title}</strong></span>
            <div class="actions">
                <c:if test="${loginUser.id eq board.user.id}">
                    <button onclick="location.href='/board/update?id=${board.id}'">수정하기</button>
                    <form action="/board/delete/${board.id}" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                        <input type="hidden" name="_method" value="delete">
                        <button type="submit">삭제하기</button>
                    </form>
                </c:if>
                <button onclick="location.href='/board/'">목록으로</button>
            </div>
        </div>
        <div class="board-meta">
            <span>작성자: ${board.user.nickname}</span>
            <span>작성 날짜: <fmt:formatDate value="${board.createdDate}" pattern="YYYY/MM/dd HH:mm:ss"/></span>
        </div>

        <hr>

        <div class="board-content">
            ${board.content}
        </div>

        <hr>
        <%@ include file="../reply/replyWrite.jsp" %>
        <hr>
        <%@ include file="../reply/replyList.jsp" %>
        <br>
    </div>
</main>

<%@ include file="../layout/footer.jsp" %>
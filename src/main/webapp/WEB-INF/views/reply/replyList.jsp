<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<div class="comments-section">
    <h3>댓글</h3>
    <c:if test="${empty board.replies}">
        <p>아직 댓글이 없습니다.</p>
    </c:if>
    <c:if test="${!empty board.replies}">
        <table class="comments-table">
            <thead>
            </thead>
            <tbody>
            <c:forEach var="reply" items="${board.replies}">
                <tr>
                    <td><strong>${reply.user.nickname}</strong></td>
                    <td colspan="5">${reply.content}</td>
                    <td>
                        <fmt:formatDate value="${reply.createDate}" pattern="YYYY/MM/dd HH:mm:ss"/>
                        <c:if test="${loginUser.id eq reply.user.id}">
                            <form action="/board/reply/delete/${board.id}/${reply.id}" method="post"
                                  onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                                <input type="hidden" name="_method" value="delete">
                                <button class="reply-delete" type="submit">삭제하기</button>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="layout/header.jsp" %>
<main>
    <table class="table">
        <tr><td colspan="4"><h2>게시판</h2></td></tr>
        <tr class="header">
            <td class="num">번호</td>
            <td class="title">제목</td>
            <td>작성자</td>
            <td>작성날짜</td>
        </tr>
        <form action="/board/asc" method="get">
            <button type="submit">ASC 순서</button>
        </form>
        <form action="/board/desc" method="get">
            <button type="submit">DESC 순서</button>
        </form>
        <c:forEach var="board" items="${boards}">
            <tr>
                    <td>${board.id}</td>
                    <td>
                        <a href="detail?id=${board.id}">
                            ${board.title}
                        </a>
                    </td>
                    <td>${board.user.nickname}</td>
                    <td>${board.createdDate}</td>
            </tr>
            <c:if test="${empty board}" >
                <tr>
                    <td colspan="4">
                        null
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <br>
    <table>
        <tr>
            <td><button onclick="location.href='/board/write'">글쓰기</button></td>
        </tr>
    </table>
</main>

<%@ include file="layout/footer.jsp" %>
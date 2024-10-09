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

        <c:forEach var="board" items="${boards.content}">
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
        </c:forEach>

        <c:if test="${empty boards.content}">
            <tr>
                <td colspan="4">게시물이 없습니다.</td>
            </tr>
        </c:if>
    </table>

    <ul>
        <c:choose>
            <c:when test="${boards.hasPrevious()}">
                <li><a href="?page=${boards.number}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li>Previous</li> <!-- Previous 링크 비활성화 -->
            </c:otherwise>
        </c:choose>

        <c:set var="begin" value="${boards.number - 2}"/>
        <c:if test="${begin < 1}">
            <c:set var="begin" value="1"/>
        </c:if>

        <c:set var="end" value="${begin + 4}"/>
        <c:if test="${end > boards.totalPages}">
            <c:set var="end" value="${boards.totalPages}"/>
        </c:if>

        <c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i == boards.number + 1}">
                    <li><a href="#">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="?page=${i}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${boards.hasNext()}">
                <li><a href="?page=${boards.number + 2}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li>Next</li> <!-- Next 링크 비활성화 -->
            </c:otherwise>
        </c:choose>
    </ul>

    <br>
    <table>
        <tr>
            <td><button onclick="location.href='/board/write'">글쓰기</button></td>
        </tr>
    </table>
</main>

<%@ include file="layout/footer.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="../layout/header.jsp" %>

<main>
    <div class="board-update">
        <h2>게시물 수정</h2>

        <form action="/board/updateBoard" method="post">
            <input type="hidden" name="id" value="${board.id}">
            <table class="table">
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" value="${board.title}" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea name="content" rows="10" required>${board.content}</textarea>
                    </td>
                </tr>
            </table>
            <br>
            <div class="actions">
                <button type="submit">수정 완료</button>
                <button type="button" onclick="location.href='/board/'">취소</button>
            </div>
        </form>
    </div>
</main>

<%@ include file="../layout/footer.jsp" %>
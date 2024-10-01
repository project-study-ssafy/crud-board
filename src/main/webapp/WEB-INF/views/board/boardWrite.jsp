<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="header.jsp" %>

<main>
    <div class="board-write">
        <h2>게시물 작성</h2>

        <form action="/board/save" method="post">
            <table class="table">
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" placeholder="제목을 입력하세요" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea name="content" rows="10" placeholder="내용을 입력하세요" required></textarea>
                    </td>
                </tr>
            </table>
            <br>
            <div class="actions">
                <button type="submit">작성 완료</button>
                <button type="button" onclick="location.href='/board/'">취소</button>
            </div>
        </form>
    </div>
</main>

<%@ include file="footer.jsp" %>
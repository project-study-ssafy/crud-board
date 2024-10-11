<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="../layout/header.jsp" %>

<main>
    <div class="board-write">
        <form action="/board/write" method="post">
            <table class="table">
                <tr>
                    <th>제목</th>
                    <td><input class="write-title" type="text" name="title" placeholder="제목을 입력하세요" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea class="write-content" name="content" rows="10" placeholder="내용을 입력하세요" required></textarea>
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

<%@ include file="../layout/footer.jsp" %>
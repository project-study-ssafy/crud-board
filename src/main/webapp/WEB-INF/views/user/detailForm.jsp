<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="detail-main">
    <div class="detail-container">
        <fieldset class="detail-fieldset">
            <div class="form-group">
                <label for="loginId">ID</label>
                <input
                        type="text"
                        class="form-control"
                        id="loginId"
                        placeholder="Enter id"
                        name="loginId"
                        value="${user.loginId}"
                        readonly
                />
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input
                        type="password"
                        class="form-control"
                        id="password"
                        placeholder="Enter password"
                        name="password"
                        value="${user.password}"
                        readonly
                />
            </div>
            <div class="form-group">
                <label for="nickname">별명</label>
                <input
                        type="text"
                        class="form-control"
                        id="nickname"
                        placeholder="Enter nickname"
                        name="nickname"
                        value="${user.nickname}"
                        readonly
                />
            </div>

            <a
                    href="${pageContext.request.contextPath}/user/update/${user.id}"
                    type="button"
                    class="btn update-btn"
            >수정하기</a
            >
            <form
                    action="${pageContext.request.contextPath}/user/delete/${user.id}"
                    method="POST"
                    style="display: inline"
                    onsubmit="return confirm('정말로 삭제하시겠습니까?');"
            >
                <button type="submit" class="delete-btn">탈퇴하기</button>
            </form>
        </fieldset>
    </div>
</div>

<%@ include file="../layout/footer.jsp"%>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>
<div class="login-main">
    <div class="login-container">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <fieldset class="login-fieldset">
                <div class="form-group">
                    <label for="loginId">ID</label>
                    <input
                            type="text"
                            name="loginId"
                            class="form-control"
                            id="loginId"
                            placeholder="아이디를 입력해주세요."
                            value="${loginDto.loginId}"
                    />
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input
                            type="password"
                            name="password"
                            class="form-control"
                            id="password"
                            placeholder="비밀번호를 입력해주세요."
                    />
                </div>

                <% if (request.getSession().getAttribute("loginError") != null) {%>
                <strong class="error-message"
                >로그인에 실패하였습니다. 아이디 또는 비밀번호를 확인해
                    주세요.</strong
                > <c:remove var="loginError" scope="session"/>
                <% } %>

                <c:remove var="loginError" scope="session"/>
                <br/>

                <button class="login-btn">로그인</button>
                <div>
                    <a href="${pageContext.request.contextPath}/user/sign-up" class="btn sign-up-btn">회원가입</a>
                </div>
            </fieldset>
        </form>
    </div>
</div>

<%@ include file="../layout/footer.jsp"%>
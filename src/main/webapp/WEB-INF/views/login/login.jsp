<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="loginId">ID:</label>
            <input type="text" name="loginId" class="form-control" id="loginId"
                   placeholder="Enter loginId" value="${loginDto.loginId}">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" id="password"
                   placeholder="Enter password">
        </div>

        <% if (request.getSession().getAttribute("loginError") != null) {%>
        <strong class="error-message">로그인에 실패하였습니다. 아이디 또는 비밀번호를 확인해 주세요.</strong>
        <c:remove var="loginError" scope="session"/>
        <% } %>
        <br/>

        <button class="btn btn-primary">로그인</button>
    </form>
</div>

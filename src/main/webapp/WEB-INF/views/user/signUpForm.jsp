<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>회원가입</title>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/user/sign-up" method="post">
        <div class="form-group">
            <label for="loginId">Id:</label>
            <input type="text" class="form-control" id="loginId" placeholder="Enter id"
                   name="loginId">
            <spring:hasBindErrors name="signUpDto">
                <c:if test="${errors.hasFieldErrors('loginId') }">
                    <strong class="error-message">${errors.getFieldError( 'loginId' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>

            <spring:hasBindErrors name="signUpDto">
                <c:if test="${errors.hasGlobalErrors()}">
                    <c:forEach var="error" items="${errors.globalErrors}">
                        <strong class="error-message">${error.defaultMessage}</strong>
                    </c:forEach>
                </c:if>
            </spring:hasBindErrors>

        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password"
                   name="password">
            <spring:hasBindErrors name="signUpDto">
                <c:if test="${errors.hasFieldErrors('password') }">
                    <strong class="error-message">${errors.getFieldError( 'password' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <div class="form-group">
            <label for="nickname">Nickname:</label>
            <input type="text" class="form-control" id="nickname" placeholder="Enter nickname"
                   name="nickname">
            <spring:hasBindErrors name="signUpDto">
                <c:if test="${errors.hasFieldErrors('nickname') }">
                    <strong class="error-message">${errors.getFieldError( 'nickname' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <button class="btn btn-primary">회원가입완료</button>

    </form>

</div>
</body>
</html>

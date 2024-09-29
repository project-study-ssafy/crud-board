<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
    <form action="${pageContext.request.contextPath}/user/update/${loginUser.id}" method="post">
        <div class="form-group">
            <label for="loginId">Id:</label>
            <input type="text" class="form-control" id="loginId" placeholder="Enter id" name="loginId" value="${user.loginId}" readonly>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" value="${user.password}">
            <spring:hasBindErrors name="userUpdateDto">
                <c:if test="${errors.hasFieldErrors('password') }">
                    <strong class="error-message">${errors.getFieldError( 'password' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <div class="form-group">
            <label for="nickname">Nickname:</label>
            <input type="text" class="form-control" id="nickname" placeholder="Enter nickname" name="nickname" value="${user.nickname}">
            <spring:hasBindErrors name="userUpdateDto">
                <c:if test="${errors.hasFieldErrors('nickname') }">
                    <strong class="error-message">${errors.getFieldError( 'nickname' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <button class="btn btn-primary">정보 수정 완료</button>
    </form>
</div>


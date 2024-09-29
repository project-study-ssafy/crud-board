<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
    <div class="form-group">
        <label for="loginId">Id:</label>
        <input type="text" class="form-control" id="loginId" placeholder="Enter id" name="loginId"
               value="${user.loginId}" readonly>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password" placeholder="Enter password"
               name="password" value="${user.password}" readonly>
    </div>
    <div class="form-group">
        <label for="nickname">Nickname:</label>
        <input type="text" class="form-control" id="nickname" placeholder="Enter nickname"
               name="nickname" value="${user.nickname}" readonly>
    </div>

    <a href="${pageContext.request.contextPath}/user/update/${user.id}" type="button">회원 정보 수정하기</a>
    <a href="${pageContext.request.contextPath}/user/delete/${user.id}" type="button">회원 삭제하기</a>

</div>


<%@ page import="com.board.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<% User loginUser = (User) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div class="home">
            <a href="/board/">홈</a>
        </div>
        <div class="container">
            <nav>
                <ul class="navul">
                    <% if(loginUser == null) { %>
                    <li><a href="/board/login">로그인</a></li>
                    <li><a href="/board/user/sign-up">회원가입</a></li>
                    <% } else {%>
                    <li>현재 로그인 정보 : <%= loginUser.getNickname() %> </li>
                    <% } %>
                </ul>
            </nav>
        </div>
    </header>
    <hr/>
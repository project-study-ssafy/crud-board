<%@ page import="com.board.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<% User loginUser = (User) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
        }
        header, footer {
            text-align: center;
            margin-bottom: 20px;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            display: inline;
            margin-right: 15px;
        }
        .table {
            width: 100%;
            border-collapse: collapse;
        }
        .table td, .table th {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .table .header {
            background-color: #f2f2f2;
        }
        .table .body {
            cursor: pointer;
        }
        .table .expanded-content {
            display: none;
        }
        .table .expanded-content.active {
            display: table-row;
        }
        button {
            margin-right: 10px;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <header>
        <div class="container">
            <h1>게시판</h1>
            <nav>
                <ul>
                    <% if(loginUser == null) { %>
                    <li><a href="/board/">홈</a></li>
                    <li><a href="/board/login">로그인</a></li>
                    <li><a href="/board/user/sign-up">회원가입</a></li>
                    <% } else {%>
                    <li><a href="/board/">홈</a></li>
                    <li>현재 로그인 정보 : <%= loginUser.getNickname() %> </li>
                    <% } %>
                </ul>
            </nav>
        </div>
    </header>
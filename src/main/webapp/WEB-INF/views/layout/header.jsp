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
            max-width: 1200px;
            margin-top: auto;
            margin-bottom: auto;
        }
        .home {
            margin-left: 100px;
            margin-top: auto;
            margin-bottom: auto;
        }
        header {
            top: 0;
            left: 0;
            right: 0;
            text-align: center;
            padding-bottom: 10px;
            display:flex;
            justify-content: space-between;
        }
        footer {
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            text-align: center;
            background-color: darkblue;
            padding-top: 25px;
            padding-bottom: 10px;
            color: #ffffff;
        }
        .navul {
            list-style-type: none;
            padding: 0;
        }
        .navul li {
            display: inline;
            margin-right: 15px;
        }
        button {
            background-color: darkblue;
            color: #ffffff;
            border-radius: 4px;
            margin-right: 10px;
            padding: 10px 15px;
        }
        .footer-container {
            max-width: 100%;
            list-style-type: none;
            display: flex;
            justify-content: space-between;

        }

        .footer-container li {

        }
        main {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .table {
            width: 80%;
            margin: 20px 0;
            border-collapse: collapse;
            border: 3px solid #ccc;
            border-radius: 8px;
            overflow: hidden;
        }
        .table .header {
                background-color: #E6E6FA;
        }
        .table td, .table th {
            border-bottom: 1px solid #ccc;
            border-left: none;
            border-right: none;
            padding: 8px;
            text-align: center;
        }
        .table th:first-child, .table td:first-child {
            border-left: 2px solid #ccc;
        }

        .table th:last-child, .table td:last-child {
            border-right: 2px solid #ccc;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            display: inline-flex;
            margin: 0 5px;
        }
        a {
            color: inherit;
            text-decoration: none;
            font-weight: 800;
        }
        a:visited {
            color: inherit;
        }
        .button-container {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
            width: 80%;
        }
        .button-container form {
            flex: 1; /* 폼이 동일한 비율로 공간을 차지하게 함 */
            text-align: center;
        }
        .search-bar {
            margin-top: 10px;
        }
        .search-bar input {
            border-radius: 4px;
            color: #000000;
            background-color: #E6E6FA;
            padding-top: 12px;
            padding-bottom: 10px;
            padding-right: 60px
        }
        .search-bar input::placeholder {
            color: #000000;
        }
        .board-write {
            background-color: #E6E6FA;
            margin-top: 15px;
            padding-bottom: 20px;
            width: 80%;
        }
        .write-title, .write-content{
            border-radius: 6px;
            width:calc(100% - 50px);
            padding: 10px;
        }
        .write-title {
            height: 20px;
        }
        .write-content {
            height: 50%;
        }
        .actions {
            display: flex; /* flexbox 사용 */
            justify-content: flex-end; /* 오른쪽 정렬 */
            margin-top: 20px; /* 버튼과 테이블 사이 여백 */
        }
    </style>
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
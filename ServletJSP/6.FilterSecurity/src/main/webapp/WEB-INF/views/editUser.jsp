<%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 11.04.2018
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script>  <%@include file="/js/validate.js"%> </script>
    <style> <%@include file="/css/style.css"%> </style>
    <title>Title</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

<form action="${pageContext.servletContext.contextPath}/edit"  method="post">
    <div class = "edit">
        <div class = "name-field">
            <label> Имя: </label>
            <input type="text" value="${editUser.name}" name ="name"/>
        </div>
        <div class = "login-field">
            <label> Логин: </label>
            <input type="text" value="${editUser.login}" name="login"/>
        </div>
        <div class = "email-field">
            <label> E-mail: </label>
            <input type="text" value="${editUser.email}" name="email"/>
        </div>
        <div class = "role-field">
            <label> Роль: </label>
            <select name="role">
                <option value="user">User</option>
                <option value="Admin">Admin</option>
            </select>
        </div>
        <div class="password-field">
            <label> New password:</label>
            <input type="password" name="password"/></div>
        <div class="button-edit">
            <input name="editButton"  type="submit" value="edit user" onclick="return validate(this.form)"/>
        </div>
    </div>
        <input type="hidden" name="oldName" value="${editUser.name}">
        <input type="hidden" name="oldLogin" value="${editUser.login}">
        <input type="hidden" name="oldEmail" value="${editUser.email}">
        <input type="hidden" name="oldPassword" value="${editUser.password}">

    </form>
    <div class="button-back">
        <form action="${pageContext.servletContext.contextPath}/" method="get">
            <input type="submit" value="back">
        </form>
    </div>
</body>
</html>

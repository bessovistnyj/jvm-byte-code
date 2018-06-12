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
    <%--<style src="<c:url value="/css/style.css"/>"> </style>--%>
        <script>  <%@include file="/js/validate.js"%> </script>
        <style> <%@include file="/css/style.css"%> </style>
        <title>Title</title>

</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/editRole"  method="post">
        <div class ="edit">
            <div class = "name-field">
                <label> Имя: </label>
                <input type="text" value="${editUser.name}" name ="name"/> </div>
            <div class = "login-field">
                <label> Логин: </label>
                <input type="text" value="${editUser.login}" name="login"/></div>
            <div class = "email-field">
                <label> E-mail: </label>
                <input type="text" value="${editUser.email}" name="email"/> </div>
            <div class = "role-field">
                <label> Роль: </label>
                <select name="role">
                    <option value="user">User</option>
                    <option value="Admin">Admin</option>
                </select>

            </div>
            <input type="submit" value="edit">
        </div>
    </form>
    <br>
    <div class="button-back">
        <form action="${pageContext.servletContext.contextPath}/" method="get">
            <input type="submit" value="back">
        </form>
    </div>

</body>
</html>

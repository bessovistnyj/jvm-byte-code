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
    <title>Title</title>
    <style>
        .edit {
            background-color: #F0FFFF;
            float:left;
        }
        .name-field{
            clear:both;
            text-align:right;
        }
        .login-field {
            clear:both;
            text-align:right;
        }
        .email-field {
            clear:both;
            text-align:right;
        }
        .role-field {
            clear:both;
            text-align:right;
        }
        .password-field {
            clear:both;
            text-align:right;
        }

        label {
            float:left;
        }
        .button-back {
            clear: left;
        }

    </style>

    <script>
        function validate(f) {
            var dis = true;
            if (f.name.value == "") {
                f.name.style.backgroundColor ="#8B0000";
                dis = false;
            }
            if (f.login.value == "") {
                f.name.style.backgroundColor ="#8B0000";
                dis = false;
            }
            if (f.email.value == "") {
                f.name.style.backgroundColor ="#8B0000";
                dis = false;
            }

            if (f.password.value == "") {
                dis = false;
            }

            if (!dis) {
                alert("Заполните все поля");
            }
            return dis;
        }
    </script>

</head>
<body>
<form action="${pageContext.servletContext.contextPath}/edit"  method="post">
    <div class = "edit">
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

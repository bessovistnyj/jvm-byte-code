<%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 10.04.2018
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        .create {
            background-color: #F0FFFF;
            float:left;
            /*position: absolute;*/
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
        .check-password {
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
    <script src="<c:url value="/js/validate.js"/>"> </script>
    <script>  </script>
</head>
</body>
<div>
    <form action="${pageContext.servletContext.contextPath}/create" method="post">
        <div class = "create">
            <div class = "name-field">
                <label> Имя: </label>
                <input type="text" name ="name"/>
            </div>
            <div class = "login-field">
                <label> Логин: </label>
                <input type="text" name="login"/>
            </div>
            <div class = "email-field">
                <label> E-mail: </label>
                <input type="text" name="email"/>
            </div>
            <div class = "role-field">
                <label> Роль: </label>
                <select name="role">
                    <option value="user">User</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>

            <div class="password-field">
                <label> Password:</label>
                <input type="password" name="password"/>
            </div>
            <div class="check-password">
                <label> Password again:</label>
                <input type="password" name="passwordCheck"/>
            </div>
            <div class="button-create">
                <input name="createButton"  type="submit" value="create user" onclick="return validate(this.form)"/>
            </div>
        </div>
    </form>
    <div class="button-back">
        <form Name ="back" action="${pageContext.servletContext.contextPath}/" method="get">
            <input type="submit" value="<-back">
        </form>
    </div>
</div>
</body>
</html>

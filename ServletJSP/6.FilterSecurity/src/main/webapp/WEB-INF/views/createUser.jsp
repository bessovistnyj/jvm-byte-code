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
    <script>
        <%@include file="/js/validate.js"%>
        <%@include file="/js/countryJson.js"%>
        $(document).ready(
            function () {
                if (${user != null && user.country != null}) {
                    findcountry()
                }
            }
        );

    </script>
    <style> <%@include file="/css/style.css"%> </style>
    <title>Title</title>
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
            <div class = "country"> <input type='text' name='country' id="country"></div>
            <div class = "city"> <input type='text' name='city' id="city"></div>

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

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
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/editRole"  method="post">
        <div>Name: <input type="text" value="<%=request.getParameter("name")%>"name="name"></div>
        <div>Login: <input type="text" value="<%=request.getParameter("login")%>"name="login"></div>
        <div><input type="hidden" value="<%=request.getParameter("email")%>"name="email"></div>
        <input type="hidden" name="userRole" value="${userRole}">
        <br>Role: <select name ="role">
        <option value = "admin">Admin</option>
        <option value = "superAdmin">S. Admin</option>
        <option value = "User">user</option>
        <input type="submit" value="edit">
    </select>
    </form>
    <br>
    <form action="${pageContext.servletContext.contextPath}/" method="get">
        <input type="submit" value="back">
        <input type="hidden" name="userRole" value="${userRole}">
    </form>

</body>
</html>

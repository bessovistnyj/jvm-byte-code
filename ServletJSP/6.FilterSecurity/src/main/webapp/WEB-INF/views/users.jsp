<%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 10.04.2018
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <style>
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            background: white;
            max-width: 70%;
            width: 70%;
            border-collapse: collapse;
            text-align: left;
        }
        th {
            font-weight: normal;
            color: #039;
            border-bottom: 2px solid #6678b1;
            padding: 10px 8px;
        }
        td {
            color: #669;
            padding: 9px 8px;
            transition: .3s linear;
        }
        tr:hover td {
            color: #6699ff;
        }
    </style>

    <title>Title</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>


<table border="1" cellpadding="1" cellspacing="1" style= "width:500px">
    <tbody>
        <tr>
            <td>User name</td>
            <td>Login</td>
            <td>email</td>
            <td>create date</td>
            <td>Country</td>
            <td>City</td>
            <td>role</td>
            <%--<td></td>--%>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.createDate}"></c:out></td>
            <td><c:out value="${user.country}"></c:out></td>
            <td><c:out value="${user.city}"></c:out></td>
            <td><c:out value="${user.role.roleName}"></c:out></td>
           <td><form action="${pageContext.servletContext.contextPath}/edit" method="get">
                    <input type="submit" value="edit">
                    <input type="hidden" name = "userId" value="${user.id}"></form>
            </td>
            <td> <c:if test="${userRole == 'superAdmin'}">
                <form action="${pageContext.servletContext.contextPath}/editRole" method="get">
                    <input type="submit" value="edit role">
                    <input type="hidden" name = "userId" value="${user.id}"></form> </c:if>
            </td>
        </tr>
        </c:forEach>
        <tr>
    </tbody>
</table>
<br>
    <form action="${pageContext.servletContext.contextPath}/create" method="get">
        <input type="submit" value="Add new user">
    </form>
</body>
</html>

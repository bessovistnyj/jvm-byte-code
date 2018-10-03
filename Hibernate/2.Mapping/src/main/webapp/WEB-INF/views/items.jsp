<%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 04.07.2018
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
<div class="mainDiv">
    <table id="usersHeader">
        <caption>Items</caption>
        <thead>
        <tr>
            <th scope="col">Car</th>
            <th scope="col">Transmission</th>
            <th scope="col">Engine</th>
            <th scope="col">GearBox</th>
            <%--<th scope="col">Foto</th>--%>
            <th scope="col">Sold</th>
            <th scope="col">DateOfCreate</th>
            <th></th>
            <th></th>
        </tr>
        <tbody id="bodyTable">
        <c:set var="userID"><c:out value="${userID}" /></c:set>
        <c:forEach items="${advertisements}" var="advertisement">
            <tr>
                <td><c:out value="${advertisement.description}"></c:out></td>
                <td><c:out value="${advertisement.car.transmission.transName}"></c:out></td>
                <td><c:out value="${advertisement.car.engine.engineName}"></c:out></td>
                <td><c:out value="${advertisement.car.gearBox.gearBoxName}"></c:out></td>
                <td><c:out value="${advertisement.closed}"></c:out></td>
                <td><c:out value="${advertisement.date}"></c:out></td>
                <td><form action="${pageContext.servletContext.contextPath}/editItem" method="get">
                    <input type="hidden" name="id" value=<c:out value="${advertisement.itemId}"></c:out>>
                    <input type="submit" class="sub" name="Edit" value="Просмотр"></form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </thead>
    </table>
    <div>
        <form action="${pageContext.servletContext.contextPath}/createItem" method="get">
            <input type="submit" value="Добавить новую заявку">
        </form>
    </div>


</div>
</body>

</html>
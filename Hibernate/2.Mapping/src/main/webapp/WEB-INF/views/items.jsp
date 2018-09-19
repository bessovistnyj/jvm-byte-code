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

    <script>
        $(document).ready(function () {
            $.ajax({
                url: "ItemsJson",
                type: "get",
                success: function (data) {
                    var newRows = "";
                    $.each(data, function (i, value) {
                        newRows = "<tr><td>" + value.car + "</td>" +
                            "<td>" + value.transmission + "</td>" +
                            "<td>" + value.engine + "</td>" +
                            "<td>" + value.gearBox + "</td>" +
                            "<td>" + value.car.images + "</td>" +
                            "<td>" + value.closed + "</td>" +
                            "<td>" + value.date + "</td></tr>";
                        $("#bodyTable").append(newRows);
                        newRows = "";
                    });
                }
            });
        });
        </script>
</head>
<body>
<div class="mainDiv">
    <%--<div>--%>
    <%--<div>--%>
    <%--<p>Search:</p>--%>
    <%--</div>--%>
    <%--<div>--%>
    <%--<input id="searchRow" type="text" placeholder="Search..">--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<br><br>--%>
    <table id="usersHeader">
        <caption>Items</caption>
        <thead>
        <tr>
            <th scope="col">Car</th>
            <th scope="col">Transmission</th>
            <th scope="col">Engine</th>
            <th scope="col">GearBox</th>
            <th scope="col">Foto</th>
            <th scope="col">Sold</th>
            <th scope="col">DateOfCreate</th>
            <th>editButon</th>
            <th></th>
        </tr>
        <tbody id="bodyTable">

        </tbody>
        </thead>
    </table>
    <div>
        <form action="${pageContext.servletContext.contextPath}/create" method="get">
            <input type="submit" value="Add new user">
        </form>
    </div>


</div>
</body>

</html>
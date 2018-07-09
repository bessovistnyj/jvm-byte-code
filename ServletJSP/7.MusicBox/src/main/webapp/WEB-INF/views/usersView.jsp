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
    <title>Users</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <%--<style> <%@include file="/css/style.css"%> </style>--%>
    <script>
        $(document).ready(function (){
            $.ajax ({
                url: "userJson",
                type: "get",
                success: function (data) {
                    var button = "<td> <form action=\"${pageContext.servletContext.contextPath}/edit\" method=\"get\">\n" +
                        "                <input type=\"submit\" value=\"edit\">\n" +
                        "                <input type=\"hidden\" name = \"userId\" value=\"${user.id}\"></form></td>"
                    var usersTable = $("#users");
                    var newRows = "";
                    $.each(data, function (i, value) {
                        newRows += "<tr><td>" + value.name +"</td>"+
                            "<td>" + value.login + "</td>" +
                            "<td>" + value.password + "</td>" +
                            "<td>" + value.role.user_role + "</td>" +
                            "<td>" + value.address.address_name + "</td>" +
                            "<td></td>"+
                            button+
                            "</tr>";
                    });
                    $("#firstTr").after(newRows);
                }
            });
        });
    </script>

    <script>
        $(document).ready(function(){
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#users tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>

</head>
<body>
<div class="mainDiv">
    <div>
        <div>
            <p>Search:</p>
        </div>
        <div>
            <input id="myInput" type="text" placeholder="Search..">
        </div>
        <br><br>
        <div>
            <form action="${pageContext.servletContext.contextPath}/create" method="get">
                <input type="submit" value="Add new user">
            </form>
        </div>
    </div>
    <table id="users">
        <caption>Users</caption>
        <thead>
        <tr id="firstTr">
            <th scope="col">Name</th>
            <th scope="col">Login</th>
            <th scope="col">password</th>
            <th scope="col">role</th>
            <th scope="col">Address</th>
            <th scope="col">MusicType</th>
            <th></th>
        </tr>
        </thead>
    </table>



</div>
</body>

</html>
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
    <style> <%@include file="/css/style.css"%> </style>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script>
        function selectCountry() {
            $.ajax({
                url:'./countryJson',
                method: "GET",
                complete: function(data) {
                    var users = data.responceJson
                    var previous_value = document.getElementById("select_country").value;
                    $(document.getElementById("select_country")).children().remove();
                    $(document.getElementById("select_country")).append("<option selected></option>");
                    for (var i = 0; i < data.length; i++) {
                        $(document.getElementById("select_country")).append("<option>" + data[i].country + "</option>");
                    }
                    document.getElementById("select_country").value = previous_value;
                }
            });
        }

    </script>
    <script> <%@include file="/js/validate.js"%>  </script>

    <script type="text/javascript">
        $(document).ready(function() {selectCountry()})
    </script>

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
            <%--<div>--%>
                <%--<label> Country</label>--%>
                <%--<input type="text" name="country" id ="country" />--%>
            <%--</div>--%>
            <div class="form-group col-md-6">
                <label>Country</label>
                <%--<select id="select_country" class="form-control" name="country" onfocus="selectCountry()" onchange="selectCity()"></select>--%>
                <select id="select_country" class="form-control" name="country" onfocus="selectCountry()"></select>
            </div>

            <%--<div class = "country-field">--%>
                <%--<label for="country">Country</label>--%>
                <%--<select class="selectCountry" name="country" id ="country" required></select>--%>
            <%--</div>--%>
            <%--<div class = "city-field">--%>
                <%--<label for="city">City</label>--%>
                <%--<select class="selectCity" name="city" id ="city" required></select>--%>
            <%--</div>--%>

            <%--<div class="col-md-5">--%>
                <%--+                            <label for="country">Country</label>--%>
                <%--+                            <select class="selectpicker" name="country" id="country" required></select>--%>
                <%--+                        </div>--%>
            <%--+                        <div class="col-md-4">--%>
            <%--+                            <label for="city">City</label>--%>
            <%--+                            <select class="selectpicker" name="city" id="city" required></select>--%>
            <%--+                        </div>--%>


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

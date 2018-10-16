$(document).ready(function (){
    $.ajax ({
        url: "userServlet",
        type: "get",
        success: function (items) {
            createTable(items.userId);
        }
    });
});


function createTable (userId){
    var nameQuery = {
        "namePart": "allTable"
    }

    $.ajax ({
        url: "jsonServlet",
        type: "get",
        data: nameQuery,
        success: function (items) {
            var usersTable = $("#usersBody");
            var newRows = "";
            $.each(items, function (i, value) {
                if (userId == value.userId) {
                    var button = "<td> <form action=\"${pageContext.servletContext.contextPath}/editItem\" method=\"get\">\n" +
                    "<input type=\"submit\" value=\"Edit\">\n" +
                    "<input type=\"hidden\" name = \"itemId\" value="+value.itemId+"> </form></td>"
                }
                newRows += "<tr><td>" + value.description +"</td>"+
                    "<td>" + value.transName+ "</td>" +
                    "<td>" + value.engineName+ "</td>" +
                    "<td>" + value.gearBoxName + "</td>";
                if (value.closed == true) {
                  newRows += "<td> <input type='checkbox' checked onclick=\"return false;\"> </td>"
                } else {
                        newRows += "<td> <input type='checkbox' onclick=\"return false;\"> </td>"
                }
                newRows += "<td>" + value.date + "</td>";
                newRows += button+
                    "</tr>";
                $("#bodyTable").append(newRows);
                newRows = "";

            });
        }
    });
}


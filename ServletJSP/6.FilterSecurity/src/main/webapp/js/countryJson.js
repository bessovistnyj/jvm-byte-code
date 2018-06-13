function findcountry() {
    $.ajax(

    )

    // $.ajax('./countryJson=' + document.getElementsByName("country")[0].value, {
    //     method: 'get',
    //     complete: function (data) {
    //         var result;
    //         //result = "<td id=\"cityselect\" ><select class=\"form-control\" name=\"city\">";
    //         result = "<td id=\"cityselect\" ><select class=\"country\" name=\"city\">";
    //         result += "<option value=\"\" selected disabled hidden>Choose city</option>";
    //         var countries = JSON.parse(data.responseText);
    //         for (var i = 0; i != cities.length; ++i) {
    //             if (countries[i].country != "${user.country}") {
    //                 result += "<option  value=\"" + cities[i].city + "\" >" + cities[i].city + "</option>";
    //             }
    //             // if (cities[i].city == "${user.city}") {
    //             //     result += "<option value=\"" + cities[i].city + "\" selected>" + cities[i].city + "</option>";
    //             // }
    //         }
    //         result += "<option";
    //         if ("${user.country}" == "Other") {
    //             result += " value=\"Other\" selected";
    //         }
    //         result += ">Other</option>";
    //         result += "</select></td>";
    //         console.log(result);
    //         document.getElementById("countrySelect").innerHTML = result;
    //     }
    // })
}
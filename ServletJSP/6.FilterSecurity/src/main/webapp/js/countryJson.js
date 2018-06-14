function selectCountry() {
    $.ajax({
            url:'../countryJson',
            method: "GET",
            complete: function(data) {
                var countries = JSON.parse(data.responseText);
                var previous_value = document.getElementById("select_country").value;
                $(document.getElementById("select_country")).children().remove();
                $(document.getElementById("select_country")).append("<option selected></option>");
                for (var i = 0; i < countries.length; i++) {
                    $(document.getElementById("select_country")).append("<option>" + countries[i].country + "</option>");
                }
                document.getElementById("select_country").value = previous_value;
            }
    });
}
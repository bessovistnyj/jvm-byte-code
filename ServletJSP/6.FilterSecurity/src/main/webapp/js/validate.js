function validate(f) {
    var dis = true;
    if (f.name.values[0] == "") {
        f.name.style.backgroundColor ="#8B0000";
        dis = false;
    }
    if (f.login.value == "") {
        f.name.style.backgroundColor ="#8B0000";
        dis = false;
    }
    if (f.email.value == "") {
        f.name.style.backgroundColor ="#8B0000";
        dis = false;
    }

    if (f.password.value != "" && f.passwordCheck.value != "") {
        if (f.password.value != f.passwordCheck.value) {
            f.name.style.backgroundColor ="#8B0000";
            dis = false;
        }
    } else {
        dis = false;
    }
    if (!dis) {
        alert("Error");
    }
    return dis;
}

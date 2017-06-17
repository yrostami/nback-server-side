
function submit() {
    var flag = true;

    alert("hii");
    var usernameVlidationErrorObj = document.getElementById("usernameValidationErrorMessage");
    var passwordVlidationErrorObj = document.getElementById("passwordValidationErrorMessage");
    var usernameObj = document.getElementById("username");
    var passwordObj = document.getElementById("password");

    usernameVlidationErrorObj.innerHTML="";
    passwordVlidationErrorObj.innerHTML="";

    usernameObj.className = usernameObj.className.replace(" error", "");
    passwordObj.className = passwordObj.className.replace(" error", "");

    var username = usernameObj.value;
    var password =  passwordObj.value;

    if (isEmpty(username)){
        usernameVlidationErrorObj.innerHTML = "&rsaquo; نام کاربری نباید خالی باشد.</br>";
        usernameObj.className = usernameObj.className + " error";
        flag = false;
    }
     
    if (isEmpty(password)) {
        passwordVlidationErrorObj.innerHTML = "&rsaquo; گذرواژه نباید خالی باشد.</br>";
        passwordObj.className = passwordObj.className + " error";
        flag = false;
    }

    if (flag)
        return true;
    else return false;
};

function isEmpty(str) {
    return (!str || 0 === str.length || str.replace(/\s/g,"") == "");
}
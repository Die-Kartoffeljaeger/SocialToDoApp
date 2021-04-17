function validateForm() {
    if (document.forms["registerForm"]["password"] === document.forms["registerForm"]["confirmPassword"]) {
        document.getElementById("mismatchError").style.display = "none";
        //Create a new user with that stuff
        return true;
    }
    else {
        document.getElementById("mismatchError").innerHTML =
            "Passwords do not match!";
        return false;
    }
}
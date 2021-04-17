function checkPassword(passedPassword, confirmPassword) {
    if (passedPassword === confirmPassword) {
        //Create a new user with that stuff
    }
    else {
        document.getElementById("mismatchError").value =
            "Passwords do not match!";
    }
}
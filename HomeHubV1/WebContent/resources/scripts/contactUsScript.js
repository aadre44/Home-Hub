function switchDiv(div){
    switch(div){
        case "login":
            var loginDiv = document.getElementById("login");
            var signUpDiv = document.getElementById("signUp");
            loginDiv.classList.remove("hide");
            signUpDiv.classList.add("hide");
            break;
        case "signUp":
            var loginDiv = document.getElementById("login");
            var signUpDiv = document.getElementById("signUp");
            loginDiv.classList.add("hide");
            signUpDiv.classList.remove("hide");
            break;
        default:
            break;
    }
}
    
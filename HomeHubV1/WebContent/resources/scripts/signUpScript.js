
var users = [];
var admin ={
    username: "username",
    email: "email",
    password: "password"
};
users.push(admin);

function verifyLogin(username, password){

    var user = users.find(user => user.username == username);
    if(user != null && user.password == password) return true;
    return false;
}
function verifyUsername(username){
    var re = new RegExp(/^[a-zA-Z0-9_.-]*$[a-zA-Z_.-]*$/g);
    if(re.test(username)){
        console.log("valid user");
        return true;
    }
    var outputBox = document.getElementById("signUpOutput");
    outputBox.innerHTML += "username not formated correctly <br>";
    console.log("invalid user");
    return false;
    //make sure email or user is of correct syntax

    //make sure email or user is not taken

    // if not send message user or email is not valid
}
function verifyEmail(email){
    var re = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
    if(re.test(email)){
        console.log("valid email");
        return true;
    }
    var outputBox = document.getElementById("signUpOutput");
    outputBox.innerHTML += "Email not formated correctly <br>";
    console.log("invalid email");
    return false;
    //make sure email or user is of correct syntax

    //make sure email or user is not taken

    // if not send message user or email is not valid
}
function verifyPasswords(password, password2){
    var re = new RegExp(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/);
    if(re.test(password)){
        if(password == password2){
            console.log("valid passwords");
            return true;
        }
        else{
            var outputBox = document.getElementById("signUpOutput");
            outputBox.innerHTML += "passwords are not equal <br>";
            console.log("passwords no matchy");
            return false
        }
    }
    var outputBox = document.getElementById("signUpOutput");
    outputBox.innerHTML += "Password not formated correctly <br>";
    console.log("invalid passwords");
    return false;
    
    //make sure passwords are of correct syntax
    //maek sure passwords are equal
    //if not set validPassword to false and send message passwords dont match

}
function login(){

    var username = document.getElementById("usernameL").value;
    var password = document.getElementById("passwordL").value;
    if(username == null || password == null) return false;
    if(verifyLogin(username, password)){
        // send them to dash with user info set
        console.log("login successful");
        location.replace("dash.html");
        return true;
    }
    //send a popup that says login was incorrect
    var outputBox = document.getElementById("loginOutput");
    outputBox.innerHTML = "";
    outputBox.innerHTML += "Login Failed";
    console.log("login failed");
    return false;
}

function signUp(){

    var user = document.getElementById("usernameS").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("passwordS").value;
    var password2 = document.getElementById("password2").value;
    if(checkSignUpDetails()){
        var newUser = {
            username: user,
            email: email,
            password: password
        }
    users.push(newUser);
    alert("Sign Up successful");
    location.replace("loginRegister.html");
    return true;
    }
    
    // send them to dash with user info set
    return false;

}
function checkSignUpDetails(){
    var user = document.getElementById("usernameS").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("passwordS").value;
    var password2 = document.getElementById("password2").value;
    
    var validUserIcon = document.getElementById("usernameIcon");
    var validEmailIcon = document.getElementById("emailIcon");
    var validPasswordIcon = document.getElementById("passwordIcon");

    if(verifyUsername(user)){
      //  validUserIcon.classList.add("valid");
    }
    else{
      //  validUserIcon.classList.add("inValid");
        return false;
    } 
    if(verifyEmail(email)){
      //  validEmailIcon.classList.add("valid");
    }
    else{
      //  validEmailIcon.classList.add("inValid");
        return false;
    } 
    if(verifyPasswords(password, password2)){
      //  validPasswordIcon.classList.add("valid");
    }
    else{
      //  validPasswordIcon.classList.add("inValid");
        return false;
    } 
    return true;

}
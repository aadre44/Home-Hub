<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<header>
    <script src = "${pageContext.request.contextPath}/resources/scripts/loginScript.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/loginStyle.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/2e8c91b170.js" crossorigin="anonymous"></script>
    <title>Login</title>
</header>
<body  style ="background-color: #555858;">
    <!--HEADER--> 
    <nav class = "navbar navbar-expand-lg navbar-light ">Home Hub
        <div class="collapse navbar-collapse">
            <ul class = "navbar-nav ml-auto">
                <li class = "nav-item">
                    <a href="home" class = "nav-link">Home</a>
                </li>
                <li class = "nav-item">
                    <a href="login" class = "nav-link">Login</a>
                </li>
          		<li class = "nav-item">
                    <a href="contactUs" class = "nav-link">Contact Us</a>
                </li>
                <li class = "nav-item">
                	<a href="faq" class = "nav-link">Help</a>
                </li>
            </ul>
        </div>
    </nav>
    <!--BODY-->
    
    
    <div class="container mainContent justify-content-center align-items-center ">
        <div class="row justify-content-space-between"> 
            <div class="col loginContainer">
                <div class="row">
                    <div class="col " >
                        <div class="ul" id = "loginMenu"Style = "display: flex; flex-direction: row; justify-content: space-evenly;">
                            <div class="li" id="loginTab" onclick="switchDiv('login')"><a href="#" onclick="switchDiv('login')">Login</a></div>
                            <div class="li"id="signUpTab" onclick="switchDiv('signUp')"><a href="#" onclick="switchDiv('signUp')">Sign Up</a></div>
                        </div>
                    </div>
                </div>
                <div class = "" id="login">
                    <h1>Login</h1>
                    <form action="validateLogin" method = "POST" style = " display: flex; flex-direction: column;">
                        <div class = "inputDiv"><input type="text" placeholder="Username" id = "usernameL" name="username"></div>
                        <div class = "inputDiv"><input type="password" placeholder="Password" id = "passwordL" name="password"></div>
                        <br>
                        <input type="submit" value ="Login" >
                        
                    </form>
                    <P id = "loginOutput"></P>
                        
                </div>


                <div class = "hide" id="signUp">
                        <h1>Sign Up</h1>
                        <form action="validateSignUp" method = "POST" style = " display: felx; flex-direction: column;">
                            <div class = "inputDiv"><input type="text" placeholder="Username" id = "usernameS" name="username"> </div>
                            <div class = "inputDiv"><input type ="text" placeholder="Email" id = "email" name="email"></div>
                            <div class = "inputDiv"><input type="password" placeholder="Password" id = "passwordS" name="password"></div>
                            <div class = "inputDiv"><input type="password" placeholder="Re-Enter Password" id = "password2"name="password2"></div>
                            <br>
                            <input type="submit" value ="Sign Up" >
                            
                        </form>
                        <P id = "signUpOutput"></P>
             
                        
                </div>

            </div>
        </div>
    </div>
    <!---->
    

</body>
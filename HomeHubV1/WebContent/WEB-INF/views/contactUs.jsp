<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Contact Us</title>
	<script src = "${pageContext.request.contextPath}/resources/scripts/contactUsScript.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/contactUsStyle.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/2e8c91b170.js" crossorigin="anonymous"></script>
</head>
<body  style ="background-color: #555858;">
    <!--HEADER--> 
    <nav class = "navbar navbar-expand-lg navbar-light">Home Hub
        <div class="collapse navbar-collapse">
            <ul class = "navbar-nav ml-auto">
                <li class = "nav-item">
                    <a href="home" class = "nav-link">Home</a>
                </li>
                <c:if test ="${user != null}">
					<li class = "nav-item">
                        <a href="dash" class = "nav-link">Dash</a>
                    </li>
				</c:if>
				<c:if test ="${user == null}">
					<li class = "nav-item">
                    	<a href="login" class = "nav-link">Login</a>
                	</li>
				</c:if>
             
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
    
    
    <div class="container">
        <div class="row " id="mainContainer"> 
            <div class="col-md-7" >
                <div id ="formCol">
                    <h3>Just Say Hi!</h1>
                    <h5>How can we help?</h3>
                    <form action="sendMessage" method = "POST">
                        <div >
                            <div class = "inputDiv">
                                <input type="text" placeholder="First Name"name = "firstName">
                            </div>
                            <div class = "inputDiv">
                                <input type="text" placeholder="Last Name" name = "lastName">
                            </div>
                        </div>
                        <div>
                            <div class = "inputDiv"><input type="text"placeholder="Email"name = "email"> </div>
                            <div class = "inputDiv"><input type="text"placeholder="Phone" name = "phone"></div>
                        </div>
                        <div>
                            <div class = "inputDiv" style="display: flex; flex-direction: column;">
                                <label for="">Message</label>
                                <textarea rows = "5" cols = "50" placeholder="Message" name = "message">
                                    
                                </textarea>
                            </div>
                        </div>
                        
                        
                        <input type="submit">
                    </form>
                </div>
                
            </div>
            <div class="col-md-5" id ="messageCol">
                <div>
                    <h3>Lets Keep In Touch!</h3>
                    <p>Well get back to you as soon as we can!</p>
                </div>
            </div>
        </div>
    </div>
    <!---->
    

</body>
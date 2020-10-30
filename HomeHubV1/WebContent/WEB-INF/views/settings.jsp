<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<header> 
    <script defer src="${pageContext.request.contextPath}/resources/scripts/settingsScript.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/settingsStyle.css">
	
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<title>Settings</title>
	<script defer>

	</script>

</header>
<body>
    <head>
        <nav class = "navbar navbar-expand-lg navbar-light" style = "background: transparent;">
            Home Hub
            <div class="collapse navbar-collapse">
                <ul class = "navbar-nav ml-auto">
                	<li class = "nav-item">
                    	<a href="home" class = "nav-link">Home</a>
                	</li>
                    <li class = "nav-item">
                        <a href="dash" class = "nav-link">Dash</a>
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
    </head>
    <div class="wrapper">
        <div class="mainContainer container">
            <div class="section">
                <div class="row"id="profileHeader">
                    <div class="col ">
                        <img id="profilePic" src="${pageContext.request.contextPath}/resources/pics/profilePic.png" alt="">
                    </div>
                    <div class="col" id="profileInfo">
                        <h2>Name: <strong>${user.firstName} &nbsp; ${user.lastName} </strong></h2> 
                        <h3>Owner</h3>
                    </div>
                </div>
            </div>
            <div class="section" id ="generalInfo">
                <hr>
                <h1 class = "title">General Info <a id= "changeInfoBtn" href="#"  style="font-size: 20px;">edit</a></h2>
                <div class="row section">
                    <div class="col-md-4">
                        <p><strong>Name:</strong> ${user.firstName} &nbsp; ${user.lastName}</p>
                        <p><strong>Username:</strong> ${user.username} </p>
                        <p><strong>Email:</strong> ${user.email}</p>
                        <p><strong>Password:</strong> ${user.password} </p>
                    </div>
                    <div class="col-md-4 " id="homes">
                        <div id = "homeTitle">
                        <h2>Homes<a id="addHomeBtn" href="#">+</a> <a id="removeHomeBtn" href="#" >-</a></h2> 
                        </div>
                        <ul id="homesList">
                            
                            <c:forEach items = "${user.homes}" var="home">
                            	<li id="home${home.id}" onclick="selectHome('${home.id}')">${home.name}
                            		 <form action="setHome" method = "POST" id = "form${home.id}" style="display:none;">
                                        <input type="number" value = "${home.id}" name = "setHomeId">
                                    </form>
                            	</li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col-md-4 "id = "homesDisplay">
                        <h6>Devices</h6>
                        <ul id = "deviceList">
                                <c:forEach items = "${deviceList}" var="device">
                                    <li onclick="select(this) "id="${device.id}">
                                    	<p class = "deviceName">${device.name}</p> <span class="deleteButton" onclick="deleteDevice('${device.id}')">&times;</span>
                                    	<form id = "form${device.id}" action="deleteDevice" method = "POST" style="display: none;">
                                        	<input type="number" name="id" value ="${device.id}">
                                    	</form>
                                    
                                    </li>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class ="hide" id="removeHome">
                    <form action="" onsubmit="removeHome()" id = "removeHomeForm">
                        <label for="">id:</label><input type="text" id= "removeHomeId">
                        <input type="submit" onclick="hide('removeHome')" value=" remove Home">
                    </form>
                    <button onclick="hide('removeHome'); removeHome()">Cancel</button>
                </div>
                <div class ="hide" id="addHome">
                    <form action="addHome" method = "POST">
                        <label for="">Address:</label><input type="text" name ="address">
                        <label for="">City:</label><input type="text" name ="city">
                        <label for="">State:</label><input type="text" name ="state">
                        <label for="">Zipcode:</label><input type="text" name ="zipcode">
                        <label for="">Name:</label><input type="text" name ="name">
                        <input type="submit" onclick="hide(this.parent.parent)" value="Add Home">
                    </form>
                    <button onclick="hide('addHome')">Cancel</button>
                </div>
                
            </div>
            
        </div>
    </div>


    <!-- The Modal -->
    <div id="modal" class="modal">

        <!-- Modal content -->
        <div class=" modalContent"id="addHomeModalContent">
            <span class="close"onclick="closeModal()">&times;</span>
            <p>Some text in the Device Modal..</p>
            <form id="addHomeForm" action="addHome" method = "POST">
                <label for="">Address:</label><input type="text" name ="address">
                <label for="">City:</label><input type="text" name ="city">
                <label for="">State:</label><input type="text" name ="state">
                <label for="">Zipcode:</label><input type="text" name ="zipcode">
                <label for="">Name:</label><input type="text" name ="name">
                <br>
                <input type="submit" onclick="" value="Add Home">
            </form>
        </div>
        <div class=" modalContent"id="removeHomeModalContent">
            <span class="close"onclick="closeModal()">&times;</span>
            <p>Some text in the Device Modal..</p>
            <form action="removeHome" method = "POST">
                <label for="">Name:</label><input type="text" name ="name">
                <br>
                <input type="submit" onclick="hide(this.parent.parent)" value="remove Home">
            </form>
        </div>
        <div class =" modalContent"id="infoModalContent">
            <span class="close" onclick="closeModal()">&times;</span>
            <form action="changeSettings" method = "POST">
                <h3>Change Password</h3>
                <H4>Password</H4>
                <label for="">Password:</label><input type="password" name ="password">
                <label for="">re-enter:</label><input type="password" name ="password2">
                <H4>Info</H4>
                <label for="">Username:</label><input type="text" name ="username">
                <label for="">First Name:</label><input type="text" name ="firstName">
                <label for="">Last Name:</label><input type="text" name ="lastName">
                <label for="">Email:</label><input type="text" name ="email">
                <br>
                <input type="submit" value="change">
            </form>
        </div>
    </div>

</body>
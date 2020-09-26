<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<header> 
    <!--  <script src="<c:url value="${pageContext.request.contextPath}/resources/scripts/settingsScript.js"/>"></script>-->
    <script defer src="${pageContext.request.contextPath}/resources/scripts/settingsScript.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/settingsStyle.css">
	
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</header>
<body>
    <head>
        <nav class = "navbar navbar-expand-lg navbar-light bg-light">
            My Task Site
            <div class="collapse navbar-collapse">
                <ul class = "navbar-nav ml-auto">
                    <li class = "nav-item">
                        <a href="home.html" class = "nav-link">Home</a>
                    </li>
                    <li class = "nav-item">
                        <a href="login.html" class = "nav-link">Login</a>
                    </li>
                    <li class = "nav-item">
                        <a href="signUp.html" class = "nav-link">Sign up</a>
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
                        <img id="profilePic" src="" alt="">
                    </div>
                    <div class="col" id="profileInfo">
                        <h2>name: ${user.firstName}___ ${user.lastName}"</h2> 
                        <h5>Guest</h5>
                    </div>
                </div>
            </div>
            <div class="section" id ="generalInfo">
                <hr>
                <h1 class = "title">General Info <a href="#"onclick="toggleEditDiv(), show('changeInfo')" style="font-size: 20px;">edit</a></h2>
                <div class="row section">
                    <div class="col-md-4">
                        <p>name: ${user.firstName} $nbsp; ${user.lastName}</p>
                        <p>username: ${user.username} </p>
                        <p>email: ${user.email}</p>
                        <p>password: ${user.password} </p>
                    </div>
                    <div class="col-md-4 " id="homes">
                        <div id = "homeTitle">
                        <h2>Homes<a href="#"onclick = "showAddHomeDiv()">+</a> <a href="#" onclick = "removeHome()">-</a></h2> 
                        </div>
                        <ul id="homesList">
                            
                            <c:forEach items = "${user.homes}" var="home">
                            	<li>${home.name}</li>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="col-md-4 "id = "homesDisplay">
                        <ul id = "deviceList">
                         
                               <h5>Devices</h5>
                            <c:forEach items = "${deviceList}" var="device">
                            	<li onclick="select(this)" id="${device.id}">${device.name} <a href="#"onclick="deleteDevice(this)">delete</a></li>
                            </c:forEach>
                            <!--     
                            <li onclick="select(this) ">Device1 <a href="#"onclick="deleteDevice(this.parentElement)">delete</a></li>
                            <li onclick="select(this)">Device1</li>
                            <li onclick="select(this)">Device1</li>
                            -->
                        </ul>
                    </div>
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
                <div class = "hide" id = "detailsDisplay">
                    <div class="" id="changeInfo">
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
                            <input type="submit" value="change">
                        </form>
                        <button onclick="toggleDiv('changeInfo'); toggleEditDiv()"> cancel</button>
                    </div>
                </div>
            </div>
            <div class="section hide">
                <hr>
                <h1 class = "title">Settings</h2>
                home Owner <br>
                address<br>
                utility username<br>
                utility password<br>
                residents<br>
                access type of home<br>

            </div>
        </div>
    </div>
</body>
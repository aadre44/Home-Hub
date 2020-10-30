<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
	<script defer
		src="${pageContext.request.contextPath}/resources/scripts/dashScript.js"></script>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/styles/dashStyle.css">

	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

	<script src="https://kit.fontawesome.com/2e8c91b170.js"
		crossorigin="anonymous"></script>
	<title>Dashboard</title>
</head>
<body style="background-color: #202020 !important;">
	<header>
		<nav class="navbar navbar-expand-lg navbar-light">
			Home Hub
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ml-auto">
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
	</header>
	<div class="wrapper" id="wrapper">
		<!--Side Bar-->
	
	
		<div class="container justify-content-center align-items-center"
			id="mainContentContainer">
			<!-- Page Content-->
			<div class="row " id="mainContentRow ">
				<div class="col " id="mainContentCol">
	
					<div class="container cardGrid">
	
						<div class="row">
							<div class="col">
								<c:if test="${home.rooms.isEmpty()}">
									<p>No Rooms in this Home!</p>
								</c:if>
								<ul id="roomList">
									
									<c:forEach items="${home.rooms}" var="room">
										<li><button class="tabButton" id="${room.id}" onclick="openRoom(${room.id})">${room.name}</button></li>
									</c:forEach>
	
	
								</ul>
							</div>
	
							<div class="col-md-1">
								<button class="addButton" id="addRoomBtn">+</button>
							</div>
						</div>
	
	
						<div class="sectionTitle">
							<h2>Devices</h2>
							<button class="addDevice addButton" id="addDeviceBtn">+</button>
						</div>
	
						<div class="row cardGrid sectionContent" id="deviceGrid">
	
	
	
							<c:forEach items="${home.rooms}" var="room">
								<!--  	<p>${home.rooms[0].devices}</p>-->
								<c:forEach items="${room.devices}" var="device">
	
									<c:if test="${device.type.equals('Light')}">
										<div class="col-md-3 card room${room.id}">
											<div class="device lightDevice">
												<div class="deviceTitle">
													<h2>${device.name}</h2>
													<p>light device</p>
												</div>
												<div class="deviceTools">
													<a><i class="fas fa-ellipsis-h addButton"
														onclick="openDeviceSettings(${device.id}, 'light')"></i></a>
												</div>
	
												<!-- Active Button //slide button -->
												<div class="slideButton deviceBtn">
													<label for="slideThree">Active</label><input type="checkbox"
														value="None" id="slideThree" name="check" checked />
												</div>
												<!-- Active Button //slide button -->
												<!-- Active Button //slide button -->
												<div class="sliderContainer deviceBtn">
													<label for="slideThree">Brightness</label> <input
														type="range" min="1" max="100" value="50" id="myRange"
														class="slider" />
												</div>
												<!-- Active Button //slide button -->
	
											</div>
										</div>
									</c:if>
	
	
									<c:if test="${device.type.equals('Default')}">
										<div class="col-md-3 card room${room.id}">
											<div class="device lightDevice">
												<div class="deviceTitle">
													<h2>${device.name}</h2>
													<p>default device</p>
												</div>
												<div class="deviceTools">
													<a><i class="fas fa-ellipsis-h addButton"
														onclick="openDeviceSettings('${device.id}', 'default')"></i></a>
												</div>
	
												<!-- Active Button //slide button -->
												<div class="slideButton deviceBtn">
													<label for="slideThree">Active</label><input type="checkbox"
														value="None" id="slideThree" name="check" checked />
												</div>
												<!-- Active Button //slide button -->
												<!-- Active Button //slide button -->
	
											</div>
										</div>
									</c:if>
	
								</c:forEach>
							</c:forEach>
						</div>
	
	
	
					</div>
	
	
					<div class="sectionTitle">
						<h2>General Info</h2>
						<button class="addDevice addButton">+</button>
					</div>
					<div class="row justify-content-between">
						<div class="col-md-8 card2">
							<div class="weather" id="card1">
								<h2 id="place"></h2>
								<img src="" alt="" id="weatherPic">
								<h3 id="description"></h3>
								<h3 id="temp"></h3>
							</div>
						</div>
						<div class="col card2 " id="pic2">
							<div class="visualBoard"></div>
						</div>
					</div>
				</div>
	
			</div>
	
		</div>
	
	<!-- End main content div-->
	
	
	
	
	<!--PANEL COL-->
	<div class="maxH " id="panelCol">
		<div class="profileHeader" id="profileHeader">
	
			<div class="" id="profileInfo">
				<div id="profileText">
					<h6 class="profileName">${user.firstName} &nbsp; ${user.lastName}</h6>
					<p class="profileTitle">Owner</p>
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/resources/pics/profilePic.png" alt="" id="profilePic"
						onclick="togglePanel()">
				</div>
	
			</div>
			<div class="" id="settingsButton" style:"display:flex; justify-content: space-evenly;">
				<a href="settings"><i class="fas fa-cog"></i></a>
				<a href="logout" method = "post">logout</i></a>
			</div>
			<!--<hr style = "border: 1px solid white; margin: 0px; padding:0px;">-->
	
		</div>
	
		<div class=" panelContent " id="panelContent">
			<div class="panelMenu">
				<div class="panelMenuTab" onclick="switchToPanelTab('settings')">Settings</div>
				<div class="panelMenuTab" onclick="switchToPanelTab('dash')">Dash</div>
				<div class="panelMenuTab" onclick="switchToPanelTab('device')">Device</div>
			</div>
			<div class="cardGrid2 scroll " id="dash">
				<div class="cardLong "></div>
				<div class="cardLong "></div>
				<div class="cardLong "></div>
			</div>
			<div class="settings hide " id="settings">
				<div class="ts">
					<div class="tsInfo">
						<h2>Name:</h2>
						<p>${user.firstName}&nbsp;${user.lastName}</p>
					</div>
					<form class="tsForm hide" action="">
						<input type="password" value="" placeholder="Password"> <input
							type="password" value="" placeholder="re-enter">
					</form>
				</div>
				<div class="ts">
					<div class="tsInfo">
						<h2>Username:</h2>
						<p>${user.username}</p>
					</div>
					<form class="tsForm hide" action="">
						<input type="password" value="" placeholder="Password"> <input
							type="password" value="" placeholder="re-enter">
					</form>
				</div>
				<div class="ts">
					<div class="tsInfo">
						<h2>Email:</h2>
						<p>${user.email}</p>
					</div>
					<form class="tsForm hide" action="">
						<input type="password" value="" placeholder="Password"> <input
							type="password" value="" placeholder="re-enter">
					</form>
				</div>
				<div class="ts">
					<div class="tsInfo">
						<h2>Password:</h2>
						<p>${user.password}</p>
					</div>
					<form class="tsForm hide" action="">
						<input type="password" value="" placeholder="Password"> <input
							type="password" value="" placeholder="re-enter">
					</form>
				</div>
			</div>
			<div class="lightSettings hide" id="lightSettings">
				<div class="mainControls">
					<!-- Active Button //slide button -->
					<div class="slideButton">
						<label for="slideThree">Active</label><input type="checkbox" style="margin-top: 30px;"
							value="None" id="slideThree" name="check" checked />
					</div>
					<!-- Active Button //slide button -->
					<!-- Active Button //slide button -->
					<div class="sliderContainer">
						<label for="slideThree">Brightness</label> <input type="range"
							min="1" max="100" value="50" id="myRange" class="slider" />
					</div>
					<!-- Active Button //slide button -->
				</div>
				<hr>
				<div class="colorChanger">
	
					<div class="colorCircle" id="colorCircle">
						<div class=" circleText">
							<p id="redText">red:</p>
							<p id="greenText">green:</p>
							<p id="blueText">blue:</p>
							<p id="colorTagText">Tag:</p>
						</div>
	
					</div>
					<!-- Active Button //slide button -->
					<div class="sliderContainer">
						<label for="slideThree">red</label> <input type="range" min="0"
							max="255" value="50" id="redSlider" class="slider"
							onchange="updateSlider('red');" />
					</div>
					<!-- Active Button //slide button -->
					<!-- Active Button //slide button -->
					<div class="sliderContainer">
						<label for="slideThree">green</label> <input type="range" min="0"
							max="255" value="50" id="greenSlider" class="slider"
							onchange="updateSlider('green');" />
					</div>
					<!-- Active Button //slide button -->
					<!-- Active Button //slide button -->
					<div class="sliderContainer">
						<label for="slideThree">blue</label> <input type="range" min="0"
							max="255" value="50" id="blueSlider" class="slider"
							onchange="updateSlider('blue');" />
					</div>
					<!-- Active Button //slide button -->
					<button onclick="saveColor()">Save</button>
				</div>
				<hr>
				<div class="colorGrid">
					<h2>Saved Colors</h2>
					<div class="" id="savedColors">
						<c:forEach items = "" var = "colors">
							<div class="colorCircle" onclick="selectColor(this)"></div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="lightSettings hide" id="defaultSettings">
				<div class="mainControls">
					<!-- Active Button //slide button -->
					<div class="slideButton">
						<label for="slideThree">Active</label><input type="checkbox"
							style="margin-top: 30px;" value="None" id="slideThree" name="check" checked />
					</div>
				</div>
				<hr>
			</div>
			<div class="tempSettings hide">
				<div class="row currentTempDisplay">
					<div class="col"></div>
				</div>
				<div class="row tempControl">
					<div class="col"></div>
					<div class="col"></div>
					<div class="col"></div>
				</div>
				<div class="row fanControl">
					<div class="col"></div>
					<div class="col"></div>
					<div class="col"></div>
				</div>
			</div>
	
		</div>
	</div>
	</div>
	<!--END PANEL COL-->
	</div>
	
	
	<!-- The Modal -->
	<div id="modal" class="modal">
	
		<!-- Modal content -->
		<div class=" modalContent" id="deviceModalContent">
			<span class="close" onclick="closeModal()">&times;</span>
			<p>Enter in some info and we can make that Device for ya!</p>
			<form action="addDevice" method="POST">
				<label>Device Name:</label><input type="text" name="name"> 
				<label>Model:</label><input type="text" name="model"> 
				<label>Type:</label> 
				<select name="type">
					<option value="default">Default</option>
					<option value="Light">Light</option>
				</select> 
			 	<label>Room:</label>
				<select name="room">
					<c:forEach items="${home.rooms}" var="room">
						<option value="${room.name}">${room.name}</option>
					</c:forEach>
				</select> 
				<input type="number" style = "display: none;" value="${user.homeId}" name = "homeId">
				<br>
				<input type="submit" onclick="addDevice(), closeModal()"value="Add Device">
			</form>
		</div>
		<div class=" modalContent" id="roomModalContent">
			<span class="close" onclick="closeModal()">&times;</span>
			<p>Enter in some info and we can make that Room for ya!</p>
			<form action="addRoom" method="POST">
				<label for="">Room Name:</label><input type="text" name="name">
				<br> <input type="submit" onclick="addRoom(), closeModal()"
					value="Add Room">
			</form>
		</div>
	</div>
	
	
	
	
	<!-- Template for DefaultDeivce-->
	<template id="defaultDeviceTemplate">
		<div class="col-md-3 card">
			<div class="device defualtDevice" id="">
				<div class="deviceTitle">
					<h2>Device Name</h2>
					<p>default device</p>
				</div>
				<div class="deviceTools">
					<a><i class="fas fa-ellipsis-h addButton"
						onclick="openDeviceSettings()"></i></a>
				</div>
				<!-- Active Button //slide button -->
				<div class="slideButton deviceBtn">
					<label for="slideThree">Active</label><input type="checkbox"
						value="None" id="slideThree" name="check" checked />
				</div>
				<!-- Active Button //slide button -->
			</div>
		</div>
	</template>
	<!-- Template for LightDeivce-->
	<template id="lightDeviceTemplate">
		<div class="col-md-3 card">
			<div class="device lightDevice" id="">
				<div class="deviceTitle">
					<h2>Main Light</h2>
					<p>light device</p>
				</div>
				<div class="deviceTools">
					<a><i class="fas fa-ellipsis-h addButton"
						onclick="openDeviceSettings()"></i></a>
				</div>
				<!-- Active Button //slide button -->
				<div class="slideButton deviceBtn">
					<label for="slideThree">Active</label><input type="checkbox"
						value="None" id="slideThree" name="check" checked />
				</div>
				<!-- Active Button //slide button -->
				<!-- Active Button //slide button -->
				<div class="sliderContainer deviceBtn">
					<label for="slideThree">Brightness</label> <input type="range"
						min="1" max="100" value="50" id="myRange" class="slider" />
				</div>
				<!-- Active Button //slide button -->
			</div>
		</div>
	</template>
	<!-- Template for TempDEVICE-->
	<template id="tempDeviceTemplate">
		<div class="col-md-3 card">
			<div class="device tempDevice" id="">
				<div class="deviceTitle">
					<h2>Device Temp</h2>
					<p>Temp device</p>
				</div>
				<div class="deviceTools">
					<a><i class="fas fa-ellipsis-h addButton"
						onclick="openDeviceSettings()"></i></a>
				</div>
				<!-- Active Button //slide button -->
				<div class="slideButton deviceBtn">
					<label for="slideThree">Active</label><input type="checkbox"
						value="None" id="slideThree" name="check" checked />
				</div>
				<!-- Active Button //slide button -->
			</div>
		</div>
	</template>
</body>
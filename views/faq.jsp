<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>FAQ</title>
	<script src = "${pageContext.request.contextPath}/resources/scripts/faqScript.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/faqStyle.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/2e8c91b170.js" crossorigin="anonymous"></script>
	
</head>
<!DOCTYPE html>
<body  style ="background-color: #555858;">
    <!--HEADER--> 
    <nav class = "navbar navbar-expand-lg navbar-light ">Home Hub
        <div class="collapse navbar-collapse">
            <ul class = "navbar-nav ml-auto">
                <li class = "nav-item">
                    <a href="home" class = "nav-link">Home</a>
                </li>
                <c:if test ="${user != null} ">
					<li class = "nav-item">
                        <a href="dash" class = "nav-link">Dash</a>
                    </li>
				</c:if>
				<c:if test ="${user == null} ">
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
    <h1>Frequently Asked Questions</h1>
    <div class="wrapper" >
    <div class="container" style="margin-top: 50px;">
        
        <div class="row " id="mainContainer"> 
            
            <div class="col section" style = "border-radius: 15px 15px 0px 0px;" onclick="toggleDetailsDiv('1')">
                <h2>How do I add a home?</h2>
            </div>
            <div class="col sectionContent hide" id = "1">
               <div>
                   <p>
                       Go to the settings page by clicking on the settings icon in your profile header.<br> 
                        Then press the add icon (+) next to the homes list.
                    </p>
               </div>
            </div>
            <div class="col section" onclick="toggleDetailsDiv('2')">
                <h2>How do I set my current Home?</h2>
            </div>
            <div class="col sectionContent hide" id = "2">
               <div>
                    <p>
                        Go to the settings page by clicking on the settings icon in your profile header.<br>
                        Select the home you want to set as the current home in the homes list.
                    </p>
               </div>
            </div>
            <div class="col section" onclick="toggleDetailsDiv('3')">
                <h2>How do I Access my settings?</h2>
            </div>
            <div class="col sectionContent hide" id = "3">
               <div>
                   <p>Go to the settings page by clicking on the settings icon in your profile header.<br></p>
               </div>
            </div>
            <div class="col section" onclick="toggleDetailsDiv('4')">
                <h2>How do I delete a home?</h2>
            </div>
            <div class="col sectionContent hide" id = "4">
               <div>
                   <p>
                        Go to the settings page by clicking on the settings icon in your profile header.<br> 
                        Then press the minus icon (+) next to the homes list.
                    </p>
               </div>
            </div>
            <div class="col section" onclick="toggleDetailsDiv('5')">
                <h2>How do I add a room?</h2>
            </div>
            <div class="col sectionContent hide" id = "5">
               <div>
                   <p>
                       Navigate to the dashboard page by pressing the dash tab in the header.<br>
                        Then click the add icon (+) in the room tab list near the top of the page.
                    </p>
               </div>
            </div>
            <div class="col section" onclick="toggleDetailsDiv('6')">
                <h2>How do I add a device?</h2>
            </div>
            <div class="col sectionContent hide" id = "6">
               <div>
                   <p>
                       Navigate to the dashboard page by pressing the dash tab in the header.<br>
                        Then click the add icon (+) next to the device list title near the top of the page.
                    </p>
               </div>
            </div>
            <div class="col section" style = "border-radius: 0px 0px 15px 15px;" onclick="toggleDetailsDiv('6')">
                <h2>How do I delete a device?</h2>
            </div>
            <div class="col sectionContent hide" id = "6">
               <div>
                   <p>Go to the settings page by clicking on the settings icon in your profile header.<br> 
                    Then press the delete icon (x) next to the device you want to delete in the device list.</p>
               </div>
            </div>
        </div>
        <div style = "display: flex; flex-direction: column; justify-content: center; align-items: center;">
            <br>
            <br>
            <H2>Still have more questions? Give us a shout!</H2>
            <H4>Send us a message <a href="contactUs">Here</a> or click the contact us tab in the header!</H4>
        </div>
    </div>
    </div>
    <!---->
    

</body>
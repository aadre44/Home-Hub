<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<header>
    <script src = ""></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/homeStyle.css">

    <script src="https://kit.fontawesome.com/2e8c91b170.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<title>Home</title>

</header>
<body  id = "homePage" style = "background-image: url('${pageContext.request.contextPath}/resources/pics/homePic.png')">
    <!--HEADER-->
    <nav class = "navbar navbar-expand-lg navbar-light ">Home Hub
        <div class="collapse navbar-collapse justify-content-space-evenly">
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
    <div class="container mainContent justify-content-center  " id="mainContent"> 
        <div>
            <h1 style = "color: white">Have A More Connected Home! </h1>
            <p style = "color: white">Stay connected</p>
            
            <button onclick = "location.href='login';">Sign Up</button>
        </div>
        
    </div> 
    <div style = "width:100%; height:100vh;">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320" class = "wave">
            <path fill="#ffffff" fill-opacity="1" d="M0,128L80,144C160,160,320,192,480,181.3C640,171,800,117,960,90.7C1120,64,1280,64,1360,64L1440,64L1440,320L1360,320C1280,320,1120,320,960,320C800,320,640,320,480,320C320,320,160,320,80,320L0,320Z"></path>
        </svg>

        <div class=" icons" style = "">
            <div class="row " ></div>

                <div class="col-lg-3" style = "min-width: 100px; max-height: 50px; display: block ;">
                <p>Check out some of our services!</p> 
                </div>
            

            
                <div class="col cardGrid"style="width: 100%;">
                    <div class="cardSlim" style = "background-image: url('${pageContext.request.contextPath}/resources/pics/working.jpg'); background-size: cover; display: flex; justify-content: center; align-items: center;"onclick="location.href='login';">
						<h3 style = "color: white">Login</h3>
                    </div>
                    <div class="cardSlim" style = "background-image: url('${pageContext.request.contextPath}/resources/pics/workingHome.jpg'); background-size: cover; display: flex; justify-content: center; align-items: center;"onclick="location.href='contactUs';">
                        <h3 style = "color: white">Contact Us</h3>
                    </div>
                    <div class="cardSlim" style = "background-image: url('${pageContext.request.contextPath}/resources/pics/homePic2.jpg'); background-size: cover; display: flex; justify-content: center; align-items: center;" onclick="location.href='faq';">
                        <h3 style = "color: white">FAQ</h3>
                    </div>
                    <div class="cardSlim" style = "background-image: url('${pageContext.request.contextPath}/resources/pics/house.jpg'); background-size: cover; display: flex; justify-content: center; align-items: center;" onclick="location.href='home';">
						<h3 style = "color: white">Check Us Out</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--FOOTER-->

</body>
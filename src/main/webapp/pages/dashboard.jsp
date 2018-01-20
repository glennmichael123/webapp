<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@ page contentType="text/html; charset=UTF-8" %>
		<% String ROOT_URL = "http://localhost:8081/SoaBaseCode/"; %>
            <!DOCTYPE html>

            <html>

            <head>
                <!--Import Google Icon Font-->
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                <!--Import materialize.css-->
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/materialize.min.css">
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/materialize.css">
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/dashboard.css">
                <!--Let browser know website is optimized for mobile-->
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            </head>

            <body>
            <div class="container-fluid">            
            	<div class="nav-wrapper teal darken-1 header">
            	<a href="#" data-activates="slide-out" class="button-collapse brand-logo"><i class="material-icons">menu</i></a>
            		<img src="<% out.print(ROOT_URL);%>images/Kanban-logo2.png" class="kanban-logo"/>
                        <ul class="right hide-on-med-and-down settings">
                            <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Settings<i class="material-icons right">arrow_drop_down</i></a></li>
                        </ul>
                </div>   
				<!-- side nav -->
	         	<ul id="slide-out" class="side-nav">
				    <li><div class="user-view">
				      <div class="background">
				        <img src="images/office.jpg">
				      </div>
				      <a href="#!user"><img class="circle" src="images/yuna.jpg"></a>
				      <a href="#!name"><span class="white-text name">John Doe</span></a>
				      <a href="#!email"><span class="white-text email">jdandturk@gmail.com</span></a>
				    </div></li>
				    <li><a href="#!"><i class="material-icons">cloud</i>First Link With Icon</a></li>
				    <li><a href="#!">Second Link</a></li>
				    <li><div class="divider"></div></li>
				    <li><a class="subheader">Subheader</a></li>
				    <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
				 </ul>
				  <!-- Dropdown Structure -->
                    <ul id="dropdown1" class="dropdown-content">
                        <li><a href="#" class="to-user">Change Password</a></li>
                        <li><a href="#" class="to-admin">Logout</a></li>
                    </ul>  
                        
                    
            </div>
            
            

                <!--Import jQuery before materialize.js-->
                <script src="js/jquery.min.js"></script>
                <script src="js/materialize.min.js"></script>
                 <script src="js/main.js"></script>	
                
            </body>

            </html>
            <script>
            	$(document).ready(function(){
            		$(".button-collapse").sideNav();
            	});
            </script>
            
	
        
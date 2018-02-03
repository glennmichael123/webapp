<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String ROOT_URL = "http://localhost:8081/SoaBaseCode/"; %>

<div class="nav-wrapper teal darken-1 header">
                    <a href="#" data-activates="slide-out" class="button-collapse brand-logo"><i class="fa fa-bars" style="font-size: 20px;"></i></a>
                        <img src="<% out.print(ROOT_URL);%>images/Kanban-logo2.png" class="kanban-logo"/>
                            <ul class="right hide-on-med-and-down settings">
                                <li><a class="dropdown-button" href="#!" data-activates="settings-dropdown">Settings</a></li>
                            </ul>
                            <div style="float: right; margin-right: 20px; margin-top: 5px;" class="white-text">Hello, ${sessionScope.username}</div>
                    </div>  
                    <div class="progress hide">
		     			 <div class="indeterminate"></div>
		 		</div>
		 		
		 		


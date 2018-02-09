<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <%@ page session="true" %>
		<% String ROOT_URL = "http://localhost:8081/SoaBaseCode/"; %>
            <!DOCTYPE html>

            <html>

            <head>
                <!--Import Google Icon Font-->
                
                <!--Import materialize.css-->
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/materialize.min.css">
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/materialize.css">
                <link href="<% out.print(ROOT_URL);%>css/icons.css" rel="stylesheet">
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/dashboard.css">
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>/css/jquery-ui.css">
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/font-awesome-4.7.0/font-awesome-4.7.0/css/font-awesome.css">
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/font-awesome-4.7.0/font-awesome-4.7.0/css/font-awesome.min.css">
                <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/font-awesome.css">
               <script src="<% out.print(ROOT_URL);%>js/jquery.min.js"></script>
               <script src="<% out.print(ROOT_URL);%>js/jquery-1.12.4.js"></script>
               <script src="<% out.print(ROOT_URL);%>js/jquery-ui.js"></script>
               
                
                <!--Let browser know website is optimized for mobile-->
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            </head>

            <body  class="teal lighten-3">
                    <div class="nav-wrapper teal darken-1 header">
                    <a href="#" data-activates="slide-out" class="button-collapse brand-logo"><i class="fa fa-bars" style="font-size: 20px;"></i></a>
                        <img src="<% out.print(ROOT_URL);%>images/Kanban-logo2.png" class="kanban-logo"/>
                            <ul class="right hide-on-med-and-down settings">
                                <li><a class="dropdown-button" href="#!" data-activates="settings-dropdown">Settings</a></li>
                            </ul>
                            <div style="float: right; margin-right: 20px; margin-top: 5px;" class="white-text">Hello, ${sessionScope.username}</div>
                    </div>   
                    <!-- side nav -->
                    <ul id="slide-out" class="side-nav">
                        <li><div class="user-view">
                          <div class="background" style="text-align:center!important;">
                            <img src="<% out.print(ROOT_URL);%>images/Kanban-colorbg.jpg" style="background-color:#00695c;">
                          </div>
                             <div style="margin-top:50px;">Filter Issues</div>
                        </div></li>
                        <li><a href="#!">Backlogs</a></li>
                        <li><a href="#!" class="my_issue">My Issues</a></li>
                     </ul>
                      <!-- Dropdown Structure -->
                        <ul id="settings-dropdown" class="dropdown-content dropdown-settings">
                            <li><a href="#modal1" class="modal-trigger">Change Password</a></li>
                            <li><a href="<%out.print(ROOT_URL); %>logout">Logout</a></li>
                        </ul>   
            <!-- modal for changing password -->
            			  <div id="modal1" class="modal">
						    <div class="modal-content">
						      <h4>Change Password</h4>
						       <input class='validate' type='password' placeholder="New Password" name='password' id='new_password' />
						       <input class='validate' type='password' placeholder="Confirm Password" name='password' id='c_password' />
								sad
						    </div>
						    <div class="modal-footer">
						      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Confirm</a>
						    </div>
						  </div>         
            <!-- end of modal  -->
                        <div id="content"> 
                            <div class="row white-text" style="position: relative;top:10px;">
                                    <div class="col l3 heading">Backlog</div>
                                    <div class="col l3 heading">Selected for Development</div>
                                    <div class="col l3 heading">In Progress</div>
                                    <div class="col l3 heading">Done</div>
                            </div>
                            <div class="row">
                                <div id="sortable1" class="col l3 connectedSortable grey lighten-3">
                                <%for(int i=0; i < 10; i++){ %>
                                    <div class="card white">
                                        <div class="card-content black-text">
                                          <p class="card-description">Create <%out.print(i);%>day plans</p>
                                          
                                            <div class="priority-task" style="position: absolute;top: 50px; left: 0px;">
                                           	 <span class="badge red white-text">High</span>
                                            </div>
                                             <div class="flagged" style="position: absolute; top: 50px; right: 10px;">
                                             
                                           	 	<i class="fa fa-flag" style="color: #b71c1c"></i>
                                            </div>
                                        
                                          
                                        </div>
                                      </div>
                                      <% } %>
                                     
                                </div>
                                <div id="sortable2" class="col l3 connectedSortable grey lighten-3">
                                </div>
                                <div id="sortable3" class="col l3 connectedSortable grey lighten-3">
                                    
                                </div>
                                <div id="sortable4" class="col l3 connectedSortable grey lighten-3">
                                
                                </div>
                            </div> 
                        </div>
                <!--Import jQuery before materialize.js-->
               
                <script src="<% out.print(ROOT_URL);%>js/materialize.min.js"></script>
                <script src="<% out.print(ROOT_URL);%>js/main.js"></script> 
                <script src="<% out.print(ROOT_URL);%>js/dashboard.js"></script>	
                
            </body>

            </html>
            <script type="text/javascript">

                  
                $(document).ready(function(){
                    $(".button-collapse").sideNav();
                    $('select').material_select();
                    $('.modal').modal();
                });
              
            </script>
          <script>
          $( function() {
        	
            $( "#sortable1, #sortable2, #sortable3, #sortable4" ).sortable({
              connectWith: ".connectedSortable",
            }).disableSelection();
          } );
        </script> 


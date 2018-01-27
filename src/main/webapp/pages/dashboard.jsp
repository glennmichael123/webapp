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
                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
               <script src="<% out.print(ROOT_URL);%>js/jquery.min.js"></script>
               <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
               <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
               
                
                <!--Let browser know website is optimized for mobile-->
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            </head>

            <body  class="teal lighten-3">
             	<div id="modal1" class="modal">
                    <div class="modal-content">
                        <p class="modal-title">CREATE ISSUE IN PROGRESS</p>
                        <div class="row">
                            <div class="input-field">
                                <label for="title-progress">Title</label>
                                <input type="text" name="title_progress" id="title-progress" class="validate">
                            </div>    
                        </div>

                        <div class="row">
                            <div class="input-field">
                                <label for="description-progress">Description</label>
                               <textarea name="description_progress" id="description-progress" class="materialize-textarea"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field">
                               <select class="icons" id="priority-progress">
                                  <option value="" disabled selected>Choose your option</option>
                                  <option value="" data-icon="<% out.print(ROOT_URL);%>images/red.jpg" class="circle">HIGH</option>
                                  <option value="" data-icon="<% out.print(ROOT_URL);%>images/orange.jpg" class="circle">MEDIUM</option>
                                  <option value="" data-icon="<% out.print(ROOT_URL);%>images/green.jpg" class="circle">LOW</option>
                                </select>
                               <label for="priority-progress">Priority</label>
                            </div>
                        </div>

                        <button class="btn" id="progress-subtask">+ subtask</button>
                        <div class="row subtask-prog">
                            
                        </div>
                         <div class="row">
                            <p>
                               <input type="checkbox" id="repeat-progress" >
                               <label for="repeat-progress">Create another issue</label>
                            </p>    
                        </div>
                    </div>
                    <div class="modal-footer">
                      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat white-text progress-modal">ADD</a>
                    </div>
                  </div>

                  <div id="modal3" class="modal">
                    <div class="modal-content">
                      <p class="modal-title">CREATE ISSUE FOR BACKLOG</p>
                      <div class="row">
                            <div class="input-field">
                                <label for="title-backlog">Title</label>
                                <input type="text" name="title_backlog" id="title-backlog" class="validate">
                            </div>
                            <div class="row">
                            <div class="input-field">
                                <label for="description-backlog">Description</label>
                               <textarea name="description_backlog" id="description-backlog" class="materialize-textarea"></textarea>
                            </div>    
                            </div>
                            <div class="row">
                                <div class="input-field">
                                   <select class="icons" id="priority-backlog">
                                      <option value="" disabled selected>Choose your option</option>
                                      <option value="" data-icon="<% out.print(ROOT_URL);%>images/red.jpg" class="circle">HIGH</option>
                                      <option value="" data-icon="<% out.print(ROOT_URL);%>images/orange.jpg" class="circle">MEDIUM</option>
                                      <option value="" data-icon="<% out.print(ROOT_URL);%>images/green.jpg" class="circle">LOW</option>
                                    </select>
                                   <label for="priority-backlog">Priority</label>
                                </div>
                            </div>

                            <button class="btn" id="backlog-subtask">+ subtask</button>
                            <div class="row subtask-back">
                                
                            </div>

                            <div class="row">
                                <p>
                                   <input type="checkbox" id="repeat-backlog" >
                                   <label for="repeat-backlog">Create another issue</label>
                                </p>    
                            </div>    
                        </div>
                    </div>
                    <div class="modal-footer">
                      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat white-text backlog-modal">ADD</a>
                    </div>
                  </div>

                  <div id="modal2" class="modal">
				    <div class="modal-content">
				      <p class="modal-title">CREATE ISSUE SELECTED FOR DEVELOPEMENT</p>
                      <div class="row">
                            <div class="input-field">
                                <label for="title-development">Title</label>
                                <input type="text" name="title_development" id="title-development" class="validate">
                            </div>
                            <div class="row">
                            <div class="input-field">
                                <label for="description-development">Description</label>
                               <textarea name="description_development" id="description-development" class="materialize-textarea"></textarea>
                            </div>    
                            </div>
                            <div class="row">
                                <div class="input-field">
                                   <select class="icons" id="priority-development">
                                      <option value="" disabled selected>Choose your option</option>
                                      <option value="" data-icon="<% out.print(ROOT_URL);%>images/red.jpg" class="circle">HIGH</option>
                                      <option value="" data-icon="<% out.print(ROOT_URL);%>images/orange.jpg" class="circle">MEDIUM</option>
                                      <option value="" data-icon="<% out.print(ROOT_URL);%>images/green.jpg" class="circle">LOW</option>
                                    </select>
                                   <label for="priority-development">Priority</label>
                                </div>
                            </div>

                            <button class="btn" id="development-subtask">+ subtask</button>
                            <div class="row subtask-dev">
                                
                            </div>

                            <div class="row">
                                <p>
                                   <input type="checkbox" id="repeat-development" >
                                   <label for="repeat-development">Create another issue</label>
                                </p>    
                            </div>    
                        </div>
				    </div>
				    <div class="modal-footer">
				      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat white-text development-modal">ADD</a>
				    </div>
				  </div>
               

                    <div class="nav-wrapper teal darken-1 header">
                    <a href="#" data-activates="slide-out" class="button-collapse brand-logo"><i class="material-icons">menu</i></a>
                        <img src="<% out.print(ROOT_URL);%>images/Kanban-logo2.png" class="kanban-logo"/>
                            <ul class="right hide-on-med-and-down settings">
                                <li><a class="dropdown-button" href="#!" data-activates="settings-dropdown">Settings</a></li>
                            </ul>
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
                        <li><a href="#!">Releases</a></li>
                     </ul>
                      <!-- Dropdown Structure -->
                        <ul id="settings-dropdown" class="dropdown-content dropdown-settings">
                            <li><a href="#" class="to-user">Change Password</a></li>
                            <li><a href="#" class="to-admin">Logout</a></li>
                        </ul>   
            
                        <div id="content"> 
                            <div class="row white-text" style="position: relative;top:10px;">
                                    <div class="col l3 heading">Backlog</div>
                                    <div class="col l3 heading">Selected for Development</div>
                                    <div class="col l3 heading">In Progress</div>
                                    <div class="col l3 heading">Done</div>
                            </div>
                            <div class="row">
                                <div id="sortable1" class="col l3 connectedSortable grey lighten-3">
                                <%for(int i=0; i < 5; i++){ %>
                                    <div class="card white">
                                        <div class="card-content black-text">
                                            <div class="task-options" style="float: right;"><a href="#" data-activates='dropdown-options<%out.print(i);%>' class="dropdown-button"><i class="material-icons">more_horiz</i></a></div>
                                                <ul id='dropdown-options<%out.print(i);%>' class="dropdown-content dropdown-task" >
                                                        <li><a href="#!" class="edit-task">Edit</a></li>
                                                        <li><a href="#!" class="delete-task">Delete</a></li>
                                                        <li><a href="#!" class="flag-task">Mark flag</a></li>
                                                 </ul>
                                          <p class="card-description">Create <%out.print(i);%>day plans</p>
                                          
                                            <div class="priority-task" style="float: left !important;position: absolute;top: 50px; left: 0px;"><span class="badge red white-text">High priority</span></div>
                                         
                                          
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
                        <div class="fixed-action-btn">
                            <a class="btn-floating btn-large teal darken-3">
                             <i class="material-icons">add</i>
                            </a>
                            <ul>
                              <li class="tooltipped fab child" data-position="left" data-delay="50" data-tooltip="In Progress" data-subitem="1"><a href="#modal1" class="btn-floating red modal-trigger"><i class="fa fa-spinner"></i></a></li>
                              <li class="tooltipped fab child" data-position="left" data-delay="50" data-tooltip="For Development" data-subitem="1"><a href="#modal2" class="btn-floating yellow darken-3 modal-trigger"><i class="fa fa-tasks"></i></a></li>
                              <li class="tooltipped fab child" data-position="left" data-delay="50" data-tooltip="Backlog" data-subitem="1"><a href="#modal3" class="btn-floating green darken-3 modal-trigger"><i class="fa fa-file-text"></i></a></li>
                              
                            </ul>
                        </div>
                <!--Import jQuery before materialize.js-->
               
                <script src="<% out.print(ROOT_URL);%>js/materialize.min.js"></script>
                <script src="<% out.print(ROOT_URL);%>js/main.js"></script> 
                <script src="<% out.print(ROOT_URL);%>js/dashboard.js"></script>	
                
            </body>

            </html>
            <script type="text/javascript">

                  
                $(document).ready(function(){
                    $('.modal').modal();
                    $(".button-collapse").sideNav();
                    $('select').material_select();
                });
               $('.modal-btnAdd').click(function(){
                    var subtask = $('.subta')
               });
            </script>
          <script>
          $( function() {
        	
            $( "#sortable1, #sortable2, #sortable3, #sortable4" ).sortable({
              connectWith: ".connectedSortable",
            }).disableSelection();
          } );
        </script> 


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <%@ page session="true" %>
		<% String ROOT_URL = "http://localhost:8081/SoaBaseCode/"; %>
            <!DOCTYPE html>

            <html>

            <head>
                <!--Import Google Icon Font-->
                <link href="<% out.print(ROOT_URL);%>css/icons.css" rel="stylesheet">
                <!--Import materialize.css-->

                    <link rel="stylesheet" href="<% out.print(ROOT_URL);%>css/profile.css">
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
                <style type="text/css">
                  .error{
                    display: none;
                  }
                  .misMatch{
                    border-bottom: 1px solid red !important;
                  }
                </style>
            </head>

            <body  class="teal lighten-3">

              <div class="nav-wrapper teal darken-1 header">
                <a href="#" id="toUserDashboard"><i class="small material-icons" style="color: #1de9b6 ">arrow_back</i></a>
              </div>  

			
             <div class="container" style="width:50%;padding:10px">
             	<div class="row card" style="padding:30px 10px 50px 10px;">
             	<div class="col s12">
                <h4 style="margin-left: 23px;margin-bottom: 20px;color: #363738;">PROFILE</h4>
                <form>
                  <input type="hidden" name="hiddenID" value="${getProfile.id}">
                  <ul class="collapsible popout" data-collapsible="accordion">
                    <li>
                      <div class="collapsible-header">First name: <span style="margin-left: 40px;" id="lblFname">${getProfile.fname}</span></div>
                      <div class="collapsible-body">
                        <input type="text" class="" name="fname" placeholder="First name" id="fname" value="${getProfile.fname}"/>
                        <span style="float: right;">
                          <a href="#" class="save" style="font-size: 13px;margin-right: 10px;">SAVE</a>
                          <a href="#" class="cancel" style="font-size: 13px;">CANCEL</a>
                        </span> 
                      </div>
                    </li>
                    <li>
                      <div class="collapsible-header">Last name: <span style="margin-left: 40px;" id="lblLname">${getProfile.lname}</span></div>
                      <div class="collapsible-body">
                        <input type="text" class="" name="lname" placeholder="Last name" id="lname" value="${getProfile.lname}"/>
                        <span style="float: right;">
                          <a href="#" class="save" style="font-size: 13px;margin-right: 10px;">SAVE</a>
                          <a href="#" class="cancel" style="font-size: 13px;">CANCEL</a>
                        </span> 
                      </div>
                    </li>
                    <li>
                      <div class="collapsible-header">Age: <span style="margin-left: 85px;" id="lblAge">${getProfile.age}</span></div>
                      <div class="collapsible-body">
                        <input type="text" class="" name="age" placeholder="Age" id="age" value="${getProfile.age}"/>
                        <span style="float: right;">
                          <a href="#" class="save" style="font-size: 13px;margin-right: 10px;">SAVE</a>
                          <a href="#" class="cancel" style="font-size: 13px;">CANCEL</a>
                        </span> 
                      </div>
                    </li>
                    <li>
                      <div class="collapsible-header">Gender: <span style="margin-left: 65px;" id="lblGender">${getProfile.gender}</span></div>
                      <div class="collapsible-body">
                      <c:choose>
          						   <c:when test="${getProfile.gender == 'Male'}">
          							 <input type="radio" name="gender" value="Male" id="m" checked><label for="m">Male</label>
                                  	 <input type="radio" name="gender" value="Female" id="f"><label for="f">Female</label>
          						   </c:when> 
          						   
          						   <c:when test="${getProfile.gender == 'Female'}">
          						   	<input type="radio" name="gender" value="Male" id="m"><label for="m">Male</label>
                                  	 <input type="radio" name="gender" value="Female" id="f" checked><label for="f">Female</label>
          						   </c:when>
          					  </c:choose>
                        <span style="float: right;">
                          <a href="#" class="save" style="font-size: 13px;margin-right: 10px;">SAVE</a>
                          <a href="#" class="cancel" style="font-size: 13px;">CANCEL</a>
                        </span> 
                      </div>
                    </li>
                    <li>
                      <div class="collapsible-header">Username: <span style="margin-left: 45px;" id="lblUsername">${getProfile.uid}</span></div>
                      <div class="collapsible-body">
                        <input type="text" class="" placeholder="Username" name="username" id="username" value="${getProfile.uid}"/>
                        <span style="float: right;">
                          <a href="#" class="save" style="font-size: 13px;margin-right: 10px;">SAVE</a>
                          <a href="#" class="cancel" style="font-size: 13px;">CANCEL</a>
                        </span> 
                      </div>
                    </li>
                    <li>
                      <div class="collapsible-header">Password: <span style="margin-left: 48px;" id="lblPassword">${getProfile.password}</span>
                        <input type="hidden" name="hiddenPassword" id="hiddenPassword" value="${getProfile.password}">
                      </div>
                      <div class="collapsible-body">
                        <div id="error" class="error center-align red-text">Passwords do not match</div><br>
                        New Password<input type="password" name="new_password" class="" placeholder="Password" id="new-pass"/><br>
                        Confirm Password<input type="password" name="confirm_password" class="" placeholder="Password" id="conf-pass"/>
                        <span style="float: right;">
                          <a href="#" class="save" style="font-size: 13px;margin-right: 10px;">SAVE</a>
                          <a href="#" class="cancel" style="font-size: 13px;">CANCEL</a>
                        </span> 
                      </div>
                    </li>
                  </ul>
                </form>
	            </div>
            	</div>
             </div>
         

            
                   
                      
   

                <!--Import jQuery before materialize.js-->
               
                <script src="<% out.print(ROOT_URL);%>js/materialize.min.js"></script>
                <script src="<% out.print(ROOT_URL);%>js/dashboard.js"></script>	
                
            </body>

            </html>
            <script type="text/javascript">   
            $(document).on('dblclick','.view-info',function(e){
           	 $('#modal-view-info').modal('open');
           });
                $(document).ready(function(){
                    $('.modal').modal();
                    $(".button-collapse").sideNav();
                    $('select').material_select();
                    $('.chips').material_chip();
                 
                });


                $(document).ready(function(){
				           $('.collapsible').collapsible({
                    accordion: false, // A setting that changes the collapsible behavior to expandable instead of the default accordion style
                    onOpen: function(el) {}, // Callback for Collapsible open
                    onClose: function(el) { 
                      $('#new-pass').val("");
                      $('#conf-pass').val("");
                     } // Callback for Collapsible close
                });
				  });

              
            </script>
            
          <script>
          $( function() {
            $( "#sortable1, #sortable2, #sortable3, #sortable4" ).sortable({
              connectWith: ".connectedSortable",
            }).disableSelection();
          } );
        </script> 


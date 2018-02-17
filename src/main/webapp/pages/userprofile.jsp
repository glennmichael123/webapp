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
             
             <div class="container" style="width:50%;padding:10px">
             	<div class="row card" style="padding:10px;">
             	<div class="col s8 offset-s2">
		             <div class='row'>
		              <div class='input-field col s12'>
		              <label for="fname">First name</label>
		                <input class='validate' type='text' name='fname' id='fname' value="Qweee"/>
		              </div>
		         	 </div>

		              <div class='row'>
		              <div class='input-field col s12'>
		              <label for="lname">Last name</label>
		                <input class='validate' type='text' name='lname' id='lname' value="Qweee"/>
		              </div>
		          	 </div>

		              <div class='row'>
		              <div class='input-field col s12'>
		              <label for="gender">Gender</label>
		                <input class='validate' type='text' name='gender' id='gender' value="Qweee"/>
		              </div>
		          	  </div>

		              <div class='row'>
		              <div class='input-field col s12'>
		              <label for="age">Age</label>
		                <input class='validate' type='text' name='age' id='age' value="Qweee"/>
		              </div>
		          	  </div>

		              <div class='row'>
		              <div class='input-field col s12'>
		              <label for="uname">Username</label>
		                <input class='validate' type='text' name='"uname"' id='"uname"' value="Qweee"/>
		              </div>
		              </div>
		             
		              <div class='row'>
		              <div class='input-field col s12'>
		              <label for="pass">Password</label>
		                <input class='validate' type='text' name='pass' id='pass' value="Qweee"/>
		              </div>
	            	 </div>
	            	 
	            	 <div class='row'>
		              <div class='col s12'>
		                <input type="radio" name="gender" value="Male" id="m" checked><label for="m">Male</label>
	         			<input type="radio" name="gender" value="Female" id="f"><label for="f">Female</label>
		              </div>
	            	 </div>
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
              
            </script>
          <script>
          $( function() {
        	
            $( "#sortable1, #sortable2, #sortable3, #sortable4" ).sortable({
              connectWith: ".connectedSortable",
            }).disableSelection();
          } );
        </script> 


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>

<head>
 <title>JAVA BASE CODE BETA 1.0</title>
	<link rel="stylesheet" href="css/styles.css" />
	<link rel="stylesheet" href="lib/css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/media-queries.css" />
	<script src="lib/js/jquery-1.10.1.min.js"></script>
	<script src="lib/js/bootstrap.min.js"></script>
	<script src="js/common.js"></script>
	<script src="lib/js/jquery.blockUI.js"></script>
  	<meta name="viewport" content="width=device-width" /> 	
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<head>

<body>
	<div class="container">
		<div class="page-header">
			<h4 style="background: white;"><spring:message code="label.appname"/></h4>
			<span class="label label-info"><a href="?lang=en">en</a></span> | <span class="label label-warning"><a href="?lang=jp">jp</a></span>
		</div>
		<ul class="nav nav-tabs">	
			<li class="active" id="lnk_home"><a href="/SoaBaseCode/"><spring:message code="label.home"/></a></li>
			<li id="lnk_profile"><a><spring:message code="label.profile"/></a></li>
			<li id="lnk_messages"><a><spring:message code="label.messages"/></a></li>
		</ul>
		<br />
		<div id="tab-content" style="width:400px;">
		
			<div class="alert" id="alert-area"></div>
			
			<input type="text" id="uid" class="form-control" placeholder="Desired User Name"></input>
			<br />		
			<input type="text" id="fname" class="form-control" placeholder="First Name"></input>
			<br />
			<input type="text" id="lname" class="form-control" placeholder="Last Name"></input>
			<br />
			
			<span class="label label-info"><spring:message code="label.gender"/></span>
			<div class="btn-group" data-toggle="buttons-radio">
			    <button id="btn-male" type="button" class="btn btn-default active"><spring:message code="label.male"/></button>
			    <button id="btn-female" type="button" class="btn btn-default"><spring:message code="label.female"/></button>
			</div>
			<br />
			<br />
			<input type="number" id="age" class="form-control" placeholder="Age"></input><span id="age-err-msg" class="label label-warning"></span>
			<br />
			
			<br />
			<button id="save-btn" class='btn btn-default'><spring:message code="label.save"/></button>
			<button id="search-btn" class='btn btn-default'><spring:message code="label.searchbyuid"/></button>
			<button id="search-all-btn" class='btn btn-default'><spring:message code="label.searchall"/></button>

			<div>
				<br />
				<ul class="list-group" id="search_result"></ul>
			</div>

		</div>
	</div>
 
</body>
</html>
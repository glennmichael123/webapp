var ROOT_URL = "http://localhost:8080/SoaBaseCode/";

$(document).ready(function(){
	// FOR JAVA BASE CODE --- BEGIN
	$('#lnk_home').click(function(){
		$('#lnk_home').addClass("active");
		$('#lnk_profile').removeClass("active");
		$('#lnk_messages').removeClass("active");
	});
	
	$('#lnk_profile').click(function(){
		$('#lnk_home').removeClass("active");
		$('#lnk_profile').addClass("active");
		$('#lnk_messages').removeClass("active");
		
		$.ajax({
			url: ROOT_URL + 'modulename/profile',
			type: "get",
			dataType: "text"
		}).done(function(data) {
			$('#tab-content').html(data);
		});
	});
	
	$('#lnk_messages').click(function(){
		$('#lnk_home').removeClass("active");
		$('#lnk_profile').removeClass("active");
		$('#lnk_messages').addClass("active");
		
		$.ajax({
			url: ROOT_URL + 'modulename/messages',
			type: "get",
			dataType: "text"
		}).done(function(data) {
			$('#tab-content').html(data);

		});
	});
	
	$('#save-btn').click(function(){

		if($("#fname").val() === '' || $("#lname").val() === '') {
			$('#alert-area').removeClass('alert-success');
			$('#alert-area').addClass('alert-danger');
			$('#alert-area').html("First name and last name required!");
		} else {
			$.ajax({
				url: ROOT_URL + 'api/saveUser',
				type: "post",
				data: {fname: $("#fname").val(), lname: $("#lname").val()}
			}).done(function(data) {
				if(data.fname) {
					$('#alert-area').removeClass('alert-danger');
					$('#alert-area').addClass('alert-success');
					$('#alert-area').html("Successfully saved " + data.fname);
				} else {
					$('#alert-area').removeClass('alert-success');
					$('#alert-area').addClass('alert-danger');
					$('#alert-area').html("There is already an existing user.");
				}
			});
		}
	});
	
	$('#search-btn').click(function(){
		$.ajax({
			url: ROOT_URL + 'api/searchUser/'+ $("#fname").val(),
			type: "get"
		}).done(function(data) {
			if (data.fname) {
				$('#search_result').empty();
				$('#search_result').append("<li class='list-group-item'>" + data.fname + " " + data.lname + "</li>");
			} else {
				$('#alert-area').removeClass('alert-success');
				$('#alert-area').removeClass('alert-danger');
				$('#alert-area').addClass('alert-danger');
				$('#alert-area').html("Cannot find user.");
			}
		});
	});
	
	$('#search-all-btn').click(function(){
		$.ajax({
			url: ROOT_URL + 'api/searchAllUsers',
			type: "get"
		}).done(function(data) {
			$('#search_result').empty();
			data.forEach(function(user){
				$('#search_result').append("<li class='list-group-item'>" + user.fname + " " + user.lname + "</li>");
			});
		});
	});
	
	// FOR JAVA BASE CODE --- END
});
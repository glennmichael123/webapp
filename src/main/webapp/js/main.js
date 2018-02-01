$(document).ready(function() {
	var currentUrl =location.protocol + '//' + location.host + location.pathname;

    var ROOT_URL = "http://localhost:8081/SoaBaseCode/";
    var loader = $('.progress');
   
    
    if(currentUrl == "http://localhost:8081/SoaBaseCode/user" || currentUrl == "localhost:8081/SoaBaseCode/user"){
    	 $.ajax({
    	        url: ROOT_URL + 'modulename/loginuser',
    	        type: "get",
    	        dataType: "text"
    	    }).done(function(data) {
    	        $('#main-container').html(data);
    	        loader.addClass('hide');
    	        
    	    });
    }else if(currentUrl == "http://localhost:8081/SoaBaseCode/admin" || currentUrl == "localhost:8081/SoaBaseCode/admin"){
    	
    	$.ajax({
	        url: ROOT_URL + 'modulename/loginadmin',
	        type: "get",
	        dataType: "text"
	    }).done(function(data) {
	        $('#main-container').html(data);
	        loader.addClass('hide');
	    });
    }else{
    	$.ajax({
	        url: ROOT_URL + 'modulename/loginuser',
	        type: "get",
	        dataType: "text"
	    }).done(function(data) {
	        $('#main-container').html(data);
	        loader.addClass('hide');
	        
	    });
    }
   
    
    
    $(document).on('click','.to-admin',function(e){
    	history.pushState(null, null, ROOT_URL +"admin");
    	loader.removeClass('hide');
    	$.ajax({
            url: ROOT_URL + 'modulename/loginadmin',
            type: "get",
            dataType: "text"
        }).done(function(data) {
            $('#main-container').html(data);
            loader.addClass('hide');

        });
    });
    
    $(document).on('click','.to-user',function(e){
    	history.pushState(null, null, ROOT_URL + "user");
    	loader.removeClass('hide');
    	$.ajax({
            url: ROOT_URL + 'modulename/loginuser',
            type: "get",
            dataType: "text"
        }).done(function(data) {
            $('#main-container').html(data);
            loader.addClass('hide');

        });
    });
    $(document).on('click','#login-user',function(e){
    	e.preventDefault();
    	var email = $("#username").val();
    	var password = $("#password").val();
    	var element = $(this);
    	element.html('Logging in');
    	element.prop('disabled', true);
    	var error = $('#error');
    	$.ajax({
    		url: ROOT_URL + 'api/loginuser',
    		type: "POST",
    		data:{
    			'username':email,
    			'password': password,
    		},
    		success: function(data){
    			if(data){
    				location.href="dashboarduser/"
    			}else{
    				element.html('Login');
    				element.prop('disabled', false);
    				error.show();
    				element.html('Login');
    				element.prop('disabled', false);
    				$('#username').val('');
    				$('#password').val('');
    			}
    		}
    	})

});
    
    $(document).on('click','#login',function(e){
    	e.preventDefault();
    	var email = $("#username").val();
    	var password = $("#password").val();
    	var element = $(this);
    	element.html('Logging in');
    	element.prop('disabled', true);
    	var error = $('#error');
    	$.ajax({
    		url: ROOT_URL + 'api/loginadmin',
    		type: "POST",
    		data:{
    			'username':email,
    			'password': password,
    		},
    		success: function(data){
    			if(data){
    				location.href="dashboard/"
    			}else{
    				element.html('Login');
    				element.prop('disabled', false);
    				error.show();
    				element.html('Login');
    				element.prop('disabled', false);
    				$('#username').val('');
    				$('#password').val('');
    			}
    		}
    	})

});
});
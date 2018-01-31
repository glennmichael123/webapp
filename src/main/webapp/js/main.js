$(document).ready(function() {
    var ROOT_URL = "http://localhost:8081/SoaBaseCode/";
    var loader = $('.progress');
//    window.pushState
    $.ajax({
        url: ROOT_URL + 'modulename/loginuser',
        type: "get",
        dataType: "text"
    }).done(function(data) {
        $('#main-container').html(data);
        loader.addClass('hide');
        
    });
    
    
    $(document).on('click','.to-admin',function(e){
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
    $(document).on('click','#login',function(e){
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
    				location.href="dashboard/"
    			}else{
    				element.html('Login');
    				element.prop('disabled', false);
    				error.show();
    				$('#username').val('');
    				$('#password').val('');
    			}
    		}
    	})

});
});
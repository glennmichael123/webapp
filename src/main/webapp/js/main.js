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
    	
    	location.href= ROOT_URL+ "dashboard/"
    })
});
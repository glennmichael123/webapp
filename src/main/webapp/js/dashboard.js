 $(document).ready(function(){
	$(document).on('click','#progress-subtask',function(e){
         var html = '<div class="input-field">'+
                    '<input type="text" style="width:97%;" name="subtask_progress" placeholder="Subtask" class="validate subtasks-progress">'+
                    '<a href="#" class="remove-subtask-progress"><i class="fa fa-times"></i></a>'+
                    '</div>';
         $('.subtask-prog').append(html);
        	 
    });
	
	$(document).on('click','.remove-subtask-progress',function(e){
        $(this).closest('.input-field').fadeOut();
	});

	$(document).on('click','#backlog-subtask',function(e){
         var html = '<div class="input-field">'+
                    '<input type="text" style="width:97%;" name="subtask_backlog" placeholder="Subtask" class="validate subtasks-backlog">'+
                    '<a href="#" class="remove-subtask-backlog"><i class="fa fa-times"></i></a>'+
                    '</div>';
         $('.subtask-back').append(html);
        	 
    });
	
	$(document).on('click','.remove-subtask-backlog',function(e){
        $(this).closest('.input-field').fadeOut();
	});

	$(document).on('click','#development-subtask',function(e){
         var html = '<div class="input-field">'+
                    '<input type="text" style="width:97%;" name="subtask_development" placeholder="Subtask" class="validate subtasks-development">'+
                    '<a href="#" class="remove-subtask-development"><i class="fa fa-times"></i></a>'+
                    '</div>';
         $('.subtask-dev').append(html);
        	 
    });
	
	$(document).on('click','.remove-subtask-development',function(e){
        $(this).closest('.input-field').fadeOut();
	});
 });
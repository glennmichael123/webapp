 $(document).ready(function(){
	 var ROOT_URL = "http://localhost:8081/SoaBaseCode/";
	$(document).on('click','#progress-subtask',function(e){
         var html = '<div class="input-field">'+
                    '<input type="text" style="width:97%;" name="subtask_progress" placeholder="Subtask" class="validate subtasks-progress">'+
                    '<a href="#" class="remove-subtask-progress"><i class="fa fa-times"></i></a>'+
                    '</div>';
         $('.subtask-prog').append(html);
        	 
    });
	
	$(document).on('click','.remove-subtask-progress',function(e){
        $(this).closest('.input-field').remove();
	});

	$(document).on('click','#backlog-subtask',function(e){
         var html = '<div class="input-field">'+
                    '<input type="text" style="width:97%;" name="subtask_backlog" placeholder="Subtask" class="validate subtasks-backlog">'+
                    '<a href="#" class="remove-subtask-backlog"><i class="fa fa-times"></i></a>'+
                    '</div>';
         $('.subtask-back').append(html);
        	 
    });
	
	$(document).on('click','.remove-subtask-backlog',function(e){
		e.preventDefault();
        $(this).closest('.input-field').remove();
	});

	$(document).on('click','#development-subtask',function(e){
		
		var html = '<div class="input-field">'+
        '<input type="text" style="width:97%;" name="subtask_development" placeholder="Subtask" class="validate subtasks-development">'+
        '<a href="#" class="remove-subtask-development"><i class="fa fa-times"></i></a>'+
        '</div>';
         $('.subtask-dev').append(html);
        
        
         
         
        	 
    });
	
	$(document).on('click','.remove-subtask-development',function(e){
        $(this).closest('.input-field').remove();
	});
	$(document).on('click','.delete-task',function(e){
		$(this).closest('.card').remove();
		 var $toastContent = $('<span>You deleted an issue</span>').add($('<button class="btn-flat toast-action">Undo</button>'));
		  Materialize.toast($toastContent, 10000);
	});
	
	$(document).on('click', '.view-releases',function(e){
		
		 location.href = ROOT_URL + 'dashboard/releases';
	});
	
	$(document).on('click','#submit-backlog',function(e){
		e.preventDefault();
		
		var title = $('#title-backlog').val();
		var description = $('#description-backlog').val();
		var priority = $('#priority-backlog').val();
		var type = 'backlog';
		
		$.ajax({
			url: ROOT_URL + 'api/saveIssues',
			type: 'POST',
			data:{
				'title': title,
				'description': description,
				'priority': priority,
				'type': type,
			},
			success: function(data){
				location.reload();
			}
		});
	});
	
	$(document).on('click','#submit-development',function(e){
		e.preventDefault();
		
		var title = $('#title-development').val();
		var description = $('#description-development').val();
		var priority = $('#priority-development').val();
		var type = 'development';
		
		$.ajax({
			url: ROOT_URL + 'api/saveIssues',
			type: 'POST',
			data:{
				'title': title,
				'description': description,
				'priority': priority,
				'type': type,
			},
			success: function(data){
				location.reload();
			}
		});
	});
	
	$(document).on('click','#submit-progress',function(e){
		e.preventDefault();
		
		var title = $('#title-progress').val();
		var description = $('#description-progress').val();
		var priority = $('#priority-progress').val();
		var type = 'progress';
		
		$.ajax({
			url: ROOT_URL + 'api/saveIssues',
			type: 'POST',
			data:{
				'title': title,
				'description': description,
				'priority': priority,
				'type': type,
			},
			success: function(data){
				location.reload();
			}
		});
	});
	
	 $(document).on('dblclick','.view-info',function(e){
       	 $('#modal-view-info').modal('open');
       	 var id = $(this).data('card-id');
       	 $.ajax({
       		 url: ROOT_URL + 'api/viewIssueDetails',
       		 type: 'POST',
       		 data:{
       			 'id':id,
       		 },
       		 success: function(data){
       			 $('#issue-detail-title').text(data.title);
       			 $('#issue-detail-desc').text(data.description);
       			 $('#issue-detail-priority').text(data.priority);
       			 
       		 }
       	 });
      });
	 
	 $("body").on({
		    mouseenter: function () {
		    	$(this).find('.flagged-not').show();
		    },
		    mouseleave:function () {
		    	$(this).find('.flagged-not').hide();
		    }
		},'.card');
	
	$(document).on('click', '.mark-flag',function(e){
		var id = $(this).data('card-id');
		console.log(id);
	});
 });
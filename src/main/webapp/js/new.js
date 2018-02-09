$(document).ready(function(){


		$(document).on('click','.add-subtask',function(e){
		e.preventDefault();
         var html = '<div class="input-field">'+
                    '<input type="text" style="width:94%;" name="subtask_progress" placeholder="Subtask" class="validate subtasks">'+
                    '<a href="#" class="remove-subtask"><i class="fa fa-times"></i></a>'+
                    '</div>';
         $('#subtask-content').append(html);
        	 
    });


		$(document).on('click','.remove-subtask',function(e){
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
		var flag = true;
		var title = $('#title-backlog').val();
		var description = $('#description-backlog').val();
		var priority = $('#priority-backlog').val();
		var type = 'backlog';
		var assignedTo = $('#backlog-assign').val();
		  var fail = false;
	       var fail_log = '';
	       
	        $( '#modal3' ).find( 'select, textarea, input' ).each(function(){
	            if( ! $( this ).prop( 'required' )){
	            	
	            } else {
	                if ( ! $( this ).val() ) {
	                    fail = true;
	                    name = $( this ).attr( 'style', 'border-bottom: 1px solid red' );
	                    fail_log += name + " is required \n";
	                }else{
	                    
	                }

	            }
	        });

	        if ( ! fail ) {
	        	if($('#repeat-backlog').is(":checked")){
	        		
	        		Materialize.toast('Saving..', 4000);

	        	}else{
	        		 $('#modal3').modal('close');
	        		 Materialize.toast('Saving..', 4000);
	        	}
	        	 $.ajax({
		       			url: ROOT_URL + 'api/saveIssues',
		       			type: 'POST',
		       			data:{
		       				'title': title,
		       				'description': description,
		       				'priority': priority,
		       				'type': type,
		       				'assigned': assignedTo,
		       			},
		       			success: function(data){
		       				  var toastElement = $('.toast').first()[0];
							  var toastInstance = toastElement.M_Toast;
							  toastInstance.remove();
			        		  Materialize.toast('Saved!', 4000);
			        		  $('#title-backlog').val('');
			        		  $('#description-backlog').val('');
			        		  $('#priority-backlog').prop('selectedIndex',0);
			        		  $('#backlog-assign').prop('selectedIndex',0);
			        		  $('#repeat-backlog').prop('checked',false);
			        		   $('#content').load(location.href + " #content");
			        		   $('select').material_select();
			        		   $( "#sortable1, #sortable2, #sortable3, #sortable4" ).sortable( "refresh" );

		       			}
		       		});
	        }
	        
		
		
	});
	
	$(document).on('click','#submit-development',function(e){
		e.preventDefault();
		
		var title = $('#title-development').val();
		var description = $('#description-development').val();
		var priority = $('#priority-development').val();
		var type = 'development';
		var assignedTo = $('#development-assign').val();
		
		var fail = false;
	       var fail_log = '';
	       
	        $( '#modal2' ).find( 'select, textarea, input' ).each(function(){
	            if( ! $( this ).prop( 'required' )){
	            	
	            } else {
	                if ( ! $( this ).val() ) {
	                    fail = true;
	                    name = $( this ).attr( 'style', 'border-bottom: 1px solid red' );
	                    fail_log += name + " is required \n";
	                }else{
	                    
	                }

	            }
	            
	       
	        });

	        if ( ! fail ) {
	        	if($('#repeat-development').is(":checked")){
	        		Materialize.toast('Saving..', 4000);
	        	}else{
	        		 $('#modal2').modal('close');
	        		 Materialize.toast('Saving..', 4000);
	        	}


	        	 $.ajax({
		       			url: ROOT_URL + 'api/saveIssues',
		       			type: 'POST',
		       			data:{
		       				'title': title,
		       				'description': description,
		       				'priority': priority,
		       				'type': type,
		       				'assigned': assignedTo,
		       			},
		       			success: function(data){
		       				var toastElement = $('.toast').first()[0];
							  var toastInstance = toastElement.M_Toast;
							  toastInstance.remove();
			        		  Materialize.toast('Saved..', 4000);
			        		  $('#title-development').val('');
			        		  $('#description-development').val('');
			        		  $('#priority-development').prop('selectedIndex',0);
			        		  $('#development-assign').prop('selectedIndex',0);
			        		  $('#repeat-development').prop('checked',false);
			        		   $('#content').load(location.href + " #content");
			        		   $('select').material_select();
		       			}
		       		});
	        }
		
});
	
	$(document).on('click','#submit-progress',function(e){
		e.preventDefault();
		
		var title = $('#title-progress').val();
		var description = $('#description-progress').val();
		var priority = $('#priority-progress').val();
		var type = 'progress';
		var assignedTo = $('#progress-assign').val();
		var fail = false;
	       var fail_log = '';
	       
	        $( '#modal1' ).find( 'select, textarea, input' ).each(function(){
	            if( ! $( this ).prop( 'required' )){
	            	
	            } else {
	                if ( ! $( this ).val() ) {
	                    fail = true;
	                    name = $( this ).attr( 'style', 'border-bottom: 1px solid red' );
	                    fail_log += name + " is required \n";
	                }else{
	                    
	                }

	            }
	        });

	        if ( ! fail ) {
	        	if($('#repeat-progress').is(":checked")){
	        		Materialize.toast('Saving..', 4000);
	        	}else{
	        		 $('#modal1').modal('close');
	        		 Materialize.toast('Saving..', 4000);
	        	}


	        	 $.ajax({
		       			url: ROOT_URL + 'api/saveIssues',
		       			type: 'POST',
		       			data:{
		       				'title': title,
		       				'description': description,
		       				'priority': priority,
		       				'type': type,
		       				'assigned': assignedTo,
		       			},
		       			success: function(data){
		       				var toastElement = $('.toast').first()[0];
							  var toastInstance = toastElement.M_Toast;
							  toastInstance.remove();
			        		  Materialize.toast('Saved..', 4000);
			        		  $('#title-progress').val('');
			        		  $('#description-progress').val('');
			        		  $('#priority-progress').prop('selectedIndex',0);
			        		  $('#progress-assign').prop('selectedIndex',0);
			        		  $('#repeat-progress').prop('checked',false);
			        		   $('#content').load(location.href + " #content");
			        		   $('select').material_select();
		       			}
		       		});
	        }
	});


$(document).on('dblclick','.view-info',function(e){
	 $('#nav-right').sideNav('show');
	 var id = $(this).data('card-id');
	 $.ajax({
	 	url: ROOT_URL + 'api/viewSubtaskDetails',
	 	type: "POST",
	 	data:{
	 		'id':id,
	 	},
	 	success: function(data){
	 		$('#issue-detail-title').val(data.title);
			 $('#issue-detail-desc').text(data.description);
			 $('#issue-detail-priority').val(data.priority == '' ? "None" : data.priority);
			 $('#assigned-to').text(data.assigned == '' ? "No one" : data.assigned);
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

$(document).on('keydown','#issue-detail-title',function(){
$('#save-edit').removeAttr("disabled");
});
$(document).on('keydown','#issue-detail-desc',function(){
$('#save-edit').removeAttr("disabled");
});

$(document).on('keydown','#issue-detail-priority',function(){
$('#save-edit').removeAttr("disabled");


});



});


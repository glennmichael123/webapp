 $(document).ready(function(){
	 var ROOT_URL = "http://localhost:8081/SoaBaseCode/";

$(document).on('click', '.save',function(e){
	if($('#new-pass').val().trim() != $('#conf-pass').val().trim()){
		$('#error').removeClass('error');
		$('#new-pass').addClass('misMatch');
        $('#conf-pass').addClass('misMatch');
        return false;
	}
	if(!$('#new-pass').val() ){
		$('#new-pass').val($('#hiddenPassword').val());
	}
	var data = $( "form" ).serialize();
	$.ajax({
		url: ROOT_URL + 'api/updateProfile',
		type: "POST",
		data: data,
		success:function(data){
			$('#lblFname').html(data.fname);
			$('#lblLname').html(data.lname);
			$('#lblAge').html(data.age);
			$('#lblGender').html(data.gender);
			$('#lblUsername').html(data.uid);
			$('#lblPassword').html(data.password);
			$('#new-pass').val("");
			$('#conf-pass').val("");
			$('#error').addClass('error');
			$('#new-pass').removeClass('misMatch');
	        $('#conf-pass').removeClass('misMatch');
			Materialize.toast('Saved', 4000);
			for (var i = 0; i <= 5; i++) {
				$('.collapsible').collapsible('close', i);
			}

		}
	});
});

$(document).on('click', '#toUserDashboard',function(e){
	 location.href = ROOT_URL + 'dashboarduser';
});


$(document).on('click', '.cancel',function(e){
	for (var i = 0; i <= 5; i++) {
		$('.collapsible').collapsible('close', i);
	}
});

$(document).on('click', '.userprofile',function(e){

	 location.href = ROOT_URL + 'dashboard/userprofile';
});
 
 $(document).on('click','#save-edit',function(e){
	 var title = $('#issue-detail-title').val();
	 var issue_detail = $('#issue-detail-desc').val();
	 var issue_prio = $('#issue-detail-priority').val();
	 var assigned_to = ($('#assigned-to').text()== 'No one' ? "" : $('#assigned-to').text());
	 var issudeID = $('#hiddenIssueID').val();
	 var flag = $('#hiddenIssueFlag').val();
	 var type = $('#hiddenType').val();
	 var order = $('#hiddenOrder').val();
	 
	 console.log(issue_detail);
	 var d = $(this);
  	 $.ajax({
  		 url: ROOT_URL + 'api/editIssue',
  		 type: 'POST',
  		 data:{
  			 'issudeID':issudeID,
  			 'title':title,
  			 'issue_prio':issue_prio,
  			 'issue_detail':issue_detail,
 			 'assigned_to':assigned_to,
 			 'flag':flag,
 			 'type':type,
 			 'order':order,
  		 },
  		 success: function(data){
  			d.prop('disabled',true);
  			Materialize.toast('Saved!', 4000);
  		 }
  	 });
  	});

	$(document).on('click','.add-user',function(e){
		e.preventDefault();
		var username = $('#users_username').val();
		var password = $('#users_password').val();
		var fname = $('#users_firstname').val();
		var lname = $('#users_lastname').val();
		var age = $('#users_age').val();
		var gender;
		if($('#m').is(':checked')){
			gender = $('#m').val();
		}else if($('#f').is(':checked')){
			gender = $('#f').val();
		}

		var fail = false;
	       var fail_log = '';
	        $( '#modalAddUser' ).find( 'input' ).each(function(){
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
	        	$('#modalAddUser').modal('close');
	        	Materialize.toast('Saving..', 4000);
	        	 $.ajax({
		       			url: ROOT_URL + 'api/saveUser',
		       			type: 'POST',
		       			data:{
		       				'uid': username,
		       				'pass': password,
		       				'fname': fname,
		       				'lname': lname,
		       				'age': age,
		       				'gender': gender,
		       			},
		       			success: function(data){
		       				var toastElement = $('.toast').first()[0];
							var toastInstance = toastElement.M_Toast;
							toastInstance.remove();
			        		Materialize.toast('USER ADDED', 4000);
		       			}
		       		});
	        }
	});

	$(document).on('click','.add-subtask',function(e){
		e.preventDefault();
         var html = '<div class="input-field">'+
                    '<input type="text" style="width:94%;" name="subtask_progress" placeholder="Subtask" class="validate subtasks-added" autofocus>'+
                    '<a href="#" class="remove-subtask"><i class="fa fa-times"></i></a>'+'<input type="button" class="btn submit-subtask" value="SUBMIT SUBTASK">'+
                    '</div>';
         $('#subtask-content').append(html);
        	 
    });
	$(document).on("click",'.submit-subtask', function(e){
		e.preventDefault();
		var data = $(this).closest('.input-field').find('.subtasks-added').val();
		var taskID=$(this).closest('.right-aligned').find('#hiddenIssueID').val();
		var element = $(this);
		element.html('Saving');
		$.ajax({
			url:ROOT_URL + 'api/addSubtask',
			type:'POST',
			data:{
				'data':data,
				'taskID':taskID
			},
			success:function(){
//				location.reload();
				element.remove();
				Materialize.toast('Successfully Saved.', 4000);
			}
		});
	});
	$(document).on('keyup','.subtasks',function(){
		var data  = $(this).val();
		var id 	  = $(this).data('subtask-id');
		var taskID=$(this).closest('.right-aligned').find('#hiddenIssueID').val();
	
		
		$.ajax({
			url : ROOT_URL + 'api/updateSubTask',
			type: 'POST',
			data:{
				'data': data,
				'id'  :id,
				'taskID': taskID
			},
			success:function(){
				
			}
		});
	});
	$(document).on('click','.remove-subtask',function(e){
		var id = $(this).data('subtask-id');
		var element = $(this).closest('.input-field');
		console.log(id);
		if(id == undefined){
			element.remove();
		}else{
			$.ajax({
				url: ROOT_URL + 'api/deleteSubTask',
				type:'POST',
				data:{
					'id':id
				},
				success:function(){
					element.remove();
				}
			});
		}
		
		
	});

	$(document).on('click','.delete-task',function(e){
		
		
		  var id = $(this).data('id');
		  var element = $(this);
		  $.ajax({
				url: ROOT_URL + 'api/deleteTask',
				type:'POST',
				data:{
					'id':id
				},
				success:function(){
					element.closest('.card').remove();
					 var $toastContent = $('<span>You deleted an issue</span>');
					  Materialize.toast($toastContent, 10000);
				}
			});
	});
	
	
	$(document).on('click', '.view-releases',function(e){
		
		 location.href = ROOT_URL + 'dashboard/releases';
	});
	$(document).on('click', '.view-trash',function(e){
		
		 location.href = ROOT_URL + 'dashboard/trash';
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
	
	 
	 
	 $("body").on({
		    mouseenter: function () {
		    	$(this).find('.fa-flag-o').show();
		    },
		    mouseleave:function () {
		    	$(this).find('.fa-flag-o').hide();
		    }
		},'.card');
	
	$(document).on('click', '.mark-flag',function(e){
		var flagged = $(this).data('card-id');
		var element = $(this);
		 $.ajax({
				url: ROOT_URL + 'api/markFlag',
				type:'POST',
				data:{
					'flagged':flagged
				},
				success:function(){
					
					element.removeClass('fa-flag-o');
					element.addClass('fa-flag');
					element.removeClass('mark-flag');
					element.addClass('unmark-flag');
					Materialize.toast('Marked as flag', 4000);
				}
			});
	});
	
	$(document).on('click', '.unmark-flag',function(e){
		var flagged = $(this).data('card-id');
		var element = $(this);
		 $.ajax({
				url: ROOT_URL + 'api/unmarkFlag',
				type:'POST',
				data:{
					'flagged':flagged
				},
				success:function(){
					$(this).closest('.input-field').remove();
					element.removeClass('fa-flag');
					element.addClass('fa-flag-o');
					element.removeClass('unmark-flag');
					element.addClass('mark-flag');
					Materialize.toast('Removed flag', 4000);
				}
			});
	});
	
	$(document).on('click', '.release-task',function(e){
		e.preventDefault();
		var released = $(this).data('id');
		var parent = $(this).closest('.card');
		 $.ajax({
				url: ROOT_URL + 'api/releaseTask',
				type:'POST',
				data:{
					'released':released
				},
				success:function(){
					parent.remove();
					Materialize.toast('Released', 4000);
				}
			});
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
	
	
	$(document).on('dblclick','.view-info',function(e){
		$('#nav-right').sideNav('show');
      	 var id = $(this).data('card-id');
      	 $.ajax({
      		 url: ROOT_URL + 'api/viewIssueDetails',
      		 type: 'POST',
      		 data:{
      			 'id':id,
      		 },
      		 success: function(data){
      			 $('#hiddenIssueID').val(data.id);
      			 $('#hiddenIssueFlag').val(data.flagged);
      			 $('#hiddenType').val(data.type);
      			 $('#issue-detail-title').val(data.title);
      			 $('#issue-detail-desc').text(data.description);
      			 $('#hiddenOrder').val(data.orders);
      			 $('#issue-detail-priority').val(data.priority == '' ? "None" : data.priority);
      			 $('#assigned-to').text(data.assigned == '' ? "No one" : data.assigned);	 
      		 }
      	 });
var subtaskContent = $('#subtask-content');
      	 $.ajax({
      		 url: ROOT_URL + 'api/viewSubtaskDetails',
      		 type: 'POST',
      		 data:{
      			 'id':id,
      		 },
      		 success: function(data){
      			 if(data == ''){
      				 subtaskContent.html('');
      			 }else{
      				$.each(data, function(i, item) {
      					var html = '<div class="input-field">'+
                        '<input type="text" style="width:94%; border-bottom:none;" value="'+item.description+'" name="subtask_progress" placeholder="Subtask" class="validate subtasks" data-subtask-id="'+item.id+'">'+
                        '<a href="#" class="remove-subtask" data-subtask-id="'+item.id+'"><i class="fa fa-times"></i></a>'+
                        '</div>';
      					
      					$('#subtask-content').append(html);
    		      	});   
      			 }
  				
      		 }
      	 });


         	 
 });
	$(document).on('click','.userprofile',function(e){
		
		
	});
	
	
	
 });
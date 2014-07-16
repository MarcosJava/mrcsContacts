//Dialog LOADING
var myApp;
	myApp = myApp
			|| (function() {
				var pleaseWaitDiv = $('<div class="modal hide" id="pleaseWaitDialog" data-backdrop="static" data-keyboard="false"><div class="modal-header"><h1>Processing...</h1></div><div class="modal-body"><div class="progress progress-striped active"><div class="bar" style="width: 100%;"></div></div></div></div>');
				return {
					showPleaseWait : function() {
						pleaseWaitDiv.modal();
					},
					hidePleaseWait : function() {
						pleaseWaitDiv.modal('hide');
					},

				};
			})();
	
	

	//Dialog Delete
	
	$('#confirmDelete').on('show.bs.modal', function (e) {
	      $message = $(e.relatedTarget).attr('data-message');
	      $(this).find('.modal-body p').text($message);
	      $title = $(e.relatedTarget).attr('data-title');
	      $(this).find('.modal-title').text($title);

	      // Pass form reference to modal for submission on yes/ok
	      var form = $(e.relatedTarget).closest('form');
	      $(this).find('.modal-footer #confirm').data('form', form);
	  });

	 
	  $('#confirmDelete').find('.modal-footer #confirm').on('click', function(){
	      $(this).data('form').submit();
	  });
	  
	  
	  //SelectOne -- Add Release
	 
	  
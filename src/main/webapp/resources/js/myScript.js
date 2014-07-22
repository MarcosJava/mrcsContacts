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
	  
	  
	  //converter grana
	  $(function converte() {
		    $("#currency").maskMoney(
		    	    {prefix:'R$ ',
		    	    allowNegative: true,
		    	    thousands:'.',
		    	    decimal:',',
		    	    affixesStay: false});
	  });
	  
	  
	  //datapicker
	  $(function ajustacalendario() {
		    $( "#calendario" ).datepicker({
		        showButtonPanel:true,
		        dateFormat: 'dd-mm-yy', 
		        showOtherMonths: true,
		        selectOtherMonths: true, closeText: 'Fechar',  
		        prevText: 'Anterior',  
		        nextText: 'Próximo',  
		        currentText: 'Começo',  
		        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
		        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],  
		        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],  
		        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],  
		        dayNamesMin: ['D','S','T','Q','Q','S','S'],  
		        weekHeader: 'Semana',  
		        firstDay: 1,  
		        isRTL: false,  
		        showMonthAfterYear: false,  
		        yearSuffix: '',  
		        timeOnlyTitle: 'Só Horas',  
		        timeText: 'Tempo',  
		        hourText: 'Hora',  
		        minuteText: 'Minuto',  
		        secondText: 'Segundo',  
		        currentText: 'Data Atual',  
		        ampm: false,  
		        month: 'Mês',  
		        week: 'Semana',  
		        day: 'Dia',  
		        allDayText : 'Todo Dia' 
		    });
		});
	  
	//datapicker
	  $(function ajustacalendario() {
		    $( "#calendario2" ).datepicker({
		        showButtonPanel:true,
		        dateFormat: 'dd-mm-yy', 
		        showOtherMonths: true,
		        selectOtherMonths: true, closeText: 'Fechar',  
		        prevText: 'Anterior',  
		        nextText: 'Próximo',  
		        currentText: 'Começo',  
		        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
		        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],  
		        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],  
		        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],  
		        dayNamesMin: ['D','S','T','Q','Q','S','S'],  
		        weekHeader: 'Semana',  
		        firstDay: 1,  
		        isRTL: false,  
		        showMonthAfterYear: false,  
		        yearSuffix: '',  
		        timeOnlyTitle: 'Só Horas',  
		        timeText: 'Tempo',  
		        hourText: 'Hora',  
		        minuteText: 'Minuto',  
		        secondText: 'Segundo',  
		        currentText: 'Data Atual',  
		        ampm: false,  
		        month: 'Mês',  
		        week: 'Semana',  
		        day: 'Dia',  
		        allDayText : 'Todo Dia' 
		    });
		});
	  
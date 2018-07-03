$(document).ready(function() {

	$('#loginform').submit(function(event) {

		

			$.post($(this).attr('action'), $(this).serialize(), function(json) {

				if (json.condition) {

					
					window.location="/DEIE/dashBoard/dashboard.html";
					

				} else {
					$('#inputName').val('');
					$('#inputPassword').val('');
					alert(json.message);

				}

			}

			, 'json');

		

		return false;
	});

});
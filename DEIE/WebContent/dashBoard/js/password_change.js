$(document).ready(function() {

	$('#passwordform').submit(function(event) {

		var p1 = $('#newpassword').val();
		var p2 = $('#newpassword2').val();

		if (p1 === p2) {

			$.post($(this).attr('action'), $(this).serialize(), function(json) {

				if (json.condition) {

					$('#oldpassword').val('');
					$('#newpassword').val('');
					$('#newpassword2').val('');
					alert(json.message);
					

				} else {
					$('#oldpassword').val('');
					$('#newpassword').val('');
					$('#newpassword2').val('');
					alert(json.message);

				}

			}

			, 'json');

		} else {

			$('#oldpassword').val('');
			$('#newpassword').val('');
			$('#newpassword2').val('');
			alert("Repeated Password doesn't match..");
			event.preventDefault();
		}

		return false;
	});

});
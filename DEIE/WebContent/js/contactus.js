$(document).ready(function() {

	$('#contactForm').submit(function(event) {

		$.post($(this).attr('action'), $(this).serialize(), function(json) {

			if (json.condition) {

				alert(json.message);

				$('#messageinformcorrect').show();
				$('#messageinformwronng').hide();

				$('#sender').val('');
				$('#email').val('');
				$('#subject').val('');
				$('#content').val('');

			} else {

				$('#messageinformcorrect').hide();
				$('#messageinformwronng').show();
				alert(json.message);

			}

		}

		, 'json');

		return false;
	});

});

$(document).ready(function() {

	$('#messageinformcorrect').hide();
	$('#messageinformwronng').hide();

});

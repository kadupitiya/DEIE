function serverCallForLogout() {
	var postData = {
		key2 : "logout"
	}
	var formURL = "/DEIE/restRequest/dashBoard/logout";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var message = data;

					if (message!=null) {

						window.location="/DEIE/dashBoard/index.html";

					} else {

						alert("Server Error");

					}

				},
				error : function(jqXHR, textStatus, errorThrown) {
					// if fails 
					alert("Server Error")
					e.preventDefault(); // STOP default action

				}
			});
	
}

$(document).ready(function() {

	$('#logout').on('click', function() {

		serverCallForLogout();

	});
	

});

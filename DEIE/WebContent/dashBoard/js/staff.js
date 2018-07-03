$(document)
		.ready(
				function() {

					var options = {
						beforeSend : function() {
							// $("#progressbox").show();
							// clear everything
							// $("#progressbar").width('0%');
							if ($('#addNoticeNumber').val() !== ""
									&& $('#addNoticeTitle').val() !== ""
									&& $('#addNoticeDes').val() !== "") {

								$("#message").empty();
								$("#percent").html("0%");
								document.getElementById("bPrecentBar").style.width = "0%";
							} else {
								alert("Please Fill all the fields ...");
								event.preventDefault();
							}
						},
						uploadProgress : function(event, position, total,
								percentComplete) {
							// $("#progressbar").width(percentComplete + '%');
							$("#percent").html(percentComplete + '%');
							document.getElementById("bPrecentBar").style.width = percentComplete
									+ "%";
							// change message text to red after 50%
							if (percentComplete > 50) {
								$("#message")
										.html(
												"<font color='green'>File Upload is in progress</font>");
							}
						},
						success : function(out) {
							// $("#progressbar").width('100%');
							$("#percent").html('100%');
							document.getElementById("bPrecentBar").style.width = "100%";

							// document.getElementById("itemList").innerHTML =
							// "";

							alert("Successfully Done ...");
							window.location = "/DEIE/dashBoard/Staff.html";

						},
						complete : function(response) {
							$("#message")
									.html(
											"<font color='blue'>Your file has been uploaded!</font>");

						},
						error : function() {
							$("#message")
									.html(
											"<font color='red'> ERROR: unable to upload files</font>");
						}
					};

					$("#addNotice").ajaxForm(options);

				});

function serverCallForSPID() {
	var postData = {
		key2 : "newsAddPage"
	}
	var formURL = "/DEIE/restRequest/dashBoard/getStaffID";
	$.ajax({
		url : formURL,
		type : "POST",
		data : postData,
		success : function(data, textStatus, jqXHR) {
			// data: return data from server

			var message = data;

			if (message.status) {

				document.getElementById("addstaffNumber").value = message.data;

			} else {

				alert(message.message);

			}

		},
		error : function(jqXHR, textStatus, errorThrown) {
			// if fails 
			alert("Server Error")
			e.preventDefault(); // STOP default action
		}
	});

}

function serverCallForSPIDList() {
	var postData = {
		key2 : "newsAddPage"
	}
	var formURL = "/DEIE/restRequest/dashBoard/getStaffIDList";
	$.ajax({
		url : formURL,
		type : "POST",
		data : postData,
		success : function(data, textStatus, jqXHR) {
			// data: return data from server

			var message = data;

			if (message.status) {

				var list = message.data;

				var rows = "<option>" + "SELECT" + "</option>";
				document.getElementById("viewstaffNumber").innerHTML = "";

				for (var i = 0; i < list.length; i++) {

					rows += "<option>" + list[i] + "</option>";

				}

				$("#viewstaffNumber").append(rows);

			} else {

				alert(message.message);

			}

		},
		error : function(jqXHR, textStatus, errorThrown) {
			// if fails 
			alert("Server Error")
			e.preventDefault(); // STOP default action
		}
	});

}
function resetAdd() {
	$('#addstaffNumber').val("");
	$('#addstaffPos').val("");
	document.getElementById("addIsHead").checked = false;
	$('#addstaffName').val("");
	$('#addDesignation').val("");
	$('#addAcadamicQulif').val("");
	$('#addProfessionalQulif').val("");
	$('#addEmail').val("");
	$('#addTelephone').val("");
	$('#addLinkedin').val("");
	$('#addFacebook').val("");
	$('#addGooglePlus').val("");
	$('#addDescription').val("");
	$('#addModuleTought').val("");
	$('#addAreaInterest').val("");
	$('#addPublication').val("");

	$("#searchBox1").show();
	$("#searchBox2").hide();
	serverCallForSPID();
}
function resetSearch() {
	$('#viewstaffNumber').val("");
	$('#viewstaffPos').val("");
	document.getElementById("viewIsHead").checked = false;
	$('#viewstaffName').val("");
	$('#viewDesignation').val("");
	$('#viewAcadamicQulif').val("");
	$('#viewProfessionalQulif').val("");
	$('#viewEmail').val("");
	$('#viewTelephone').val("");
	$('#viewLinkedin').val("");
	$('#viewFacebook').val("");
	$('#viewGooglePlus').val("");
	$('#viewDescription').val("");
	$('#viewModuleTought').val("");
	$('#viewAreaInterest').val("");
	$('#viewPublication').val("");

	$("#imageTagSearch").hide();
	$("#updateButton").hide();
	$("#editButton").hide();
	$("#disableButton").hide();
	$("#searchBox1").show();
	$("#searchBox2").hide();
	document.getElementById("searchImage").src = "";

	serverCallForSPIDList();
}

$(document).ready(function() {
	$(".radio-inline").change(function() {
		if (document.getElementById('moduleRadAdd').checked) {
			$("#hideAddModule").show();
			$("#hideSearchModule").hide();
			resetAdd();
		} else {
			$("#hideAddModule").hide();
			$("#hideSearchModule").show();
			resetSearch();
		}
	});
});

function serverCallForSingleSPLoad(index) {
	var postData = {
		staffClick : index
	}
	var formURL = "/DEIE/restRequest/SingleStaffLoad";
	$.ajax({
		url : formURL,
		type : "POST",
		data : postData,
		success : function(data, textStatus, jqXHR) {
			// data: return data from server

			var lecturer = data.selectedLecturer;

			$('#viewstaffNumber').val(lecturer.lecturerId);
			$('#viewstaffPos').val(lecturer.sortOrder);

			if (lecturer.ishead === 1) {
				document.getElementById("viewIsHead").checked = true;
			} else {
				document.getElementById("viewIsHead").checked = false;
			}

			$('#viewstaffName').val(lecturer.name);
			$('#viewDesignation').val(lecturer.designation);
			$('#viewAcadamicQulif').val(lecturer.academicQulifications);
			$('#viewProfessionalQulif')
					.val(lecturer.professionalQualifications);
			$('#viewEmail').val(lecturer.email);
			$('#viewTelephone').val(lecturer.telephone);
			$('#viewLinkedin').val(lecturer.linkedin);
			$('#viewFacebook').val(lecturer.facebook);
			$('#viewGooglePlus').val(lecturer.googlePlus);
			$('#viewDescription').val(lecturer.description);
			$('#viewModuleTought').val(lecturer.modulesTought);
			$('#viewAreaInterest').val(lecturer.areaOfInterest);
			$('#viewPublication').val(lecturer.publications);

			$("#imageTagSearch").show();

			document.getElementById("searchImage").src = "../"
					+ lecturer.imageLink;

			$("#editButton").show();
			$("#disableButton").show();

			if (lecturer.isDisable == 0) {
				document.getElementById("disableButton").innerHTML = "Disable";
			} else {

				document.getElementById("disableButton").innerHTML = "Enable";
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
	$("#viewstaffNumber").change(function() {

		var x = document.getElementById("viewstaffNumber").selectedIndex;
		var selected1 = document.getElementById("viewstaffNumber").options;
		var itemSelected = selected1[x].text;
		if (itemSelected !== "SELECT") {

			serverCallForSingleSPLoad(itemSelected);

		} else {
			resetSearch();
		}
	});

});

$(document).ready(function() {
	$('#disableButton').on('click', function() {

		$("#searchnoticeActionType").val("disableButton");

	});
});

$(document)
		.ready(
				function() {
					$('#editButton')
							.on(
									'click',
									function() {

										$("#searchnoticeActionType").val(
												"editButton");
										$("#updateButton").show();
										$("#disableButton").hide();
										$("#editButton").hide();

										$("#searchBox2").show();
										var x = document
												.getElementById("viewstaffNumber").selectedIndex;
										var selected1 = document
												.getElementById("viewstaffNumber").options;
										var itemSelected = selected1[x].text;

										$('#updatestaffNumber').val(
												itemSelected);
										$('#updatestaffPos').val(
												$('#viewstaffPos').val());

										document.getElementById("updateIsHead").checked = document
												.getElementById("viewIsHead").checked;

										$('#updatestaffName').val(
												$('#viewstaffName').val());
										$('#updateDesignation').val(
												$('#viewDesignation').val());
										$('#updateAcadamicQulif').val(
												$('#viewAcadamicQulif').val());
										$('#updateProfessionalQulif').val(
												$('#viewProfessionalQulif')
														.val());
										$('#updateEmail').val(
												$('#viewEmail').val());
										$('#updateTelephone').val(
												$('#viewTelephone').val());
										$('#updateLinkedin').val(
												$('#viewLinkedin').val());
										$('#updateFacebook').val(
												$('#viewFacebook').val());
										$('#updateGooglePlus').val(
												$('#viewGooglePlus').val());
										$('#updateDescription').val(
												$('#viewDescription').val());
										$('#updateModuleTought').val(
												$('#viewModuleTought').val());
										$('#updateAreaInterest').val(
												$('#viewAreaInterest').val());
										$('#updatePublication').val(
												$('#viewPublication').val());

										$("#searchBox1").hide();

									});
				});

$(document)
		.ready(
				function() {
					$('#updateButton')
							.on(
									'click',
									function() {

										var options = {
											beforeSend : function() {
												// $("#progressbox").show();
												// clear everything
												// $("#progressbar").width('0%');
												if ($('#updatestaffNumber')
														.val() !== ""
														&& $('#updatestaffPos')
																.val() !== ""
														&& $('#updatestaffName')
																.val() !== ""
														&& $(
																'#updateDesignation')
																.val() !== ""
														&& $(
																'#updateAcadamicQulif')
																.val() !== ""
														&& $(
																'#updateProfessionalQulif')
																.val() !== ""
														&& $('#updateEmail')
																.val() !== ""
														&& $('#updateTelephone')
																.val() !== ""
														&& $('#updateLinkedin')
																.val() !== ""
														&& $('#updateFacebook')
																.val() !== ""
														&& $(
																'#updateGooglePlus')
																.val() !== ""
														&& $(
																'#updateDescription')
																.val() !== ""
														&& $(
																'#updateModuleTought')
																.val() !== ""
														&& $(
																'#updatePublication')
																.val() !== ""
														&& $(
																'#updateAreaInterest')
																.val() !== "") {

													$("#Smessage").empty();
													$("#Spercent").html("0%");
													document
															.getElementById("SbPrecentBar").style.width = "0%";
												} else {
													alert("Please Fill all the fields ...");
													event.preventDefault();
												}
											},
											uploadProgress : function(event,
													position, total,
													percentComplete) {
												// $("#progressbar").width(percentComplete
												// + '%');
												$("#Spercent").html(
														percentComplete + '%');
												document
														.getElementById("SbPrecentBar").style.width = percentComplete
														+ "%";
												// change message text to red
												// after 50%
												if (percentComplete > 50) {
													$("#Smessage")
															.html(
																	"<font color='green'>File Upload is in progress</font>");
												}
											},
											success : function(out) {
												// $("#progressbar").width('100%');
												$("#Spercent").html('100%');
												document
														.getElementById("SbPrecentBar").style.width = "100%";

												// document.getElementById("itemList").innerHTML
												// =
												// "";

												alert("Successfully Done ...");
												window.location = "/DEIE/dashBoard/Staff.html";

											},
											complete : function(response) {
												$("#Smessage")
														.html(
																"<font color='blue'>Your file has been uploaded!</font>");

											},
											error : function() {
												$("#Smessage")
														.html(
																"<font color='red'> ERROR: unable to upload files</font>");
											}
										};

										$("#searchModule").ajaxSubmit(options);

									});
				});

$(document)
		.ready(
				function() {

					$('#searchModule')
							.submit(
									function(event) {

										var key = $("#searchnoticeActionType")
												.val();

										if (key === "editButton") {
											event.preventDefault();
											return false;

										} else if (key === "disableButton") {

											$
													.post(
															$(this).attr(
																	'action'),
															$(this).serialize(),
															function(json) {

																if (json.status) {

																	var val = document
																			.getElementById("disableButton").innerHTML;

																	if (val === "Disable") {
																		document
																				.getElementById("disableButton").innerHTML = "Enable";
																	} else {

																		document
																				.getElementById("disableButton").innerHTML = "Disable";
																	}
																	alert(json.message);
																	window.location = "/DEIE/dashBoard/Staff.html";
																}

																else {

																	alert(json.message);
																}

															}, 'json');
											return false;

										} else {

											event.preventDefault();
										}

									});

				});

$(document).ready(function() {

	$("#hideAddModule").show();
	$("#hideSearchModule").hide();

	$("#searchBox1").show();
	$("#searchBox2").hide();

	serverCallForSPID();

});

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
							window.location = "/DEIE/dashBoard/RADevelopment.html";

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
	var formURL = "/DEIE/restRequest/dashBoard/getRnDID";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var message = data;

					if (message.status) {

						document.getElementById("addR&DSupervisor").innerHTML = "";
						document.getElementById("addR&DCoSupervisor").innerHTML = "";
						document.getElementById("addR&DNumber").value = message.data;

						var data2 = message.data2;

						if (data2 !== null) {

							var rows = "<option>" + "SELECT" + "</option>";

							for (var i = 0; i < data2.length; i++) {

								rows += "<option>" + data2[i].name + " :: "
										+ data2[i].lecturerId + "</option>";

							}

							document.getElementById("addR&DSupervisor").innerHTML = rows;
							document.getElementById("addR&DCoSupervisor").innerHTML = rows;

						}

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
	var formURL = "/DEIE/restRequest/dashBoard/getRnDIDList";
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
				document.getElementById("rndNumber1").innerHTML = "";

				for (var i = 0; i < list.length; i++) {

					rows += "<option>" + list[i] + "</option>";

				}

				$("#rndNumber1").append(rows);

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
	$('#addNoticeNumber').val("");
	$('#addNoticeTitle').val("");
	$("#addNoticeDes").val("");
	$("#searchBox1").show();
	$("#searchBox2").hide();
	serverCallForSPID();
}
function resetSearch() {
	$('#noticeNumber').val("");
	$('#searchNoticeTitle').val("");
	$("#searchNoticeDes").val("");
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
		rndClick : index
	}
	var formURL = "/DEIE/restRequest/SinglerndLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var specialSingleNotice = data.specialRND;

					if (specialSingleNotice.nSupervisor !== null
							&& specialSingleNotice.supervisor !== null) {

						var idList = specialSingleNotice.nSupervisor;
						var supervisorMap = specialSingleNotice.supervisor;

						if (idList[0] !== 0)
							$('#viewRnDSupervisor').val(
									supervisorMap[idList[0]] + " :: "
											+ idList[0]);

						else
							$('#viewRnDSupervisor').val("");
						if (idList.length === 2 && idList[1] !== 0)
							$('#viewRnDcoSupervisor').val(
									supervisorMap[idList[1]] + " :: "
											+ idList[1]);

						else
							$('#viewRnDcoSupervisor').val("");

					}

					$('#addRnDTitle1').val(specialSingleNotice.topic);
					$('#addRnDAbstract1').val(
							specialSingleNotice.abstractDetails);
					$('#addRnDYouTubeLink1').val(
							specialSingleNotice.youTubeLink);
					$('#addRnDWebsiteLink1').val(
							specialSingleNotice.websiteLink);
					$('#addRnDKeywords1').val(specialSingleNotice.keywords);
					$('#addRnDMemberNames1').val(
							specialSingleNotice.memberNames);
					$('#RnDDate1').val(specialSingleNotice.date);
					$('#addRnDDes1').val(specialSingleNotice.description);

					$("#imageTagSearch").show();

					var imageCount = specialSingleNotice.imageCount;
					if (imageCount == 1) {

						document.getElementById("searchImage").src = "../"
								+ specialSingleNotice.imageName;

					} else if (imageCount > 1) {

						document.getElementById("imageTagSearch").innerHTML = "<label>Images </label>";
						document.getElementById("searchImage").innerHTML = "";
						var rows = "";

						for (var i = 1; i <= imageCount; i++) {

							if (i == 1) {
								rows += "<img alt='' class='img-responsive' src='"
										+ "../"
										+ specialSingleNotice.imageName
										+ "' />";
							} else {

								var nameMod = specialSingleNotice.imageName;

								nameMod = nameMod.substring(0,
										nameMod.length - 4);

								rows += "<img alt='' class='img-responsive' src='"
										+ "../" + nameMod + i + ".jpg' />";
							}
							rows += "<br>"

						}
						$("#searchImage").append(rows);

					}

					if (specialSingleNotice.isDisable == 0) {
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
	$("#rndNumber1").change(function() {

		var x = document.getElementById("rndNumber1").selectedIndex;
		var selected1 = document.getElementById("rndNumber1").options;
		var itemSelected = selected1[x].text;
		if (itemSelected !== "SELECT") {
			$("#editButton").show();
			$("#disableButton").show();
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
												.getElementById("rndNumber1").selectedIndex;
										var selected1 = document
												.getElementById("rndNumber1").options;
										var itemSelected = selected1[x].text;

										$("#rndNumber2").val(itemSelected);

										$('#addRnDTitle2').val(
												$('#addRnDTitle1').val());
										$('#addRnDAbstract2').val(
												$('#addRnDAbstract1').val());
										$('#addRnDYouTubeLink2').val(
												$('#addRnDYouTubeLink1').val());
										$('#addRnDWebsiteLink2').val(
												$('#addRnDWebsiteLink1').val());
										$('#addRnDKeywords2').val(
												$('#addRnDKeywords1').val());
										$('#addRnDMemberNames2').val(
												$('#addRnDMemberNames1').val());
										$('#dp4').val($('#RnDDate1').val());
										$('#addRnDDes2').val(
												$('#addRnDDes1').val());

										document
												.getElementById("updateRnDSupervisor").innerHTML = document
												.getElementById("addR&DSupervisor").innerHTML;
										document
												.getElementById("updateRnDCoSupervisor").innerHTML = document
												.getElementById("addR&DCoSupervisor").innerHTML;

										var superV = $('#viewRnDSupervisor')
												.val();
										var coSuperV = $('#viewRnDcoSupervisor')
												.val();

										if (superV !== null && superV !== "")
											$('#updateRnDSupervisor').val(
													superV);
										else
											$('#updateRnDSupervisor').val(
													"SELECT");

										if (coSuperV !== null
												&& coSuperV !== "")
											$('#updateRnDCoSupervisor').val(
													coSuperV);
										else
											$('#updateRnDCoSupervisor').val(
													"SELECT");

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
												if ($('#rndNumber2').val() !== ""
														&& $('#addRnDTitle2')
																.val() !== ""
														&& $('#addRnDAbstract2')
																.val() !== ""
														&& $('#addRnDDes2')
																.val() !== ""
														&& $('#dp4').val() !== ""
														&& $(
																'#addRnDMemberNames2')
																.val() !== ""
														&& $('#addRnDKeywords2')
																.val() !== ""
														&& $(
																'#addRnDYouTubeLink2')
																.val() !== ""
														&& $(
																'#addRnDWebsiteLink2')
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
												window.location = "/DEIE/dashBoard/RADevelopment.html";

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
																	window.location = "/DEIE/dashBoard/RADevelopment.html";
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

	$('#dp3').datepicker();
	$('#dp4').datepicker();
	serverCallForSPID();

});

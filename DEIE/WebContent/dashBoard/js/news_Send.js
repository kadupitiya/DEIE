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
							window.location = "/DEIE/dashBoard/News.html";

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
	var formURL = "/DEIE/restRequest/dashBoard/getNewsID";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var message = data;

					if (message.status) {

						document.getElementById("addNoticeNumber").value = message.data;

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
	var formURL = "/DEIE/restRequest/dashBoard/getNewsIDList";
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
				document.getElementById("noticeNumber").innerHTML = "";

				for (var i = 0; i < list.length; i++) {

					rows += "<option>" + list[i] + "</option>";

				}

				$("#noticeNumber").append(rows);

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
		newsClick : index
	}
	var formURL = "/DEIE/restRequest/SingleNewsLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var specialSingleNotice = data.selectedNews;

					$('#searchNoticeTitle').val(specialSingleNotice.title);
					$('#searchNoticeDes').val(specialSingleNotice.description);
					$("#imageTagSearch").show();

					var imageCount = specialSingleNotice.imageCount;
					if (imageCount == 1) {

						document.getElementById("searchImage").src = "../"
								+ specialSingleNotice.imageLink;

					} else if (imageCount > 1) {

						document.getElementById("imageTagSearch").innerHTML = "<label>Images </label>";
						document.getElementById("searchImage").innerHTML = "";
						var rows = "";

						for (var i = 1; i <= imageCount; i++) {

							if (i == 1) {
								rows += "<img alt='' class='img-responsive' src='"
										+ "../"
										+ specialSingleNotice.imageLink
										+ "' />";
							} else {

								var nameMod = specialSingleNotice.imageLink;

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
	$("#noticeNumber").change(function() {

		var x = document.getElementById("noticeNumber").selectedIndex;
		var selected1 = document.getElementById("noticeNumber").options;
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

$(document).ready(function() {
	$('#editButton').on('click', function() {

		$("#searchnoticeActionType").val("editButton");
		$("#updateButton").show();
		$("#disableButton").hide();
		$("#editButton").hide();

		$("#searchBox2").show();
		var x = document.getElementById("noticeNumber").selectedIndex;
		var selected1 = document.getElementById("noticeNumber").options;
		var itemSelected = selected1[x].text;

		$("#SaddNoticeNumber").val(itemSelected);

		var title = $("#searchNoticeTitle").val();
		;

		var des = $("#searchNoticeDes").val();

		$("#SaddNoticeTitle").val(title);

		$("#SaddNoticeDes").val(des);

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
												if ($('#SaddNoticeNumber')
														.val() !== ""
														&& $('#SaddNoticeTitle')
																.val() !== ""
														&& $('#SaddNoticeDes')
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
												window.location = "/DEIE/dashBoard/News.html";

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
																	window.location = "/DEIE/dashBoard/News.html";
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

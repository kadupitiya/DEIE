/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function serverCall() {
	var postData = {
		staffClick : window.localStorage.getItem("staffClick")
	}
	var formURL = "/DEIE/restRequest/SingleStaffLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var selectedLecturer = data.selectedLecturer;

					var projectList = selectedLecturer.reasearchList;

					$('#lecImage').attr('src', selectedLecturer.imageLink);
					$('#linkedIn').attr('href', selectedLecturer.linkedin);
					$('#facebook').attr('href', selectedLecturer.facebook);
					$('#googlePlus').attr('href', selectedLecturer.googlePlus);

					document.getElementById("nameOfLec").innerHTML = selectedLecturer.name;
					document.getElementById("designation").innerHTML = selectedLecturer.designation;
					document.getElementById("academicQulifications").innerHTML = selectedLecturer.academicQulifications;
					document.getElementById("professionalQualifications").innerHTML = selectedLecturer.professionalQualifications;
					document.getElementById("description").innerHTML = selectedLecturer.description;
					document.getElementById("email").innerHTML = '<strong>Email : </strong>'
							+ selectedLecturer.email;
					document.getElementById("telephone").innerHTML = '<strong>Tel : </strong>'
							+ selectedLecturer.telephone;

					$('#linkedIn2').attr('href', selectedLecturer.linkedin);
					$('#facebook2').attr('href', selectedLecturer.facebook);
					$('#googlePlus2').attr('href', selectedLecturer.googlePlus);

					document.getElementById("areaOfInterest").innerHTML = "";
					var array1 = selectedLecturer.areaOfInterest.split("::");
					var textTobeAppended = "";
					for (var i = 0; i < array1.length; i++) {

						textTobeAppended = textTobeAppended
								+ '<li><i class="rounded-x fa fa-angle-right"></i>'
								+ array1[i] + '</li>';
					}
					$("#areaOfInterest").append(textTobeAppended);

					document.getElementById("modulesTought").innerHTML = "";
					var array2 = selectedLecturer.modulesTought.split("::");
					var textTobeAppended2 = "";
					for (var i = 0; i < array2.length; i++) {

						textTobeAppended2 = textTobeAppended2
								+ '<li><i class="rounded-x fa fa-angle-right"></i>'
								+ array2[i] + '</li>';
					}
					$("#modulesTought").append(textTobeAppended2);

					document.getElementById("publications").innerHTML = "";
					var array3 = selectedLecturer.publications.split("::");
					var textTobeAppended3 = "";
					for (var i = 0; i < array3.length; i++) {

						textTobeAppended3 = textTobeAppended3
								+ '<li><p align="justify">' + array3[i]
								+ '</p></li>';
					}
					$("#publications").append(textTobeAppended3);

					// RND List

					document.getElementById("reseachList").innerHTML = "";

					var imageList = "";

					var specialNoticePage = projectList;
					var dataLength = specialNoticePage.length;

					for (var i = 0; i < dataLength; i = i + 1) {

						imageList = imageList
								+ '<div class="container content-1 profile"><br> <br><div class="col-md-11"><div class=""><div class="cbp_tmlabel project"><h2 class="proj">';

						imageList = imageList + specialNoticePage[i].topic;

						imageList = imageList + '</h2><h6>By ( ';

						if (specialNoticePage[i].nSupervisor !== null
								&& specialNoticePage[i].supervisor !== null) {

							var idList = specialNoticePage[i].nSupervisor;
							var supervisorMap = specialNoticePage[i].supervisor;

							for (var l = 0; l < idList.length; l++) {

								imageList = imageList + '<a id="' + idList[l]
										+ '" class="singleItemClick" value="'
										+ idList[l] + '" href="#">'
										+ supervisorMap[idList[l]] + '</a>';
								imageList = imageList + ", ";
							}
						}
						imageList = imageList
								+ specialNoticePage[i].memberNames + " )</h6>"

						imageList = imageList
								+ '<div class="row"><div class="col-md-4"><img class="img-responsive" src="';

						imageList = imageList + specialNoticePage[i].imageName;

						imageList = imageList
								+ '" alt=""><div class="md-margin-bottom-20"></div></div><div class="col-md-8"><p align="justify"><strong>Abstract : </strong>';

						imageList = imageList
								+ specialNoticePage[i].abstractDetails
										.substring(0, 500)
								+ "....."
								+ "</p><p align='justify'><strong>Keywords: </strong>"
								+ specialNoticePage[i].keywords;

						imageList = imageList

								+ "</p><p><strong>WebLink: </strong><a href='"
								+ specialNoticePage[i].websiteLink
								+ "'>"
								+ specialNoticePage[i].websiteLink
								+ "</a></p><p> <strong>Youtube: </strong><a href='"
								+ specialNoticePage[i].youTubeLink + "'>"
								+ specialNoticePage[i].youTubeLink
								+ "</a></p></div></div>";
						imageList = imageList
								+ "<a class='hover-effect'>"
								+ "</a><p align='right'><button class='btn-u btn-u-xs btn-u' type='button' id='idSN"
								+ specialNoticePage[i].researchId + "' value='"
								+ specialNoticePage[i].researchId
								+ "' align= >Read more</button></p></div>";

						imageList = imageList + "</div>";

						imageList = imageList + "</div>";
						imageList = imageList + "</div>";

					}

					$("#reseachList").append(imageList);

					for (var i = 0; i < specialNoticePage.length; i = i + 1) {

						var valId = "#idSN" + specialNoticePage[i].researchId;

						$(valId).on('click', function(event) {

							var clickVal = event.target.value;

							window.localStorage.setItem("rndClick", clickVal);
							window.location = "research_view.html";

						});

					}

					$('.singleItemClick').on('click', function(event) {

						var clickVal = event.target.id;

						window.localStorage.setItem("staffClick", clickVal);
						window.location = "staff_details.html";

					});

				},
				error : function(jqXHR, textStatus, errorThrown) {
					// if fails 
					alert("Server Error")
				}
			});
	e.preventDefault(); // STOP default action

}

$(document).ready(function() {

	serverCall();

});

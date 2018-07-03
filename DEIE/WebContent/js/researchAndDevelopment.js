/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var valuePre = 0;
function serverCall() {
	var postData = {
		key : 'rndLoad'
	}
	var formURL = "/DEIE/restRequest/rndLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					document.getElementById("rndDiv").innerHTML = "";

					var rndList = data.researchAndDevelopmentPage;

					var imageList = "<ul class='timeline-v2'>";

					for (var i = 0; i < rndList.length; i++) {

						imageList = imageList
								+ "<li><time class='cbp_tmtime' datetime=''><span></span><span>"
								+ rndList[i].date
								+ "</span></time> <i class='cbp_tmicon rounded-x hidden-xs'></i><div class='cbp_tmlabel project'>"
								+ "<h2>" + rndList[i].topic + "</h2><h6>By ( ";

						if (rndList[i].nSupervisor !== null
								&& rndList[i].supervisor !== null) {

							var idList = rndList[i].nSupervisor;
							var supervisorMap = rndList[i].supervisor;

							for (var l = 0; l < idList.length; l++) {

								imageList = imageList + '<a id="' + idList[l]
										+ '" class="singleItemClick" value="'
										+ idList[l] + '" href="#">'
										+ supervisorMap[idList[l]] + '</a>';
								imageList = imageList + ", ";
							}
						}
						imageList = imageList + rndList[i].memberNames
								+ " )</h6>"
						imageList = imageList
								+ "<div class='row'><div class='col-md-4'><img class='img-responsive' src='"
								+ rndList[i].imageName
								+ "' alt=''><div class='md-margin-bottom-20'></div></div><div class='col-md-8'><p align='justify'>";

						imageList = imageList
								+ "<strong>Abstract: </strong>"
								+ rndList[i].abstractDetails.substring(0, 450)
								+ "....."
								+ "</p><p align='justify'><strong>Keywords: </strong>"
								+ rndList[i].keywords;

						imageList = imageList

								+ "</p><p><strong>WebLink: </strong><a href='"
								+ rndList[i].websiteLink
								+ "'>"
								+ rndList[i].websiteLink
								+ "</a></p><p> <strong>Youtube: </strong><a href='"
								+ rndList[i].youTubeLink + "'>"
								+ rndList[i].youTubeLink
								+ "</a></p></div></div>";
						imageList = imageList
								+ "<a class='hover-effect'>"
								+ "</a><p align='right'><button class='btn-u btn-u-xs btn-u' type='button' id='idSN"
								+ rndList[i].researchId + "' value='"
								+ rndList[i].researchId
								+ "' align= >Read more</button></p></div></li>";

						imageList = imageList + "</div>";
					}

					imageList = imageList + "</ul>";

					$("#rndDiv").append(imageList);

					for (var i = 0; i < rndList.length; i = i + 1) {

						var valId = "#idSN" + rndList[i].researchId;

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
function serverCallLoadMore() {
	var postData = {
		key : 'rndLoad',
		key2 : 'loadMore'
	}
	var formURL = "/DEIE/restRequest/rndLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {

					document.getElementById("rndDiv").innerHTML = "";

					var rndList = data.researchAndDevelopmentPage;

					var dataLength = rndList.length;

					if (dataLength == valuePre) {

						$('#loadMoreButtonSP').hide();
					} else {

						$('#loadMoreButtonSP').show();
					}

					valuePre = dataLength;

					var imageList = "<ul class='timeline-v2 timeline-change'>";

					for (var i = 0; i < rndList.length; i++) {

						imageList = imageList
								+ "<li><time class='cbp_tmtime' datetime=''><span></span><span>"
								+ rndList[i].date
								+ "</span></time> <i class='cbp_tmicon rounded-x hidden-xs'></i><div class='cbp_tmlabel project'>"
								+ "<h2>" + rndList[i].topic + "</h2><h6>By ( ";

						if (rndList[i].nSupervisor !== null
								&& rndList[i].supervisor !== null) {

							var idList = rndList[i].nSupervisor;
							var supervisorMap = rndList[i].supervisor;

							for (var l = 0; l < idList.length; l++) {

								imageList = imageList + '<a id="' + idList[l]
										+ '" class="singleItemClick" value="'
										+ idList[l] + '" href="#">'
										+ supervisorMap[idList[l]] + '</a>';
								imageList = imageList + ", ";
							}
						}
						imageList = imageList + rndList[i].memberNames
								+ " )</h6>"
						imageList = imageList
								+ "<div class='row'><div class='col-md-4'><img class='img-responsive' src='"
								+ rndList[i].imageName
								+ "' alt=''><div class='md-margin-bottom-20'></div></div><div class='col-md-8'><p align='justify'>";

						imageList = imageList
								+ "<strong>Abstract: </strong>"
								+ rndList[i].abstractDetails.substring(0, 450)
								+ "....."
								+ "</p><p align='justify'><strong>Keywords: </strong>"
								+ rndList[i].keywords;

						imageList = imageList

								+ "</p><p><strong>WebLink: </strong><a href='"
								+ rndList[i].websiteLink
								+ "'>"
								+ rndList[i].websiteLink
								+ "</a></p><p> <strong>Youtube: </strong><a href='"
								+ rndList[i].youTubeLink + "'>"
								+ rndList[i].youTubeLink
								+ "</a></p></div></div>";
						imageList = imageList
								+ "<a class='hover-effect'>"
								+ "</a><p align='right'><button class='btn-u btn-u-xs btn-u' type='button' id='idSN"
								+ rndList[i].researchId + "' value='"
								+ rndList[i].researchId
								+ "' align= >Read more</button></p></div></li>";

						imageList = imageList + "</div>";
					}

					imageList = imageList + "</ul>";

					$("#rndDiv").append(imageList);

					for (var i = 0; i < rndList.length; i = i + 1) {

						var valId = "#idSN" + rndList[i].researchId;

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
	$('#loadMoreButtonSP').on('click', function(event) {

		serverCallLoadMore();

	});

});

$(document).ready(function() {

	serverCall();

});

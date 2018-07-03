/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var valuePre = 0;
function serverCall() {
	var postData = {
		key : 'specialNoticeLoad'
	}
	var formURL = "/DEIE/restRequest/specialNoticeLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					document.getElementById("mainImageSN").innerHTML = "";

					var specialNoticePage = data.specialNoticePage;

					var specialNoticePageCount = data.specialNoticePageCount;

					var mainImage = "<div class='fancybox img-hover-v1' title='"
							+ specialNoticePage[0].title
							+ "'> <span><img"
							+ " class='full-width img-responsive' src='"
							+ specialNoticePage[0].imageLink
							+ "' alt=>"
							+ "</div>";

					$("#mainImageSN").append(mainImage);
					document.getElementById("titleSPM").innerHTML = specialNoticePage[0].title;
					document.getElementById("desSPM").innerHTML = specialNoticePage[0].description;

					document.getElementById("noticeViewID").innerHTML = "";

					var imageList = "";

					var dataLength = specialNoticePage.length;

					for (var i = 0; i < specialNoticePage.length; i = i + 4) {

						imageList = imageList
								+ "<div class='row margin-bottom-20'>";

						for (var j = i; j < i + 4
								&& j < specialNoticePage.length; j++) {

							imageList = imageList
									+ "<div class='col-md-3 col-sm-6'>";
							imageList = imageList
									+ "<div class='thumbnails thumbnail-style thumbnail-kenburn'>";

							imageList = imageList
									+ "<div class='thumbnail-img'>";

							imageList = imageList
									+ "<div class='overflow-hidden'>";
							imageList = imageList
									+ "<img class='img-responsive' src='"
									+ specialNoticePage[j].imageLink
									+ "' alt= >";

							imageList = imageList + "</div>";
							imageList = imageList + "</div>";

							imageList = imageList + "<div class='caption'><h3>";

							imageList = imageList
									+ "<a class='hover-effect'>"
									+ specialNoticePage[j].title.substring(0,
											20)
									+ "..."
									+ "</a></h3><p align='right'><button class='btn-u btn-u-xs btn-u' type='button' id='idSN"
									+ specialNoticePage[j].specialNoticeId
									+ "' value='"
									+ specialNoticePage[j].specialNoticeId
									+ "' align= >Read more</button></p>";

							imageList = imageList + "</div>";

							imageList = imageList + "</div>";
							imageList = imageList + "</div>";

						}

						imageList = imageList + "</div>";
					}
					imageList = imageList + "</div>";

					$("#noticeViewID").append(imageList);

					for (var i = 0; i < specialNoticePage.length; i = i + 1) {

						var valId = "#idSN"
								+ specialNoticePage[i].specialNoticeId;

						$(valId)
								.on(
										'click',
										function(event) {

											var clickVal = event.target.value;

											window.localStorage.setItem(
													"specialNoticeClick",
													clickVal);
											window.location = "special_notices_view.html";

										});

					}

					$('#idSNM').on(
							'click',
							function(event) {

								var clickVal = event.target.value;
								// var id2 =
								// id1.substring(0,
								// id1.length - 1);

								window.localStorage.setItem(
										"specialNoticeClick", clickVal);
								window.location = "special_notices_view.html";

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
		key : 'specialNoticeLoad',
		key2 : 'loadMore'
	}
	var formURL = "/DEIE/restRequest/specialNoticeLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					document.getElementById("mainImageSN").innerHTML = "";

					var specialNoticePage = data.specialNoticePage;

					var specialNoticePageCount = data.specialNoticePageCount;

					var mainImage = "<div class='fancybox img-hover-v1 imgText' title='"
							+ specialNoticePage[0].title
							+ "'> <span><img"
							+ " class='full-width img-responsive' src='"
							+ specialNoticePage[0].imageLink
							+ "' alt=>"
							+ "<h2>"
							+ "	<span>"
							+ specialNoticePage[0].title
							+ " <br>"
							+ "<p align='left' id='textMainImage'>"
							+ specialNoticePage[0].description
							+ "</p></span></h2></span></div>";

					$("#mainImageSN").append(mainImage);

					document.getElementById("noticeViewID").innerHTML = "";

					var imageList = "";

					var dataLength = specialNoticePage.length;

					if (dataLength == valuePre) {

						$('#loadMoreButtonSP').hide();
					} else {

						$('#loadMoreButtonSP').show();
					}

					valuePre = dataLength;

					for (var i = 0; i < specialNoticePage.length; i = i + 4) {

						imageList = imageList
								+ "<div class='row margin-bottom-20'>";

						for (var j = i; j < i + 4
								&& j < specialNoticePage.length; j++) {

							imageList = imageList
									+ "<div class='col-md-3 col-sm-6'>";
							imageList = imageList
									+ "<div class='thumbnails thumbnail-style thumbnail-kenburn'>";

							imageList = imageList
									+ "<div class='thumbnail-img'>";

							imageList = imageList
									+ "<div class='overflow-hidden'>";
							imageList = imageList
									+ "<img class='img-responsive' src='"
									+ specialNoticePage[j].imageLink
									+ "' alt= >";

							imageList = imageList + "</div>";
							imageList = imageList + "</div>";

							imageList = imageList + "<div class='caption'><h3>";

							imageList = imageList
									+ "<a class='hover-effect'>"
									+ specialNoticePage[j].title.substring(0,
											20)
									+ "..."
									+ "</a></h3><p align='right'><button class='btn-u btn-u-xs btn-u' type='button' id='idSN"
									+ specialNoticePage[j].specialNoticeId
									+ "' value='"
									+ specialNoticePage[j].specialNoticeId
									+ "' align= >Read more</button></p>";

							imageList = imageList + "</div>";

							imageList = imageList + "</div>";
							imageList = imageList + "</div>";

						}

						imageList = imageList + "</div>";
					}
					imageList = imageList + "</div>";

					$("#noticeViewID").append(imageList);

					for (var i = 0; i < specialNoticePage.length; i = i + 1) {

						var valId = "#idSN"
								+ specialNoticePage[i].specialNoticeId;

						$(valId)
								.on(
										'click',
										function(event) {

											var clickVal = event.target.value;
											// var id2 =
											// id1.substring(0,
											// id1.length - 1);

											window.localStorage.setItem(
													"specialNoticeClick",
													clickVal);
											window.location = "special_notices_view.html";

										});

					}

					$('#idSNM').on(
							'click',
							function(event) {

								var clickVal = event.target.value;
								// var id2 =
								// id1.substring(0,
								// id1.length - 1);

								window.localStorage.setItem(
										"specialNoticeClick", clickVal);
								window.location = "special_notices_view.html";

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

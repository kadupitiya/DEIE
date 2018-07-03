/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function serverCall() {
	var postData = {
		newsClick : window.localStorage.getItem("newsClick")
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

					document.getElementById("mainImageSN").innerHTML = "";

					var sliderV = "<div class='carousel slide carousel-v2' id='portfolio-carousel' ><ol class='carousel-indicators'>";

					for (var i = 0; i < specialSingleNotice.imageCount; i++) {

						if (i == 0) {

							sliderV = sliderV
									+ "<li class='active rounded-x' data-target='#portfolio-carousel' data-slide-to='"
									+ i + "'></li>";

						} else {
							sliderV = sliderV
									+ "<li class='rounded-x' data-target='#portfolio-carousel' data-slide-to='"
									+ i + "'></li>";
						}

					}

					sliderV = sliderV + "</ol><div class='carousel-inner'>";

					for (var i = 1; i <= specialSingleNotice.imageCount; i++) {

						if (i == 1) {

							sliderV = sliderV
									+ "<div class='item active'><img class='full-width img-responsive' src='";

							sliderV = sliderV + specialSingleNotice.imageLink;

							sliderV = sliderV + "'></div>";

						} else {

							sliderV = sliderV
									+ "<div class='item'><img class='full-width img-responsive' src='";

							var nameMod = specialSingleNotice.imageLink;

							nameMod = nameMod.substring(0, nameMod.length - 4);

							sliderV = sliderV + nameMod + i + ".jpg"

							+ "'></div>";

						}

					}

					sliderV = sliderV
							+ "</div><a class='left carousel-control rounded-x' href='#portfolio-carousel' role='button' data-slide='prev'><i class='fa fa-angle-left arrow-prev'></i>"
							+ "</a> <a class='right carousel-control rounded-x' href='#portfolio-carousel' role='button' data-slide='next'><i class='fa fa-angle-right arrow-next'></i></a></div>";

					$("#mainImageSN").append(sliderV);

					document.getElementById("titleSP").innerHTML = specialSingleNotice.title;
					document.getElementById("descSP").innerHTML = specialSingleNotice.description;

				},
				error : function(jqXHR, textStatus, errorThrown) {
					// if fails 
					alert("Server Error")
				}
			});

}

function serverCallForLeft() {
	var postData = {
		key : 'newsLoad'
	}
	var formURL = "/DEIE/restRequest/newsLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var specialNoticePage = data.newsPage;

					var specialNoticePageCount = data.newsPageCount;

					document.getElementById("noticeViewID").innerHTML = "";

					var imageList = "";

					var dataLength = specialNoticePage.length;

					for (var i = 0; i < 3; i = i + 4) {

						for (var j = i; j < i + 4 && j < 3; j++) {

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
									+ specialNoticePage[j].newsId + "' value='"
									+ specialNoticePage[j].newsId
									+ "' align= >Read more</button></p>";

							imageList = imageList + "</div>";

							imageList = imageList + "</div>";
							imageList = imageList + "</div>";

						}

					}
					imageList = imageList + "</div>";

					$("#noticeViewID").append(imageList);

					for (var i = 0; i < specialNoticePage.length; i = i + 1) {

						var valId = "#idSN" + specialNoticePage[i].newsId;

						$(valId).on('click', function(event) {

							var clickVal = event.target.value;
							// var id2 =
							// id1.substring(0,
							// id1.length - 1);

							window.localStorage.setItem("newsClick", clickVal);
							window.location = "news_and_events_view.html";

						});

					}

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
	serverCallForLeft();

});

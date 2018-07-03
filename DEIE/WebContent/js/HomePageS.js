/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function serverCallForNews() {
	var postData = {
		key2 : "specialNewsPage"
	}
	var formURL = "/DEIE/restRequest/SingleNewsLoadMainPage";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var specialSingleNotice = data.homePage;

					document.getElementById("newsTitle0").innerHTML = specialSingleNotice[0].title.substring(0, 20)+"...";
					$('#newsImage0').attr("src",
							specialSingleNotice[0].imageLink)
					$("#idNW0").data("key", specialSingleNotice[0].newsId);

					document.getElementById("newsTitle1").innerHTML = specialSingleNotice[1].title.substring(0, 20)+"...";
					$('#newsImage1').attr("src",
							specialSingleNotice[1].imageLink)
					$("#idNW1").data("key", specialSingleNotice[1].newsId);

					document.getElementById("newsTitle2").innerHTML = specialSingleNotice[2].title.substring(0, 20)+"...";
					$('#newsImage2').attr("src",
							specialSingleNotice[2].imageLink)
					$("#idNW2").data("key", specialSingleNotice[2].newsId);

					document.getElementById("newsTitle3").innerHTML = specialSingleNotice[3].title.substring(0, 20)+"...";
					$('#newsImage3').attr("src",
							specialSingleNotice[3].imageLink)
					$("#idNW3").data("key", specialSingleNotice[3].newsId);

				},
				error : function(jqXHR, textStatus, errorThrown) {
					// if fails 
					alert("Server Error")
				}
			});
	e.preventDefault(); // STOP default action

}

function serverCall() {
	var postData = {
		key2 : "specialMainPage"
	}
	var formURL = "/DEIE/restRequest/specialSingleNoticeLoadMainPage";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					var specialSingleNotice = data.homePage;

					document.getElementById("specialNoticeTitle").innerHTML = specialSingleNotice[0].title;
					document.getElementById("specialNoticeDescription").innerHTML = specialSingleNotice[0].description;
					$('#specialNoticeImage').attr("src",
							specialSingleNotice[0].imageLink)

					// document.getElementById("idSN1").value =
					// specialSingleNotice[0].specialNoticeId ;

					$("#idSN1").data("key",
							specialSingleNotice[0].specialNoticeId);
					// alert($("#idSN1").data("key"));

					document.getElementById("specialNoticeTitle2").innerHTML = specialSingleNotice[1].title;
					document.getElementById("specialNoticeDescription2").innerHTML = specialSingleNotice[1].description;
					$('#specialNoticeImage2').attr("src",
							specialSingleNotice[1].imageLink)
					$("#idSN2").data("key",
							specialSingleNotice[1].specialNoticeId);
					
					serverCallForNews();

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

function buttonClick(event) {

	var clickVal = "#" + event.target.id;

	var data1 = $(clickVal).data("key");

	window.localStorage.setItem("specialNoticeClick", data1);
	window.location = "special_notices_view.html";

}
function buttonClickNews(event) {

	var clickVal = "#" + event.target.id;

	var data1 = $(clickVal).data("key");

	window.localStorage.setItem("newsClick", data1);
	window.location = "news_and_events_view.html";

}

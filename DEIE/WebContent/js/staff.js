/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var valuePre = 0;
function serverCall() {
	var postData = {
		key : 'rndLoad'
	}
	var formURL = "/DEIE/restRequest/staffLoad";
	$
			.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					// data: return data from server

					document.getElementById("departmentHead").innerHTML = "";

					var staffDetails = data.pageList;

					var departmentHead = data.departmentHead;

					var headOfDepartment = '<div class="row"><div class="col-md-5"><img class="img-responsive md-margin-bottom-10" src="'
							+ departmentHead.imageLink
							+ '" alt=""></div><div class="col-md-7"><h2>Head of the Department</h2><span><strong>';

					headOfDepartment = headOfDepartment + departmentHead.name
							+ '</strong> </span> <span><strong></strong>'
							+ departmentHead.academicQulifications
							+ '</span><hr><p align="justify">'
							+ departmentHead.description
							+ '</p><p><strong>Email : </strong>'
							+ departmentHead.email
							+ '</p><p><strong>Tel : </strong>'
							+ departmentHead.telephone + '</p></div></div>';

					$("#departmentHead").append(headOfDepartment);

					document.getElementById("contentLoad").innerHTML = "";

					var imageList = '<div class="content-md team-v1 col-padding row  margin-bottom-30"><ul class="list-unstyled row">';

					var dataLength = staffDetails.length;

					for (var i = 0; i < dataLength; i = i + 3) {

						imageList = imageList
								+ '<ul class="list-unstyled row">';

						for (var j = i; j < i + 3 && j < dataLength; j++) {

							imageList = imageList
									+ '<li class="col-sm-4 col-xs-6 md-margin-bottom-30"><div class="team-img"><img class="img-responsive"src="';

							imageList = imageList
									+ staffDetails[j].imageLink
									+ '" alt=""><ul><li><a href="'
									+ staffDetails[j].linkedin
									+ '"><i class="icon-custom icon-sm rounded-x fa fa-linkedin"></i></a></li><li><a href="'
									+ staffDetails[j].facebook
									+ '"><i class="icon-custom icon-sm rounded-x fa fa-facebook"></i></a></li><li><a href="'
									+ staffDetails[j].googlePlus
									+ '"><i class="icon-custom icon-sm rounded-x fa fa-google-plus"></i></a></li></ul></div><h3><a id="'
									+ staffDetails[j].lecturerId
									+ '" class="singleItemClick" value="'
									+ staffDetails[j].lecturerId
									+ '" href="#">';

							imageList = imageList + staffDetails[j].name
									+ '</a></h3><h4>'
									+ staffDetails[j].academicQulifications
									+ '</h4><h5>' + staffDetails[j].designation
									+ '</h5><p><strong>Email :</strong>'
									+ staffDetails[j].email
									+ '<br> <strong>Tel:</strong>'
									+ staffDetails[j].telephone + '</p></li>';

						}
						imageList = imageList + '</ul>';
					}
					imageList = imageList + '</div>';

					$("#contentLoad").append(imageList);

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

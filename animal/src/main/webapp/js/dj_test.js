/*사진 리스트 출력*/
$.ajax({

	url : '../Education/education/ajax/list.do',
	dataType : 'json',
	type : "get",
	contentType : "multipart/form-data",
	cache : true,
	success : function(resultObj) {
		var div = $("#subtable");
		for(var education of resultObj.data) {
			education.filename = "p6.jpeg";
			var check1 = education.filename.split(".");
			$("<div class='boxsub1 gallery mix " + education.eduSpec + "'>")
			.html(
					"<div class='card'>"+
					"<div class='background detailLnk' eduNo='" + education.eduNo + "'>"+
					"<img src='../images/p6.jpeg' width='325px;' height='410px;' />"+
					"</div>"+
					"<a class='overlay detailLnk' href='#' eduNo='"
					+ education.eduNo + "' ></a> " + 
					"<i class='fa fa-camera-retro'></i>"+
					"</a> <a class='thumb' href='#'></a>"+
					"<div class='infosub'>"+
					"<h2>"+
					"<a class='detailLnk' eduNo='" + education.eduNo + "' href='#'>" + education.eduTitle + "</a>"+
					"</h2>"+
					"<div class='foot'>"+
					"<i class='line'></i> <span class='date'>" + education.eduCreateDate + "</span>"+
					"<span id='view-like'><i class='fa fa-eye'></i> " + education.eduViews + 
					"</span>"+
					"</div>"+
					"</div>"+
			"</div>")
			.appendTo(div);
			console.log(education.eduTitle);

		}
		$("a.detailLnk").click(clickDetailLnk);
	}
}); 

function clickDetailLnk(event) {
	event.preventDefault(); 
	location.href = "edu_form.html?eduNo=" + $(event.target).attr("eduNo");
}

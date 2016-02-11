
$.getJSON('../boastboard/ajax/rank.do', function(resultObj) {
    console.log(resultObj);
	var div = $("#section-img");
	var topcheck1;

	var length = resultObj.data.length;

	if (resultObj.data.length == 1) {
		length = 1;
	} else if (resultObj.data.length == 2) {
		length = 2;
	} else if (resultObj.data.length >= 3) {
		length = 3;
	}
	var setClass;
	for(var i = 0; i < length; i++ ) {
		topcheck1 = resultObj.data[i].filename.split(".");
		topcheck1 = topcheck1.slice(1,2).toString().toLowerCase();

		if(topcheck1 == "jpg" ||
      topcheck1 == "jpeg" ||
      topcheck1 == "png" ||
      topcheck1 == "gif" ||
      topcheck1 == "bmp") {

			console.log("가로 : " + resultObj.size[i].width);
			console.log("세로 : " + resultObj.size[i].height);
			if (resultObj.size[i].width > resultObj.size[i].height) {
				setClass="landscape";
			} else {
				setClass="portrait";
			}

			$("<div class='box1 gallery'>")
			.html(
					"<div class='card'>" +
					"<div class='background'>" +
					"<img src='../files/" + resultObj.data[i].filename + "' class='" + setClass + "'>" +
					"</div>" +
					"<a href='#' class='overlay' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>" +
					"<a href='#' class='icon-camera' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>" +
					"<i class='fa fa-camera-retro'></i>" +
					"</a>" +
					"<a class='thumb' href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>" +
					"<div class='info'>" +
					"<h2>" +
					"<a href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>" + resultObj.data[i].title + "</a>" +
					"</h2>" +
					"<div class='foot'>" +
					"<i class='line'></i>" +
					"<span class='date'>"+resultObj.data[i].createDate+"</span>" +
					"<span class='view-like'>" +
					"<i class='fa fa-eye'></i> "+resultObj.data[i].view +
					" <i class='fa fa-thumbs-o-up'></i> "+resultObj.data[i].like +
					"</span>" +
					"</div>" +
					"</div>" +
			"</div>")
			.appendTo(div);


		} else if (topcheck1 == "avi" ||
				topcheck1 == "wmv" ||
				topcheck1 == "mp4" ||
				topcheck1 == "mkv" ||
				topcheck1 == "wav") {

			console.log("가로 : " + resultObj.size[i].width);
			console.log("세로 : " + resultObj.size[i].height);
			if (resultObj.size[i].width > resultObj.size[i].height) {
				setClass="landscape";
			} else {
				setClass="portrait";
			}

			$("<div class='box1 gallery'>")
			.html(
					"<div class='card'>" +
					"<div class='background'>" +
					"<img src='../files/" + resultObj.data[i].filename + "' class='" + setClass + "'>" +
					"</div>" +
					"<a href='#' class='overlay' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>" +
					"<a href='#' class='icon-youtube' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>" +
					"<i class='fa fa-youtube-play'></i>" +
					"</a>" +
					"<a class='thumb' href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>" +
					"<div class='info'>" +
					"<h2>" +
					"<a href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>" + resultObj.data[i].title + "</a>" +
					"</h2>" +
					"<div class='foot'>" +
					"<i class='line'></i>" +
					"<span class='date'>" + resultObj.data[i].createDate + "</span>" +
					"<span class='view-like'>" +
					"<i class='fa fa-eye'></i> "+resultObj.data[i].view +
					" <i class='fa fa-thumbs-o-up'></i> "+resultObj.data[i].like +
					"</span>" +
					"</div>" +
					"</div>" +
			"</div>")
			.appendTo(div);
		}
	}

});



/*사진 리스트 출력*/
$(document).ready(function() {

	/* list Ajax 시작 */
	$.ajax({
		url: "../boastboard/ajax/list.do?",
		dataType: "json",
		type: "POST",
		async: "false",
		success:
			function(resultObj) {
			$("#subtable").empty();
			var div = $("#subtable");

			console.log("불러온 데이터 갯수....." + resultObj.data.length);

			var setClass;
			for(var i = 0; i < resultObj.data.length; i++ ) {
				var check1 = resultObj.data[i].filename.split(".");
				check1 = check1.slice(1,2).toString().toLowerCase();

				if(check1 == "jpg" ||
						check1 == "jpeg" ||
						check1 == "png" ||
						check1 == "gif" ||
						check1 == "bmp") {
					console.log("가로 : " + resultObj.size[i].width);
					console.log("세로 : " + resultObj.size[i].height);
					if (resultObj.size[i].width > resultObj.size[i].height) {
						setClass="landscape";
					} else {
						setClass="portrait";
					}

					$("<div class='boxsub1 gallery mix " +resultObj.data[i].pSpec + "'>")
					.html(
							"<div class='card'>" +
							"<div class='background'>" +
							"<img src='../files/" + resultObj.data[i].filename + "' class='" + setClass + "' />" +
							"</div>"+
							"<a href='#' class='overlay' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a> " +
							"<a href='#' class='icon-camera' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>"+
							"<i class='fa fa-camera-retro'></i>"+
							"</a> <a class='thumb' href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>"+
							"<div class='infosub'>"+
							"<h2>"+
							"<a href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>"+resultObj.data[i].title+"</a>"+
							"</h2>"+
							"<div class='foot'>"+
							"<i class='line'></i> <span class='date'>"+resultObj.data[i].createDate+"</span>"+
							"<span class='view-like'><i class='fa fa-eye'></i> "+resultObj.data[i].view+
							" <i class='fa fa-thumbs-o-up'></i> "+ resultObj.data[i].like +" </span>"+
							"</div>"+
							"</div>"+
					"</div>").appendTo(div);
				} else if (check1 == "avi" ||
						check1 == "wmv" ||
						check1 == "mp4" ||
						check1 == "mkv" ||
						check1 == "wav") {

					console.log("가로 : " + resultObj.size[i].width);
					console.log("세로 : " + resultObj.size[i].height);
					if (resultObj.size[i].width > resultObj.size[i].height) {
						setClass="landscape";
					} else {
						setClass="portrait";
					}
					$("<div class='boxsub1 gallery mix "+resultObj.data[i].pSpec+"'>")
					.html(
							"<div class='card'>"+
							"<div class='background'>"+
							"<img src='../files/"+resultObj.data[i].filename+"' class='" + setClass + "' />"+
							"</div>"+
							"<a href='#' class='overlay' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>" +
							"</a> <a href='#' class='icon-youtube' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>"+
							"<i class='fa fa-youtube-play'></i>"+
							"</a> <a class='thumb' href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>"+
							"<div class='infosub'>"+
							"<h2>"+
							"<a href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>"+resultObj.data[i].title+"</a>"+
							"</h2>"+
							"<div class='foot'>"+
							"<i class='line'></i> <span class='date'>"+resultObj.data[i].createDate+"</span>"+
							"<span class='view-like'><i class='fa fa-eye'></i> "+resultObj.data[i].view+
							" <i class='fa fa-thumbs-o-up'></i> "+ resultObj.data[i].like +" </span>"+
							"</div>"+
							"</div>"+
					"</div>").appendTo(div);
				}
			}

		}

	});
	/* list Ajax 종료 */

});/*마지막지점*/



/* more 페이징 */
$(document).ready(function() {
	/* count ajax 실행 */
	var currentPage = 1;
	var totalPage = 0;


	$.ajax({
		url:"../boastboard/ajax/count.do",
		dataType: "json",
		async: "json",
		type: "GET",
		success: function(resultObj) {
			totalPage = resultObj.count;
			if(totalPage == 1 || totalPage == 0) {
				$('#moreBtn-Origin').empty();
			}
		}
	});

	$('.moreBtn').click(function(event) {


		if(currentPage < totalPage) {
			currentPage = currentPage + 1;
			console.log("List/현재 currentPage...." + currentPage);

			/*Paging ajax 실행*/
			$.ajax({

				url:"../boastboard/ajax/list.do?pageNo="+currentPage,
				dataType: "json",
				type: "POST",
				async: "false",
				success:
					function(resultObj) {
					/* $("#subtable").empty(); */
					var div = $("#subtable");
					console.log("불러온 데이터 갯수....." + resultObj.data.length);

					var setClass;
					for(var i = 0; i < resultObj.data.length; i++ ) {
						var check1 = resultObj.data[i].filename.split(".");
						check1 = check1.slice(1,2).toString().toLowerCase();
						if(check1 == "jpg" ||
								check1 == "jpeg" ||
								check1 == "png" ||
								check1 == "gif" ||
								check1 == "bmp") {

							console.log("가로 : " + resultObj.size[i].width);
							console.log("세로 : " + resultObj.size[i].height);
							if (resultObj.size[i].width > resultObj.size[i].height) {
								setClass="landscape";
							} else {
								setClass="portrait";
							}

							$("<div class='boxsub1 gallery mix " +resultObj.data[i].pSpec + "'>")
							.html(
									"<div class='card'>" +
									"<div class='background'>" +
									"<img src='../files/" + resultObj.data[i].filename + "' class='" + setClass + "' />" +
									"</div>"+
									"<a href='#' class='overlay' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>" +
									"<a href='#' class='icon-camera' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>"+
									"<i class='fa fa-camera-retro'></i>"+
									"</a> <a class='thumb' href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>"+
									"<div class='infosub'>"+
									"<h2>"+
									"<a href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>"+resultObj.data[i].title+"</a>"+
									"</h2>"+
									"<div class='foot'>"+
									"<i class='line'></i> <span class='date'>"+resultObj.data[i].createDate+"</span>"+
									"<span class='view-like'><i class='fa fa-eye'></i> "+resultObj.data[i].view+
									" <i class='fa fa-thumbs-o-up'></i> "+ resultObj.data[i].like +" </span>"+
									"</div>"+
									"</div>"+
							"</div>").appendTo(div);
						} else if (check1 == "avi" ||
								check1 == "wmv" ||
								check1 == "mp4" ||
								check1 == "mkv" ||
								check1 == "wav") {

							console.log("가로 : " + resultObj.size[i].width);
							console.log("세로 : " + resultObj.size[i].height);
							if (resultObj.size[i].width > resultObj.size[i].height) {
								setClass="landscape";
							} else {
								setClass="portrait";
							}

							$("<div class='boxsub1 gallery mix "+resultObj.data[i].pSpec+"'>")
							.html(
									"<div class='card'>"+
									"<div class='background'>"+
									"<img src='../files/"+resultObj.data[i].filename+"' class='" + setClass + "' />"+
									"</div>"+
									"<a href='#' class='overlay' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a> "+
									"<a href='#' class='icon-youtube' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>"+
									"<i class='fa fa-youtube-play'></i>"+
									"</a> <a class='thumb' href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'></a>"+
									"<div class='infosub'>"+
									"<h2>"+
									"<a href='#' onclick='detailBoastBoard("+resultObj.data[i].dno+")'>"+resultObj.data[i].title+"</a>"+
									"</h2>"+
									"<div class='foot'>"+
									"<i class='line'></i> <span class='date'>"+resultObj.data[i].createDate+"</span>"+
									"<span class='view-like'><i class='fa fa-eye'></i> "+resultObj.data[i].view+
									" <i class='fa fa-thumbs-o-up'></i> "+ resultObj.data[i].like +" </span>"+
									"</div>"+
									"</div>"+
							"</div>").appendTo(div);
						}
					}



				}/* List Load function(resultObj) 끝 */

			});/*List Load ajax 끝*/

			if(currentPage == totalPage) {
				$('#more').css({"border":"0px"});
				$('#moreBtn-Origin').empty();
			}

		} /* IF문 끝 */

		else if(currentPage == totalPage) {
			alert("더이상 페이지가 존재하지 않습니다.");
			console.log("더이상 페이지가 존재하지 않습니다.");
		}


	});
});/*마지막지점*/

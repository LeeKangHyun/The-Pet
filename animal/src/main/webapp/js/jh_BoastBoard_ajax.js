/*사진 리스트 출력*/
$.getJSON('../boastboard/ajax/list.do', function(resultObj) {
	var div = $("#subtable");
	for(var i = 0; i < resultObj.data.length - 1; i = i + 4 ) {

		$("<div class='boxsub1 gallery'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i].fileName+"' width='325px;' height='410px;' />"+
				"</div>"+
				"<a href='#' class='overlay'></a> <a href='#'>"+ 
				"<i class='fa fa-youtube-play'></i>"+
				"</a> <a class='thumb' href='#'></a>"+
				"<div class='infosub'>"+
				"<h2>"+
				"<a href='#'>"+resultObj.data[i].title+"</a>"+
				"</h2>"+
				"<div class='foot'>"+
				"<i class='line'></i> <span class='date'>"+resultObj.data[i].createDate+"</span>"+
				"<span id='view-like'><i class='fa fa-eye'></i> "+resultObj.data[i].view+
				" <i class='fa fa-thumbs-o-up'></i> "+ resultObj.data[i].like +" </span>"+
				"</div>"+
				"</div>"+
		"</div>")
		.appendTo(div);

		if(resultObj.data.length - 1 == i) {
			break;
		}


		$("<div class='boxsub2 gallery'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+1].fileName+"' width='325px;' height='410px;' />"+
				"</div>"+
				"<a href='#' class='overlay'></a> <a href='#'>"+ 
				"<i class='fa fa-youtube-play'></i>"+
				"</a> <a class='thumb' href='#'></a>"+
				"<div class='infosub'>"+
				"<h2>"+
				"<a href='#'>"+resultObj.data[i+1].title+"</a>"+
				"</h2>"+
				"<div class='foot'>"+
				"<i class='line'></i> <span class='date'>"+resultObj.data[i+1].createDate+"</span>"+
				"<span id='view-like'><i class='fa fa-eye'></i> "+resultObj.data[i+1].view+
				" <i class='fa fa-thumbs-o-up'></i> "+ resultObj.data[i+1].like +" </span>"+
				"</div>"+
				"</div>"+
		"</div>")
		.appendTo(div);

		if(resultObj.data.length - 1 == (i+1)) {
			break;
		}

		$("<div class='boxsub3 gallery'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+2].fileName+"' width='325px;' height='410px;' />"+
				"</div>"+
				"<a href='#' class='overlay'></a> <a href='#'>"+ 
				"<i class='fa fa-youtube-play'></i>"+
				"</a> <a class='thumb' href='#'></a>"+
				"<div class='infosub'>"+
				"<h2>"+
				"<a href='#'>"+resultObj.data[i+2].title+"</a>"+
				"</h2>"+
				"<div class='foot'>"+
				"<i class='line'></i> <span class='date'>"+resultObj.data[i+2].createDate+"</span>"+
				"<span id='view-like'><i class='fa fa-eye'></i> "+resultObj.data[i+2].view+
				" <i class='fa fa-thumbs-o-up'></i> "+ resultObj.data[i+2].like +" </span>"+
				"</div>"+
				"</div>"+
		"</div>")
		.appendTo(div);

		if(resultObj.data.length - 1 == (i + 2)) {
			break;
		}

		$("<div class='boxsub4 gallery'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+3].fileName+"' width='325px;' height='410px;' />"+
				"</div>"+
				"<a href='#' class='overlay'></a> <a href='#'>"+ 
				"<i class='fa fa-youtube-play'></i>"+
				"</a> <a class='thumb' href='#'></a>"+
				"<div class='infosub'>"+
				"<h2>"+
				"<a href='#'>"+resultObj.data[i+3].title+"</a>"+
				"</h2>"+
				"<div class='foot'>"+
				"<i class='line'></i> <span class='date'>"+resultObj.data[i+3].createDate+"</span>"+
				"<span id='view-like'><i class='fa fa-eye'></i> "+resultObj.data[i+3].view+
				" <i class='fa fa-thumbs-o-up'></i> "+ resultObj.data[i+3].like+" </span>"+
				"</div>"+
				"</div>"+
		"</div>")
		.appendTo(div);

		if(resultObj.data.length - 1 == (i + 3)) {
			break;
		}

	}
}); 
/*사진 리스트 출력 끝*/




$.getJSON('../boastboard/ajax/rank.do', function(resultObj) {
	
	var div = $("#rank-section");
	
	
	
	$("<div class='box1 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[0].fileName+"' width='325px;'"+
			"height='410px;' />"+
			"</div>"+
			"<a href='' class='overlay'> </a> <a href='#'>" +
			"<i class='fa fa-camera-retro'></i>"+
			"</a> <a class='thumb' href='#'></a>"+
			"<div class='info'>"+
			"<h2>"+
			"<a href='#3'>"+resultObj.data[0].title+"</a>"+
			"</h2>"+
			"<div class='foot'>"+
			"<i class='line'></i> <span class='date'>"+resultObj.data[0].createDate+"</span>"+
			"<span id='view-like'><i class='fa fa-eye'></i> "+resultObj.data[0].view+" <i class='fa fa-thumbs-o-up'></i> "+resultObj.data[0].like+" </span>"+
			"</div>"+
			"</div>"+
			"</div>")
			.appendTo(div);
	
	$("<div class='box2 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[1].fileName+"' width='325px;'"+
			"height='410px;' />"+
			"</div>"+
			"<a href='' class='overlay'> </a> <a href='#'>" +
			"<i class='fa fa-camera-retro'></i>"+
			"</a> <a class='thumb' href='#'></a>"+
			"<div class='info'>"+
			"<h2>"+
			"<a href='#3'>"+resultObj.data[1].title+"</a>"+
			"</h2>"+
			"<div class='foot'>"+
			"<i class='line'></i> <span class='date'>"+resultObj.data[1].createDate+"</span>"+
			"<span id='view-like'><i class='fa fa-eye'></i> "+resultObj.data[1].view+" <i class='fa fa-thumbs-o-up'></i> "+resultObj.data[1].like+" </span>"+
			"</div>"+
			"</div>"+
			"</div>")
			.appendTo(div);
	
	$("<div class='box3 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[2].fileName+"' width='325px;'"+
			"height='410px;' />"+
			"</div>"+
			"<a href='' class='overlay'> </a> <a href='#'>" +
			"<i class='fa fa-camera-retro'></i>"+
			"</a> <a class='thumb' href='#'></a>"+
			"<div class='info'>"+
			"<h2>"+
			"<a href='#3'>"+resultObj.data[0].title+"</a>"+
			"</h2>"+
			"<div class='foot'>"+
			"<i class='line'></i> <span class='date'>"+resultObj.data[2].createDate+"</span>"+
			"<span id='view-like'><i class='fa fa-eye'></i> "+resultObj.data[2].view+" <i class='fa fa-thumbs-o-up'></i> "+resultObj.data[2].like+" </span>"+
			"</div>"+
			"</div>"+
			"</div>")
			.appendTo(div);

}); 


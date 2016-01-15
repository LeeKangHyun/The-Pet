/*사진 리스트 출력*/
$.getJSON('../boastboard/ajax/list.do', function(resultObj) {
	var div = $("#subtable");
	for(var i = 0; i < resultObj.data.length - 1; i = i + 4 ) {

		
		
		
        
		var check1 = resultObj.data[i].filename.split(".");
        check1 = check1.slice(1,2);
        if(check1 == "jpg" ||
           check1 == "jpeg" ||
           check1 == "png" ||
           check1 == "gif" ||
           check1 == "bmp") { 
		$("<div class='boxsub1 gallery mix "+resultObj.data[i].pSpec+"'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i].filename+"' width='325px;' height='410px;' />"+
				"</div>"+
				"<a href='#' class='overlay'></a> <a href='#'>"+ 
				"<i class='fa fa-camera-retro'></i>"+
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
    } else if (check1 == "aiv" ||
               check1 == "wmv" ||
               check1 == "mp4" ||
               check1 == "mkv" ||
               check1 == "wav") {
               $("<div class='boxsub1 gallery mix "+resultObj.data[i].pSpec+"'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i].filename+"' width='325px;' height='410px;' />"+
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
		.appendTo(div);}

		if(resultObj.data.length - 1 == i) {
			break;
		}

    
    
        
        
        
        
    
        
        
        
        var check2 = resultObj.data[i+1].filename.split(".");
        check2 = check2.slice(1,2);
        if(check2 == "jpg" ||
           check2 == "jpeg" ||
           check2 == "png" ||
           check2 == "gif" ||
           check2 == "bmp") { 
		$("<div class='boxsub1 gallery mix "+resultObj.data[i+1].pSpec+"'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+1].filename+"' width='325px;' height='410px;' />"+
				"</div>"+
				"<a href='#' class='overlay'></a> <a href='#'>"+ 
				"<i class='fa fa-camera-retro'></i>"+
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
        } else if (check1 == "aiv" ||
               check2 == "wmv" ||
               check2 == "mp4" ||
               check2 == "mkv" ||
               check2 == "wav") {
            $("<div class='boxsub1 gallery mix "+resultObj.data[i+1].pSpec+"'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+1].filename+"' width='325px;' height='410px;' />"+
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
		.appendTo(div); }
                

		if(resultObj.data.length - 1 == (i+1)) {
			break;
		}

        
        
        
        
        
        
        
        
        var check3 = resultObj.data[i+2].filename.split(".");
        check3 = check3.slice(1,2);
        if(check3 == "jpg" ||
           check3 == "jpeg" ||
           check3 == "png" ||
           check3 == "gif" ||
           check3 == "bmp") { 
		$("<div class='boxsub1 gallery mix "+resultObj.data[i+2].pSpec+"'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+2].filename+"' width='325px;' height='410px;' />"+
				"</div>"+
				"<a href='#' class='overlay'></a> <a href='#'>"+ 
				"<i class='fa fa-camera-retro'></i>"+
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
        } else if (check3 == "aiv" ||
               check3 == "wmv" ||
               check3 == "mp4" ||
               check3 == "mkv" ||
               check3 == "wav") {
            $("<div class='boxsub1 gallery mix "+resultObj.data[i+2].pSpec+"'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+2].filename+"' width='325px;' height='410px;' />"+
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
        }

		if(resultObj.data.length - 1 == (i + 2)) {
			break;
		}
        
        
        
        
        
        
        
        
        var check4 = resultObj.data[i+3].filename.split(".");
        check4 = check4.slice(1,2);
        if(check4 == "jpg" ||
           check4 == "jpeg" ||
           check4 == "png" ||
           check4 == "gif" ||
           check4 == "bmp") { 
		$("<div class='boxsub1 gallery mix "+resultObj.data[i+3].pSpec+"'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+3].filename+"' width='325px;' height='410px;' />"+
				"</div>"+
				"<a href='#' class='overlay'></a> <a href='#'>"+ 
				"<i class='fa fa-camera-retro'></i>"+
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
        } else if(check4 == "aiv" ||
               check4 == "wmv" ||
               check4 == "mp4" ||
               check4 == "mkv" ||
               check4 == "wav"){ 
		$("<div class='boxsub1 gallery mix "+resultObj.data[i+3].pSpec+"'>")
		.html(
				"<div class='card'>"+
				"<div class='background'>"+
				"<img src='../images/"+resultObj.data[i+3].filename+"' width='325px;' height='410px;' />"+
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
        } 

		if(resultObj.data.length - 1 == (i + 3)) {
			break;
		}

        
        
        
	}
}); 
/*사진 리스트 출력 끝*/




$.getJSON('../boastboard/ajax/rank.do', function(resultObj) {
	
	var div = $("#rank-section");
	
	
    var topcheck1 = resultObj.data[0].filename.split(".");
    topcheck1 = topcheck1.slice(1,2);
    if(topcheck1 == "jpg" ||
        topcheck1 == "jpeg" ||
        topcheck1 == "png" ||
        topcheck1 == "gif" ||
        topcheck1 == "bmp") { 
	$("<div class='box1 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[0].filename+"' width='325px;'"+
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
    } else if (topcheck1 == "aiv" ||
               topcheck1 == "wmv" ||
               topcheck1 == "mp4" ||
               topcheck1 == "mkv" ||
               topcheck1 == "wav") {
        $("<div class='box1 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[0].filename+"' width='325px;'"+
			"height='410px;' />"+
			"</div>"+
			"<a href='' class='overlay'> </a> <a href='#'>" +
			"<i class='fa fa-youtube-play'></i>"+
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
    }
        
        
        
        
    var topcheck2 = resultObj.data[1].filename.split(".");
    topcheck2 = topcheck2.slice(1,2);
    if(topcheck2 == "jpg" ||
        topcheck2 == "jpeg" ||
        topcheck2 == "png" ||
        topcheck2 == "gif" ||
        topcheck2 == "bmp") { 
	$("<div class='box2 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[1].filename+"' width='325px;'"+
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
    } else if (topcheck2 == "aiv" ||
               topcheck2 == "wmv" ||
               topcheck2 == "mp4" ||
               topcheck2 == "mkv" ||
               topcheck2 == "wav") {
        $("<div class='box2 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[1].filename+"' width='325px;'"+
			"height='410px;' />"+
			"</div>"+
			"<a href='' class='overlay'> </a> <a href='#'>" +
			"<i class='fa fa-youtube-play'></i>"+
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
    }
        
        
        
	
        var topcheck3 = resultObj.data[1].filename.split(".");
    topcheck3 = topcheck3.slice(1,2);
    if(topcheck3 == "jpg" ||
        topcheck3 == "jpeg" ||
        topcheck3 == "png" ||
        topcheck3 == "gif" ||
        topcheck3 == "bmp") { 
	$("<div class='box3 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[2].filename+"' width='325px;'"+
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
        } else if (topcheck3 == "aiv" ||
               topcheck3 == "wmv" ||
               topcheck3 == "mp4" ||
               topcheck3 == "mkv" ||
               topcheck3 == "wav") {
            $("<div class='box3 gallery'>")
	.html("<div class='card'>"+
			"<div class='background'>"+
			"<img src='../images/"+resultObj.data[2].filename+"' width='325px;'"+
			"height='410px;' />"+
			"</div>"+
			"<a href='' class='overlay'> </a> <a href='#'>" +
			"<i class='fa fa-youtube-play'></i>"+
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
        } 

}); 


$.getJSON('../boastboard/ajax/rank.do', function(resultObj) {

	var div = $("#rank-section");
	var topcheck1;
	for(var i = 0; i < 3; i++ ) {
		topcheck1 = resultObj.data[i].filename.split(".");
		topcheck1 = topcheck1.slice(1,2);
		if(topcheck1 == "jpg" ||
				topcheck1 == "jpeg" ||
				topcheck1 == "png" ||
				topcheck1 == "gif" ||
				topcheck1 == "bmp") {

			$("<div class='box1 gallery'>")
			.html(
					"<div class='card'>" +
					"<div class='background'>" +
					"<img src='../images/" + resultObj.data[i].filename + "'>" +
					"</div>" +
					"<a href='' class='overlay'></a>" + 
					"<a href='#'>" +
					"<i class='fa fa-camera-retro'></i>" +
					"</a>" +
					"<a class='thumb' href='#'></a>" +
					"<div class='info'>" +
					"<h2>" +
					"<a href='#3'>" + resultObj.data[i].title + "</a>" +
					"</h2>" +
					"<div class='foot'>" +
					"<i class='line'></i>" + 
					"<span class='date'>"+resultObj.data[i].createDate+"</span>" +
					"<span class='view-like'>" + 
					"<i class='fa fa-thumbs-o-up'></i>" + resultObj.data[i].like + 
					"<i class='fa fa-eye'></i>" + resultObj.data[i].view + 
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

			$("<div class='box1 gallery'>")
			.html(
					"<div class='card'>" +
					"<div class='background'>" +
					"<img src='../images/" + resultObj.data[i].filename + "'>" + 
					"</div>" +
					"<a href='' class='overlay'></a>" +
					"<a href='#'>" +
					"<i class='fa fa-youtube-play'></i>" +
					"</a>" +
					"<a class='thumb' href='#'></a>" +
					"<div class='info'>" +
					"<h2>" +
					"<a href='#3'>" + resultObj.data[i].title + "</a>" +
					"</h2>" +
					"<div class='foot'>" +
					"<i class='line'></i>" + 
					"<span class='date'>" + resultObj.data[i].createDate + "</span>" +
					"<span class='view-like'>" +
					"<i class='fa fa-eye'>" + "</i>" + resultObj.data[i].view + 
					"<i class='fa fa-thumbs-o-up'></i>" + resultObj.data[i].like + 
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
    
    /* count Ajax 시작 */
        	  $.ajax({
    		  url: "../boastboard/ajax/count.do",
    		  dataType: "json",
    		  async: "false",
    		  type: "GET",
    		  success:	function(resultObj) {
    			  /* page function 시작 */
    			    var pag = $('#pagination').simplePaginator({
    			        totalPages:resultObj.count,
    			        maxButtonsVisible: 5,
    			        clickCurrentPage: true,
    			        pageChange: function(page) {
    			        	/* list Ajax 시작 */
    			            $.ajax({
    			            	
    			            	url: "../boastboard/ajax/list.do?pageNo="+page,
    			                dataType: "json",
    			                type: "POST",
    			                async: "false",
    			                success:
    			                	function(resultObj) {
    			                	$("#subtable").empty();
    			                	$("#HIDDEN").trigger("click");
    			                	$("#All").trigger("click");
    			            		var div = $("#subtable");
    			            		console.log(resultObj.data.length);
    			            		

    			                      
    			                  		for(var i = 0; i < resultObj.data.length; i++ ) {
    			                			var check1 = resultObj.data[i].filename.split(".");
    			                			check1 = check1.slice(1,2);
    			                			if(check1 == "jpg" ||
    			                					check1 == "jpeg" ||
    			                					check1 == "png" ||
    			                					check1 == "gif" ||
    			                					check1 == "bmp") { 
    			                				$("<div class='boxsub1 gallery mix " +resultObj.data[i].pSpec + "'>")
    			                				.html(
    			                						"<div class='card'>" +
    			                						"<div class='background'>" +
    			                						"<img src='../images/" + resultObj.data[i].filename + "' width=325px; height=410px; />" +
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
    			        	
    			        	
    			        	
    			        	
    			        	
    			        	
    			        	
    			        	
    			        	
    			        	
    			        	
    			        	
    			        	
    			        }
    			      });
/* 첫번째 page function 종료 */
    			      $('#changeTotalPages').click(function() {
    			        pag.simplePaginator('setTotalPages', 10);
    			      })

    			      $('#changePage').click(function() {
    			        pag.simplePaginator('changePage', 3);
    			      })

    			      $('#hide').click(function() {
    			        pag.simplePaginator('hide');
    			      })
    			      
    		  }/*count ajax success 끝나는 지점*/
    	  })/*count ajax 끝나는 지점*/
});/*마지막지점*/
    
	
    

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Slid Menu</title>
<!--  내가만든 css들  -->
<link href="../css/sh_slidmenu_header.css" type="text/css"
	rel="stylesheet" />



<!--  폰트아이콘 링크  -->
<link href="../lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="../css/icon-font.min.css" rel="stylesheet" />

<!-- 캘린더 css -->
<link href="../lib/bootstrap/dist/css/bootstrap.css" rel='stylesheet'
	type='text/css' />

<!-- 캘린더 스크립트 -->

<script src='../lib/jquery/jquery.min.js'></script>

<!-- 지호가 만든 css -->
<link href="../css/jh_search.css" type="text/css" rel="stylesheet">
<link href="../css/jh_pictures.css" type="text/css" rel="stylesheet">

</head>

<body>
	<header>
		<div class="header_title">
			<a href="diary.html">THE PET</a>
		</div>
	</header>

	<section>

		<!--  메뉴 버튼  -->
		<input type="checkbox" id="menuToggle" />

		<div class="menu">
			<label for="menuToggle" class="menu-icon"><i
				class="fa fa-bars fa-lg"></i></label>
			<!--  메뉴 내용  -->

			<nav class="menu-nav">
				<ul class="menu-nav-ul">
					<li><a href="#"><i class="lnr lnr-pencil"></i> 교육</a></li>
					<li><a href="#"><i class="lnr lnr-store"></i> 분양</a></li>
					<li><a href="#"><i class="lnr lnr-heart"></i> 짝짓기</a></li>
					<li><a href="#"><i class="lnr lnr-leaf"></i> 산책코스</a></li>
					<li><a href="BoastBoard/list.do"><i class="lnr lnr-paw"></i>
							자랑해요</a></li>
					<li><a href="diary.html"><i class="lnr lnr-book"></i> 다이어리</a></li>
				</ul>
			</nav>
			<!--  //메뉴 내용  -->
		</div>


		<div id="main-body">

			<!-- 위의 제목 부분 -->
			<span id="boastname"><i class="fa fa-camera"></i> 자랑하기</span> 
			<span id="top3"><i class="fa fa-thumbs-o-up"></i> Top 3</span>
			<!-- 위의 제목 부분 끝 -->


      <!-- Top 3 영역 시작 -->
			<table>
				<tr>
					<td>
						<!-- 사진 표현하는  툴 -->
						<div class="box gallery">
							<div class="card">
								<div class="background">
									<img alt="" src="../images/h1.jpg" width="325px;"
										height="410px;" />
								</div>
								<a href="#" class="overlay"> </a> <a href="#"> <i
									class="fa fa-camera-retro"></i>
								</a> <a class="thumb" href="#"></a>
								<div class="info">
									<h2>
										<a href="#">사진 테스트 중, 어떤가요??? </a>
									</h2>
									<div class="foot">
										<i class="line"></i> <span class="date">2016.01.06</span>
										<!-- 좋아요 or Views를 넣을 공간! -->
									</div>
								</div>
							</div>
						</div> <!-- 사진 표현하는  툴 끝 -->
					</td>

					<td>
						<!-- 사진 표현하는  툴 -->
						<div class="box gallery">
							<div class="card">
								<div class="background">
									<img alt="" src="../images/h2.jpg" width="325px;"
										height="410px;" />
								</div>
								<a href="#" class="overlay"> </a> <a href="#"> <i
									class="fa fa-camera-retro"></i>
								</a> <a class="thumb" href="#"></a>
								<div class="info">
									<h2>
										<a href="#">사진 테스트 중, 어떤가요??? </a>
									</h2>
									<div class="foot">
										<i class="line"></i> <span class="date">2016.01.06</span>
										<!-- 좋아요 or Views를 넣을 공간! -->
									</div>
								</div>
							</div>
						</div> <!-- 사진 표현하는  툴 끝 -->
					</td>
					
					<td>
						<!-- 사진 표현하는  툴 -->
						<div class="box gallery">
							<div class="card">
								<div class="background">
									<img alt="" src="../images/h2.jpg" width="325px;"
										height="410px;" />
								</div>
								<a href="#" class="overlay"> </a> <a href="#"> <i
									class="fa fa-camera-retro"></i>
								</a> <a class="thumb" href="#"></a>
								<div class="info">
									<h2>
										<a href="#">사진 테스트 중, 어떤가요??? </a>
									</h2>
									<div class="foot">
										<i class="line"></i> <span class="date">2016.01.06</span>
										<!-- 좋아요 or Views를 넣을 공간! -->
									</div>
								</div>
							</div>
						</div> <!-- 사진 표현하는  툴 끝 -->
					</td>
				</tr>
			</table>
			<!-- Top 3 영역 끝 -->

      <!-- Top 3 영역 밑 라인 -->
			<hr>



			<!-- 검색하는 툴  -->
			<div class="search">
				<input type="text" />
				<div class="close">
					<span class="front"></span> <span class="back"></span>
				</div>
			</div>
			<!-- 검색하는 툴 끝 -->


      <!-- 사진 게시물 영역 -->
			<div id=subtable>
				<table>
					<c:forEach var="boastboard" items="${boastboards}">
						<tr>
							<td>
								<!-- 사진 표현하는  툴 -->
								<div class="boxsub gallery">
									<div class="card">
										<div class="background">
											<img alt="" src="../images/${boastboard.fileName}" width="325px;"
												height="410px;" />
										</div>
										<a href="#" class="overlay"> </a> <a href="#"> <i
											class="fa fa-camera-retro"></i>
										</a> <a class="thumb" href="#"></a>
										<div class="infosub">
											<h2>
												<a href="#">${boastboard.title}</a>
											</h2>
											<div class="foot">
												<i class="line"></i> <span class="date">${boastboard.createDate.toLocaleString()}</span>
												<!-- 좋아요 or Views를 넣을 공간! -->
											</div>
										</div>
									</div>
								</div> <!-- 사진 표현하는  툴 끝 -->
							</td>
							<td>
								<!-- 사진 표현하는  툴 -->
								<div class="boxsub gallery">
									<div class="card">
										<div class="background">
											<img alt="" src="../images/${boastboard.fileName}" width="325px;"
												height="410px;" />
										</div>
										<a href="#" class="overlay"> </a> <a href="#"> <i
											class="fa fa-youtube-play"></i>
										</a> <a class="thumb" href="#"></a>
										<div class="infosub">
											<h2>
												<a href="#">${boastboard.title}</a>
											</h2>
											<div class="foot">
												<i class="line"></i> <span class="date">${boastboard.createDate.toLocaleString()}</span>
												<!-- 좋아요 or Views를 넣을 공간! -->
											</div>
										</div>
									</div>
								</div> <!-- 사진 표현하는  툴 끝 -->
							</td>
							<td>
								<!-- 사진 표현하는  툴 -->
								<div class="boxsub gallery">
									<div class="card">
										<div class="background">
											<img alt="" src="../images/${boastboard.fileName}" width="325px;"
												height="410px;" />
										</div>
										<a href="#" class="overlay"> </a> <a href="#"> <i
											class="fa fa-camera-retro"></i>
										</a> <a class="thumb" href="#"></a>
										<div class="infosub">
											<h2>
												<a href="#">사진 테스트 중, 어떤가요???</a>
											</h2>
											<div class="foot">
												<i class="line"></i> <span class="date">${boastboard.createDate.toLocaleString()}</span>
												<!-- 좋아요 or Views를 넣을 공간! -->
											</div>
										</div>
									</div>
								</div> <!-- 사진 표현하는  툴 끝 -->
							</td>
							<td>
								<!-- 사진 표현하는  툴 -->
								<div class="boxsub gallery">
									<div class="card">
										<div class="background">
											<img alt="" src="../images/${boastboard.fileName}" width="325px;"
												height="410px;" />
										</div>
										<a href="#" class="overlay"> </a> <a href="#"> <i
											class="fa fa-youtube-play"></i>
										</a> <a class="thumb" href="#"></a>
										<div class="infosub">
											<h2>
												<a href="#">사진 테스트 중, 어떤가요??? </a>
											</h2>
											<div class="foot">
												<i class="line"></i> <span class="date">${boastboard.createDate.toLocaleString()}</span>
												<!-- 좋아요 or Views를 넣을 공간! -->
											</div>
										</div>
									</div>
								</div> <!-- 사진 표현하는  툴 끝 -->
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- 사진 게시물 영역 끝 -->
			
		</div>
	</section>
</body>
</html>

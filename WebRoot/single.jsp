<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.Video.entity.VideoInfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>视频详情</title>
	
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
	
	<!-- Owl Carousel Assets -->
    <link href="owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="owl-carousel/owl.theme.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="font-awesome-4.4.0/css/font-awesome.min.css"  type="text/css">
	
	<!-- jQuery and Modernizr-->
	<script src="js/jquery-2.1.1.js"></script>
	
	<!-- Core JavaScript Files -->  	 
    <script src="js/bootstrap.min.js"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<header>
	<% 
		
		List<VideoInfo> hvideo = (List<VideoInfo>)request.getAttribute("hvideo");
		VideoInfo video = (VideoInfo)request.getAttribute("video");
	%>
	<!--Top-->
	<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-sm-6">
					<strong>Welcome to Video!</strong>
				</div>
				<div class="col-md-6 col-sm-6">
					<ul class="list-inline top-link link">
						<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
						<li><a href="#"><i class="fa fa-comments"></i> Contact</a></li>
						<li><a href="#"><i class="fa fa-question-circle"></i> FAQ</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	
	<!--Navigation-->
    <nav id="menu" class="navbar">
		<div class="container">
			<div class="navbar-header"><span id="heading" class="visible-xs">Categories</span>
			  <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="Getvideos"><i class="fa fa-home"></i> 主页</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> 账户</a>
						<div class="dropdown-menu">
							<div class="dropdown-inner">
								<ul class="list-unstyled">
									<li><a href="login.jsp">登录</a></li>
									<li><a href="register.jsp">注册</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li><a href="Getcat?Cat=dy"><i class="fa fa-play-circle-o"></i> 电影</a>
						
					</li>
					<li ><a href="Getcat?Cat=ty"><i class="fa fa-list"></i> 体育</a>
					</li>
					<li><a href="Getcat?Cat=zy"><i class="fa fa-cubes"></i> 综艺</a></li>
					<li><a href="Getcat?Cat=dm"><i class="fa fa-envelope"></i> 动漫</a></li>
					<li><a href="Getcat?Cat=dsj"><i class="fa fa-envelope"></i> 电视剧</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="header-slide">
		<div id="owl-demo" class="owl-carousel">
		
		<%
		for(VideoInfo videos:hvideo){
		 %>
			<div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span><%= videos.Cat %></span>
						<a href="Getsingle?VID=<%= videos.VID %>">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p><%= videos.Title %></p>
					</div>
					<img src="images/2.jpg" />
				</div>
			</div>
			
			<%
			}
			 %>
			 
		</div>
	</div>
</header>
<!-- Header -->
	
	<!-- /////////////////////////////////////////Content -->
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div id="main-content" class="col-md-8">
					<div class="wrap-vid">
						<video controls="controls" autoplay="autoplay" style="width: 737px;height: 400px;">
							<source src="<%= video.Url %>" type="video/mp4"> </source>
						</video>
					</div>
					
					<div class="line"></div>
					<h1 class="vid-name"><a href="#"><%= video.Title %></a></h1>
					<div class="info">
						<h5>By <a href="#">admin</a></h5>
						
						<span><i class="fa fa-heart"></i><%=video.Cnum %></span>
					</div>
					<p style="margin-top: 20px"><%= video.Jj %>.</p>
					
					<div class="line"></div>
					<div class="comment">
						<h3>留言</h3>
						<form name="form1" method="post" action="">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
									<input type="text" class="form-control input-lg" name="name" id="name" placeholder="Enter name" required="required" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="email" class="form-control input-lg" name="email" id="email" placeholder="Enter email" required="required" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<textarea name="message" id="message" class="form-control" rows="4" cols="25" required="required"
										placeholder="Message"></textarea>
									</div>						
									<button type="submit" class="btn btn-4 btn-block" name="btnSend" id="btnSend">
								Send</button>
								</div>
							</div>
						</form>
					</div>
					<div class="line"></div>
					
				</div>
				<div id="sidebar" class="col-md-4">
					<!---- Start Widget ---->
					<div class="widget wid-follow">
						<div class="heading"><h4><i class="fa fa-users"></i> Follow Us</h4></div>
						<div class="content">
							
							<img src="images/banner.jpg" />
						</div>
						<div class="line"></div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-post">
						<div class="heading"><h4><i class="fa fa-globe"></i> Category</h4></div>
						<div class="content">
							<div class="post wrap-vid">
								<div class="zoom-container">
									<div class="zoom-caption">
										<span>Video's Tag</span>
										<a href="single.html">
											<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
										</a>
										<p>Video's Name</p>
									</div>
									<img src="images/7.jpg" />
								</div>
								<div class="wrapper">
									<h5 class="vid-name"><a href="#">Video's Name</a></h5>
									<div class="info">
										<h6>By <a href="#">Kelvin</a></h6>
										<span><i class="fa fa-calendar"></i>25/3/2015</span> 
										<span><i class="fa fa-heart"></i>1,200</span>
									</div>
								</div>
							</div>
							<div class="post wrap-vid">
								<div class="zoom-container">
											<div class="zoom-caption">
												<span>Video's Tag</span>
												<a href="single.html">
													<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
												</a>
												<p>Video's Name</p>
											</div>
											<img src="images/8.jpg" />
										</div>
								<div class="wrapper">
									<h5 class="vid-name"><a href="#">Video's Name</a></h5>
									<div class="info">
										<h6>By <a href="#">Kelvin</a></h6>
										<span><i class="fa fa-calendar"></i>25/3/2015</span> 
										<span><i class="fa fa-heart"></i>1,200</span>
									</div>
								</div>
							</div>
							<div class="post wrap-vid">
								<div class="zoom-container">
									<div class="zoom-caption">
										<span>Video's Tag</span>
										<a href="single.html">
											<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
										</a>
										<p>Video's Name</p>
									</div>
									<img src="images/9.jpg" />
								</div>
								<div class="wrapper">
									<h5 class="vid-name"><a href="#">Video's Name</a></h5>
									<div class="info">
										<h6>By <a href="#">Kelvin</a></h6>
										<span><i class="fa fa-calendar"></i>25/3/2015</span> 
										<span><i class="fa fa-heart"></i>1,200</span>
									</div>
								</div>
							</div>
						</div>
						<div class="line"></div>
					</div>
					<!---- Start Widget ---->
					
				</div>
			</div>
		</div>
	</div>

	<footer>
		
		<div class="wrap-footer">
			<div class="container">
				
			</div>
		</div>
		<div class="bottom-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-6 copyright">
						<span>Copyright © 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">网页模板</a></span>
					</div>
					<div class="col-md-6 col-sm-6 link">
						<div class="menu-footer-menu-container">
							<ul id="menu-footer-menu" class="menu list-inline">
								<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
								<li><a href="#"><i class="fa fa-comments"></i> Contact</a></li>
								<li><a href="#"><i class="fa fa-question-circle"></i> FAQ</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</footer>
	<!-- Footer -->
	
	<!-- JS -->
	<script src="owl-carousel/owl.carousel.js"></script>
    <script>
    $(document).ready(function() {
      $("#owl-demo").owlCarousel({
        autoPlay: 3000,
        items : 5,
        itemsDesktop : [1199,4],
        itemsDesktopSmall : [979,4]
      });

    });
    </script>
	
</body>
</html>

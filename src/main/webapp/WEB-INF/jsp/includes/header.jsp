<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- 
<header class="header">
	<div class="container">
	<div class="title">
					<a href="<%=request.getContextPath() %>/"> 
						앱 스캔 결과 레포팅 사이트		
					</a>
				</div>
	</div>
	<div class="outer">
		<div class="inner">
			<div class="centered">
				
			</div>
		</div>
	</div>		
</header>
--%>

	<div class="navbar-wrapper">
		<div class="container">
			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="<%=request.getContextPath()%>/issue/index">AppScanResult</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="<%=request.getContextPath()%>/issue/index"><spring:message code="label.menu1.text"/></a></li>
							<li><a href="<%=request.getContextPath()%>/project/index"><spring:message code="label.menu2.text"/></a></li>
							<!-- <li><a href="#contact">Contact</a></li>
							<li><a href="#dropdown">Etc</a></li> -->
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<div class="container">
					<div class="carousel-caption">
						<h1>
						<spring:message code="label.title.site"/></h1>
						<p>
							<a href="<%=request.getContextPath()%>/js/lib/android/android.html"
							target="_blank">
							<code> Sample:  Report Sample URL</code>
							</a><br/>
							<spring:message code="label.subtitle.description1" /> <br/>
							<spring:message code="label.subtitle.description2" />
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

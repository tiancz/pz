<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>programmer</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<link rel="stylesheet" href="http://localhost:8080/pz/views/css/common/nav.css" type="text/css" />
<style type="text/css">
 #container {
 	width:500px;
 	margin:45px 30px 25px 200px;
 	}
 #user_icon {margin:0px 30px 15px -50px;}
 #abstract {margin:-40px 30px 5px 0px;}
</style>
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js">
</script>
<script>
	$(document).ready(function(){
	});
</script>
</head>
<body>
<div class="nav">
	<div class="menu">
		<ul>
			<li><a href="/zone/home/home"><i class="fa fa-home fa-fw"></i>首页</a></li>
			<li><a href="/zone/note/archive"><i class="fa fa-archive fa-fw"></i>归档</a></li>
			<li><a href="/zone/note/category"><i class="fa fa-th fa-fw"></i>分类</a></li>
			<li><a href="/zone/note/tag"><i class="fa fa-tags fa-fw"></i>标签</a></li>
			<li><a href="/zone/about"><i class="fa fa-user fa-fw"></i>关于</a></li>
		</ul>
	</div>
</div>

<div class="wrapper">
<div id="inputBox">
	<ul>
		<li><a href="#">写篇技术文章</a></li>
		<li></li>
		<li></li>
	</ul>
</div>
<p>
<div id="res"></div>
<p>
<div id="container">
  <div id="content">
	内容:
	<br>
	<c:forEach items="${moments}" var="moment">
		moment:
		<c:out value="${moment.momentContent}"/>
		<br>
	</c:forEach>
    <div id="content_footer">footer</div>
  </div>
</div>
</div>
</body>
</html>
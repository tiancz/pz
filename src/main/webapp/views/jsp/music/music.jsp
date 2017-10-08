<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>Music</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<style type="text/css">
</style>
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js">
</script>
<script>

</script>
</head>
<body>
<div class="nav">
	<ul>
		<li><a href="/cola/home/home">说句话</a></li>
		<li><a href="/cola/photo/photo">发照片</a></li>
		<li><a href="/cola/note/createNote">写随笔</a></li>
		<li><a href="/cola/note/checkNote">看随笔</a></li>
		<li><a href="/cola/programmer/programmer">程序猿</a></li>
		<li><a href="/cola/music/music">听音乐</a></li>
		<li><a href="/cola/movie/movie">看电影</a></li>
	</ul>
</div>
<div class="wrapper">
<p>
	<h1>music</h1>
	<p>
	<a href="/cola/movie" >movie</a>
</div>
</body>
</html>
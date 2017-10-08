<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<div class="nav">
	<ul>
		<li><a href="/cola/home/home">Home</a></li>
		<li><a href="/cola/moment/moment">说句话</a></li>
		<li><a href="/cola/photo/photo">发照片</a></li>
		<li><a href="/cola/note/createNote">写随笔</a></li>
		<li><a href="/cola/note/checkNote">看随笔</a></li>
		<li><a href="/cola/programmer/programmer">程序猿</a></li>
		<li><a href="/cola/music/music">听音乐</a></li>
		<li><a href="/cola/movie/movie">看电影</a></li>
	</ul>
</div>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>new note</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<style type="text/css">
 #article_foot a{
 	color:#080808;
 }
</style>
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js">
</script>
<script>
	$(document).ready(function(){
	});
</script>
</head>
<body bgcolor="#f0f0f0">
<jsp:include flush="true" page="/views/jsp/common/nav.jsp" />
<div class="wrapper">
	<div id="article">
		<h1 align="center">日记</h1>
			${note.articleTitle}<P>
			<h6>${note.articleContent}</h6><P>
			${note.category}<P>
			<div id="article_foot">
				<span><a href="/cola/note/edit/${note.articleId}">修改</a></span>
				&nbsp;&nbsp;&gt;&gt;
				<span><a href="/cola/note/delete/${note.articleId}">删除</a></span>
			</div>
	</div>
</div>
</body>
</html>
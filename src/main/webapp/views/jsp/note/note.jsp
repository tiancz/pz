<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>Blog Programming</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<style type="text/css">
 body{font-family:Verdana,Arial,Helvetica,sans-serif;}
 body .blog {
 	margin:0px 16px 0px 200px;
 }
 body .blogTitle {
 	margin:20 0 10 0;
 	font-weight:bolder;
 	color:#000;
 }
 body .blogCon {margin:0;line-height:1.3;font-size:10pt;}
 body .blogFoot {text-align:right;padding-bottom:20;}
 .sideBar{float:left;width:220px;height:100px;}
 .blogFoot a{
 	color:#0f0f0f;
 }
 .blogFoot a:hover{
 	color:#0082ff;
 	cursor:pointer;
 }
</style>
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js"></script>
<script>
	/* $(document).ready(function(){
	}); */

	function update(){
		alert(123);
	}
</script>
</head>
<body>

<jsp:include flush="true" page="/views/jsp/common/nav.jsp" />

<div class="wrapper">
<p>
<div class="main">
	<div class="sideBar"></div>
	<div class="blog">
  		<div class="blogTitle" style="font-size:16;">
  			android开发中的数据库SQLite的使用
		</div>
  		<div class="blogCon" style="font-size:16;">摘要: 其实学习android很久了，关于数据存储，之前学习的时候也一同学习过，编程这些东西很久没用都忘得差不多了，最近做个项目要用到，所以又学习了一遍。android中关于数据<p>的存储有好几种，这次主要是SQLite的使用。首先说一点，我的技术很烂，原理什么的不说了，就是讲一下怎么使用，包括“增删改查”这几...
  			<a>阅读全文</a>
  		</div>
  		<div class="blogFoot" style="font-size:16;">
  			posted @ 2015-03-11 13:58 楚莫言 阅读(201) 评论(0) 
  			<a href="/cola/note/edit">编辑</a>
  		</div>
	</div>
	<c:forEach items="${notes}" var="note">
		<div class="blog">
  			<div class="blogTitle">
  				<c:out value="${note.articleTitle}"/>
  			</div>
			<div class="blogCon" style="font-size:16;">
				<c:out value="${note.articleContent}"/>
  			</div>
  			<div class="blogFoot">
  				posted @<c:out value="${note.userName}"/>&nbsp;&nbsp;<c:out value="${note.dateCreated}"/> 阅读(<c:out value="${note.countComment}"/>) 评论(<c:out value="${note.countComment}"/>) 
  				<a href="javascript:void(0);" onclick="update();">编辑</a>
  			</div>
		</div>
	</c:forEach>
</div>
</div>
</body>
</html>
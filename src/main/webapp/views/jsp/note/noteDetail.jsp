<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>Blog Programming</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>/views/static/css/font-awesome.min.css" type="text/css" />
<style type="text/css">
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
	<div class="content">
		<div class="blog">
			<div class="blogTitle">
				<ul>
					<li>
						<c:out value="${article.title}"/>
					</li>
				</ul>
			</div>
			<div class="info">
				<span class="date" style="color:#4a86e8">write by <c:out value="${article.dateUpdated}"/></span>
			</div>
			<div class="blogCon">
				<c:out value="${article.content}"/>
			</div>
 			<div class="blogFoot">
 				posted @<c:out value="${article.author}"/>&nbsp;&nbsp;<c:out value="${note.dateCreated}"/> 阅读(<c:out value="${note.countComment}"/>) 评论(<c:out value="${note.countComment}"/>) 
 				<a href="javascript:void(0);" onclick="update();">编辑</a>
 			</div>
		</div>
	</div>
</div>
</body>
</html>
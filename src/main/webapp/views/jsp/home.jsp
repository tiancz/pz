<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>your homepage</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>/views/static/css/font-awesome.min.css" type="text/css" />
<style type="text/css">
.blog{
	margin:50px 150px 50px 150px;
	width:90%;
}
.blog .title{
	text-align:center;
}
</style>
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/views/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="<%=basePath%>/views/ckfinder/ckfinder.js"></script>
<script type="text/javascript">
    var editor = null;
    window.onload = function(){
    	//CKFinder.setupCKEditor();
        editor = CKEDITOR.replace('ckeditor'); //参数‘ckeditor’是textarea元素的name属性值，而非id属性值
        editor.getData();
        CKFinder.setupCKEditor( editor, '../' ) ;
    }
</script>
<script type="text/javascript">
    function save(){
        editor.updateElement(); //非常重要的一句代码
        //前台验证工作
        //提交到后台
    }
</script>
</head>
<body>
<jsp:include flush="true" page="/views/jsp/common/nav.jsp" />
<div class="wrapper">
	<div class="content">
		<c:forEach items="${articles}" var="article">
		<div class="blog">
			<div class="title">
				<ul>
					<li>
						<a href="<%=basePath%>/article/articleDetial.do?id=<c:out value='${article.id}'/>">
						<c:out value="${article.title}"/>
						</a>
					</li>
				</ul>
			</div>
			<div class="info">
				<span class="date" style="color:#4a86e8"><c:out value="${article.dateUpdated}"/></span>
			</div>
			<div class="summary">
				<c:out value="${article.content}"/>
			</div>
			<hr size="3" width="80%" color=#000>
		</div>
		</c:forEach>
	</div>
	<a href="<%=basePath%>/article/addArticle.do">add a new note</a>
	<div>
		<form id="detailForm" action="submit.do" method="get">
		    <textarea id="ckeditor" name="ckeditor"></textarea>
		    <input type="submit" value="保存" id="submit" onclick="save()" />
		</form>
	</div>
</div>
</body>
</html>
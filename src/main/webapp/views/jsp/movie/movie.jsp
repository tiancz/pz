<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>Movie</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<style type="text/css">
</style>
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/views/js/vue/vue.js"></script>
<script>
	$(document).ready(function(){
	});
</script>
</head>
<body>
<jsp:include flush="true" page="/views/jsp/common/nav.jsp" />
<div class="wrapper">
<p>
	<h1>movie</h1>
	<div id="content">
		{{content_text}}
	</div>
</div>
<script>
	var movie = new Vue({
		el:'#content',
		data:{
			content_text:'welcome to movie zone!'
		}
	})
</script>
</body>
</html>
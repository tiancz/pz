<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>photo</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<style type="text/css">
	table a {text-decoration:none;color:#000;}
	table a:hover{cursor:pointer;color:#789;}
</style>
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<link rel="stylesheet" href="http://localhost:8080/pz/views/css/common/nav.css" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js">
</script>
<script>
// 	$(document).ready(function(){
// 	});
	function upload(){
		var files = document.getElementById("pic").files;
		var container = document.getElementById("pic_container");
		preview(files,container);
	}
	
	function preview(pic,container){
		if(typeof FileReader == 'undefined'){
			alert("your brower not support filereader function");
		}else{
			for(var i=0;i<pic.length;i+=1){
				var sigleFile = pic[i];
				if(!/image\/\w+/.test(sigleFile.type)){
					alert("please upload correct file");
					return false;
				}
				var reader = new FileReader();
				reader.readAsDataURL(sigleFile);
				reader.onload = function(evt){
					//alert(evt.target.result);
					//console.log(this.result);
					container.innerHTML="\<img src="+evt.target.result+" style='max-width:700px;max-height:650;'\>";
					console.log("123");
					document.getElementById("inputForm").submit();
				}
			}
		}
	}
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
<p>
	<h1>photo</h1>
	<form id="inputForm" name="inputForm" enctype="multipart/form-data" action="sendPhoto" method="post">
		<table>
			<tr>
				<td>
					<div id="pic_container"></div>
					<input id="pic" accept="image/*" type="file" name="pic">
					<a href="javascript:void(0);" onclick="javascript:upload();">
						upload picture
					</a>
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</table>
	</form>
	<c:forEach items="${photos}" var="photo">
		<img alt="" src="http://192.168.136.128<c:out value="${photo.pictureUrl}"/>">
	</c:forEach>
</div>
</body>
</html>
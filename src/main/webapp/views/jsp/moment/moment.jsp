<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>Moment</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<style type="text/css">
	.input_text{
		padding:6px;
		width-max:950px;
		width:550px;
		height-max:100px;
		border:1px solid #ccc;
	}
	.input_text #moment{
		width-max:950px;
		width:550px;
		height-max:100px;
		border:0px solid #ccc;
		outline:none;
		display:inline-block;
		resize:none;
	}
	.blogCon span{
		color:#0082ff;
	}
</style>
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/views/js/vue/vue.js"></script>
<script>
	//$(document).ready(function(){
		function checkData(){
			if(checkword()){
				document.getElementById("inputForm").submit();
			}
		}
		function checkword(){
			var moment = document.getElementById("moment");
			var momentword = moment.value;
			if(momentword.length>0){
				if(momentword.length>140){
					alert("too many words,make sure that within 140 words.");
					return false;
				}else{
					return true;
				}
			}else{
				alert("you should input something.");
				return false;
			}
		}
	//});
</script>
</head>
<body>
<jsp:include flush="true" page="/views/jsp/common/nav.jsp" />
<div class="wrapper">
	
	<div class="momentInput">
		<form id="inputForm" name="inputForm" method="post" action="createMoment">
			<div id="momentid">
			
			<div id="input_text" class="input_text">
				<textarea id="moment" name="moment" v-model="momenttext" rows="4" placeholder="生活点滴。。。"></textarea>
			</div>
			<div class="input_button">
				<input id="moment_submit" name="moment_submit" 
				v-if="seen" type="button" value="发布" onclick="checkData();"/>
			</div>
			
			</div>
		</form>
	</div>

	<div id="content">
		<c:forEach items="${moments}" var="note">
		<div class="blog">
			<div class="blogCon" style="font-size:16;">
				<c:out value="${note.momentContent}"/>
				<span><c:out value="${note.dateUpdated}"/><P></span>
  			</div>
		</div>
		</c:forEach>
	</div>
</div>
<script>
	var moment = new Vue({
		el:'#momentid',
		data:{
			seen:true
		}
	})
</script>
</body>
</html>
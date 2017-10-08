<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<html>
<head>
<title>新加日记</title>
<link rel="stylesheet" href="<%=basePath%>/views/css/common/common.css" type="text/css" />
<style type="text/css">
	#wrapper {
		width:950px;margin:0 auto;
	}
	.note_tag{
		width:538px;
	}
	.tag-input {
		position:relative;
		padding:6px;
		width:538px;
		height:26px;
		border:1px solid #ccc;
	}
	.tag-info{
		display:inline;
		margin:0px 3px 0px 0px;
		width:100%;
		height:24px;
	}
	.tag-panels {
		width:538px;
	}
	.tag {
		width: 55px;
		font-size:13px;
	}
</style>
<script type="text/javascript" src="<%=basePath%>/views/js/jquery/jquery-2.1.4.min.js">
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".tag").click(function(){
			var dataReactid = $(this).attr('data-reactid');
			var value = $(this).text().trim();
//			汉字长度1em
//			大写字符 9px
//			小写字符7px
			var width = value.length;
			
			//最多添加5个标签
			var tagInfo = $('#tag-input');
//			<input id="note_tag" name="note_tag" value="" style="width:26px;" />
			var str = "<div class='tag-info' id='tag-info'><input type='text' name='note-tag' value='"+value+"' data-reactid='"+dataReactid+"' style='border:0;width:"+width*7+"px;'/></div>";
			tagInfo.append(str);
		});
		
		
	});
	function checkData(){
		var tagInput = $('input[name="tag_val"]');
		var values = '';
		$('input[name="note-tag"]').each(function(){
			if(values==''){
				values = values + $(this).val();
			}else{
				values = values + ',' + $(this).val();
			}
		});
		tagInput.attr("value",values);
		document.getElementById("submitText").submit();
	}
</script>
</head>
<body>
<jsp:include flush="true" page="/views/jsp/common/nav.jsp" />
<div id="wrapper">
<div id="contents">
<h1>新加日记</h1><p>
<div id="article">
<form name="submitText" id="submitText" action="/note/updateNote" method="post">
	<label>题目:</label><p>
	<input name="note_title" autofocus="autofocus" value="${note.articleTitle}" style="width:582px;">
	<p>
	<label>正文:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图片&nbsp;链接
	<p>
	<textarea name="note_text" id="note_text" style="width:582px;height:400px;">
		<c:out value="${note.articleContent}"/>
	</textarea>
	<p>
	<div class="note_tags">
		<label>标签:</label>
		<div class="tag-editor" id="tag-editor">
			<div class="tag-input" id="tag-input">${note.category}
			</div>
			<input type="hidden" id="tag_val" name="tag_val" value=""/>
			<div class="tag-panels" id="tag-panels">
				<dl>
					<dt>常用标签:</dt>
					<dd>
						<c:forEach items="${tags}" var="tag">
							<a class="tag" data-reactid="${tag.tagId}">
								<c:out value="${tag.tagName}"/>
							</a>
						</c:forEach>
						<a class="tag" data-reactid=".0.2.1.1.a">历史</a>
						<a class="tag" data-reactid=".0.2.1.1.b">科学</a>
						<a class="tag" data-reactid=".0.2.1.1.d">体育</a>
						<a class="tag" data-reactid=".0.2.1.1.f">旅行</a>
						<a class="tag" data-reactid=".0.2.1.1.g">居家</a>
						<a class="tag" data-reactid=".0.2.1.1.h">美食</a>
						<a class="tag" data-reactid=".0.2.1.1.n">成长</a>
						<a class="tag" data-reactid=".0.2.1.1.p">美女</a>
						<a class="tag" data-reactid=".0.2.1.1.r">创意</a>
						<a class="tag" data-reactid=".0.2.1.1.s">科技</a>
						<a class="tag" data-reactid=".0.2.1.1.t">星座</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<p>
	<input type="button" name="preview_note" value="预览">
	&nbsp;
	<input type="button" name="note_submit" value="发表" onclick="checkData();">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" name="note_cancel" value="取消">
</form>
</div>
</div>
</div>
</body>
</html>
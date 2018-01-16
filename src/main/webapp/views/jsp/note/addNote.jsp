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
<script type="text/javascript" src="<%=basePath%>/views/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="<%=basePath%>/views/ckeditor/config.js"></script>
<script type="text/javascript" src="<%=basePath%>/views/ckfinder/ckfinder.js"></script>
<script type="text/javascript">
    var editor = null;
    window.onload = function(){
    	//CKFinder.setupCKEditor();
        editor = CKEDITOR.replace('ckeditor');//参数‘ckeditor’是textarea元素的name属性值，而非id属性值
        editor.getData();
        CKFinder.setupCKEditor( editor, '../' ) ;
        editor.on("instanceReady", function (evt) {
        	editor.addCommand("save", {exec: function (editor) {
        		alert(editor.getData());
        	}});
        });
    }
</script>
</head>
<body>

<jsp:include flush="true" page="/views/jsp/common/nav.jsp" />

<div class="wrapper">
	<div class="content">
		<div class="title">
			<ul>
				<li>
					<h5>新加文档</h5>
				</li>
			</ul>
		</div>
		<div id=textContent>
		    <textarea id="ckeditor" name="ckeditor"></textarea>
		    <button type="button" id="submit">保存</button>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		$('#textContent #submit').click(function(){
			var data = {
					'note':editor.getData()
			}
			var JsonData = JSON.stringify(data);
			$.ajax({
				url:'../article/addArticle.do',
				type:'POST',
				dataType:'json',
				contentType:'application/json',
				data:JsonData,
				async:false,
				success:function(data){
					location.href="../views/"+data.view+".jsp"
				}
			});
		});
	});
</script>
</body>
</html>
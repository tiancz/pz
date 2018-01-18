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
<link rel="stylesheet" href="http://localhost:8080/pz/views/css/common/nav.css" type="text/css" />
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
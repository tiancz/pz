<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<link rel="stylesheet" href="<%=basePath%>/views/css/common/nav.css" type="text/css" />
<div class="nav">
	<div class="menu">
		<ul>
			<li><a href="/cola/home/home"><i class="fa fa-home fa-fw"></i>首页</a></li>
			<li><a href="/cola/moment/moment"><i class="fa fa-archive fa-fw"></i>归档</a></li>
			<li><a href="/cola/photo/photo"><i class="fa fa-th fa-fw"></i>分类</a></li>
			<li><a href="/cola/note/createNote"><i class="fa fa-tags fa-fw"></i>标签</a></li>
			<li><a href="/cola/note/checkNote"><i class="fa fa-user fa-fw"></i>关于</a></li>
		</ul>
	</div>
</div>

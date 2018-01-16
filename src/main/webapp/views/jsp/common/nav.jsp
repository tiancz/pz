<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getLocalPort()+request.getContextPath();%>
<link rel="stylesheet" href="<%=basePath%>/views/css/common/nav.css" type="text/css" />
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

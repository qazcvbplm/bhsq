<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
 <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">
                  <li class=" active">
                      <a class="" href="index.jsp">
                          <i class="icon-dashboard"></i>
                          <span>首页</span>
                      </a>
                  </li>
                <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="icon-book"></i>
                          <span>板块管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
			                          <li><a class="" href="platelist.do">板块列表</a></li>
			                           <li><a class="" href="plateadd.jsp">添加板块</a></li>
                      </ul>
                  </li> 
                   <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="icon-book"></i>
                          <span>文章管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
			                          <li><a class="" href="articlelist.do">文章列表</a></li>
			                           <li><a class="" href="addarticle.jsp">添加文章</a></li>
                      </ul>
                  </li> 
                   <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="icon-book"></i>
                          <span>用户管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
			                          <li><a class="" href="userlist.do">用户列表</a></li>
                      </ul>
                  </li> 
                    <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="icon-book"></i>
                          <span>系统配置</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
			                          <li><a class="" href="">修改广告位</a></li>
                      </ul>
                  </li> 
                 
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
</body>
</html>
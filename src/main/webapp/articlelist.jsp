<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>
<style>
.fd:hover{
transform:scale(3,3); 
}
</style>
  <body>


  <section id="container" class="">
      <!--header start-->
        <%@ include file="head.jsp" %>
      <!--header end-->
      <!--left nav-->
     <%@ include file="left.jsp" %>
      <!--sidebar end-->
       <!--main content start-->
     <!--main content start-->
    
      <section id="main-content">
          <section class="wrapper">
		       <div class="row">
			     <div class="col-md-2">
			      <!--   <a class="btn btn-success" href="addproduct.jsp">新建商品</a> -->
			     </div>
			    </div> 
		     <h1></h1>
              <!-- 数据区段-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                          </header>
                          <table class="table table-striped border-top" id="sample_1">
                          <thead>
                          <tr>
                              <th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" /></th>
                              <th class="hidden-phone">封面图</th>
                              <th class="hidden-phone">标题</th>
                              <th class="hidden-phone" >所属板块</th>
                              <th class="hidden-phone">访问量</th>
                              <th class="hidden-phone">操作</th>
                          </tr>
                        <%--   <a click="sort(${t.id},${t.sort})" class="btn btn-success">↑</a> --%>
                          </thead>
                          <tbody id="rq">
                          <c:forEach var="t" items="${sessionScope.alist}">
                          <tr class="odd gradeX" id="cla${t.id}">
                               <td><input type="checkbox" class="checkboxes" value="1" /></td>
                               <td>
                               <c:forEach var="im" items="${t.imagelist}">
                               <img class="fd" height="100px" width="100px" src="${im}">
                               </c:forEach>
                               </td>
                               <td>${t.title}</td>
                                <td>${t.plate.name}</td>
                                <th class="hidden-phone">${t.visitor}</th>
                               <td class="hidden-phone"><a class="btn btn-success" href="findbyid.do?id=${t.id }&type=${t.type}">编辑</a>&nbsp;<a class="btn btn-danger" onclick="delet(${t.id})">删除</a></td>
                          </tr>
                          </c:forEach>
                          </tbody>
                          </table>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <div id="mt"></div>
      <!--main content end--> 
      <!--main content end-->
  </section>

     <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <script type="text/javascript" src="assets/data-tables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>
    <script src="js/dynamic-table.js"></script> 
    <script src="js/common-scripts.js"></script>
    <script src="js/tzh.js"></script>
<script>
var sub=false;
var image;

function mt()
{
	 clear();
	 $("#sbbtn").attr("type","reset");
	  $("#sbbtn").attr("onclick","st()");
	$("#mt").modal('show');
}
  function selectimage(){
	  var input=document.querySelector("#image");
	  input.click();
  }
  function yl()
  {
	  var f=document.querySelector("input[type='file']");
	  var filereader=new FileReader();
	     filereader.addEventListener("load",function(e){
	    	   $("#yulan").attr("src",e.target.result);
	    	   image=f.files[0];
	     });
	     filereader.readAsDataURL(f.files[0]);
	     sub=true;
  }
  var it;
  var zid=0;
  function delet(id)
  {
	  it=$("#cla"+id);
	  zid=id;
	  $T.alert({
		  msg:'是否确定删除',
		  success:'dele()'
	  })
	 /*  */
  }
  function dele(){
	  alert(zid);
	  $.ajax({
		  url:'articledelete.do?id='+zid,
		  dataType:'json',
		  success:function(res){
			  it.slideUp('10');
		  }
	  })
  }
  function st()
  {
	  var xhr=new XMLHttpRequest();
	  var fd=new FormData();
	  var file=document.querySelector("#image");
	  var name=document.querySelector("#name").value;
	  if(sub)
	{
		  fd.append("image",image);
		  xhr.open("post","addcla.do?name="+encodeURI(encodeURI(name)),true);
		  xhr.addEventListener("load",function(){
			  var json=JSON.parse(xhr.responseText);
			  $("#mt").modal("hide");
    		  var rq=document.querySelector("#rq");
    		   rq.innerHTML+= '<tr class="odd gradeX" id="cla'+json.id+'">'+
               '<td><input type="checkbox" class="checkboxes" value="1" /></td>'+
               '<td><img class="fd" height="50px" width="100px" src="./'+json.image+'"></td>'+
               '<td>'+json.name+'</td>'+
               '<td>'+json.sort+'</td>'+
               '<td><a class="btn btn-success" href="productlistbyclassesid.do?classesid='+json.id+'">点击查看</a></td>'+
               '<td><a class="btn btn-primary" href="topiclistbyclassesid.do?classesid='+json.id+'">点击查看</a></td>'+
               '<th class="hidden-phone"><a href="sort.do?id='+json.id+'&sort='+json.sort+'" class="btn btn-success">↑</a></th>'+
               '<td class="hidden-phone">&nbsp'+
               '<a class="btn btn-success" onclick="editor('+json.id+',\''+json.image+'\',\''+json.name+'\')">编辑</a>'+
               '<a class="btn btn-danger" onclick="delet('+json.id+')">删除</a></td>'+
               ' </tr>'; 
		  });
		  xhr.send(fd);
	    }else
		{
		alert("请选择图片");
		}
  }
  function sort(id,sort)
  {
	  $.ajax({
		  url:'sort.do?id='+id+'&sort='+sort,
				  dataType:'json',
			success:function(data){
				$("#sort"+id).html(data);
				$("#sort").click();
			}	  
	  })
  }
  function clear(){
	   $("#name").val("");
	   $("#yulan").attr("src","");
	   $("input[type='file']").attr("value","");
  }
  
  function editor(id,image,name){
	    clear();
	    $("#name").val(name);
	    $("#sbbtn").attr("type","submit");
	    $("#sbbtn").attr("onclick","");
	    $("#yulan").attr("src",image);
	    $("input[name='id']").attr("value",id);
	    $("#mt").modal("show");
  }
</script>

  </body>
</html>

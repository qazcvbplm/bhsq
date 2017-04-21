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
              <!-- 数据区段-->
              <form  enctype="multipart/form-data"  action="configupdatelbt.do" method="post"> 
            <div class="container">
               <div class="row">
                 <label>首页轮播图</label>
                      <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						  <!-- Indicators -->
						  <ol class="carousel-indicators">
						    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
						    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
						  </ol>
						   <input type="file" id="file0" name="pic" style="display:none">
						   <input type="file" id="file1" name="pic" style="display:none">
						   <input type="file" id="file2" name="pic" style="display:none">
						   <input type="file" id="file3" name="pic" style="display:none">
						   <input type="file" id="file4" name="pic" style="display:none">
						   <input type="file" id="file5" name="pic" style="display:none">
						  <!-- Wrapper for slides -->
						  <div class="carousel-inner text-center" role="listbox">
						    <div class="item active">
						   <center>
						      <img src="./img/lbt.jpg" id="show0" onclick="up(this)">
						   </center>
						      <div class="carousel-caption">
						      </div>
						    </div>
						    <div class="item">
						      <center>
						      <img src="./img/lbt.jpg" id="show1" onclick="up(this)">
						      </center>
						      <div class="carousel-caption">
						      </div>
						    </div>
						      <div class="item">
						      <center>
						      <img src="./img/lbt.jpg" id="show2" onclick="up(this)">
						      </center>
						      <div class="carousel-caption">
						      </div>
						    </div>
						  </div>
						
						  <!-- Controls -->
						  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						    <span class="sr-only">Next</span>
						  </a>
						</div>             
                 </div>
                  <div class="row">
                       <label>滨海圈轮播图</label>
                      <div id="carousel-example-generic2" class="carousel slide" data-ride="carousel">
						  <!-- Indicators -->
						  <ol class="carousel-indicators">
						    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
						    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
						  </ol>
						
						  <!-- Wrapper for slides -->
						  <div class="carousel-inner text-center" role="listbox">
						    <div class="item active">
						   <center>
						      <img src="./img/lbt.jpg" id="show3" onclick="up(this)">
						   </center>
						      <div class="carousel-caption">
						      </div>
						    </div>
						    <div class="item">
						      <center>
						      <img src="./img/lbt.jpg" id="show4" onclick="up(this)">
						      </center>
						      <div class="carousel-caption">
						      </div>
						    </div>
						      <div class="item">
						      <center>
						      <img src="./img/lbt.jpg" id="show5" onclick="up(this)">
						      </center>
						      <div class="carousel-caption">
						      </div>
						    </div>
						  </div>
						
						  <!-- Controls -->
						  <a class="left carousel-control" href="#carousel-example-generic2" role="button" data-slide="prev">
						    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="right carousel-control" href="#carousel-example-generic2" role="button" data-slide="next">
						    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						    <span class="sr-only">Next</span>
						  </a>
						</div>             
                 </div>
               <div class="row">
                 <center> <button type="submit" class="btn btn-success">提交</button></center>
               </div>
            </div>
            </form>
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
   <!--  <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <script type="text/javascript" src="assets/data-tables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>
    <script src="js/dynamic-table.js"></script>  -->
    <script src="js/common-scripts.js"></script>
    <script src="js/tzh.js"></script>
<script>
    $(document).ready(function(){
    	$T.previewI({
    		file:"file0",
    		show:"show0"
    	})
    	$T.previewI({
    		file:"file1",
    		show:"show1"
    	})
    	$T.previewI({
    		file:"file2",
    		show:"show2"
    	})
    	$T.previewI({
    		file:"file3",
    		show:"show3"
    	})
    	$T.previewI({
    		file:"file4",
    		show:"show4"
    	})
    	$T.previewI({
    		file:"file5",
    		show:"show5"
    	})
    })

    function up(it){
    	var id=$(it).attr("id");
    	switch(id){
    	case 'show0':
    		$("#file0").click();
    		break;
    	case 'show1':
    		$("#file1").click();
    		break;
    	case 'show2':
    		$("#file2").click();
    		break;
    	case 'show3':
    		$("#file3").click();
    		break;
    	case 'show4':
    		$("#file4").click();
    		break;
    	case 'show5':
    		$("#file5").click();
    		break;
    	}
    }
</script>

  </body>
</html>

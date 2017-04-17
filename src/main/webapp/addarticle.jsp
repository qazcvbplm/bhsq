<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">
     <link href="ue/themes/default/css/umeditor.min.css" type="text/css" rel="stylesheet">
        <script src="js/jquery.js"></script>
    <script type="text/javascript" src="ue/third-party/jquery.min.js"></script>
     <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="ue/third-party/template.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="ue/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ue/umeditor.min.js"></script>
    <script type="text/javascript" src="ue/lang/zh-cn/zh-cn.js"></script>
    <title>后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
      <section id="main-content" >
          <section class="wrapper" >
              <!-- 数据区段-->
              <form enctype="multipart/form-data"  action="" method="post">
              <div class="container">
                  <div class="row">
                       <div class="form-group">
                           <label class="control-label">标题</label>
                           <input class="form-control" name="title" >
                       </div>
                  </div>
                   <div class="row">
                         <div class="col-md-12">
                           <label class="control-label">封面图</label>
                           </div>
                  </div> 
                  <div class="row" >
                           <input type="file" id="image1" name="image" style="display:none">
                           <input type="file"  id="image2" name="image"  style="display:none">
                           <input type="file"  id="image3" name="image"  style="display:none">
                           <div class="col-md-4 " >
                           <center><div  id="show1" onclick="select(this)"  style="width:200px;height:200px;background:url('./img/add_btn.jpg');background-size:100% 100%;" ></div></center>
                           </div>
                            <div class="col-md-4">
                           <center><div id="show2" onclick="select(this)" style="width:200px;height:200px;background:url('./img/add_btn.jpg');background-size:100% 100%;" ></div></center>
                           </div>
                           <div class="col-md-4">
                           <center><div id="show3" onclick="select(this)" style="width:200px;height:200px;background:url('./img/add_btn.jpg');background-size:100% 100%;" ></div></center>
                           </div>
                  </div>
                   <div class="row">
                    <label class="control-label">正文内容</label>
			            <script  type="text/plain" id="myEditor"  name="text" style="width:100%;height:400px;">
            			 </script>
                   </div>
                   <h1></h1>
                    <div class="row text-center">
                       <button class="btn btn-success " type="submit">确定</button>
                   </div>
              </div>
              </form>
              <!-- page end-->
          </section>
      </section>
      <!--main content end--> 
      <!--main content end-->
  </section>

<!--  convertHtmlToText: function convertHtmlToText(inputText) {  
             var returnText = "" + inputText;  
             returnText = returnText.replace(/<\/div>/ig, '\r\n');  
            returnText = returnText.replace(/<\/li>/ig, '\r\n');  
            returnText = returnText.replace(/<li>/ig, ' * ');  
             returnText = returnText.replace(/<\/ul>/ig, '\r\n');  
            
             returnText = returnText.replace(/<br\s*[\/]?>/gi, "\r\n");   
              
             returnText=returnText.replace(/<p.*?>/gi, "\r\n");  
            returnText=returnText.replace(/<a.*href="(.*?)".*>(.*?)<\/a>/gi, " $2 ($1)");  
            
             returnText=returnText.replace(/<script.*>[\w\W]{1,}(.*?)[\w\W]{1,}<\/script>/gi, "");  

             returnText=returnText.replace(/<style.*>[\w\W]{1,}(.*?)[\w\W]{1,}<\/style>/gi, "");  

             returnText=returnText.replace(/<(?:.|\s)*?>/g, "");   
            
             returnText=returnText.replace(/(?:(?:\r\n|\r|\n)\s*){2,}/gim, "\r\n\r\n");  
            
             returnText = returnText.replace(/ +(?= )/g,'');  
              
             returnText=returnText.replace(/ /gi," ");  
             returnText=returnText.replace(/&/gi,"&");  
            returnText=returnText.replace(/"/gi,'"'); 
            returnText=returnText.replace(/</gi,'<'); 
             returnText=returnText.replace(/>/gi,'>');  
             return returnText;
       } -->
    <!-- js placed at the end of the document so the pages load faster -->
   
        <script type="text/javascript" src="js/tzh.js"></script>
     <script src="js/common-scripts.js"></script>
     <script> 
     var um = UM.getEditor('myEditor');
     $(document).ready(function(){
    	  $T.preview({
    		  file:'image1',
    		  show:'show1'
    	  })
    	   $T.preview({
    		  file:'image2',
    		  show:'show2'
    	  })
    	   $T.preview({
    		  file:'image3',
    		  show:'show3'
    	  })
 
     })
     
     
     function select(it){
    	 var id=$(it).attr("id");
    	 if(id=='show1')
          $("#image1").click();
    	 if(id=='show2')
             $("#image2").click();
    	 if(id=='show3')
             $("#image3").click();
    	 
     }
     
     </script>
     
  </body>
</html>

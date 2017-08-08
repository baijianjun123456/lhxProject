<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US"><head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"> 
<title>鹦鹉螺-首页</title>
<script type="text/javascript">
	var basePath = "<%=basePath%>";
</script>
<!-- Bootstrap -->
<link href="<%=basePath%>common/ywl/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/ywl/css/custom.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/ywl/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/ywl/css/font-awesome-ie7.min.css">
<script type="text/javascript"	src="<%=basePath%>common/plugin/jquery/3.2.1/jquery-3.2.1.min.js" ></script>
<script type="text/javascript"	src="<%=basePath%>common/js/Ajax.js" ></script>
<script type="text/javascript"	src="<%=basePath%>system/login/js/welcome.js" ></script>

</head>

<body style="width:100%;height:100%;">
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content log-bg">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">注册</h4>
      </div>
      <div class="modal-body log-cus">
        <div class="input-group input-group-lg">
         <span class="input-group-addon"><i class="icon-user"></i></span>
         <input type="text" class="form-control" placeholder="手机号" aria-describedby="sizing-addon1">

        </div>
        <div class="input-group input-group-lg">
         <span class="input-group-addon"><i class="icon-envelope"></i></span>
         <input type="text" class="form-control" placeholder="验证码" aria-describedby="sizing-addon1"> <span class="input-group-btn"><button type="button" class="btn btn-default ">获取验证码</button></span>

        </div>
        <div class="input-group input-group-lg">
              <span class="input-group-addon"><i class="icon-lock"></i></span>
              <input type="text" class="form-control" placeholder="密码" aria-describedby="sizing-addon1">
        </div>
<button type="button" class="btn btn-primary btn-lg dropdown-toggle">注册</button>
<a href="#">已有账号？马上登录</a>
      </div>
      
    </div>
  </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<form  name="loginForm" id="loginForm">
		 <input type="hidden"  name="userCode" id="userCode"  value="12354"/>
		  <div class="modal-dialog" role="document">
		    <div class="modal-content log-bg">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel1">登录</h4>
			      </div>
		      	<form  name="loginForm" id="loginForm">
		      
			      <div class="modal-body log-cus" >
			        <div class="input-group input-group-lg">
				         <span class="input-group-addon"><i class="icon-user"></i></span>
				         <input type="text" class="form-control" placeholder="手机号" aria-describedby="sizing-addon1" name="userName">
			        </div>
			        <div class="input-group input-group-lg">
			              <span class="input-group-addon"><i class="icon-lock"></i></span>
			              <input type="text" class="form-control" placeholder="密码" aria-describedby="sizing-addon1" name="password" >
			        </div>
						<button type="button" class="btn btn-primary btn-lg dropdown-toggle"  id="loginsubmit" name = "loginsubmit">登 录</button>
						<a href="#"  data-toggle="modal" data-target="#myModal1">免费注册</a><a href="#">忘记密码</a>
			      </div>
		      
		   	 </div>
		  </div>
	  </form>
</div>

	<div class="container">
	      <!-- Static navbar -->
	      <nav class="navbar navbar-default navbar-cus">
	        <div class="container-fluid">
	          <div class="navbar-header">
	            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	              <span class="sr-only">Toggle navigation</span>
	              <span class="icon-bar"></span>
	              <span class="icon-bar"></span>
	              <span class="icon-bar"></span>
	            </button>
	            <a class="navbar-brand" href="#"> </a>
	          </div>
	          <div id="navbar" class="navbar-collapse collapse">
	            <ul class="nav navbar-nav">
	              <li class="active"><a href="#"><i class="icon-home "></i>  首页</a></li>
	              <li><a href="#"><i class="icon-trophy "></i>  VIP</a></li>
	              <li><a href="#"><i class="icon-lightbulb "></i>  关于</a></li>
	            
	            </ul>
	            <ul class="nav navbar-nav navbar-right">
	             
	              <li><a href="<%=basePath%>system/login/login.do" ><i class="icon-user"></i>  登录</a></li>
	              <li><a href="#"  data-toggle="modal" data-target="#myModal1">注册</a></li>
	            </ul>
	          </div><!--/.nav-collapse -->
	        </div><!--/.container-fluid -->
	      </nav>
	    
	      <div class="jumbotron text-center">
	      <div class="row">
			  <div class="search-box" >
			    <div class="input-group input-group-search">
				      <div class="input-group-btn">
					        <button type="button" class="btn btn-tra dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ><span id="butType">A股</span><i class=" icon-angle-down caret"></i> </button>
					        <input type="hidden" value="A" id="type" name="type" />
					        <ul class="dropdown-menu" id="typeMenu">
					          <li><a href="javascript:void(0)" value="A" >A股</a></li>
					          <li><a href="javascript:void(0)" value="B">B股</a></li>
					          <li><a href="javascript:void(0)" value="H">H股</a></li>
					          <li><a href="javascript:void(0)" value="N">N股</a></li>
					          <li><a href="javascript:void(0)" value="S">S股</a></li>
					        </ul>
				      </div>
			      	  <input type="text" class="form-control form-control-cus" aria-label="..."  value="请输入股票代码/股票名称"  id="name"> 
			      	  <br>
			      	   <div class="input-group-btn" >
					        <button type="button" class="btn btn-tra dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ><span id="butType"></span><i class=" icon-angle-down caret" id="downListId"></i> </button>
					        <input type="hidden" value="A" id="type" name="type" />
					        <ul class="dropdown-menu" id="stockList" style="width:620px;left:-570px;top:60px">
					        </ul>
				      </div>
				      
			      	  <span class="input-group-btn">
			          	<button class="btn  btn-search" type="button" id="search">搜 索</button>
			      	  </span>
			    	</div>
			  </div>
			</div>
	      </div>
			

		
	      <div class="container-fluid bg-grey">
	      	<div class="row bg-black pad-cus">
	 			 <div class="col-md-2 pad-top-cus">
					  <a class="btn tool" role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample" onClick="getAllSelf()"><i class="icon-star-empty"></i>
					 		<span>自选股</span>
					  </a> 
					  <a class="btn tool" role="button" data-toggle="collapse" href="#collapseExample2" aria-expanded="false" aria-controls="collapseExample2"><i class="icon-tasks"></i>
					 	<span> 多条件选</span>
					  </a>
					  <a class="btn tool" role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample3"><i class="icon-upload-alt"></i>
					 	<span>上传数据</span>
					  </a> 
					  <a class="btn tool" role="button" data-toggle="collapse" href="#collapseExample2" aria-expanded="false" aria-controls="collapseExample4"><i class="icon-folder-close-alt"></i>
					 	<span>收藏夹 </span>
					  </a>
				<div class="clearfix"></div>
				<div class="collapse fix" id="collapseExample" style="width:250px;">
			  		<div class="well" id="selfMenu">

			  		</div>
				</div>
				<div class="collapse fix" id="collapseExample2">
				  <!-- <div class="well">
				    12.
				  </div> -->
				</div>
				<div class="collapse fix" id="collapseExample3">
				  <!-- <div class="well">
				    12.
				  </div> -->
				</div>
				<div class="collapse fix" id="collapseExample4">
				  <!-- <div class="well">
				    12.
				  </div> -->
				</div>
	  	  </div><!-- 工具栏 -->
	  	  
		  <div class="col-md-10  bg-grey with-cus">
		  		<div class="row">
		  			<ul class="nav nav-pills tab1">
			 			 <li role="presentation" class="active"><a href="javascript:void(0)" onClick="stockPage('T0001','上证')">上证</a></li>
			  			 <li role="presentation"><a href="javascript:void(0)" onClick="stockPage('T0002','深证')">深证</a></li>
			  			 <li role="presentation"><a href="javascript:void(0)" onClick="stockPage('T0003','沪300')">沪300</a></li>
			             <li role="presentation"><a href="javascript:void(0)" onClick="stockPage('T0004','创业板')">创业板</a></li>
					</ul>
		        </div><!-- tab1 -->
				<iframe id="mainframe"  width="100%" height="605px" frameborder="0" scrolling="auto"  src="<%=basePath%>market/manager/page/mainChart.do?tcode=T0001&tname=上证">
					
				</iframe>
		  </div><!--row end -->
   </div>
   <div class="news-tit" >
	    <h3><small><a href="<%=basePath%>/message/publicize/getpublicizelist.do">更多&gt;</a></small>最新报告</h3></div>
	      
	        <div class="container-fluid bg-grey news">
	        <ul>
		       <!--  <li><a href="#">白银有色新股速览:扩大资源储量,多业务齐发展<span>2016-10-22 </span></a></li>
		        <li><a href="#">白银有色新股速览:扩大资源储量,多业务齐发展<span>2016-10-22 </span></a></li> -->
		        <c:forEach items="${resultList }" var="item">
	        		<!--  <li><a href="#">白银有色新股速览:扩大资源储量,多业务齐发展</a></li>
	        		<li><a href="#">白银有色新股速览:扩大资源储量,多业务齐发展</a></li> -->	
	        		<li><a href="<%=basePath%>/message/publicize/publicizeDetail.do?pubId=${item.id_}">${item.title}</a></li>  
				</c:forEach>
			</ul>
	        </div>
	</div> <!-- /container -->
	<div class="text-center foot">©鹦鹉螺版权所有   powered by 6HX</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
	<script src="<%=basePath%>common/ywl/js/jquery-1.11.2.min.js"></script>
	
	<!-- Include all compiled plugins (below), or include individual files as needed --> 
	<script src="<%=basePath%>common/ywl/js/bootstrap.js"></script>
</body>
</html>

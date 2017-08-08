<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap - Prebuilt Layout</title>
<!-- Bootstrap -->
<link href="<%=basePath%>common/ywl/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/ywl/css/custom.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/ywl/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/ywl/css/font-awesome-ie7.min.css"> 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="<%=basePath%>common/ywl/js/bootstrap.js"></script>
<script src="<%=basePath%>common/ywl/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"	src="<%=basePath%>message/publicize/js/publicizeAll.js" ></script>
</head>
<body class="bg-cus">
<input type="hidden" id="type" value="${type}"/>	
<input type="hidden" id="basePath" value="<%=basePath%>"/>
<!-- Modal -->
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
  <div class="modal-dialog" role="document">
    <div class="modal-content log-bg">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel1">登录</h4>
      </div>
      <div class="modal-body log-cus" >
        <div class="input-group input-group-lg">
         <span class="input-group-addon"><i class="icon-user"></i></span>
         <input type="text" class="form-control" placeholder="手机号" aria-describedby="sizing-addon1">
        </div>
        <div class="input-group input-group-lg">
              <span class="input-group-addon"><i class="icon-lock"></i></span>
              <input type="text" class="form-control" placeholder="密码" aria-describedby="sizing-addon1">
        </div>
<button type="button" class="btn btn-primary btn-lg dropdown-toggle">登 录</button>
<a href="#"  data-toggle="modal" data-target="#myModal1">免费注册</a><a href="#">忘记密码</a>
      </div>
      
    </div>
  </div>
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
             
              <li><a href="#" data-toggle="modal" data-target="#myModal"><i class="icon-user"></i>  登录</a></li>
              <li><a href="#"  data-toggle="modal" data-target="#myModal1">注册</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
  <div class="cus-tit" >
  <h3>全部报告</h3></div>      
        <div class="container-fluid bg-grey news-shot min-height">        
		<c:forEach items="${publicizeList }" var="item">	
		<!--公告标题  -->
		<div class="one-article"><div class="news-tit">${item.title}</div>
		<!--公告简介跳转到详情  -->
		 <a class="shot"  <%-- href="javascript:publicizeDetail('${item.id_}')" --%> href="<%=basePath%>/message/publicize/publicizeDetail.do?pubId=${item.id_}">${item.abstrac}</a>
		 <div class="time">${item.fabutime} </div>
		</c:forEach>
        </div>
        <div class="pull-right">
        <nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav></div>
    </div> <!-- /container -->
<div class="text-center foot bg-black">©鹦鹉螺版权所有   powered by 6HX</div>
<script type="text/javascript">
   function publicizeDetail(pubId){
	   $.ajax({
			type:"POST",
		    async:true,
			url:basePath+'/message/publicize/publicizeDetail.do?pubId='+pubId,		       	
			cache:false,
			success:function(data){
			       		
			}
		})
   }   
</script>

</body>
</html>
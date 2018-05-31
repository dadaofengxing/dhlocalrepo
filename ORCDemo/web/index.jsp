<%--
  Created by IntelliJ IDEA.
  User: willinggod
  Date: 2018/3/9
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("basePath",basePath);
%>
<html>
<head>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>文字识别</title>
        <jsp:include page="/common/import/jquery.jsp"></jsp:include>
        <jsp:include page="/common/import/bootstrap.jsp"></jsp:include>
        <jsp:include page="/common/import/jqueryFileUpload.jsp"></jsp:include>
    </head>
<body id="page-top">
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">中软华腾-文字识别</a>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#services">Services</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header -->
<header class="masthead">
    <div class="container">
        <div class="intro-text">
            <div class="intro-lead-in">Welcome To Our Studio!</div>
            <div class="intro-heading text-uppercase">It's Nice To Meet You</div>
            <a id="addFile" class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">上传保单图片</a>
            <a id="addFile2" class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">上传计划书图片</a>
            <div class="text-uppercase">
                <p id="showText"></p>
            </div>
        </div>
    </div>
</header>
<div style="display: none">
    <input id="fileupload"  type="file" name="files"   />
</div>
</body>
<script>
    $(function(){
        $("#addFile").bind("click",function(){
            $("#fileupload").click();
            uploadFile();
        });
    });
    $(function(){
        $("#addFile2").bind("click",function(){
            $("#fileupload").click();
            uploadFile2();
        });
    });
    //上传文件
    function uploadFile(){
        var url="${basePath}upload/OcrOrange";
        $('#fileupload').fileupload({
            url:url,
            multiple:true,
            limitMultiFileUploads:3,
            done: function (e, data) {
                var text=data.result;
                $("#showText").html(text);
            }
        });
    }
    //上传计划书
    function uploadFile2(){
        var url="${basePath}upload/OcrOrange?index=2";
        $('#fileupload').fileupload({
            url:url,
            multiple:true,
            limitMultiFileUploads:3,
            done: function (e, data) {
                var text=data.result;
                $("#showText").html(text);
            }
        });
    }

</script>
</html>

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
        <title>文字识别——前端</title>
        <jsp:include page="/common/import/jquery.jsp"></jsp:include>
        <jsp:include page="/common/import/bootstrap.jsp"></jsp:include>
        <jsp:include page="/common/import/jqueryFileUpload.jsp"></jsp:include>
    </head>
<body id="page-top">


<!-- Header -->
<header class="masthead">
    <div class="container">
        <div class="intro-text">
            <a id="addFile" class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">浏览图片</a>
            <div class="text-uppercase">
                <p id="showText"></p>
            </div>
        </div>
    </div>
</header>
<div style="display: none">
    <input id="image"  type="file" name="files"   />
</div>
</body>
<script>
    var client_id='Va5yQRHlA4Fq5eR3LT0vuXV4';
    var client_secret = '0rDSjzQ20XUj5itV6WRtznPQSzr5pVw2';
    var access_token = "24.bdc12eb856d6aeb830d14f4afba73332.2592000.1523925644.282335-10937637";
    $(function(){
        $("#addFile").bind("click",function(){
            $("#image").click();
            var imageBase64 = getBase64Str();
            var tempSign = '3e01425d1e74f00ac3628f73929c3b96';
            uploadBase64(imageBase64,tempSign);
        });
    });
    function getBase64Str() {
        var reader = new FileReader();
        var AllowImgFileSize = 2100000; //上传图片最大值(单位字节)（ 2 M = 2097152 B ）超过2M上传失败
        var file = $("#image")[0].files[0];
        var imgUrlBase64;
        if (file) {
            //将文件以Data URL形式读入页面
            reader.readAsDataURL(file);
            imgUrlBase64 = reader.result;
                reader.onload = function (e) {
                //var ImgFileSize = reader.result.substring(reader.result.indexOf(",") + 1).length;//截取base64码部分（可选可不选，需要与后台沟通）
                if (AllowImgFileSize != 0 && AllowImgFileSize < reader.result.length) {
                    alert( '上传失败，请上传不大于2M的图片！');
                    return;
                }else{
                    //执行上传操作
                    alert(reader.result);
                }
            }
            return imgUrlBase64;
        }
    }

    //获取access_token
    function getAccessToken(){
        if(access_token != ''){
            console.log('access_token is not null .access_token='+access_token)
            return;
        }
        var url='https://aip.baidubce.com/oauth/2.0/token';
        $.ajax({
            url:url,
            type:"post",
            data:{"grant_type":'client_credentials','client_id':client_id,'client_secret':client_secret},
            dataType:"json",
            success:function(data){
                access_token=data.access_token;
                console.log('now get access_token='+access_token);
            }
        })
    }
    //上传文件
    function uploadBase64(data,templateSign){
        var imageUrl='http://ai.baidu.com/iocr/template/image/query?imageKey=D3AD5581606D44DA82FD0998ACD1D9DB';
        var url="https://aip.baidubce.com/rest/2.0/solution/v1/iocr/recognise?access_token"+access_token;
        $.ajax({
            async : true,
            url : url,
            type : "GET",
            dataType : "jsonp", // 返回的数据类型，设置为JSONP方式
            jsonp : 'callback', //指定一个查询参数名称来覆盖默认的 jsonp 回调参数名 callback
            jsonpCallback: 'handleResponse', //设置回调函数名
            data : {"image":imageUrl,'templateSign':templateSign},
            success: function(response, status, xhr){
                console.log('状态为：' + status + ',状态是：' + xhr.statusText);
                console.log(response);
            }
        });

    }
function handleResponse(response) {
    console.log(response);
}
</script>
</html>

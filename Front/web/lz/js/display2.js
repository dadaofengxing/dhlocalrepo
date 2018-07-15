var url = "http://localhost:9011/";
var pageSize = 20;
var productListFromBack = new Array();
function getDataFromBack() {
    $.ajax({
        type: 'POST',
        url: url+"product/list",
        async: false,
        data: JSON.stringify({"pageNo":"1","pageSize":pageSize}),
        dataType: "json",
        contentType: 'application/json',
        success: function (result) {
            console.log(result);
            productListFromBack =  result;
        }
    });
}
function addProduct(data) {
    $.ajax({
        type: 'POST',
        url: url+"product/add",
        async: false,
        data: JSON.stringify(data),
        dataType: "json",
        contentType: 'application/json',
        success: function (result) {
            console.log(result);
        }
    });
}
function deleteProduct(index) {
    $.ajax({
        type: 'GET',
        url: url+"product/delete/"+index,
        contentType: 'application/json',
        success: function (result) {
            console.log(result);
            showImg();
        }
    });
}
function showImg() {
    console.log("begin to show image")
    getDataFromBack();
    var productList = productListFromBack.pageModel.resultSet;
    var innerHtmls = "";
    for(var i=0; i<productList.length; i++){
        var innerHtml = '<tr><td class="td1"><img src="'
            +productList[i].src+
            '" style="width: 100%; height: 100%;"></td><td class="td2"><input type="text" style="width: 100%; height: 100%;" readonly value="'
            +showProductTextProp(productList[i])+
            '" id="title'
            +i+
            '"></td></tr>';
        innerHtmls+=innerHtml;
    }
    setValueForTable('display_table',innerHtmls)

}
function showProductTextProp(product) {
    var len = "全长："+product.length + '<br>';
    var rc = "刃长："+product.renLength + '<br>';
    var bc = "柄长："+product.bingLength + '<br>';
    var wei = "重量："+product.weight + '<br>';
    var op = "其他属性："+product.otherProp;
    return len+rc+bc+wei+op;
}
function setValueForTable(tableid,innerHtmls) {
    //table的innerHTML只读，所以采用替换子节点的方式进行
    var docTable =  document.getElementById(tableid);//找到要使用innerHTML的table

    var newDiv = document.createElement('div');
    newDiv.innerHTML = '<table><tbody>'+innerHtmls+'</tbody></table>'//既然不能给table使用innerHTML，我给新创建的div的innerHTML赋值还不行吗？

    var newTbody = newDiv.childNodes[0].tBodies[0];
    var oldTbody = docTable.tBodies[0];
    docTable.replaceChild(newTbody, oldTbody);//用替换子节点的方式来赋值，这样也只要操作一次，虽然多了一个创建div的步骤，但是因为我们没有将其添加到body中，所以不会影响页面的渲染，速度还是很快
}

function showEditImg() {
    console.log("begin to show edit image")
    getDataFromBack();
    var productList = productListFromBack.pageModel.resultSet;
    var innerHtmls = "";
    for(var i=0; i<productList.length; i++){
        var td1InnerHtml = "";
        if(productList[i].src == "" || null == productList[i].src){
            td1InnerHtml = "<input type='file' id='btn_file"+i+"' style='display:block'><a href='javascript:void(0);' onclick='uploadImg("+i+");'>请上传图片</a>";
        }else {
            var imageSrc = productList[i].src;
            td1InnerHtml ='<img src="'+imageSrc+'" style="width: 100%; height: 100%;">';
        }
        var innerHtml = '<tr><td class="td1">'+td1InnerHtml+'</td><td class="td2"><input type="text" style="width: 100%; height: 100%;"  value=\''
            +showProductTextProp(productList[i])+
            '\' id="title'
            + i+
            '" onmouseleave="saveValue('
            +i+
            ')" onclick="editMethod('
            +i+
            ')"></td></tr>';
        console.log(innerHtml)
        innerHtmls+=innerHtml;
    }
    setValueForTable("edit_table",innerHtmls)
}
function uploadImg(index) {
    console.log("begin to upload pic "+index);
    // $("#btn_file"+index).click();
    var fileObj = document.getElementById("btn_file"+index).files[0]; // js 获取文件对象
    if(null == fileObj){
        alert("请先选择文件！");
        return;
    }
    var form = new FormData(); // FormData 对象
    form.append("file", fileObj); // 文件对象
    $.ajax({
        url:url+"upload/uploadImage",
        async: false,
        type:"post",
        data:form,
        processData:false,
        contentType:false,
        success:function(res){
            if(res){
                alert("上传成功！");
            }
            console.log(res);
        },
        error:function(err){
            alert("网络连接失败,稍后重试",err);
        }

    })
}
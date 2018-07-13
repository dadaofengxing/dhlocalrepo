var images = window.localStorage.getItem("images");
var imageStyle = [];
function showImg() {
    console.log("begin to show image")
    readDataJson();
    var innerHtmls = "";
    for(var i=0; i<imageStyle.length; i++){
        var innerHtml = '<tr><td class="td1"><img src="image/'
            +imageStyle[i].imgSrc+
            '" style="width: 100%; height: 100%;"></td><td class="td2"><input type="text" style="width: 100%; height: 100%;" readonly value="'
            +imageStyle[i].imgDesc+
            '" id="title'
            +i+
            '"></td></tr>';
        innerHtmls+=innerHtml;
    }
    setValueForTable('display_table',innerHtmls)

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
    readDataJson();
    var innerHtmls = "";
    for(var i=0; i<imageStyle.length; i++){
        var innerHtml = '<tr><td class="td1"><img src="image/'
            +imageStyle[i].imgSrc+
            '" style="width: 100%; height: 100%;"></td><td class="td2"><input type="text" style="width: 100%; height: 100%;"  value=\''
            +JSON.stringify(imageStyle[i])+
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

function readDataJson() {
    imageStyle = localStorage.getItem("imageStyle");
    if(null !=imageStyle && imageStyle.length > 0){
        imageStyle = $.parseJSON(imageStyle);
        return;
    }

    $.ajaxSettings.async = false; //(同步执行)
    $.getJSON("js/data.json",function(data){
        var $jsontip = $("#ok");
        var strHtml = new Array();//存储数据的变量
        $jsontip.empty();//清空内容
        $.each(data,function(infoIndex,info){
            var item = {"imgSrc":"","imgDesc":""};
            item.imgSrc=info["imgSrc"]
            item.imgDesc=info["imgDesc"];
            strHtml[infoIndex]=item;
        })
        imageStyle = strHtml
        console.log("strHtml="+JSON.stringify(strHtml))
    });
}
function saveDataJson(jsonData) {
    var fso=new ActiveXObject("Scripting.FileSystemObject"); //实例化
    f1 = fso.OpenTextFile("js/data2.json",8,true);//这样就能继续写了。分清WriteLine，和Write
    f1.WriteLine(" 这是回车行");
    //f1.Write("这才是一行文字：  ");
    f1.Close();
}
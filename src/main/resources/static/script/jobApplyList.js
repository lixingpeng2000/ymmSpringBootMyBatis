
// 页面加载发送该接口
window.onload = function() {
	getemployjobshowtb();
}
function getemployjobshowtb() {
    $.ajax({
                url : "http://localhost/ymm/employJobshow",
                contentType : "application/json",
                type : "get",
                dataType : "json",
                success : function(returnData) {
                   if (returnData.resultCode == "200") {
                           var jobinfoData = returnData.data;
                           var tbody = document.getElementById('mainTbId');
                        for(var i = 0;i < jobinfoData.length; i++){ //遍历一下json数据
                           var trow = getDataRow(jobinfoData[i]); //定义一个方法,返回tr数据
                           tbody.appendChild(trow);
                        }

                    } else {
                        alert("f程序内部错误500");
                    }
                },
                error : function(err) {
                    console.log(err);
                }
            });
};


function getDataRow(h){
     var row = document.createElement('tr'); //创建行   

     var idCell = document.createElement('td'); //创建第一列id
     idCell.innerHTML = h.id; //填充数据
     row.appendChild(idCell); //加入行  ，下面类似

     var usernameCell = document.createElement('td');//创建第二列jname
     usernameCell.innerHTML = h.ename;
     row.appendChild(usernameCell);
     
     var telCell = document.createElement('td');//创建第三列jcity
     telCell.innerHTML = h.tel;
     row.appendChild(telCell);
   
     var nameCell = document.createElement('td');//创建第四列jname
     nameCell.innerHTML = h.jname;
     row.appendChild(nameCell);
     
     var jobCell = document.createElement('td');//创建第五列jcity
     jobCell.innerHTML = h.jcity;
     row.appendChild(jobCell);
   
     var nameCell = document.createElement('td');//创建第6列jclass
     nameCell.innerHTML = h.jclass;
     row.appendChild(nameCell);
     
     var jobCell = document.createElement('td');//创建第7列duty
     jobCell.innerHTML = h.duty;
     row.appendChild(jobCell);

     var idCell = document.createElement('td'); //创建第8列req
     idCell.innerHTML = h.req; //填充数据
     row.appendChild(idCell); //加入行  ，下面类似
     
     var nameCell = document.createElement('td');//创建第9列nature
     nameCell.innerHTML = h.nature;
     row.appendChild(nameCell);
     
     //到这里，json中的数据已经添加到表格中，下面为每行末尾添加删除按钮
     var delCelllast = document.createElement('td');//创建第八列，操作列
     row.appendChild(delCelllast);
     var btnDel = document.createElement('input'); //创建一个input控件
     btnDel.setAttribute('type','button'); //type="button"
     btnDel.setAttribute('value','删除'); 
     delCelllast.className='lasttd';
     delCelllast.appendChild(btnDel);  //把删除按钮加入td，别忘了
      //删除操作
    btnDel.onclick=function(){
         if(confirm("确定删除这一行嘛？")){
             //找到按钮所在行的节点，然后删掉这一行
              this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);
              delfun(h.id)            
             //btnDel - td - tr - tbody - 删除(tr)
             //刷新网页还原。实际操作中，还要删除数据库中数据，实现真正删除
             }
         } 
     return row; //返回tr数据    
}

function delfun(id) {
    $.ajax({
                url : "http://localhost/ymm/employJobshow?id="+id,
                contentType : "application/json",
                type : "delete",
                dataType : "json",
                success : function(returnData) {
                   if (returnData.resultCode == "200") {
                        return true;
                        
                    } else {
                        return false;
                    }
                },
                error : function(err) {
                    console.log(err);
                }
            });
};




var introduceId = document.getElementById("introduceId");
var introduceInput = document.getElementById('introduceInput');
var fileId = document.getElementById("fileId");
var fileInput = document.getElementById("fileInput");
//获取当前url的参数中的city和jname
function getUrlPara(paraName) {
	var sUrl = location.href;
	var sReg = "(?:\\?|&){1}" + paraName + "=([^&]*)"
	var re = new RegExp(sReg, "gi");
	re.exec(sUrl);
	return RegExp.$1;
}

var city = getUrlPara("city");
var jname = getUrlPara("jname")

introduceId.addEventListener('click',function(){
       introduceInput.click();
})
fileId.addEventListener('click',function(){
       fileInput.click();
})
function clearPersoninfo(){
    	document.getElementById("name").value="";
        document.getElementById("tel").value="";
        document.getElementById("mail").value="";
    }
//提交点击函数
function submitUserInfo() {
    //获取应聘者信息数据
    var name = document.getElementById("name").value;
    var tel = document.getElementById("tel").value;
    var mail = document.getElementById("mail").value;
    console.log(jname);
    console.log(city);
    var newcity = decodeURIComponent(city);// 转码
    var newjname = decodeURIComponent(jname);// 转码
    if(name==""||tel==""||mail==""){
    	alert("用户名或者密码或者手机号为空");
    	return false;
    	clearPersoninfo();
    } ;  
    if(!isPoneAvailable(tel)){
		alert("无效手机号");
		clearPersoninfo();
    	return false;
    }   
    if(!isMailAvailable(mail)){
		alert("无效邮箱");
		clearPersoninfo();
    	return false;
    } 
    $.ajax({
		url:"http://localhost/ymm/employ",
		contentType: "application/json",
		type:"post",
		data:JSON.stringify({"name":name,"tel":tel,"mail":mail,"jname":newjname,"jcity":newcity}),
		dataType:"json",
		success:function(data){
            if(data.resultCode == "200"){
                alert("提交成功");
                clearPersoninfo();
            } else if(data.resultCode == "501"){				
				alert("提交失败,手机号【"+tel+"】,重复申请【"+newjname+"】岗位");
				clearPersoninfo();
					}
            else {
                alert("提交失败");
                clearPersoninfo();
            }    
		}
    });
};
document.getElementById("submitId").addEventListener('click', submitUserInfo);


//页面加载发送该接口
window.onload = function() {
	getjobinfobrief();
}
function getjobinfobrief() {
	$.ajax({
				url : "http://localhost/ymm/jobBrief?jcity=" + city+"&jname="+jname,
				contentType : "application/json",
				type : "get",
				dataType : "json",
				success : function(returnData) {
					if (returnData.resultCode == "200") {
						var jobinfoData = returnData.data;
							var jcity = jobinfoData[0].jcity;
							var jname = jobinfoData[0].jname;
							var dept = jobinfoData[0].dept;
							var jclass = jobinfoData[0].jclass;
							var nature = jobinfoData[0].nature;
							var publishTime = jobinfoData[0].createDate;
						document.getElementById("jnameId").innerText=jname;												
						document.getElementById("jdeptId").innerText=dept;	
						document.getElementById("natureId").innerText=nature;	
						document.getElementById("jclassId").innerText=jclass;	
						document.getElementById("jcityId").innerText=jcity;	
						document.getElementById("publishTimeId").innerText=publishTime;	
						htmlStr = "<a class='myaclass' href='http://localhost/ymm/jobInfo.html?city="+jcity+"&jname="+jname+"&dept="+dept+"&jclass="+jclass+"&nature="+nature+ "'>职位详情</a>";
						htmlStrApp = "<a class='myaclass' href='http://localhost/ymm/jobApplication.html?city="+jcity+"&jname="+jname+ "'>职位申请</a>";
						$("#jobInfoLi").html(htmlStr);
						$("#jobApplicationLi").html(htmlStrApp);
					} else{
						alert("f程序内部错误500");
					}
				},
				error : function(err) {
					console.log(err);
				}
			});
};
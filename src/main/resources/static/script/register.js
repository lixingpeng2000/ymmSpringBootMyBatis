//提交点击函数
function submitUserInfo() {
    //获取用户信息数据
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    if(userName==""||password==""){
    	alert("用户名或者密码为空");
    	return false;
    } ;     
    $.ajax({
		url:"http://localhost/ymm/user",
		contentType: "application/json",
		type:"post",
		data:JSON.stringify({"username":userName,"pwd":password}),
		dataType:"json",
		success:function(data){
			 if(data.resultCode == "200"){
                alert("注册成功");
                location.href='http://localhost/ymm/';
            }else {
                alert("注册失败");
                location.href='http://localhost/ymm/';
            } 
		  }
        });
};
document.getElementById("submitId").addEventListener('click', submitUserInfo);

//密码校验函数
function checkpwd() {
    var p1 = document.getElementById("password").value;//获取密码框的值
    var p2 = document.getElementById("confirmP").value;//获取重新输入的密码值
    if (p1 == "") {
        alert("请输入密码！"); //检测到密码为空，提醒输入//
        document.form1.pwd1.focus(); //焦点放到密码框
        return false; //退出检测函数
    };

    if (p1 != p2) { //判断两次输入的值是否一致，不一致则显示错误信息
        document.getElementById("confirmP").style.backgroundColor="red";
        return false;
    } else {
        //密码一致，可以继续下一步操作 
    };
};

document.getElementById("confirmP").addEventListener('change', checkpwd);
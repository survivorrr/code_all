function userLoginMouseContrl(){
	var ok=true;
	var name=$("#count").val().trim();
	var password=$("#password").val().trim();
	$("#count_span").html("");
	$("#password_span").html("");
	if(name==""){
		$("#count_span").html("用户名不能为空");
		ok=false;
	}
	if(password==""){
		$("#password_span").html("密码不能为空");
		ok=false;
	}
	//发送请求
	if(ok){
		$.ajax({
			url:path+"/user/login.do",
			type:"post",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(result){     //回调处理success或者error
				//result是服务器返回的JSON结果
				if(result.status==0){
					//将用户的信息保存到Cookie
					var userId = result.data.cn_user_id;
					addCookie("userId",userId,2);
					window.location.href="edit.html";
				}else if(result.status==1){//用户名错误
					$("#count_span").html(result.msg);
				}else if(result.status==2){//密码错误
					$("#password_span").html(result.msg);
				}
			},
			error:function(){
				alert("登录失败！");
			}
		});	
	}	
};
function userLoginKeyContrl(event){ 
	var code = event.keyCode;
	if(code==13){
		var ok=true;
		var name=$("#count").val().trim();
		var password=$("#password").val().trim();
		$("#count_span").html("");
		$("#password_span").html("");
		if(name==""){
			$("#count_span").html("用户名不能为空");
			ok=false;
		}
		if(password==""){
			$("#password_span").html("密码不能为空");
			ok=false;
		}
		//发送请求
		if(ok){
			$.ajax({
				url:path+"/user/login.do",
				type:"post",
				data:{"name":name,"password":password},
				dataType:"json",
				success:function(result){     //回调处理success或者error
					//result是服务器返回的JSON结果
					if(result.status==0){
						//将用户的信息保存到Cookie
						var userId = result.data.cn_user_id;
						addCookie("userId",userId,2);
						window.location.href="edit.html";
					}else if(result.status==1){//用户名错误
						$("#count_span").html(result.msg);
					}else if(result.status==2){//密码错误
						$("#password_span").html(result.msg);
					}
				},
				error:function(){
					alert("登录失败！");
				}
			});	
		}	
	}
};

function userRegist(){
	//获取参数
	var name=$("#regist_username").val().trim();
	var nick=$("#nickname").val().trim();
	var password=$("#regist_password").val().trim();
	var final_password=$("#final_password").val().trim();
//	alert(name+" "+nick+" "+password+" "+final_password);
	//检查数据格式
	//检查用户
	var ok=true;
	if(name==""){
		$("#warning_1 span").html("用户不能为空");
		$("#warning_1").show();//本来这个内容是隐藏的，当格式不对时span里面加载“用户不能为空”，然后通过show()显示出来。
		ok=false;
	}
	//检测密码
	if(password==""){
		$("warning_2 span").html("密码不能为空");
		$("#warning_2").show();
		ok=false;
	}else if(password.length>0 && password.length<6){
		$("#warning_2 span").html("密码不能小于6位");
		$("#warning_2").show();
		ok=false;
	}
	//检测确认密码
	if(final_password!=password){
		$("#warning_3 span").html("输入密码不一致");
		$("#warning_3").show();
		ok=false;
	}
	if(ok){//数据校验通过
		$.ajax({
			url:path+"/user/add.do",
			type:"post",
			data:{"name":name,"nick":nick,"password":password},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					alert(result.msg);
					//执行返回
					$("#back").click();               //这里为什么不单击，就可以直接自动返回?????????????????
				}else if(result.status==1){
					//用户名被占用
					$("#warning_1 span").html(result.msg);
					$("#warning_1").show();
				}
			},
			error:function(){
				alert("注册失败");
			}
		})
	}
}

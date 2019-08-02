//搜索分享笔记
function sureSearchShare(event){
	var code = event.keyCode;
	if(code==13){
		//清空搜索区域原有的笔记列表
		$("#search_ul").empty();
		//切换显示区
		$("#pc_part_2").hide();//隐藏全部笔记列表
		$("#pc_part_6").show();//显示搜索的结果列表
		//获取请求参数
		var keyword=$("#search_note").val().trim();
		page=1;
		//发送ajax请求
		loadPageShare(keyword,page);
	}
};

//点击更多继续加载
function moreSearchShare(){
	//获取参数
	var keyword=$("#search_note").val().trim();
	page = page+1;
	//发送ajax请求加载列表
	loadPageShare(keyword,page);
};

function loadPageShare(keyword,page){
	$.ajax({
		url:path+"/share/search.do",
		type:"post",
		data:{"keyword":keyword,"page":page},
		dataType:"json",
		success:function(result){
			var shares = result.data;
			for(var i=0;i<shares.length;i++){
				//获取shareId
				var shareId = shares[i].cn_share_id;
				//获取shareTitle
				var shareTitle = shares[i].cn_share_title;
				//获取li对象
				var sli="";
				sli+='<li class="online">';
				sli+='	<a>';
				sli+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				sli+= shareTitle;
				sli+='		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				sli+='	</a>';
				sli+='</li>';
				var $li = $(sli);
				//绑定shareId
				$li.data("shareId",shareId);
				//将li对象添加到ul当中
				$("#search_ul").append($li);
			}
		},
		error:function(){
			alert("查询失败");
		}
	});
}

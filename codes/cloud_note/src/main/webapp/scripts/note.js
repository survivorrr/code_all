/**note.js 封装笔记相关操作**/
//分页加载搜索分享笔记
function searchSharePage(keyword,page){
 $.ajax({
     //url:base_path+"/note/hight_search.do",
		 url:base_path+"/note/search_share.do",
		 type:"post",
		 data:{"keyword":keyword,"page":page},
		 dataType:"json",
		 success:function(result){
			 if(result.status==0){
				 //获取服务器返回的搜索结果
				 var shares = result.data;
				 //循环解析生成列表li元素
				 for(var i=0;i<shares.length;i++){
					 var shareId = //分享ID
						 shares[i].cn_share_id;
					 var shareTitle = //分享标题
						 shares[i].cn_share_title;
					 //生成一个li
				var sli = "";
				sli+='<li class="online">';
				sli+='	<a>';
				sli+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				sli+= shareTitle;
				sli+='		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-star"></i></button>';
				sli+='	</a>';
				sli+='</li>';
				var $li = $(sli);
				$li.data("shareId",shareId);
					 //添加到搜索结果ul中
					 $("#pc_part_6 ul").append($li);
				 }
			 }
		 },
		 error:function(){
			 alert("搜索异常");
		 }
	 });
};

//分享笔记
function shareNote(){
	//获取请求参数
	$li = $(this).parents("li"); //this代表点击的那个对象，即这里指分享的按钮
	var noteId = $li.data("noteId");
	//发送请求
	$.ajax({
		url:path+"/share/add.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var noteTitle = result.data.cn_share_title;
				var sli="";
				sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				sli+= noteTitle;
				sli+='<i class="fa fa-sitemap"></i>';
				sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				$li.find("a").html(sli);
				alert(result.msg);
			}
		},
		error:function(){
			alert("分享笔记失败")
		}
	});
};
//转移笔记
function moveNote(){
	 //获取请求参数
	 //获取要转移的笔记ID
	 var $li = 
		$("#note_ul a.checked").parent();
	 var noteId = $li.data("noteId");
	 //获取要转入的笔记本ID
	 var bookId = $("#moveSelect").val();
	 //发送Ajax请求
	 $.ajax({
		 url:base_path+"/note/move.do",
		 type:"post",
		 data:{"noteId":noteId,"bookId":bookId},
		 dataType:"json",
		 success:function(result){
			 if(result.status==0){
				 //移除笔记li
				 $li.remove();
				 //提示成功
				 alert(result.msg);
			 }
		 },
		 error:function(){
			 alert("转移笔记异常");
		 }
	 });
 };
//删除笔记
function deleteNote(){
	 //获取请求参数
	 var $li = $("#note_ul a.checked").parent();
	 var noteId = $li.data("noteId");
	 //发送Ajax请求
	 $.ajax({
		 url:path+"/note/delete.do",
		 type:"post",
		 data:{"noteId":noteId},
		 dataType:"json",
		 success:function(result){
			 if(result.status==0){
				// alert("确定删除此笔记？");  //当多个alert()写在一起时，直接执行最后一个alert(),前面的alert()跳过
				 //删除li
				 $li.remove();
				 //提示成功
				 alert(result.msg);
			 }
		 },
		 error:function(){
			 alert("删除笔记异常");
		 }
	 });
 };
//隐藏笔记菜单
function hideNoteMenu(){
	 //隐藏所有笔记菜单
	 $("#note_ul div").hide();
 };
//弹出笔记菜单
function popNoteMenu(){
	$("#note_ul a").removeClass("checked");
	$(this).parents("li").find("a").addClass("checked");
	//隐藏所有的下拉菜单
	$("#note_ul div").hide();
	//$("#note_ul").find("div").hide(); //这种与上面效果相同
	//显示点击的下拉菜单
	$(this).parents("li").find("div").slideDown(1000);
	return false;   //阻止冒泡事件
};
//创建笔记操作
function addNote(){
	 var userId = getCookie("userId");  //获取请求参数
	 var noteTitle = $("#input_note").val().trim();  //获取对话框中笔记名称
	 var $li = $("#book_ul a.checked").parent();  //获取选中的笔记本li元素
	 var bookId = $li.data("bookId");
	 //检查格式
	 var ok = true;
	 if(userId==null){
		 ok = false;
		 window.location.href="log_in.html";
	 }
	 if(noteTitle==""){
		 ok = false;
		 $("#title_span").html("笔记名称为空");
	 }
	 //发送Ajax请求
	 if(ok){
		 $.ajax({
			 url:path+"/note/addNote.do",
			 type:"post",
			 data:{"userId":userId,"noteTitle":noteTitle,"bookId":bookId},
			 dataType:"json",//返回数据的格式
			 success:function(result){
				 if(result.status==0){
					 //关闭对话框
					 closeAlertWindow();
					 //生成笔记列表li
					 var noteId = result.data.cn_note_id;//获取服务器返回的笔记ID
					 createNoteLi(noteId,noteTitle);
					 //弹出提示
					 alert(result.msg);
				 }
			 },
			 error:function(){
				 alert("创建笔记异常");
			 }
		 });
	 }
 };
//"保存笔记"按钮的处理
 function updateNote(){
	//获取参数
	var $li=$("#note_ul a.checked").parent();
	//获取笔记id
	var noteId = $li.data("noteId");
	//获取笔记的标题和内容
	var noteTitle = $("#input_note_title").val().trim();
	var noteBody = um.getContent();
 	$.ajax({
		url:path+"/note/update.do",
		type:"post",
		data:{"noteId":noteId,"noteTitle":noteTitle,"noteBody":noteBody},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var str="";
				str+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				str+= noteTitle;
				str+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				//将str替换到li的a元素里
				$li.find("a").html(str);
				//提示成功
				alert(result.msg);
			}
		},
		error:function(){
			alert("笔记保存失败");
		}
	}); 
};
//根据笔记ID加载笔记信息
 function loadNote(){
	//设置选中效果
	 $("#note_ul a").removeClass("checked");
	//$("#note_ul").find("a").removeClass("checked");//这个效果和上面的效果一样
	$(this).find("a").addClass("checked");
	//获取请求参数
	var noteId=$(this).data("noteId");//之前在添加li元素的时候通过$(li).data("noteId",noteId)绑定过noteId
	//发送ajax请求
	$.ajax({
		url:path+"/note/loadNote.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				//获取返回的笔记标题
				var title = result.data.cn_note_title;
				//获取笔记的内容
				var body = result.data.cn_note_body;
				//设置笔记标题
				$("#input_note_title").val(title);
				//设置笔记内容
				um.setContent(body);
			}
		},
		error:function(){
			alert("加载笔记信息失败");
		}
	});
};
//根据笔记本ID加载笔记列表
 function loadBookNotes(){   
	//清除原来的选中效果
	$("#book_ul a").removeClass("checked");
	//设置选中效果
	$(this).find("a").addClass("checked");
	//切换显示区域
	$("#pc_part_2").show();//显示搜索结果列表
	$("#pc_part_6").hide();//隐藏全部笔记列表
	//获取参数
	var bookId = $(this).data("bookId");
	$.ajax({
		url:path+"/note/loadNotes.do",
		type:"post",
		data:{"bookId":bookId},
		dataType:"json",
		
		success:function(result){
			//获取笔记信息
			var notes = result.data;
			//清除原列表信息
			$("#note_ul").empty();
		//	$("#note_ul li").remove();  //这个效果和上面的效果一样
			for(var i=0;i<notes.length;i++){
				//获取笔记ID
				var noteId = notes[i].cn_note_id;
				//获取笔记标题
				var noteTitle = notes[i].cn_note_title;
				//生成笔记li
				createNoteLi(noteId,noteTitle);
			}
		},
		error:function(){
			alert("笔记加载失败");
		}
	});
};
 
 //创建笔记列表li元素
 function createNoteLi(noteId,noteTitle){
	var sli = "";
	sli+='<li class="online">';
	sli+='	<a>';
	sli+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	sli+= noteTitle;
	//sli+='<i class="fa fa-sitemap"></i>';
	sli+='		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	sli+='	</a>';
	sli+='	<div class="note_menu" tabindex="-1">';
	sli+='		<dl>';
	sli+='			<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	sli+='			<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	sli+='			<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	sli+='		</dl>';
	sli+='	</div>';
	sli+='</li>';
	//转换为jQuery对象
	var $li = $(sli);
	//将noteId绑定到li元素上
	$li.data("noteId",noteId);
	//将li元素添加到笔记列表ul中
	$("#note_ul").append($li); 
 };
 
 
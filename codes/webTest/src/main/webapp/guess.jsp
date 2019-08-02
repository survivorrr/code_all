<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>猜数字游戏</title>
<script src="my.js"></script>
	<script>
		var	ran = parseInt(10*Math.random());
		console.log(ran);
		function guess(){
			var n = $F("num");	//这些是js的语法，$(".(#)num").value("")，类似这种语法的是jquery的语法，别搞混淆了.
			console.log(n);
/* 
$F("num")在没有进入guess函数之前，也就是说把$F("num")写在guess()外面是会报错的，	Uncaught TypeError: Cannot read property 'value' of null,因为
 
function $(id){return document.getElementById(id);}
function $F(id){return $(id).value;	} 这两个函数封装好了，如果写在guess外面的话，在没有进入guess的时候是不会执行的，所以赚不到id为num的元素，所以用
									value属性会报错。如果写在guess里面，当点击按钮执行guess函数的时候，这两个函数才会获得动力去执行并获得元素和元素的值。
*/
			if(isNaN(n)){
				$("result").innerHTML="请输入一个数字";
			}else{
				if(n > ran){
					$("result").innerHTML="大了";
				}else if(n < ran){
					$("result").innerHTML="小了";
				}else{
					$("result").innerHTML="对了";
				}
			}		
		}
	
	</script>
</head>
<body >
	<input type="text" id="num" style="font-size: 30px"/>
	<input type="button" id="butt" value="猜" onclick="guess();" style="font-size: 30px"/>
	<!--  <input type="text" id="result" style="font-size: 30px"/>  -->
	<span id="result" style="font-size: 30px"></span>
</body>
</html>
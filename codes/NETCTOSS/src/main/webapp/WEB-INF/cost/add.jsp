<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>达内－NetCTOSS</title>
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global_color.css" />
<script language="javascript" type="text/javascript">
            //保存结果的提示
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }

            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                if (type == 1) {
                    inputArray[4].readOnly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readOnly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readOnly = true;
                    inputArray[6].className += " readonly";
                    inputArray[6].value = "";
                }
                else if (type == 2) {
                    inputArray[4].readOnly = false;
                    inputArray[4].className = "width100";
                    inputArray[5].readOnly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readOnly = false;
                    inputArray[6].className = "width100";
                }
                else if (type == 3) {
                    inputArray[4].readOnly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readOnly = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readOnly = false;
                    inputArray[6].className = "width100";
                }
            }
        </script>
</head>
<body>
	<!--Logo区域开始-->
	<div id="header">
		<c:import url="../logo.jsp"></c:import>
	</div>
	<!--Logo区域结束-->
	<!--导航区域开始-->
	<div id="navi">
		<!--     include file="../menu.jsp" 外面套一个百分号加@  -->
		<!-- 	不用这个include形式是因为可以用一个标签代替这个include,为什么要代替这个include-->
		<!-- 	是因为如果jsp页面给美工去改的话美工不方便，写成如下标签形式就可以了，但是要引入上面-->
		<!-- 	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->

		<c:import url="../menu.jsp"></c:import>
	</div>
	<!--导航区域结束-->
	<!--主要区域开始-->
	<div id="main">
		<div id="save_result_info" class="save_fail">保存失败，资费名称重复！</div>
		<!-- 
            	当前:/NETCTOSS/toAddCost.do
            	 目标:/NETCTOSS/addCost.do-->
		<form action="addCost.do" method="post" class="main_form">
			<div class="text_info clearfix">
				<span>资费名称：</span>
			</div>
			<div class="input_info">
				<input type="text" class="width300" name="name" /> <span
					class="required">*</span>
				<div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
			</div>
			<div class="text_info clearfix">
				<span>资费类型：</span>
			</div>
			<div class="input_info fee_type">
				<input type="radio" name="costType" value="1" id="monthly"
					onclick="feeTypeChange(1);" /> <label for="monthly">包月</label> <input
					type="radio" name="costType" value="2" checked="checked"
					id="package" onclick="feeTypeChange(2);" /> <label for="package">套餐</label>
				<input type="radio" name="costType" value="3" id="timeBased"
					onclick="feeTypeChange(3);" /> <label for="timeBased">计时</label>
			</div>
			<div class="text_info clearfix">
				<span>基本时长：</span>
			</div>
			<div class="input_info">
				<input type="text" name="baseDuration" class="width100" /> <span
					class="info">小时</span> <span class="required">*</span>
				<div class="validate_msg_long">1-600之间的整数</div>
			</div>
			<div class="text_info clearfix">
				<span>基本费用：</span>
			</div>
			<div class="input_info">
				<input type="text" name="baseCost" class="width100" /> <span
					class="info">元</span> <span class="required">*</span>
				<div class="validate_msg_long error_msg">0-99999.99之间的数值</div>
			</div>
			<div class="text_info clearfix">
				<span>单位费用：</span>
			</div>
			<div class="input_info">
				<input type="text" name="unitCost" class="width100" /> <span
					class="info">元/小时</span> <span class="required">*</span>
				<div class="validate_msg_long error_msg">0-99999.99之间的数值</div>
			</div>
			<div class="text_info clearfix">
				<span>资费说明：</span>
			</div>
			<div class="input_info_high">
				<textarea name="descr" class="width300 height70"></textarea>
				<div class="validate_msg_short error_msg">100长度的字母、数字、汉字和下划线的组合</div>
			</div>
			<div class="button_info clearfix">
				<input type="submit" value="保存" class="btn_save" /> <input
					type="button" value="取消" class="btn_save" onclick="history.back();" />
			</div>
		</form>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span> <br /> <span>版权所有(C)加拿大达内IT培训集团公司
		</span>
	</div>
</body>
</html>

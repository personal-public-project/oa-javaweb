<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
</head>
<body>
	姓名：<input id="userName" name="userName" />
	<input id="btnSave" type="button" value="提交">
	
	<script type="text/javascript" src="jquery-3.2.0.min.js"></script>
	<script type="text/javascript">
		// 页面加载完成后执行
		$(function(){
			// 绑定点击事件
			$("#btnSave").click(function(){
				var userName = $("#userName").val();
				$.ajax({
					url:"AddUserServlet",// 后端处理的服务
					type:"post",
					data:{userName:userName},
					dataType:"json",
					success:function(data){ // 回调函数
						console.log(data);
					}
				});
			});
		});
	</script>
</body>
</html>
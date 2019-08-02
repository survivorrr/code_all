<%@page pageEncoding="utf-8"
	import="entity.Emp,dao.*,java.util.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>查询员工</title>
	</head>
	<body>
		<table border="1" cellspacing="0" width="40%"/>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>职位</td>
				<td>薪水</td>
			</tr>
			<%
				EmpDao dao = new EmpDaoImpl();
				List<Emp> list= dao.findAll();
				if(list!=null){
					for(Emp e:list){
			%>			
				<tr>
						<td><%=e.getEmpno()%></td>	
						<td><%=e.getEname()%></td>	
						<td><%=e.getJob()%></td>	
						<td><%=e.getSal()%></td>	
				</tr>			
			<%	
					}		
				}
			%>
		</table>
	</body>
</html>
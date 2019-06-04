<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800"  border="1" align="center" cellspacing="0">
	<caption>公司部门信息</caption>
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>地点</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
<c:forEach var="dept"  items="${depts }"  varStatus="i">
		<tr>
		<th>${(page.thePage-1)*page.pageRow+i.index+1}</th>
		<th> ${dept.dname} </th>
		<th>${dept.loc}</th>
		<th><a href="DeptServlet.do?method=getDept&deptno=${dept.deptno}">编辑</a></th>
		<th><a href="DeptServlet.do?method=delDept&deptno=${dept.deptno}">删除</a></th>
		</tr>
</c:forEach>	
		<tr>
<th colspan="4">
<a href="DeptServlet.do?method=findAll&thePage=1">首页</a>
<a href="DeptServlet.do?method=findAll&thePage=${page.thePage==1?1:(page.thePage-1)}">上一页</a>
<a href="DeptServlet.do?method=findAll&thePage=${page.thePage==page.pageCount?page.pageCount:(page.thePage+1)}">下一页</a>
<a href="DeptServlet.do?method=findAll&thePage=${page.pageCount}">末页</a>
</th>
</tr>
</table>
<a href="DeptAdd.jsp">添加部门</a>
</body>
</html>
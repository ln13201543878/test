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
	<caption>公司员工信息</caption>
		<tr>
			<th>序号</th>
			<th>员工姓名</th>
			<th>职位</th>
			<th>上级</th>
			<th>入职日期</th>
			<th>工资</th>
			<th>奖金</th>
			<th>部门</th>
			<th>转部门</th>
		</tr>
	<c:forEach     var="emp"  items="${emps}"  varStatus="i">
		<tr>
		<th>${i.index+1}</th>
		<th> ${emp.ename} </th>
		<th>${emp.job}</th>
		
		<c:forEach var="emp2" items="${emps }" >
		<c:if test="${emp.mgr==emp2.empno }">
		<th>${emp2.ename}</th>
		</c:if>	
		</c:forEach>
		<c:if test="${emp.mgr=='' }">
		<th>Boss</th>
		</c:if>
	
		
		 <th>${emp.hiredate}</th>
		<th>${emp.sal}</th>
		<th>${emp.comm}</th>
		<c:forEach var="dept" items="${depts }" >
		<c:if test="${emp.deptno==dept.deptno }">
		<th>${dept.dname}</th>	
		</c:if>
		</c:forEach>
		<th><a href="EmpServlet.do?method=turnDept&empno=${emp.empno  }">转部门</a></th>
		</tr>
		
		</c:forEach>
		
	</table>
	
<a href="EmpServlet.do?method=findAll2">添加信息</a>
</body>
</html>
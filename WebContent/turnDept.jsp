<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="EmpServlet.do?method=turnDeptDo" method="post">


		<input type="hidden" name="empno" value="${emp.empno }" />

		员工姓名:${emp.ename}</br> 
		新部门: <select name="deptno">
			<c:forEach var="dept" items="${depts }">
				<c:if test="${dept.deptno!=emp.deptno }">
					<option value="${dept.deptno }">${dept.dname }</option>
				</c:if>
				<c:if test="${dept.deptno==emp.deptno }">
				<c:set var="dnow"  value="${dept.dname }"></c:set>
				</c:if>
			</c:forEach>
		</select></br>
		当前部门:${dnow }</br>

	


		

		<button>确定</button>

	</form>

</body>
</html>
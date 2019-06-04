<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  action="DeptServlet.do?method=editDept"  method="post">
<input type="hidden"   name="deptno"  value="${depts.deptno }"/>
<table>
<caption>修改部门信息</caption>
<tr>
<th>部门名称</th>
<td><input type="text" name="dname"  value="${depts.dname }"></td>
</tr>
<tr>
<th>部门城市</th>
<td><input type="text" name="loc"  value="${depts.loc }"></td>
</tr>

</table>
<button >添加</button>
</form>
</body>
</html>
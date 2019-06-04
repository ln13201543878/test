<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  action="DeptServlet.do?method=addDept"  method="post">
<table>
<caption>添加部门</caption>

<tr>
<th>部门编号</th>
<td><input type="text"   name="deptno"></td>
</tr>
<tr>
<th>部门名称</th>
<td><input type="text" name="dname"></td>
</tr>
<tr>
<th>部门城市</th>
<td><input type="text" name="loc"></td>
</tr>

</table>
<button >添加</button>
</form>

</body>
</html>
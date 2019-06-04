<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	for(var i=80;i<120;i++){
		var objValue=$("<option></option>");
		objValue.val(i);
		objValue.html(i);
		$("#year").append(objValue);
	}
	for(var i=1;i<13;i++){
		var monValue=$("<option></option>");
		monValue.val(i);
		monValue.html(i);
		$("#month").append(monValue);
	}
	$("#year").change(function(){
		var yearValue=$("#year").val();
		var monthValue=$("#month").val();
		var d=new Date(yearVal,monthValue,0);
		dateNum=d.getDate();
		showDate();
	});
	$("#month").change(function(){
		var yearValue=$("#year").val();
		var monthValue=$("#month").val();
		var d=new Date(yearVal,monthValue,0);
		dateNum=d.getDate();
		showDate();
	});
	var dateNum=31;
	showDate();
	function showDate(){
		$("#date").empty();
		for(var i=1;i<=dateNum;i++){
		var dateValue=$("<option></option>");
		dateValue.val(i);
		dateValue.html(i);
		$("#date").append(dateValue);
		
		}
	}
	$("#empno").blur(function(){
		checkEmpno();
	});
	function  checkEmpno(){
		var empnoValue=$("#empno").val();
		var zz=/^\d{4}$/;
		var flag=false;
		var message ="<font color='red'>no</font>";
		if(zz.test(empnoValue)){
			flag=true;
			message="<font color='green'>ok</font>";
		}
		$("#empno").next().html(message);
		return flag;
	}
	function checkAll(){
		return checkEmpno();
	}
	$("form").submit(function(){
		return checkAll();
	});
});
</script>
<body>

	<form action="EmpServlet.do?method=addEmp" method="post">
		<table width="800" border="1" align="center">
			<caption>添加员工</caption>


			<tr>
			<th>员工号</th>
				<td><input type="text" id="empno"  name="empno"/><span></span></td>
			</tr>
			<tr>
			<th>姓名</th>
				<td><input type="text" name="ename" /></td>
			</tr>
			<tr>
			<th>职位</th>
				<td><input type="text" name="job" /></td>
			</tr>

			<tr>
			<th>上级编号</th>
				<td><select name="mgr">
						
						<c:forEach var="emp"   items="${emps }">
							<option value="${emp.empno }">${emp.ename }</option>
					</c:forEach>
				</select>
				</td>
			</tr>

			<tr>
			<th>入职日期</th>
				<td><select id="year"  name="year"></select>年 
				<select id="month" name="month"></select>月
					<select id="date" name="date"></select>日</td>
			</tr>
			<tr>
			<th>工资</th>
				<td><input type="text" name="sal" /></td>
			</tr>
			<tr>
			<th>奖金</th>
				<td><input type="text" name="comm" /></td>
			</tr>
			<tr>
			<th>部门编号</th>
				<td><select name="deptno">
				<c:forEach var="dept"  items="${depts }">
				<option value="${dept.deptno }">
				${dept.dname }
				</option>
				</c:forEach></select></td>
			</tr>
			<tr>
			<th colspan="2">
			<input type="submit"  value="添加员工"  />
			<input type="reset"  value="重置"/>
			</th>
			</tr>

		</table>
	</form>

</body>
</html>
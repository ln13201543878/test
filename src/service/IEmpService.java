package service;

import java.util.List;

import bean.Dept;
import bean.Emp;

public interface IEmpService {
	void addEmp(Emp emp);
	void editEmp(Emp emp);
	void deleteEmp(Integer empno);
	Emp getEmp(Integer empno);
	List<Emp> getAllEmp();
	void turnDept(int empno, int deptno);
}

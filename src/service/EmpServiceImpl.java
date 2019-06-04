package service;

import java.util.List;

import bean.Dept;
import bean.Emp;
import dao.DaoFactory;

public class EmpServiceImpl implements IEmpService {

	@Override
	public void addEmp(Emp emp) {
		DaoFactory.getEmpDao().save(emp);
	}

	@Override
	public void editEmp(Emp emp) {
		DaoFactory.getEmpDao().update(emp);
	}

	@Override
	public void deleteEmp(Integer empno) {
		DaoFactory.getEmpDao().delete(empno);
	}

	@Override
	public Emp getEmp(Integer empno) {
		return DaoFactory.getEmpDao().findOne(empno);
	}

	@Override
	public List<Emp> getAllEmp() {
		return DaoFactory.getEmpDao().findAll();
	}

	@Override
	public void turnDept(int empno, int deptno) {
	Emp emp=DaoFactory.getEmpDao().findOne(empno);
	emp.setDeptno(deptno);
	DaoFactory.getEmpDao().update(emp);
	}

}

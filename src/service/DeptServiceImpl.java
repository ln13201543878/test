package service;

import java.util.List;

import bean.Dept;
import bean.Emp;
import bean.Page;
import dao.DaoFactory;

public class DeptServiceImpl implements IDeptService {

	@Override
	public void addDept(Dept dept) {
		DaoFactory.getDeptDao().save(dept);
	}

	@Override
	public void editDept(Dept dept) {
		DaoFactory.getDeptDao().update(dept);
	}

	@Override
	public void deleteDept(Integer deptno) {
		List<Emp>emps=DaoFactory.getEmpDao().findAll();
		for (Emp emp : emps) {
			if(emp.getDeptno()==deptno) {
				emp.setDeptno(0);
				DaoFactory.getEmpDao().update(emp);
			}
		}
		DaoFactory.getDeptDao().delete(deptno);
	}

	@Override
	public Dept getDept(Integer deptno) {
		return DaoFactory.getDeptDao().findOne(deptno);
	}

	@Override
	public List<Dept> getAllDept() {
		return DaoFactory.getDeptDao().findAll();
	}

	@Override
	public List<Dept> getAllDeptByPage(Page page) {
		List<Dept>depts=DaoFactory.getDeptDao().findAll();
		page.setPageRowCount(depts.size());
		page.setPageCount(depts.size()%page.getPageRow()==0?depts.size()/page.getPageRow():depts.size()/page.getPageRow()+1);
		List<Dept>depts2=DaoFactory.getDeptDao().findAllByPage(page);
		return depts2;
	}

}

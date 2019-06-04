package service;

import java.util.List;

import bean.Dept;
import bean.Page;

public interface IDeptService {
	void addDept(Dept dept);
	void editDept(Dept dept);
	void deleteDept(Integer deptno);
	Dept getDept(Integer deptno);
	List<Dept> getAllDept();
	List<Dept> getAllDeptByPage(Page page);
}

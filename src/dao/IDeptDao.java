package dao;

import java.util.List;

import bean.Dept;
import bean.Page;

public interface IDeptDao {
	void save(Dept dept);
	void delete(Integer deptno);
	void update(Dept dept);
	Dept findOne(Integer deptno);
	List<Dept>findAll();
	List<Dept> findAllByPage(Page page);
}

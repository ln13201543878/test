package dao;

import java.util.List;

import bean.Emp;

public interface IEmpDao {
	void save(Emp emp);
	void delete(Integer empno);
	void update(Emp emp);
	Emp findOne(Integer empno);
	List<Emp> findAll();
}

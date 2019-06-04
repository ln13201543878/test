package dao;

import java.util.List;

import bean.Dept;
import bean.Emp;
import util.BaseDao;

public class EmpDaoImpl implements IEmpDao {
	BaseDao<Emp> bd = new BaseDao();

	@Override
	public void save(Emp emp) {
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		Object[] objs = { emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(),
				emp.getComm(), emp.getDeptno() };
		bd.update(sql, objs);
	}

	@Override
	public void delete(Integer empno) {
		String sql = "delete from emp where empno=?";
		Object[] objs = { empno };
		bd.update(sql, objs);
	}

	@Override
	public void update(Emp emp) {
		String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=?  where  empno=?";
		Object[] objs = { emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(),
				emp.getDeptno(), emp.getEmpno() };
		bd.update(sql, objs);
	}

	@Override
	public Emp findOne(Integer empno) {
		String sql = "select * from emp where empno=?";
		Object[] objs = { empno };
		List<Emp> emps = bd.select(sql, objs, Emp.class);
		return emps.size() == 0 ? null : emps.get(0);
	}

	@Override
	public List<Emp> findAll() {
		String sql = "select * from emp";
		Object[] objs = {};
		List<Emp> emps = bd.select(sql, objs, Emp.class);
		return emps;
	}

}

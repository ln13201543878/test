package dao;

import java.util.List;

import bean.Dept;
import bean.Page;
import util.BaseDao;

public class DeptDaoImpl implements IDeptDao {
	BaseDao<Dept> bd=new BaseDao();
	@Override
	public void save(Dept dept) {
		String sql="insert into dept values(?,?,?)";
		Object[] objs= {dept.getDeptno(),dept.getDname(),dept.getLoc()};
		bd.update(sql, objs);
		
	}

	@Override
	public void delete(Integer deptno) {
		String sql="delete from dept where deptno=?";
		Object[] objs= {deptno};
		bd.update(sql, objs);
	}

	@Override
	public void update(Dept dept) {
		String sql="update dept set dname=?,Loc=?  where deptno=?";
		Object[] objs= {dept.getDname(),dept.getLoc(),dept.getDeptno()};
		bd.update(sql, objs);
	}

	@Override
	public Dept findOne(Integer deptno) {
		String sql="select * from dept where deptno=?";
		Object[] objs= {deptno};
		List<Dept>depts=bd.select(sql, objs, Dept.class);
		return depts.size()==0?null:depts.get(0);
	}

	@Override
	public List<Dept> findAll() {
		String sql="select * from dept";
		Object[] objs= {};
		List<Dept>depts=bd.select(sql, objs, Dept.class);
		return depts;
	}

	@Override
	public List<Dept> findAllByPage(Page page) {
		String sql="select * from dept limit ?,?";
		Object[] objs= {(page.getThePage()-1)*page.getPageRow(),page.getPageRow()};
		List<Dept>depts=bd.select(sql, objs, Dept.class);
		return depts;
	}

}

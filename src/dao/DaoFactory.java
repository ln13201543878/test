package dao;

public class DaoFactory {
	public static IDeptDao getDeptDao() {
		return new DeptDaoImpl();
	} 
	public static IEmpDao getEmpDao() {
		return new EmpDaoImpl();
	}
}

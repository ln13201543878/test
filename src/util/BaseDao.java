package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDao<T> {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public void update(String sql, Object[] objs) {
		try {
			con = JdbcUtils.getcon();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i + 1, objs[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, ps, con);
		}

	}

	public List<T> select(String sql, Object[] objs, Class<T> c) {
		List<T> list = new ArrayList<T>();
		try {
			con = JdbcUtils.getcon();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i + 1, objs[i]);
			}
			rs=ps.executeQuery();
			while (rs.next()) {
				T t = (T) c.newInstance();
				Method[] methods = c.getMethods();
				for (int i = 0; i < methods.length; i++) {
					Method m = methods[i];
					String mName = m.getName();
					if (mName.startsWith("set")) {
						String fieldName = mName.substring(3);
						// 获得方法的参数列表类型 setUid(Integer uid); {Integer.class}
						Class[] cs = m.getParameterTypes();

						if(cs[0]==Integer.class){
							m.invoke(t, rs.getInt(fieldName));
						}else if(cs[0]==String.class){
							//调用自己  course.setCno(rs.getString("cno"));
							m.invoke(t, rs.getString(fieldName));
						}else if(cs[0]==Date.class){
							//调用自己  course.setCno(rs.getString("cno"));
							m.invoke(t, rs.getDate(fieldName));
						}else if(cs[0]==Double.class){
							//调用自己  course.setCno(rs.getString("cno"));
							m.invoke(t, rs.getDouble(fieldName));
						}else if(cs[0]==Float.class){
							//调用自己  course.setCno(rs.getString("cno"));
							m.invoke(t, rs.getFloat(fieldName));
						}
					}
				}
				list.add(t);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(rs, ps, con);
		}

		return list;
	}

}

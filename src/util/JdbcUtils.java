package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	static String driver;
	static String url;
	static String user;
	static String password;
	static Connection con;
	static {
		Properties pro = new Properties();
		try {
			pro.load(JdbcUtils.class.getResourceAsStream("db.properties"));
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			password=pro.getProperty("password");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getcon() throws SQLException {
		con=DriverManager.getConnection(url,user,password);
		return con;
	}
	public static void close(ResultSet rs,Statement sta,Connection con) {
		try {
		if(rs!=null) {
				rs.close();
			} 
		if(sta!=null) {
			sta.close();
		}
		if(con!=null) {
			con.close();
		}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



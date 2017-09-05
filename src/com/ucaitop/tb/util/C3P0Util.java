package com.ucaitop.tb.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	
	private static ComboPooledDataSource datasourse = new ComboPooledDataSource();


	public static ComboPooledDataSource getDatasourse() {
		return datasourse;
	}
	public static Connection getConnection() throws SQLException{
		
		return datasourse.getConnection();
	}
	public static void release(Connection conn,Statement st,ResultSet rs){
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(st!=null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}

package com.book.common.sql;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	public static Connection getConnection() {
		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://127.0.0.1:3306/book_reviews";
			String user ="chaedud02";
			String pw ="0000";
			
			conn = DriverManager.getConnection(url, user, pw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && conn.isClosed() == false) {
				conn.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn){
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && conn.isClosed() == false) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && stmt.isClosed() == false) {
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!= null && rs.isClosed() == false) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
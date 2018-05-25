/**
 * 
 */
package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author LiuYanliang
 * 
 */
public class JdbcDemo {
	private static final String userName = "root";
	private static final String passWord = "root";
	private static final String sql = "select count(*) from pisp_user";
	private static final String sql2 = "select count(*) from pisp_user where USER_TYPE = ?";
	private  Connection conn = null;
	private  PreparedStatement pstmt = null;
	private  Statement stmt = null;
	private  ResultSet rs = null;
	
	
	/**
	 * 准备工作：获取数据库驱动和数据库连接
	 */
	@Before
	public void testBefore() {
		StringBuffer sb = new StringBuffer();
		sb.append("jdbc:mysql://localhost:3306/pisp?");
		sb.append("useUnicode=true&characterEncoding=UTF8");
		
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			conn = DriverManager.getConnection(sb.toString(), userName, passWord);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Statement执行sql语句
	 */
	@Test
	public void testJdbc1() {
		try {
			//获取sql执行者
			stmt = conn.createStatement();
			//执行sql语句
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 注意：下标从1开始
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * PreparedStatement执行sql语句
	 */
	
	@Test
	public void testJdbc2() {
		try {
			pstmt = conn.prepareStatement(sql2);
			//parameterIndex参数下标，从1开始，x参数值
			pstmt.setInt(1, 5);
			// 执行sql语句
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 注意：下标从1开始
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * 释放资源：先得到的后关闭
	 */
	@After
	public void testAfter() {
		try {
			if(rs != null){
				rs.close();
			}
			
			if(stmt != null){
				stmt.close();
			}
			
			if(pstmt != null){
				pstmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

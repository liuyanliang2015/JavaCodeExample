/**
 * 
 */
package com.test.jdbc;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author LiuYanliang
 * 
 */
public class JdbcInjectDemo {
	
	@Test
	public void test(){
		login("13683329671",md5Encode("329671"));
		login("13683329671' or '1=1",md5Encode("329671"));
	}

	/**
	 * 用户登录
	 * @param userName
	 * @param passWord
	 */
	public void login(String userName, String passWord) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.0.7:3306/ssmp", "root", "root");
			// 获取sql执行者
			stmt = conn.createStatement();
			// 执行sql语句
			String sql = "SELECT * from ssmp_account WHERE ACCOUNT_NAME ='"+userName+"' and PASSWORD='"+passWord+"'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("登录成功");
			}else{
				System.out.println("账号或者密码错误");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
	
	public static  String md5Encode(String source){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bs=md.digest(source.getBytes());
			StringBuffer buff=new StringBuffer();
    		for(int i=0;i<bs.length;i++){
    			String hex=Integer.toHexString(bs[i] & 0xFF);
    			if(hex.length()==1){
    				hex="0"+hex;
    			}
    			buff.append(hex);
    		}
    		return buff.toString();
		}catch(Exception e){
			e.printStackTrace();
			return source;
		}
	}

}

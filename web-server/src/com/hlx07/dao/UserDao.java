package com.hlx07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hlx07.domain.User;
import com.hlx07.utils.DBUtiles;

public class UserDao {
	
	public static boolean insert(User user){
		//1.连接数据库
		
		try {
			Connection conn =DBUtiles.getConnection("users");
			
			
			String sql="insert into user (username,userpass) values (?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			
			ps.setString(2, user.getUserpass());
			
			ps.execute();
			
			conn.close();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static boolean delete(String name){
		//1.连接数据库
		try {
			Connection conn =DBUtiles.getConnection("users");
			
			
			String sql="delete from user where username=?";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setString(1, name);
			
			ps.execute();
			
			conn.close();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAll(){
		//1.连接数据库
		try {
			Connection conn =DBUtiles.getConnection("users");
			
			Statement st = conn.createStatement();
			
			String sql="delete from user";
			
			st.execute(sql);
			
			conn.close();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void update(){
		//1.连接数据库
	}
	public void selectAll(){
		//1.连接数据库
	}
	/**
	 * 从数据库表中查找某一条记录的方法
	 * @param id（查找某一条记录的依据）
	 */
	public static User selectOne(String username){
		//
		User s=null;
		try {
			//
			Connection conn =DBUtiles.getConnection("users");
			String sql="select * from user where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				s=new User(rs.getString("username"), rs.getString("userpass"));
			}
			rs.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}

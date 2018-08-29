package com.hlx07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hlx07.domain.Student;
import com.hlx07.domain.User;
import com.hlx07.utils.DBUtiles;

public class StudentDao {
	
	public static boolean insert(Student student){
		//1.连接数据库
		
		try {
			Connection conn =DBUtiles.getConnection("users");
			
			
			String sql="insert into student (number,name,college,score) values (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, student.getNumber());
			
			ps.setString(2, student.getName());
			
			ps.setString(3, student.getCollege());
			
			ps.setString(4, student.getScore());
			
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
	/**
	 * 查找所有的用户
	 * @return
	 */
	public static ArrayList<Student> selectAll(){
		
		ArrayList<Student> students=new ArrayList<Student>();
		//1.连接数据库
		
		try {
			//
			Connection conn =DBUtiles.getConnection("users");
			String sql="select * from student";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Student s=new Student(rs.getString("number"), rs.getString("name"), rs.getString("college"), rs.getString("score"));
				students.add(s);
				s=null;
			}
			rs.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
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
	
	/**
	 * 根据你给的页的信息，查找这一页的用户
	 * @return
	 */
	public static ArrayList<Student> selectPageStudent(int currentPageIndex,int count){
		
		ArrayList<Student> students=new ArrayList<Student>();
		//1.连接数据库
		
		try {
			//
			Connection conn =DBUtiles.getConnection("users");
			String sql="select * from student limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			int startIndex =(currentPageIndex-1)*count;
			ps.setInt(1,startIndex);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Student s=new Student(rs.getInt("id"),rs.getString("number"), rs.getString("name"), rs.getString("college"), rs.getString("score"));
				students.add(s);
				s=null;
			}
			rs.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
	}
	
	
	/**
	 * 查找所有的用户
	 * @return
	 */
	public static int selectAllCount(){
		
		int count=0;
		//1.连接数据库
		
		try {
			//
			Connection conn =DBUtiles.getConnection("users");
			String sql="select count(*) from student";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	
}

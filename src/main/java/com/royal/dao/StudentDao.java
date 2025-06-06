package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.util.DbConnection;

public class StudentDao 
{
	public int insertStudent(StudentBean sbean) 
	{
		String insertQuery = "INSERT INTO student(name,std,marks) VALUES (?,?,?)";
		Connection conn = DbConnection.getConnection();
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
			
				pstmt.setString(1, sbean.getName());
				pstmt.setInt(2, sbean.getStd());
				pstmt.setInt(3, sbean.getMarks());
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao : insertStudent() Db not connected");
		}
		return rowsAffected;
	}
	public int updateStudent(int rno , StudentBean sbean) 
	{
		String updateQuery = "UPDATE student SET name=?, std=?, marks=? WHERE rno = ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateQuery);
			
				pstmt.setString(1, sbean.getName());
				pstmt.setInt(2, sbean.getStd());
				pstmt.setInt(3, sbean.getMarks());
				pstmt.setInt(4, sbean.getRno());
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao : updateStudent() Db not connected");
		}
		return rowsAffected;
		
	}
	public int deleteStudent(int rno) 
	{
		String deleteQuery = "DELETE FROM student WHERE rno = ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
			
				pstmt.setInt(1, rno);
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao : deleteStudent() Db not connected");
		}
		return rowsAffected;
	}
	public ArrayList<StudentBean> getAllStudentRecords() 
	{
		String selectQuery = "SELECT  * FROM student";
		Connection conn = DbConnection.getConnection();
		PreparedStatement pstmt = null;
		ArrayList<StudentBean> list  = new ArrayList<StudentBean>();
		StudentBean sbean =  null;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectQuery);
			
				ResultSet rs = pstmt.executeQuery();

				while(rs.next()) 
				{
					int rno = rs.getInt(1);
					String name = rs.getString(2);
					int std = rs.getInt(3);
					int marks = rs.getInt(4);
					
					sbean = new StudentBean(rno, name, std, marks);
					
					list.add(sbean); 
				}
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao : getAllStudentRecords() Db not connected");
		}
		return list;
	}
	public StudentBean getStudentByRno(int rno) 
	{
		String selectQuery = "SELECT  * FROM student WHERE rno=?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement pstmt = null;
		StudentBean sbean =  null;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectQuery);
			
				pstmt.setInt(1, rno);
				ResultSet rs = pstmt.executeQuery();

				rs.next(); 
				
				rno = rs.getInt(1);
				String name = rs.getString(2);
				int std = rs.getInt(3);
				int marks = rs.getInt(4);
				
				sbean = new StudentBean(rno, name, std, marks);
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao : getStudentByRno() Db not connected");
		}
		return sbean;
	}
}

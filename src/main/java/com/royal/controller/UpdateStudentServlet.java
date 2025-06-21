package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int rno	= Integer.parseInt(request.getParameter("rno"));
		
		System.out.println("Update--rno : " + rno);
		
		String name = request.getParameter("name");
		int std 	= Integer.parseInt(request.getParameter("std"));
		int marks 	= Integer.parseInt(request.getParameter("marks"));
		
		System.out.println("rno :" + rno);
		System.out.println("name : "+name);
		System.out.println("std : "+std);
		System.out.println("marks : "+marks);
		
		StudentBean sbean = new StudentBean(0, name, std, marks);
		
		StudentDao dao = new StudentDao();
		
		int rowsAffected = dao.updateStudent(rno, sbean);
		
		RequestDispatcher rd = null;
		
		if (rowsAffected > 0) 
		{
			rd = request.getRequestDispatcher("ListStudentServlet");
			
		} else 
		{
			rd = request.getRequestDispatcher("EditStudentServlet?rno="+rno);
		}
		rd.forward(request, response);
	}
}

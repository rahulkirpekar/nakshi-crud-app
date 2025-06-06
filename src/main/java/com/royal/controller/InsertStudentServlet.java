package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		int std 	= Integer.parseInt(request.getParameter("std"));
		int marks 	= Integer.parseInt(request.getParameter("marks"));
		
		
		StudentBean sbean = new StudentBean(0, name, std, marks);
		
		StudentDao dao = new StudentDao();
		
		int rowsAffected = dao.insertStudent(sbean);
		
		RequestDispatcher rd = null;
		
		if (rowsAffected > 0) 
		{
			rd = request.getRequestDispatcher("ListStudentServlet");
			
		} else 
		{
			rd = request.getRequestDispatcher("studentregistration.jsp");
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}

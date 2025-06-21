package com.royal.controller;

import java.io.IOException;

import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		StudentDao dao = new StudentDao();
		
		int rowsAffected = dao.deleteStudent(rno);
		RequestDispatcher rd = null;
		if (rowsAffected > 0) 
		{
			rd = request.getRequestDispatcher("ListStudentServlet");
		}else 
		{
			rd = request.getRequestDispatcher("ListStudentServlet");			
		}
		rd.forward(request, response);
	}
}

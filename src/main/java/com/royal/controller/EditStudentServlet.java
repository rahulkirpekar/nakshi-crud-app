package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		StudentDao dao = new StudentDao();
		
		StudentBean sbean =	dao.getStudentByRno(rno);
		
		System.out.println("EditStudentServlet : sbean " + sbean);
		
		request.setAttribute("sbean", sbean);
		
		request.getRequestDispatcher("editstudent.jsp").forward(request, response);
		
	}
}

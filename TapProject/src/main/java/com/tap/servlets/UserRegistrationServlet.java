package com.tap.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.daoimplementation.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callingUserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phonenumber=req.getParameter("phonenumber");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		
		User user=new User(name,email,phonenumber,password,address,role);
		UserDAOImpl impl=new UserDAOImpl();
		int res=impl.addUser(user);
		
		PrintWriter out=resp.getWriter();
		if(res==1)
		{
			//out.println("Registration is successful "+ name);
			//resp.sendRedirect("LoginValidation");
			req.getRequestDispatcher("LoginValidation").forward(req, resp);

		}
		else
		{
			out.println("Something went wrong.");
		}
	}

}

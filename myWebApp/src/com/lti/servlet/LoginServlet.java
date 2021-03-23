package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.lti")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("majrul") && password.equals("123") )
		{
			String rememberMe=request.getParameter("rememberMe");
			if(rememberMe != null) {
				Cookie c1= new Cookie("username",username);
				c1.setMaxAge(60*60);
				Cookie c2= new Cookie("password",password);
				c2.setMaxAge(60*60);
				response.addCookie(c1);
				response.addCookie(c2);
			}
				response.sendRedirect("welcome.html");
		}
		
		else
			response.sendRedirect("login.html");

	}

}

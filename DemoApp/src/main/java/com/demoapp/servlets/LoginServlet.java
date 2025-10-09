package com.demoapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Data Rec from login page");
		String email =  request.getParameter("email_key");
		String password = request.getParameter("password_key");
		
		System.out.println("Your email add is "+email);
		System.out.println("Your password is "+password);
		
		if(email.equals("admin@rdec.in") && password.equals("123456")) {
			HttpSession session = request.getSession();
			session.setAttribute("name_key", "Aryan");
			response.sendRedirect("home.jsp");
		}else {
			System.out.println("Your email or password is invalid");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Thisi shrw a E");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

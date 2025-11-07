package com.demoapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.demoapp.database.DatabaseConnection;

/**
 * Servlet implementation class VerifyOTPServlet
 */
@WebServlet("/VerifyOTPServlet")
public class VerifyOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyOTPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enteredOTP =  request.getParameter("enteredOTP");
		HttpSession session = request.getSession(false);
		int sentOTP =  (int)(session.getAttribute("sentOTP"));
		String email = (String)(session.getAttribute("userEmail"));
		if(Integer.parseInt(enteredOTP) == sentOTP) {
			boolean verifiactionStatus = DatabaseConnection.verifyUser(email);
			if(verifiactionStatus) {
				response.sendRedirect("login_page.html");
			}else {
				System.out.println("User Verification Failed");
			}
		}else {
			System.out.println("Verification Failed");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

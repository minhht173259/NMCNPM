package com.rest.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rest.dao.UserDAO;
import com.rest.utils.model.UserObject;

@SuppressWarnings("serial")
@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();

		HttpSession session = request.getSession(true);
		UserObject userDemo = null;
		boolean t = true;

		userDemo = UserDAO.login(username, password);
		if (userDemo != null) {
			session.setAttribute("userDemo", userDemo);
			session.setAttribute("success", "");
			response.sendRedirect("index.jsp");
			t = false;
		}

		if (t == true) {
			request.setAttribute("message", "Please try again!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}

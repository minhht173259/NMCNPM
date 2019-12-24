package com.rest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rest.dao.UserDAO;
import com.rest.utils.model.UserObject;

@SuppressWarnings("serial")
@WebServlet(name = "EditUser", urlPatterns = { "/EditUser" })
public class EditUser extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {

		} finally {
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String email = request.getParameter("email").trim();
		String address = request.getParameter("address").trim();
		String role = request.getParameter("role").trim();
		HttpSession session = request.getSession(true);

		UserObject user = new UserObject();
		user.setPassword(password);
		user.setEmail(email);
		user.setAddress(address);
		user.setUsername(username);
		user.setRole(Integer.valueOf(role));
		String result = UserDAO.updateUser(user);
		if ("OK".equalsIgnoreCase(result)) {
			session.setAttribute("userDemo", user);
			session.setAttribute("success", "");
		} else {
			session.setAttribute("error", "");
		}
		response.sendRedirect("index.jsp");
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}

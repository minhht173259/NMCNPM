package com.rest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet(name = "RegisterServlet", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {

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
		String diachi = request.getParameter("address").trim();

		HttpSession session = request.getSession(true);

		if (UserDAO.getNumberUserByName(username) == 0) {
			UserObject user = new UserObject();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setAddress(diachi);
			user.setRole(0);

			int id = UserDAO.insertUser(user);
			user.setId(id);
			session.setAttribute("userDemo", user);
			session.setAttribute("success", "");
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("message", "Tên người dùng " + username + " đã có trong hệ thống!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
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

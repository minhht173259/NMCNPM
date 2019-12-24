package com.rest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.dao.UserDAO;

@SuppressWarnings("serial")
@WebServlet(name = "NguoidungServlet", urlPatterns = { "/NguoidungServlet" })
public class UserServlet extends HttpServlet {

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
		int id = Integer.parseInt(request.getParameter("idsp"));
		int page = Integer.parseInt(request.getParameter("page"));

		if (request.getParameter("Xoa") != null) {
			if ("OK".equalsIgnoreCase(UserDAO.deleteUser(String.valueOf(id)))) {
				response.sendRedirect("userManager.jsp?page=" + page + "");
			}
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}

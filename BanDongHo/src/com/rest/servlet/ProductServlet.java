package com.rest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.dao.ProductDAO;
import com.rest.utils.model.ProductObject;

@SuppressWarnings("serial")
@WebServlet(name = "ProductServlet", urlPatterns = { "/ProductServlet" })
public class ProductServlet extends HttpServlet {

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

		String name = request.getParameter("name").trim();
		int gia = Integer.parseInt(request.getParameter("gia"));
		String xuatxu = request.getParameter("xuatxu").trim();
		String image = request.getParameter("link").trim();

		if (request.getParameter("image") != null) {
			image = "";
			image += "images/" + request.getParameter("image").trim();
		}

		if (request.getParameter("edit") != null) {
			ProductObject product = new ProductObject();
			product.setName(name);
			product.setPrice(gia);
			product.setImage(image);
			product.setOrigin(xuatxu);
			product.setId(id);
			if ("OK".equalsIgnoreCase(ProductDAO.updateProduct(product))) {
				response.sendRedirect("productManager.jsp?page=" + page + "");
			}
		}

		if (request.getParameter("delete") != null) {
			if ("OK".equalsIgnoreCase(ProductDAO.deleteProductByID(String.valueOf(id)))) {
				response.sendRedirect("productManager.jsp?page=" + page + "");
			}
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}

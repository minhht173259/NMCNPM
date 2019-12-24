package com.rest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rest.bean.SQLconnection;
import com.rest.dao.ProductDAO;
import com.rest.utils.model.ProductObject;

@SuppressWarnings("serial")
@WebServlet(name = "AddProduct", urlPatterns = { "/AddProduct" })
public class AddProduct extends HttpServlet {

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

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		int price = Integer.valueOf(request.getParameter("price").trim());
		String image = "images/" + request.getParameter("images").trim();
		String brand = request.getParameter("brand").trim();
		String origin = request.getParameter("origin").trim();
		String detail = request.getParameter("detail").trim();

		HttpSession session = request.getSession(true);
		SQLconnection con = new SQLconnection();
		Statement st = null;
		ResultSet rs = null;
		ProductObject sanpham = new ProductObject();
		boolean t = true;

		if (ProductDAO.getNumberProductByName(name) == 0) {
			ProductObject product = new ProductObject();
			product.setName(name);
			product.setPrice(price);
			product.setImage(image);
			product.setBrand(brand);
			product.setOrigin(origin);
			product.setDetail(detail);
			if ("OK".equalsIgnoreCase(ProductDAO.insertProduct(product))) {
				request.setAttribute("message", "Cập nhật thành công!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/addNewProduct.jsp");
				if (dispatcher != null) {
					dispatcher.forward(request, response);
				}
			}
		} else {
			request.setAttribute("message", "");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/addNewProduct.jsp");
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

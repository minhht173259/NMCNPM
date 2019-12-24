<%@page import="java.util.List"%>
<%@page import="com.rest.dao.InvoiceDAO"%>
<%@page import="com.rest.utils.model.InvoiceObject"%>
<%@page import="com.rest.utils.model.ProductObject"%>
<%@page import="com.rest.utils.model.UserObject"%>
<%@page import="com.rest.utils.model.CartObject"%>
<%@page import="com.rest.utils.*"%>
<%@page import="com.rest.bean.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	CartObject cart = (CartObject) session.getAttribute("cart");
	if (request.getParameter("update") != null) {
		int id = Integer.parseInt(request.getParameter("idsp"));
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		if (cart == null)
			cart = new CartObject();
		cart.updateSanpham(id, soluong);
		session.setAttribute("cart", cart);
		response.sendRedirect("shoppingCart.jsp");
	} else {
		if (request.getParameter("Xoa") != null) {
			int id = Integer.parseInt(request.getParameter("idsp"));
			cart.delSanpham(id);
			session.setAttribute("cart", cart);
			response.sendRedirect("shoppingCart.jsp");
		}
	}

	if (request.getParameter("Guidonhang") != null) {
		UserObject us = (UserObject) session.getAttribute("userDemo"); //lấy tên người dùng
		List<ProductObject> listsp = cart.getGiohang(); //lấy list sản phẩm người dùng mua.

		for (int i = 0; i < listsp.size() ; i++) { //tạo mỗi sản phẩm 1 hóa đơn.
			InvoiceObject hd = new InvoiceObject();
			hd.setUserID(us.getId());
			hd.setProduct(listsp.get(i));
			hd.setTotal(listsp.get(i));

			InvoiceDAO.addInvoice(hd);
		}
		String msg = "Gửi đơn hàng thành công!";
		session.setAttribute("message", msg);
		response.sendRedirect("shoppingCart.jsp");
	}
%>
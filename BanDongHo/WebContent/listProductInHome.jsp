<%@page import="java.util.List"%>
<%@page import="com.rest.dao.ProductDAO"%>
<%@page import="com.rest.utils.model.ProductObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
	String brand = null;
	if (request.getParameter("brand") != null) {
		brand = (String) (request.getParameter("brand"));
	}
	List<ProductObject> listProduct = ProductDAO.getListAllProduct();

%>

<!DOCTYPE html>
<div class="show-title-00">
	<div class="title-00">
		<ul>
			<% if (brand.equals("new")) { %>
				<li class="_1"><a>Sản phẩm mới</a></li>
			<% } else { %>
				<li class="_1"><a href="listProduct.jsp?brand=<%=brand%>"><%=brand%></a></li>
			<% } %>
				<li class="_2" style="font-size: 14px;">
			<% if (listProduct.size() > 10 && !brand.equals("new")) { %> 
				<a href="listProduct.jsp?brand=<%=brand%>">Xem tiếp</a> 
			<% } %>
			</li>
		</ul>
	</div>
	<% if (brand.equals("new")) { %>
	<% for (int i = listProduct.size() - 1; i >= listProduct.size() - 12; i--) { %>
	<div class="content">
		<div class="pro-item">
			<ul>
				<li class="image"><a 
				<%
					String link = "";
					link += " href='detailProduct.jsp?id=" + listProduct.get(i).getId() + "'>";
					out.print(link);
				%>
					<img src="<%=listProduct.get(i).getImage()%>" width="160" height="200" />> </a></li>
				<li class="title">
				<%
					String link2 = "";
					link2 += "<a href='detailProduct.jsp?id=" + listProduct.get(i).getId() + "'>" + listProduct.get(i).getName() + "</a>";
					out.print(link2);
				%>
				</li>
				<li class="price"><%=listProduct.get(i).getPrice()%> VNĐ</li>
			</ul>
		</div>
	</div>
	<% } %>
	<%
	} else {
		List<ProductObject> listProductByBrand = ProductDAO.getListProductByBrand(brand);
		int kt = 0;
		if (listProductByBrand.size() < 8) {
			kt = listProductByBrand.size();
		}
		else {
			kt = 8;
		}
		for (int i = 0; i <= kt - 1; i++) {
	%>
	<div class="content">
		<div class="pro-item">
			<ul>
				<li class="image"><a 
				<%
					String link = "";
					link += " href='detailProduct.jsp?id=" + listProductByBrand.get(i).getId() + "'>";
					out.print(link);
				%>>
				<img src="<%=listProductByBrand.get(i).getImage()%>" width="160" height="200" /> </a></li>
				<li class="title">
				<%
					String link2 = "";
					link2 += "<a href='detailProduct.jsp?id=" + listProductByBrand.get(i).getId() + "'>" + listProductByBrand.get(i).getName() + "</a>";
					out.print(link2);
				%>
				</li>
				<li class="price"><%=listProductByBrand.get(i).getPrice()%> VNĐ</li>
			</ul>
		</div>
	</div>
	<% } %>
	<% } %>
</div>
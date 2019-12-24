<%@page import="com.rest.dao.ProductDAO"%>
<%@page import="com.rest.utils.model.ProductObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    ProductObject product = ProductDAO.getDetailProductById(id);
%>
<html>
<head>
<title>Trang sản phẩm</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link href="css/product.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="product">
		<div class="pro-top">
			<div class="pro-top-images">
				<div class="images">
					<img src="<%=product.getImage() %>" />
				</div>
			</div>
			<div class="pro-top-info">
				<div class="pro-title">
					<span>Tên sản phẩm : </span><span style="font-size: 18px; margin-left: 10px;"><%=product.getName() %></span>
				</div>
				<div class="pro-price">
					<p>
						Giá bán :
						<%=product.getPrice()%>VNĐ
					</p>
				</div>

				<div class="entry-content">
					<ul class="propertie-list">
						<li><span class="propertie">Thương hiệu : </span><%=product.getBrand() %></li>
						<li><span class="propertie">Xuất xứ : </span><%=product.getOrigin()%></li>
						<li><span class="propertie">Dòng sản phẩm : </span>Elegance</li>

						<li><span class="propertie">Trạng thái : </span>Còn hàng</li>
					</ul>
				</div>
				<div style="padding: 30px 30px">
					<% 
	                    String vale ="";
	                    vale += "<a href='shoppingCart.jsp?id="+id+"'><img src='images/muahang.png'/></a>";
	                    out.print(vale);
                    %>
				</div>
			</div>
		</div>
		<div class="pro-detail">
			<h2>Chi tiết về sản phẩm</h2>
			<hr>
			<div class="entry-content" style="border: none">
				<ul class="propertie-list">
					<li><span><%=product.getDetail()%></span></li>
				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
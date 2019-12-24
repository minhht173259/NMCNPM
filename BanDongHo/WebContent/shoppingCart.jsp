<%@page import="java.util.List"%>
<%@page import="com.rest.dao.ProductDAO"%>
<%@page import="com.rest.utils.model.ProductObject"%>
<%@page import="com.rest.utils.model.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/quantri.css" type="text/css" rel="stylesheet" />
<title>JSP Page</title>

</head>
<body>
<script type="text/javascript">
function checkCart() {
	var amount = document.getElementById("amountID").value;
	if (amount.match(/^\d+$/)) {
		if (amount <0) {
			document.getElementById("amountID").value = 0;
		}
	} else {
		document.getElementById("amountID").value = 0;
	}
	return true;
}
</script>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- quan tri san pham -->

	<div class="quantri">
		<div class="qt-title">Giỏ hàng</div>
		<div class="qt-content">
			<div class="qt-00"></div>
			<div class="qt-01">
				<% if(session.getAttribute("userDemo") == null) { %>
				<br> <br> <br> <br> <br> <br>
				<p style="font-size: 18px" align="center">Bạn chưa đăng nhập vào hệ thống!</p>
				<br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
				<% } else if (request.getParameter("id") != null) {
					String id = request.getParameter("id");
					CartObject cart = (CartObject)session.getAttribute("cart");
                    if (cart == null)  cart = new CartObject(); 
                    if (id != null) {
	                    ProductObject product = ProductDAO.getDetailProductById(id); //lấy sản phẩm vừa bỏ vào giỏ hàng.
	                    cart.addSanpham(product);
                    }
                    session.setAttribute("cart", cart);//lưu trạng thái
				} 
				if (session.getAttribute("userDemo") != null && session.getAttribute("cart") == null) { %>
					<br> <br> <br> <br> <br> <br>
					<p style="font-size: 18px" align="center">Bạn chưa chọn mua sản phẩm nào!</p>
					<br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
				<% } else if (session.getAttribute("cart") != null) {
                    CartObject cart=(CartObject)session.getAttribute("cart");
                    List<ProductObject> listProduct =cart.getGiohang();
                    if (listProduct.size() == 0) { %>
                   	<br> <br> <br> <br> <br> <br>
					<p style="font-size: 18px" align="center">Bạn chưa chọn mua sản phẩm nào!</p>
					<br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
                <% } else { %>
				<br> <br>
				<p style="font-size: 16px" align="center">
					Tổng Tiền : <span style="color: #F00"><%=cart.getTotalprice() %> VNĐ</span>
				</p>
				<br> <br>

				<script type="text/javascript">
                       <% if(session.getAttribute("message")!=null) { %>
                              alert("Gửi đơn hàng thành công");
                              <% session.removeAttribute("message"); %>
                       <% } %>
                    </script>
				<form action="shoppingCartUpdate.jsp" method="post" onsubmit="return checkCart(this)">
					<table class="tab-qt" style="margin: 10px auto">
						<tr>
							<td>Hình ảnh</td>
							<td>Tên sản phẩm</td>
							<td>Đơn giá</td>
							<td>Số lượng</td>
							<td>Thành tiền</td>
							<td>Cập nhật</td>
							<td>Xóa</td>
						</tr>
						<% for (int i=0 ; i<listProduct.size(); i++) { %>
							<tr>
								<td><a><img src="<%=listProduct.get(i).getImage()%>" width="100px" height="100px" /></a></td>
								<td><%=listProduct.get(i).getName() %></td>
								<td><%=listProduct.get(i).getPrice()%></td>
								<td><input name="soluong" id="amountID" type="text" value="<%=listProduct.get(i).getAmount()%>" style="text-align: center; height: 30px; width: 80px" /></td>
								<td><%=(listProduct.get(i).getAmount() * listProduct.get(i).getPrice()) %></td>
								<td><input type="submit" name="update" value="Cap nhat" width="100px" height="20px" /></td>
								<td>
									<input type="submit" name="Xoa" value="Xóa" width="100px" height="20px" />
									<input type="hidden" name="idsp" value="<%=listProduct.get(i).getId()%>" />
								</td>
								
							</tr>
						<% } %>
					</table>
				</form>
			</div>
			<form action="shoppingCartUpdate.jsp" method="post">
				<div style="float: right; padding-right: 150px; margin-bottom: 30px">
					<input type="submit" name="Guidonhang" value="Gửi đơn hàng" style="height: 30px; width: 95px" />
				</div>
			</form>
			<%} %>
			<%} %>
		</div>
	</div>

	<!-- quan tri san pham -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

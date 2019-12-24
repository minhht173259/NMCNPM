<%@page import="com.rest.dao.ProductDAO"%>
<%@page import="com.rest.utils.model.ProductObject"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang chủ</title>
<meta http-equiv="content-type" content="html/text; charset=utf-8" />
<link href="css/show-product.css" rel="stylesheet" type="text/css" />

<jsp:include page="bannerSides.jsp"></jsp:include>

</head>

<body>
	<!--Begin: header-->
	<jsp:include page="header.jsp"></jsp:include>
	<!--Begin: content-->
	<jsp:include page="content-top.jsp"></jsp:include>
	<br>
	<jsp:include page="menu-filter.jsp"></jsp:include>
	<br>
	<%
	List<ProductObject> listProduct = ProductDAO.getListAllProduct();
	%>
	<jsp:include page="listProductInHome.jsp">
		<jsp:param value="new" name="brand"/>
	</jsp:include>
	<br>
	<jsp:include page="listProductInHome.jsp">
		<jsp:param value="Casio" name="brand"/>
	</jsp:include>
	<br>
	<jsp:include page="listProductInHome.jsp">
		<jsp:param value="Titan" name="brand"></jsp:param>
	</jsp:include>
	<br>
	<jsp:include page="listProductInHome.jsp">
		<jsp:param value="Seiko" name="brand"/>
	</jsp:include>
	<br>
	<br>
	<!--End: content-->

	<!--Begin: footer-->
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
	<% if (session.getAttribute("success")!=null) {
		session.removeAttribute("success"); %>
		alert("Giao dịch thành công!");
	<% } else if (session.getAttribute("error")!=null) {
		session.removeAttribute("error"); %>
		alert("Giao dịch không thành công!");
	<% } %>
	</script>
	<!--End: footer-->
</body>

</html>
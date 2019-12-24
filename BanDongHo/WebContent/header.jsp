<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.rest.utils.model.UserObject"%>
<html>
<head>
<title>header</title>
<meta http-equiv="content-type" content="html/text;charset=utf-8" />
<link href="css/header.css" type="text/css" rel="stylesheet" />
</head>
<body style="background-color: #383838">
	<div id="header">
		<div id="wrap-header">
			<div class="header-top">
				<div class="header-top-left">
					<ul>
						<li><a href="https://www.hust.edu.vn/" target="_blank">hust.edu.vn</a></li>
						<li><a href="#">|</a></li>
						<li style="border-right: none"><a href="https://ctt-daotao.hust.edu.vn/" target="_blank">ctt-daotao.vn</a></li>
					</ul>
				</div>

				<div class="header-top-right">
					<ul>
						<% if(session.getAttribute("userDemo")==null) { %>
						<li><a href="register.jsp">Đăng kí</a></li>
						<li><a>|</a></li>
						<li><a href="login.jsp">Đăng nhập</a></li>
						<% } else {
						    UserObject user = (UserObject)session.getAttribute("userDemo");
                        %>
						<li><a href="logout.jsp">Thoát</a></li>
						<li><a>|</a></li>
						<li><a href="register.jsp">Trang cá nhân</a></li>
						<li><a>|</a></li>
						<% if (user.getRole()==1) { // nếu là admin %>
						<li><a href="productManager.jsp">Trang quản trị</a></li>
						<li><a>|</a></li>
						<% } %>
						<li><a> Xin chào : <%=user.getUsername()%>
						</a></li>
						<%} %>
					</ul>
				</div>
			</div>

			<div class="header-bottom">
				<a href="index.jsp"><img src="images/bg.png" /> </a>

			</div>

			<!--Begin: content-menu-->
			<div class="header-menu">
				<div class="nav-menu">
					<ul>
						<li><a href="index.jsp">Trang chủ</a></li>
						<li><a href="#">Giới thiệu</a></li>
						<li class="menu-00"><a href="#">Sản phẩm</a>
							<ul class="menu-01">
								<li class="menu-01-li"><a href="listProduct.jsp?brand=Casio">CASIO</a></li>
								<li class="menu-01-li"><a href="listProduct.jsp?brand=Titan">TITAN</a></li>
								<li class="menu-01-li"><a href="listProduct.jsp?brand=Seiko">SEIKO</a></li>
							</ul></li>
						<li><a href="#">Dịch vụ</a></li>
						<li><a href="#">Liên hệ</a></li>
					</ul>
				</div>

			</div>
			<!--End: content-menu-->
		</div>
	</div>
</body>
</html>
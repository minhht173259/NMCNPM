<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="content-type" content="html/text; charset=utf-8" />
<link href="css/dang-nhap.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!--Begin: header-->
	<jsp:include page="header.jsp"></jsp:include>

	<!--Begin: content-->
	<script type="text/javascript">
            function checkLogin(){
                var username = document.forms["formLogin"]["username"].value;
                var password = document.forms["formLogin"]["password"].value;
                if( username=="" || password==""){
                    alert("Dien day du thong vao bang dang nhap!!!");
                    return false;
                } 
               return true;
            }
        </script>
	<div class="login">
		<div class="login-title">Đăng nhập</div>
		<div class="login-body" style="width: 600px">
			<form action="LoginServlet" method="post" name="formLogin" onsubmit="return checkLogin(this)">
				<table>
					<tr>
					   <td colspan="2">
						   <label class="message">
						        <% if (request.getAttribute("message")!= null){%>
									<span style="color: #FF0000; font-size: 15px"><%=request.getAttribute("message")%></span>
								<% } %>
						   </label>
					   </td>
					</tr>
					<tr class="tr-tab">
						<td class="login-name">Tên đăng nhập:</td>
						<td><input class="input-text" type="text" name="username"></td>
					</tr>
					<tr class="tr-tab">
						<td class="login-pass">Mật khẩu:</td>
						<td><input class="input-text" type="password" name="password" autocomplete="off"></td>
					</tr>
					<tr class="tr-tab">
						<td class="login-name"></td>
						<td><input class="buttom" type="submit" name="btnLogin" value="Đăng nhập"> <input class="buttom" type="reset" name="btnReset"
							value="Nhập lại" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<!--End: content-->

	<!--Begin: footer-->
	<jsp:include page="footer.jsp"></jsp:include>

	<!--End: footer-->
</body>

</html>
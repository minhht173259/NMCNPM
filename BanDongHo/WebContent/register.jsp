<%@page import="com.rest.utils.model.UserObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.rest.utils.*"%>
<!DOCTYPE html>
<html>
	<head>
    	<title></title>
        <meta http-equiv="content-type" content="html/text; charset=utf-8"/>
        <link href="css/dang-nhap.css" rel="stylesheet" type="text/css" />     
    </head>
    
    <body>
    	<!--Begin: header-->
        <jsp:include page="header.jsp"></jsp:include>
        
        <!--Begin: content-->
        <script type="text/javascript">
            function checkDangki(){
                username = document.forms["formDangki"]["username"];
                password = document.forms["formDangki"]["password"];
                email    = document.forms["formDangki"]["email"];
                reg1     = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
                testmail = reg1.test(email.value);
                address   = document.forms["formDangki"]["address"];
                
                if(username.value==""){
                    alert("Hãy chọn tên đăng nhập");
                    username.focus();
                    return false;
                }
                if(password.value==""){
                    alert("Chưa nhập mật khẩu");
                    password.focus();
                    return false;
                }
                
                if(!testmail){
                    alert("Địa chỉ email không hợp lệ");
                    email.focus();
                    return false;
                }
               
                if(address.value==""){
                    alert("Chưa nhập địa chỉ");
                    address.focus();
                    return false;
                }
               
            }
        </script>
            <div class="login">
            <% if(session.getAttribute("userDemo")==null) {%>
            <div class="login-title">Đăng kí thành viên</div>
                <div class="login-body" style="width:600px">
                    <form action="RegisterServlet"  method="post" name="formDangki" onsubmit="return checkDangki(this)" >
                        <table>
                            <tbody>
                                <tr class="tr-tab">
                                	<td colspan="2">
                                		<label class="message">
            	                          <% if (request.getAttribute("message")!= null){%>
                                             <span style="color:#FF0000; font-size: 15px "><%=request.getAttribute("message")%></span>
            	                          	<% request.removeAttribute("message"); %>
            	                          <% } %>
                                        </label>
                                	</td>
                                </tr>
                                <tr class="tr-tab">
                                	<td class="login-name">Tên đăng nhập:</td>
                                	<td>
                                		<input class="input-text" type="text" name="username" style="width:240px">
                                	</td>
                                </tr>
                                <tr class="tr-tab"> 
                                	<td class="login-pass">Mật khẩu:</td>
                                	<td><input class="input-text" type="password" name="password" autocomplete="off" style="width:240px"></td>
                                </tr>
                                
                                <tr class="tr-tab">
                                	<td class="login-name">Email:</td>
                                	<td>
                                		<input class="input-text" type="text" name="email" style="width:240px">
                                	</td>
                                </tr>
                                
                                <tr class="tr-tab">
                                	<td class="login-name">Địa chỉ:</td>
                                	<td>
                                		<input class="input-text" type="text" name="address" style="width:240px">
                                	</td>
                                </tr>
                                
                                <tr class="tr-tab">
                                     <td class="login-name"></td>
                                    <td style="text-align: center" colspan="2">
                                        <input type="submit" class="buttom" name="btnLogin" value="Đăng kí" />
                                        <input type="reset" class="buttom"  name="btnReset" value="Nhập lại" />
                                    </td>
                                </tr>
                        	</tbody>
                        </table>
                    </form>
             	</div>
                <% } else{
                    UserObject us = (UserObject)session.getAttribute("userDemo");
                %>
                <div class="login-title">Thông tin cá nhân</div>
                <div class="login-body" style="width:600px">
                    <form action="EditUser" method="post">
                        <table >
                            <tbody>
                                <tr class="tr-tab">
                                	<td colspan="2">
                                		<label class="message">
            	                          <% if (request.getAttribute("message")!= null){%>
                                             <span style="color:#FF0000; font-size: 15px"><%=request.getAttribute("message")%></span>
                                             <% request.removeAttribute("message"); %>
            	                          <%}%>
                                        </label>
                                	</td>
                                </tr>
                                <tr class="tr-tab">
                                	<td class="login-name">Tên đăng nhập:</td>
                                	<td>
                                            <input name="username" class="input-text" value="<%=us.getUsername()%>" type="text"  style="width:240px">
                                	</td>
                                </tr>
                                <tr class="tr-tab"> 
                                	<td class="login-pass">Mật khẩu:</td>
                                        <td><input class="input-text" type="password" value="<%=us.getPassword()%>" name="password" autocomplete="off" style="width:240px"></td>
                                </tr>
                                
                                <tr class="tr-tab">
                                	<td class="login-name">Email:</td>
                                	<td>
                                    	<input class="input-text" value="<%=us.getEmail()%>"type="text" name="email" style="width:240px">
                                	</td>
                                </tr>
                                
                                <tr class="tr-tab">
                                	<td class="login-name">Địa chỉ:</td>
                                	<td>
                                            <input class="input-text" value="<%=us.getAddress()%>" type="text" name="address" style="width:240px">
                                            <input class="input-text" value="<%=us.getRole()%>" type="hidden" name="role" style="width:240px">
                                	</td>
                                </tr>
								
                                <tr class="tr-tab">
                                     <td class="login-name"></td>
                                    <td style="text-align: center" colspan="2">
                                        <input type="submit" class="buttom" name="btnLogin" value="Sửa" />
                                        <a href="index.jsp"><input type="button" class="buttom"  name="btnReset" value="Hủy" /></a>
                                    </td>
                                </tr>
                        	</tbody>
                        </table>
                    </form>
             	</div>
                <%}%>
             </div>
        
        <!--End: content-->
        
        <!--Begin: footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        
        <!--End: footer-->
    </body>

</html>
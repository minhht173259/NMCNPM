<%@page import="com.rest.dao.ProductDAO"%>
<%@page import="com.rest.dao.UserDAO"%>
<%@page import="com.rest.utils.model.UserObject"%>
<%@page import="com.rest.utils.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	boolean isAdmin = false;
	if(session.getAttribute("userDemo") !=null) {
		UserObject us = (UserObject)session.getAttribute("userDemo");
		if(us.getRole()==1) {
			isAdmin = true;
		}
	}
	if (!isAdmin) {
		response.sendRedirect("index.jsp");
	}
	//Phân trang.
	int full= 10; //so nguoi dung toi da tren trang.
	//lấy số lượng tất cả các nguoi dung
	int total = UserDAO.getListAllUser().size();
	int sopage =1;              
	 //lấy số page.
	if (total % full ==0){
	    sopage = total/full;
	} else {
	    sopage =total/full +1;
	}     
	int page1 =1;
	if(request.getParameter("page") != null){
	       page1  = Integer.parseInt(request.getParameter("page"));
	} 
	int start = full*(page1-1);                 
	//lấy nguoi dung
	List<UserObject> listpage;
	listpage = UserDAO.getAllPage(start, full);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/quantri.css" type="text/css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <!-- quan tri san pham -->
        <div style="margin: 50px auto auto 200px;">
           <a href="productManager.jsp"><input type="button" value="Quản trị sản phẩm" style="padding:5px" /></a>
            <a href="userManager.jsp"><input type="button" value="Quản trị người dùng" style="padding:5px" /></a>
        </div>
        <div class="quantri">
            <div class="qt-title">
            	Quản trị người dùng	
            </div>
            <div class="qt-content">
            	<div class="qt-00">
                	<table style="margin:10px auto;">
                    	<tr>
                            <td width="200px"><a href="register.jsp" ><img src="images/them.png" /></a></td>
                            <td width="200"><a href="#"><img src="images/xoa.png" /></a></td>
                        </tr>
                    </table>
                </div>
                <div class="qt-01">
                    <form action="UserServlet" method="post">
                    	<table class="tab-qt" style="margin:10px auto">
                            <tr>
                                <td class="tabtd">Tên người dùng</td>
                                <td class="tabtd">Password</td>
                                <td class="tabtd">Email</td>
                                <td class="tabtd">Địa chỉ</td>
                                <td class="tabtd">Xóa</td>            
                                <td class="tabtd">Chọn</td>
                            </tr>
                            <% for(int i=0 ; i<=listpage.size()-1; i++){ %>
                            <tr>
                                <td style="color: white;"><%=listpage.get(i).getUsername()%></td>
                                <td><%=listpage.get(i).getPassword()%></td>
                                <td><%=listpage.get(i).getEmail()%></td>
                                <td><%=listpage.get(i).getAddress()%></td>
                                <td><input type="submit" name="Xoa" value="Xóa" width="400px" height="40px" style="padding: 5px 15px"  /></td> 
                                <td>
                                	<input type="checkbox" />
                                	<input type="hidden" name="idsp" value="<%=listpage.get(i).getId()%>" />
                                	<input type="hidden" name="page" value="<%=page1%>">
                                </td>
                                
                            </tr>
                        	<%} %>
                    	</table>
                    </form>
                        <div style="float: right; margin-right: 200px;margin-bottom: 30px">
                            <ul>
                               <% 
                               for(int i=1 ; i<= sopage; i++) {
                                   String link = "";  
                                   link += "<li style='float:left; width:20px; color: gold; font-weight: bold;text-align: center; border: 1px solid white'> <a href='userManager.jsp?page="+i+"'>"+i+"</a> </li>";     
                                   out.print(link);
                               }
                               %>
                            </ul>
                        </div>
                </div>
            </div>
        </div>
        <!-- quan tri san pham -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

<%@page import="com.rest.utils.model.UserObject"%>
<%@page import="com.rest.dao.ProductDAO"%>
<%@page import="com.rest.utils.model.ProductObject"%>
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
        int full= 20; //so trang mac định
        //lấy số lượng tất cả các sản phẩm
        int total = ProductDAO.getTotalAll();
        int sopage =1;                
         //lấy số page.
        if (total % full ==0) {
			sopage = total/full;
        } else {
			sopage =total/full +1;
        }
        int page1 = 1;
        if(request.getParameter("page") != null){
       page1  = Integer.parseInt(request.getParameter("page"));
        } 
        
        int start = full*(page1-1);
        //lấy sản phẩm của trang đó.
        List<ProductObject> listpage = ProductDAO.getAllProudctPage("", start, full);
        
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
            	Quản trị sản phẩm	
            </div>
            <div class="qt-content">
            	<div class="qt-00">
                	<table style="margin:10px auto;">
                    	<tr>
                            <td width="200px"><a href="addNewProduct.jsp" ><img src="images/them.png" /></a></td>
                            <td width="200"><a href="#"><img src="images/xoa.png" /></a></td>
                        </tr>
                    </table>
                </div>
                <div class="qt-01">
                <form action="ProductServlet" method="post">
                    <table class="tab-qt" style="margin:10px auto">
                    	
                        	<tr>
                            
                                <td class="tabtd">Tên sản phẩm</td>
                                <td class="tabtd">Giá sản phẩm</td>
                                <td class="tabtd">Xuất xứ</td>
                                <td class="tabtd">Thương hiệu</td>
                                <td class="tabtd">Ảnh</td>
                                <td class="tabtd">Chỉnh sửa ảnh</td>
                                <td class="tabtd">Sửa</td>
                                <td class="tabtd">Xóa</td>            
                               <!-- <td>Chọn</td> -->
                            </tr>
                            <% for(int i=0 ; i<=listpage.size()-1; i++){ %>
                         
                            <tr>          
                                <td><input type="text" name="name" value="<%=listpage.get(i).getName() %>" style="text-align: center; height: 30px; width: 80px" /></td>
                                <td><input type="text" name="gia" value="<%=listpage.get(i).getPrice() %>" style="text-align: center; height: 30px; width: 80px" /></td>
                                <td><input type="text" name ="xuatxu" value="<%=listpage.get(i).getOrigin() %>" style="text-align: center; height: 30px; width: 80px" /></td>
                                <td>                                                                    
                                        <%=listpage.get(i).getBrand() %>           
                                </td>
                                <td><input type="text" name ="link" value="<%=listpage.get(i).getImage() %>" style="text-align: center; height: 30px; width: 80px" /></td>
                                <td>
                                    <input type="file" name="image" style="text-align:left ; height: 30px; width: 95px !important" />
                                </td>
                                
                                <td><input type="submit" name="edit" value="Sửa" width="400px" height="40px" style="padding:5px 15px" /></td>
                                <td>
                                	<input type="submit" name="delete" value="Xóa" width="400px" height="40px"  style="padding:5px 15px" />
                                	<input type="hidden" name="idsp" value="<%=listpage.get(i).getId()%>">
                                	<input type="hidden" name="page" value="<%=page1%>">
                                </td> 
                            <!--    <td><input type="checkbox" /></td> -->
                                
                            </tr>
                        	<% } %>
                      </table>
                        </form>
                        <div style="float: right; margin-right: 50px;margin-bottom: 20px">
                            <ul>
                               <% 
                               for (int i=1 ; i<= sopage; i++) {
                                   String link = "";  
                                   link += "<li style='float:left; width:20px; color: gold; font-weight: bold;text-align: center; border: 1px solid white'> <a href='productManager.jsp?page="+i+"'>"+i+"</a> </li>";     
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

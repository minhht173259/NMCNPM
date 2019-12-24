<%@page import="java.util.List"%>
<%@page import="com.rest.dao.ProductDAO"%>
<%@page import="com.rest.utils.model.ProductObject"%>
<%@page import="com.rest.utils.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String brand = null;
        if (request.getParameter("brand") != null){
			brand  = (String)(request.getParameter("brand"));
        }
        //PHÂN TRANG.
        int full= 20; //so trang mac định
        //lấy số lượng sản phẩm
        int total = ProductDAO.getTotalAllByBrand(brand);
        
        int sopage =1;
        
        //lấy số page.
        if (total % full ==0){
            sopage = total/full;
        } else {
            sopage =total/full +1;
        }
         
        int pagenumber =1;
        int page1 =1;
        if(request.getParameter("page") != null){
            page1  = Integer.parseInt(request.getParameter("page"));
        }
        
        pagenumber = page1;
        int start = full*(pagenumber-1);
        //lấy sản phẩm của trang đó.
        List<ProductObject> listpage = ProductDAO.getAllProudctPage(brand, start, full);
%>

<!DOCTYPE html>
<html>
	<head>
    	<title>Trang san pham 1</title>
        <meta http-equiv="content-type" content="html/text; charset=utf-8"/>
        <link href="css/show-product.css" rel="stylesheet" type="text/css" />
        
        
    </head>
    
    <body>
    	<!--Begin: header-->
        <jsp:include page="header.jsp"></jsp:include>
        
        <!--Begin: content-->
        <jsp:include page="content-top.jsp"></jsp:include>
            <br>
        
        <jsp:include page="menu-filter.jsp"></jsp:include>
        <br>
        
        <div class="show-title-00">
    <div class="title-00">
        <ul>
            <li class="_1"><a>Thương hiệu <%=brand%></a></li>
            <li class="_2" style="font-size: 14px;">
                <ul>
                  <% 
                     for(int i=1 ; i<= sopage; i++) {
                       String link = "";  
                       link += "<li><a href='listProduct.jsp?brand=" + brand + "&page=" + i + "'>" + i + "</a> </li>";
                       out.print(link);
                    }
                  %>
                </ul>
                  
            </li>

        </ul>
    </div>
        <% for(int i = 0 ; i<listpage.size() ; i++) {%>
         <div class="content">
        <div class="pro-item">
            <ul >
        <li class="image">
            <a 
            <% 
	            String link = "";  
	            link += " href='detailProduct.jsp?id="+listpage.get(i).getId()+"'>";
	            out.print(link);
            %>>
             <img src="<%=listpage.get(i).getImage()%>" width="160" height="200" />
            </a>
        </li>
        <li class="title">
            
            <% 
             String link2 = "";  
             link2 += "<a href='detailProduct.jsp?id="+listpage.get(i).getId()+"'>"
                   +  listpage.get(i).getName()
                   +  "</a>";
             out.print(link2);
            %>
        </li>
        <li class="price"><%=listpage.get(i).getPrice()%> VNĐ</li>
    </ul>
    </div>
    </div>
    <%}%>
        </div>
         <br>
        <br>
        <br>

        <!--End: content-->
        
        <!--Begin: footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        
        <!--End: footer-->
    </body>

</html>

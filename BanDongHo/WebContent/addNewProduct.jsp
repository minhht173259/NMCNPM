<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="css/dang-nhap.css" rel="stylesheet" type="text/css" /> 
        <title>Thêm sản phẩm</title>
        <script type="text/javascript">
            function checkPro(){
                var gt1 = document.forms["formPro"]["name"].value;
                var gt2 = document.forms["formPro"]["price"].value;
                var gt3 = document.forms["formPro"]["images"].value;
                var gt4 = document.forms["formPro"]["brand"].value;
                var gt5 = document.forms["formPro"]["origin"].value;
                var gt6 = document.forms["formPro"]["detail"].value;
                if( gt1=="" || gt2=="" || gt3=="" ||gt4=="" ||gt5=="" ||gt6==""){
                    alert("Dien day du thong vao bang dang nhap!!!");
                    return false;
                } 
               return true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <br>
        <div class="login">
            <div class="login-title">Thêm sản phẩm</div>
                <div class="login-body" style="width:450px">
                <form action="AddProduct" method="post" name="formPro" onsubmit="return checkPro(this)">
                	<table style="margin: auto; text-align: center">
                        <tr class="tr-tab">
                        	<td>
                        		<label class="message">
                                <% if (request.getAttribute("message")!= null){%>
                                    <span style="color:#FF0000; font-size: 15px "><%=request.getAttribute("message")%></span>
                                <%}%>
                            	</label>
                        	</td>
                        	<td></td>
                        </tr> 
                        <tr class="tr-tab">
                            <td class="login-name">Tên sản phẩm:</td>
                            <td>
                                <input class="input-text" type="text" name="name" style="width:300px">
                            </td>
                        </tr>
                        <tr class="tr-tab">
                                <td class="login-name">Ảnh đại diện:</td>
                                <td><input  type ="file" style="width:300px" name="images" ></td>
                                 
                        </tr>
                        <tr class="tr-tab">
                                <td class="login-name">Giá sản phẩm:</td>
                                <td><input class="input-text" type ="text" style="width:300px" name="price"></td>
                        </tr>
                        <tr class="tr-tab">
                                <td class="login-name">Thương hiệu:</td>
                                <td>
                                    <select class="input-text" name="brand">
                                        <option>Casio</option>
                                        <option>Tittan</option>
                                        <option>Seiko</option>
                                    </select>
                                </td>
                        </tr>
                        <tr class="tr-tab">
                                <td class="login-name">Xuất xứ:</td>
                                <td><input class="input-text" type ="text" style="width:300px" name="origin"></td>
                        </tr >
                        <tr class="tr-tab">
                                <td class="login-name">Mô tả:</td>
                                <td><textarea class="input-text" style="height: 100px; width: 300px" name="detail"></textarea></td>
                        </tr>
                        <tr class="tr-tab">
                                <td></td>
                        <td class="tr-tab">
                            <input class="buttom" type="submit" name="btnThem" value="Thêm" style="height:25px; width:95px;">
                            <input class="buttom" type="reset" name="btnReset" value="Nhập lại" style="height:25px; width:95px" />
                        <br>

                        </td>
                        </tr>
                	</table>
                </form>
            </div>
        </div>
        <br>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

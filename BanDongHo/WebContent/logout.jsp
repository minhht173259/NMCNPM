<%
    if (session.getAttribute("userDemo") != null) {
        session.removeAttribute("userDemo");
        session.removeAttribute("cart");
        session.invalidate();
        response.sendRedirect("index.jsp");
    } else {
        response.sendRedirect("index.jsp");
    }
%>
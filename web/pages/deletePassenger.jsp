<%-- 
    Document   : deletePassenger
    Created on : Mar 23, 2024, 10:38:15 PM
    Author     : Dell
--%>

<%@page import="db.dbcon"%>
<%@page import="java.sql.ResultSet"%>

<%
    dbcon query1 = new dbcon();
    ResultSet rs = null;
    String u = request.getParameter("passengerID").trim();
    String sql = "delete from Passenger where username='" + u + "'";
    boolean result = query1.deletedata(sql);
    request.setAttribute("deleteSuccess", result);
    RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
    dispatcher.forward(request, response);

%>

Passenger Has Been Deleted
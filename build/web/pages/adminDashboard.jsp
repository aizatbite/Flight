<%-- 
    Document   : adminDashboard
    Created on : Mar 23, 2024, 4:15:51 PM
    Author     : Dell
--%>

<%@page import="db.dbcon"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin!</h1>
        <section class="content">


            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Passenger ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Passport No.</th>
                        <th scope="col">Password</th>
                        <th scope="col">Update</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- get the user information -->
                    <%
                   //users.Users loginuser=new users.Users();

                        //  loginuser=(Users)session.getAttribute("user");
                        //   out.println(loginuser);
                        dbcon query1 = new dbcon();
                        ResultSet rs = null;
                        String sql = "SELECT\n"
                                + "\"public\".\"Passenger\".\"passengerID\",\n"
                                + "\"public\".\"Passenger\".\"passengerName\",\n"
                                + "\"public\".\"Passenger\".\"passengerEmail\",\n"
                                + "\"public\".\"Passenger\".\"passportNumber\",\n"
                                + "\"public\".\"Passenger\".\"passengerPassword\"\n"
                                + "FROM\n"
                                + "\"public\".\"Passenger\"";
                        rs = query1.sqlquery(sql);
                        int i = 1;
                        while (rs.next()) {
                    %>
                    <tr>
                        <th scope="row"><% out.println(i); %></th>
                        <td><% out.println(rs.getString("passengerID")); %></td>
                        <td><% out.println(rs.getString("passengerName"));%></td>
                        <td><% out.println(rs.getString("passengerEmail"));%></td>
                        <td><% out.println(rs.getString("passportNumber"));%></td>
                        <td><% out.println(rs.getString("passengerPassword"));%></td>
                        <td>

                            <%
                                String redirect = "updatePassenger.jsp?passengerID=" + rs.getString("passengerID");%>

                            <a class="btn btn-primary"  href = "<% out.println(redirect); %>" > Update</a>
                        </td>
                        <td>
                            <%
                                String redirect1 = "deletePassenger.jsp?passengerID=" + rs.getString("passengerID");%>

                            <a class="btn btn-danger"  href = "<% out.println(redirect1); %>" > Delete</a>

                        </td>

                    </tr>
                    <%  i++;
                        } %>
                </tbody>
                <%
                    String redirect2 = "insertuser.jsp";%>

                <a class="btn btn-primary"  href = "<% out.println(redirect2);%>" > Insert</a>

            </table>







        </section>
    </body>
</html>

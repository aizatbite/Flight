package Booking;

import db.dbcon; // Import your dbcon package
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class insertbooking extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Extract booking details from the request
            String flightId = request.getParameter("flightId").trim();
            String passengerId = request.getParameter("passengerId").trim();
            String paymentStatus = request.getParameter("paymentStatus").trim();

            // Insert the booking into the database
            int result = insertFlightBooking(flightId, passengerId, paymentStatus);

            // Set the result as a request attribute and dispatch to a JSP page to show the result
            request.setAttribute("insertSuccess", true);
            request.setAttribute("bookingId", result);

            request.getRequestDispatcher("/bookingResult.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private int insertFlightBooking(String flightId, String passengerId, String paymentStatus) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertbooking.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO flight2 (flight_id, passenger_id, payment_status) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Establish database connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FlightTicketingSystem", "shafiq", "");

            // Prepare the statement
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, flightId);
            ps.setString(2, passengerId);
            ps.setString(3, paymentStatus);

            // Execute the SQL
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated keys (last inserted ID)
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int lastInsertedId = rs.getInt(1); // Retrieve the last inserted ID
                    // Set the last inserted ID as needed
                    // For now, let's just print it
                    System.out.println("Last Inserted ID: " + lastInsertedId);
                    return lastInsertedId;

                }
            } else {
                return 0; // Return false if insertion failed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // Return false if an exception occurs
        } finally {
            // Close resources in the finally block
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public String getServletInfo() {
        return "Servlet for inserting flight bookings into a database";
    }
}

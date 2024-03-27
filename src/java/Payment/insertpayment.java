package Payment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insertpayment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extract parameters from the request
        String bookingId = request.getParameter("bookingId");
        String paymentMethod = request.getParameter("paymentMethod");
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Call the insertPayment method to insert payment
        int paymentId = insertPayment(bookingId, paymentMethod, amount);

        // Optionally, you can forward the request to another servlet or JSP page
        // For example:
        // request.getRequestDispatcher("/paymentResult.jsp").forward(request, response);
    }

    public int insertPayment(String bookingId, String paymentMethod, double amount) {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertpayment.class.getName()).log(Level.SEVERE, null, ex);
        }

        // SQL query to insert payment
        String sql = "INSERT INTO payment (booking_id, payment_method, amount) VALUES (?, ?, ?)";

        // Initialize database connection and prepared statement
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Establish database connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FlightTicketingSystem", "shafiq", "");

            // Prepare the statement
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Integer.parseInt(bookingId));
            ps.setString(2, paymentMethod);
            ps.setDouble(3, amount);

            // Execute the SQL
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated keys (last inserted ID)
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int lastInsertedId = rs.getInt(1); // Retrieve the last inserted ID
                    // Return the last inserted ID
                    return lastInsertedId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return 0; // Return 0 if insertion failed
    }
}

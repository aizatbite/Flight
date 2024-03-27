package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author virtualspace
 */
public class dbcon {

    CachedRowSet rowSet;
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    String driver;   //"org.gjt.mm.mysql.Driver"
    String urlcon; //"jdbc:mysql://localhost:3306/database"
    String username;//select count(*) as rowcount from users where username=(?) and password=(?)
    String password;

    public dbcon() {
        this.driver = "org.postgresql.Driver";
        this.urlcon = "jdbc:postgresql://localhost:5432/FlightTicketingSystem";
        this.username = "shafiq";
        this.password = "";
    }

    public dbcon(String driver, String urlcon, String u, String p) {
        this.driver = driver;
        this.username = u;
        this.password = p;

    }
    
      public String fetchSingleResult(String query) throws SQLException {
        String result = null;
        try {
            Class.forName(driver);
            try (Connection con = DriverManager.getConnection(urlcon, username, password);
                 PreparedStatement ps = con.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    result = rs.getString(1); // Get the first column of the first row
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet sqlquery(String executesql) throws SQLException {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(urlcon, username, password);
            ps = con.prepareStatement(executesql);
            // stmt=con.createStatement();
            rs = ps.executeQuery();
        } catch (ClassNotFoundException ex) {
            // Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);

        }
        return rs;

    }

public int executesql(String sql, String... params) throws SQLException {
    // Use a PreparedStatement for security and efficiency
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        // Set the parameters if any
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
            }
        }
        // Execute the SQL
        int rowsAffected = ps.executeUpdate();

        // Retrieve the generated key (last inserted ID)
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve generated key");
            }
        }
    }
}


    public class simplejdbcapp {

        static final String DB_URL
                = "jdbc:derby://localhost:1527/sample;;create=true;user=app;password=app";
        static final String DB_DRV
                = "org.apache.derby.jdbc.ClientDriver";
        //static final String DB_USER = "root";
        //static final String DB_PASSWD = "";   
        ResultSet resultset = null;
        Connection connection = null;
        Statement statement = null;

        public simplejdbcapp() {

        }

        public ResultSet getdata(String sql) {
            ResultSet temp = null;
            try {
                // connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                //Get a connection
                connection = DriverManager.getConnection(DB_URL);
                statement = connection.createStatement();
                temp = statement.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(simplejdbcapp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(simplejdbcapp.class.getName()).log(Level.SEVERE, null, ex);
            }
            return temp;
        }

        public boolean deletedata(String sql) {
            boolean success = false;
            ResultSet temp = null;
            try {
                // connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                //Get a connection

                connection = DriverManager.getConnection(DB_URL);
                statement = connection.createStatement();
                int rowAffected = statement.executeUpdate(sql);
                if (rowAffected > 0) {
                    success = true;
                    // System.out.println("Deletion successful. Rows affected: " + rowsAffected);
                } else {
                    // System.out.println("Deletion failed or no rows affected.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(simplejdbcapp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(simplejdbcapp.class.getName()).log(Level.SEVERE, null, ex);
            }
            return success;
        }
    }
}

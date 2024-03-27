/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import db.dbcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author virtualspace
 */
public class Users {

    private String userid;
    private String password;
    private String name;
    private String email;
    private String tel;
    private String userinterface;

    public Users() {

    }

    public Users(String username, String password, String name) {
        this.userid = username;
        this.password = password;
        this.name = name;
    }

    public int checkUserStatus() {
        ResultSet rs = null;
        int x = 0;
        try {

            db.dbcon query1 = new db.dbcon();

            String sql = "SELECT\n"
                    + "count(*) as rowcount\n"
                    + " FROM\n"
                    + "\"public\".\"Passenger\" \n"
                    + "WHERE\n"
                    + "\"public\".\"Passenger\".\"passengerEmail\" = '" + this.getUserid().trim() + "' and\n"
                    + "\"public\".\"Passenger\".\"passengerPassword\" = '" + this.getPassword().trim() + "'";

            rs = query1.sqlquery(sql);
            rs.next();
            x = rs.getInt("rowcount");

        } catch (Exception ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*} catch (SQLException ex) {
         Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        return x;
    }

    public boolean updateUser(String u, String p, String n, String e) {
        int rowAffected = 0;
        try {
            // String sql="INSERT INTO tbluser (username,name,dob,password)"
            //         + "VALUES ('"+u+"','"+n+"',"+ "null"+",'"+p+"')";
            String sql = "UPDATE tbluser SET name = '" + n + "',"
                    + " dob = '" + e + "', password = '" + p + "' WHERE username = '" + u + "'";

            dbcon query1 = new dbcon();
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Get a connection

            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
            rowAffected = statement.executeUpdate(sql);

        } catch (Exception ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rowAffected == 1) {
            return true;
        } else {
            return false;
        }
    }

    void updatename() {
        ResultSet rs = null;

        try {

            dbcon query1 = new dbcon();
            String sql = "";
            sql = "select name from tbluser where username='" + this.getName() + "'";
            rs = query1.sqlquery(sql);
            rs.next();
            //this.name=rs.getString("name");

            //  String n = rs.getString(3);
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    static final String DB_URL
            = "jdbc:derby://localhost:1527/sample;;create=true;user=app;password=app";
    static final String DB_DRV
            = "org.apache.derby.jdbc.ClientDriver";
    //static final String DB_USER = "root";
    //static final String DB_PASSWD = "";   
    ResultSet resultset = null;
    Connection connection = null;
    Statement statement = null;

    public boolean registerUser(String u, String p, String n, String e) {
        int rowAffected = 0;
        try {
            String sql = "INSERT INTO tbluser (username,name,dob,password)"
                    + "VALUES ('" + u + "','" + n + "','" + e + "','" + p + "')";
            dbcon query1 = new dbcon();
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Get a connection

            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
            rowAffected = statement.executeUpdate(sql);

        } catch (Exception ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rowAffected == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

}

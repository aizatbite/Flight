/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import db.dbcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.Users;

/**
 *
 * @author Dell
 */
public class Admindb {

    private String adminEmail;
    private String adminPassword;

    public Admindb() {

    }

    public Admindb(String adminEmail, String adminPassword) {
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    public int checkAdminStatus() {
        ResultSet rs = null;
        int x = 0;
        try {

            db.dbcon query1 = new db.dbcon();

            String sql = "SELECT\n"
                    + "count(*) as rowcount\n"
                    + " FROM\n"
                    + "\"public\".\"Admin\" \n"
                    + "WHERE\n"
                    + "\"public\".\"Admin\".\"adminEmail\" = '" + this.getAdminEmail().trim() + "' and\n"
                    + "\"public\".\"Admin\".\"adminPassword\" = '" + this.getAdminPassword().trim() + "'";

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

    /**
     * @return the adminEmail
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    /**
     * @param adminEmail the adminEmail to set
     */
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    /**
     * @return the adminPassword
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * @param adminPassword the adminPassword to set
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

}

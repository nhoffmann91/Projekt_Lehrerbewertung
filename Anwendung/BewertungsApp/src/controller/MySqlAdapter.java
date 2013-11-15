package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Class to adapt the MySql Database
public class MySqlAdapter {
	private String Username = "root";
    private String Password = "Passwort";
    private String Driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://mysql.host.net:3306/datenbank";
    private Connection connection;
 
    public MySqlAdapter() {
        this.Connect();
    }
    
    public MySqlAdapter(String user, String pass) {
        this.Username = user;
        this.Password = pass;
        this.Connect();
    }
 
    public void Close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (Exception e) {
            }
        }
    }
 
    public void Connect() {
        try {
            Class.forName(this.Driver);
            this.connection = DriverManager.getConnection(this.URL,
                    this.Username, this.Password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Connecting with User:" + Username + " and Password:" + Password);
        }
    }
 
    public boolean isConnected() {
        try {
            ResultSet rs = this.ReturnQuery("SELECT 1;");
            if (rs == null) {
                return false;
            }
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
 
    public ResultSet ReturnQuery(String query) {
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.err.println(e.toString());
            return null;
        }
    }
 
    public boolean RunQuery(String query) {
        try {
            Statement stmt = this.connection.createStatement();
            return stmt.execute(query);
        } catch (Exception e) {
            //  e.printStackTrace();
            return false;
        }
    } 
}

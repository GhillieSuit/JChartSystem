/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author dbstk
 */
public class DB_CONN {
    String strDriver;
    String strURL;
    String strUser;
    String strPW;
    
    Connection DB_con;
    PreparedStatement DB_pstm;
    ResultSet DB_rs;
    
    public DB_CONN() {
    	String resource = "config/DB.properties";
    	Properties properties = new Properties();
    	try {
            InputStream reader = getClass().getResourceAsStream(resource);
            properties.load(reader);
            this.strDriver = properties.getProperty("driver");
            this.strURL = properties.getProperty("url");
            this.strUser = properties.getProperty("username");
            this.strPW = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void dbOpen() throws IOException{
        try {
            Class.forName(strDriver);
            DB_con = DriverManager.getConnection(strURL, strUser, strPW);
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    
    public void dbClose() throws IOException{
        try {
            DB_con.close();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
}

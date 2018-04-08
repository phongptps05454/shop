/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TUNGDUONG
 */
public class DBConnect {
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://ps05454.mysql.database.azure.com:3306/shop?useSSL=true&requireSSL=false";
            conn = DriverManager.getConnection(url,"ps05454@ps05454","abc@1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    
}

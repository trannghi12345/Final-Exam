/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import database.ITRequest;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Date;
import java.sql.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class test {
    
     public static void main(String[] args) throws SQLException{
         Connection conn = ITRequest.getConnection();
         if (conn != null) {
             System.out.println("Connected");
             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
             System.out.println("Driver name: " + dm.getDriverName());
             System.out.println("Driver version: " + dm.getDriverVersion());
             System.out.println("Product name: " + dm.getDatabaseProductName());
             System.out.println("Product version: " + dm.getDatabaseProductVersion());
         }
//            ITRequest.insert("name",Date.valueOf("2002-06-18"), "email", "type1", "detail1");
//         ITRequest.createReq("Tran Nguyen Bao Nghi",Date.valueOf("2002-06-18"),"bnghi@", "", "");
         ITRequest.searchReq(1);
     }
  
     
}

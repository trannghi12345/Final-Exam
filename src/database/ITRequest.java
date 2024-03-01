/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

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

/**
 *
 * @author ADMIN
 */
public class ITRequest {
//    static final String URL = "jdbc:sqlserver://LAPTOP-M7JP18Q0; databaseName = VBoxData";
//    static final String user = "sa";
//    static final String pass = "trannghi12345";
//    
//    public static void createReq(int ReqID, String ReqName, Date ReqDate, String ReqEmail, String ReqType, String ReqDetails) throws SQLException{
//        String sql = "Insert into ITRequest1 (?,?,?,?,?,?)";
//        Connection conn = DriverManager.getConnection(URL, user, pass);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setInt(1, ReqID);
//        pstmt.setString(2, ReqName);
//        pstmt.setDate(3, ReqDate);
//        pstmt.setString(4, ReqEmail);
//        pstmt.setString(5, ReqType);
//        pstmt.setString(6, ReqDetails);
//        int i = pstmt.executeUpdate();
//        System.out.println(i);
//    }
//    
//    public static void select() throws SQLException{
//        String sql = "Select * from ITRequest1 WHERE ReqID like ?";
//        Connection conn = DriverManager.getConnection(URL, user, pass);
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//        while(rs.next()){
//            System.out.println("ReqID: " + rs.getInt("ReqID"));
//            System.out.println("ReqName: " + rs.getString("ReqName"));
//            System.out.println("ReqDate: " + rs.getDate("ReqDate"));
//            System.out.println("ReqEmail: " + rs.getString("ReqEmail"));
//            System.out.println("ReqType: " + rs.getString("ReqEmail"));
//            System.out.println("ReqDetails: " + rs.getString("ReqDetails"));
//        }
//        
//    }
//    
//    public static void print(int id) throws SQLException{
//                Connection conn = DriverManager.getConnection(URL, user, pass);
//
//        
//        final String sql = "select * from ITRequest1 where ReqID = ?";
//        
//        PreparedStatement ps = conn.prepareStatement(sql);
//        
//        ps.setInt(1, id);
//        
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()){
//            System.out.print(rs.getInt("ReqID")+"\t");
//            System.out.print(rs.getString("ReqName")+"\t");
//            System.out.print(rs.getDate("ReqDate")+"\t");
//            System.out.print(rs.getString("ReqEmail")+"\t\t");
//            System.out.print(rs.getString("ReqType")+"\t");
//            System.out.println(rs.getString("ReqDetails"));   
//        }
//        
//    }
//    public static void main(String[] args) throws SQLException {
//        createReq(2, "TranNguyenBaoNghi", Date.valueOf("2002-07-14"), "nghib2012138@student.ctu.edu.vn","","");
//            print(1);
//       
//    }        

    static final String URL = "jdbc:sqlserver://LAPTOP-M7JP18Q0; databaseName = VBoxData";
    static final String user = "sa";
    static final String pass = "trannghi12345";

    public static Connection getConnection() throws SQLException {
        Connection c = null;

        c = DriverManager.getConnection(URL, user, pass);
        return c;
    }
//    

    public static void createReq(String ReqName, Date ReqDate, String ReqEmail, String ReqType, String ReqDetail) throws SQLException {
        Connection c = DriverManager.getConnection(URL, user, pass);
        PreparedStatement pstmt;
        String SQL = "Insert into ITRequest values (?,?,?,?,?)";
        pstmt = c.prepareStatement(SQL);
//   
        pstmt.setString(1, ReqName);
        pstmt.setDate(2, ReqDate);
        pstmt.setString(3, ReqEmail);
        pstmt.setString(4, ReqType);
        pstmt.setString(5, ReqDetail);

        int rows = pstmt.executeUpdate();
        System.out.println("Rows impacted : " + rows);
    }

    public static void searchReq(int x) {
        try {
            Connection c = getConnection();
            String sql = "select * from ITRequest WHERE ReqID = ?";
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, x);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getInt("ReqID") + "\t");
                System.out.print(rs.getString("ReqName") + "\t");
                System.out.print(rs.getDate("ReqDate") + "\t");
                System.out.print(rs.getString("ReqEmail") + "\t");
                System.out.print(rs.getString("ReqType") + "\t");
                System.out.print(rs.getString("ReqDetail") + "\t");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ITRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection c) throws SQLException {
        if (c != null) {
            c.close();
        }
    }

}

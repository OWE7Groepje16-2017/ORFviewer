/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orffinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class DataExporter {

    static private Connection connection;
    public static Connection

    getConnection() throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xirect.nl", "pg16", "blaat1234_16");
        }
        return connection;
    }

    public void exportData(int seqID, String originNseq, String projectName,
            String Organism, String header, int ORFID, String ORFNSeq, int RFNumber) {
        String query1 = "insert into items values ('"+seqID+"','"+originNseq+"','"+projectName+"','"+Organism+"','"+header+"')";
        String query2 = "insert into items values ('"+ORFID+"','"+ORFNSeq+"','"+RFNumber+"','"+seqID+"')";
        
        try{
            Connection c = getConnection();
            Statement stmt = c.createStatement();
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
        }catch(Exception e){
            System.out.println("something went wrong");
        }
    }
    
}

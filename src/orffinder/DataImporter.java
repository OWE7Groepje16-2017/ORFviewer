/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orffinder;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author jdm
 */
public class DataImporter {
    
    static private Connection connection = null;
    private ArrayList<String> importedData = new ArrayList();

    /**
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://xirect.nl:3306/pg16", "pg16", "blaat1234_16");
        }
        return connection;
    }

    /**
     *
     * @param projectName
     * @return
     */
    public ArrayList<String> importData(String projectName){
        
        try {
            Connection c = getConnection();
            Statement getSequences = c.createStatement();
            String seqQuery = "SELECT originNSeq as obtSeq, header as obtHeader FROM sequence "
                    + "WHERE projectName = '"+projectName+"';";
            ResultSet rs = getSequences.executeQuery(seqQuery);
            while (rs.next()) {
                importedData.add(rs.getString("obtHeader"));
                importedData.add(rs.getString("obtSeq"));
            }
        } catch (Exception e) {
            System.out.println("something went wrong while fetching maxORF");
            e.printStackTrace();
        

        
    }
        return importedData;
    }
    
}

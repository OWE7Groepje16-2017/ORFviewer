/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orffinder;

import java.sql.*;

/**
 *
 * @author
 */
public class DataExporter {

    static private Connection connection = null;

    public static Connection
            getConnection() throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://xirect.nl:3306/pg16", "pg16", "blaat1234_16");
        }
        return connection;
    }

    public void exportSequence(int seqID, String originNseq, String projectName,
            String Organism, String header) {

        try {
            Connection c = getConnection();
            PreparedStatement stmtSeq = null;
            String seqQuery = "INSERT INTO sequence (sequenceID, originNSeq, organismName, projectName, header) VALUES(?,?,?,?,?)";
            stmtSeq = c.prepareStatement(seqQuery);
            stmtSeq.setInt(1, seqID);
            stmtSeq.setString(2, originNseq);
            stmtSeq.setString(3, Organism);
            stmtSeq.setString(4, projectName);
            stmtSeq.setString(5, header);
            stmtSeq.executeUpdate();
        } catch (Exception e) {
            System.out.println("something went wrong while exporting sequence");
        }
    }

    public void exportORF(int ORFID, String ORFNSeq, String RFNumber, int seqID) {
        

        try {
            Connection c = getConnection();
            PreparedStatement stmtORF = null;
            String seqQuery = "INSERT INTO ORF (ORFID, ORFNSeq, RFNumber, sequenceID) VALUES(?,?,?,?)";
            stmtORF = c.prepareStatement(seqQuery);
            stmtORF.setInt(1, ORFID);
            stmtORF.setString(2, ORFNSeq);
            stmtORF.setString(3, RFNumber);
            stmtORF.setInt(4, seqID);
            stmtORF.executeUpdate();
        } catch (Exception e) {
            System.out.println("something went while exporting ORF");
            e.printStackTrace();
        }
    }

    public int getSeqID() {
        int maxID = 0;
        try {
            Connection c = getConnection();
            Statement getMax = c.createStatement();
            String maxIDquery = "SELECT MAX(sequenceID) as maxSeqID FROM sequence;";
            ResultSet rs = getMax.executeQuery(maxIDquery);
            while (rs.next()) {
                maxID = rs.getInt("maxSeqID");
            }
        } catch (Exception e) {
            System.out.println("something went wrong while fetching maxseq");
            e.printStackTrace();
        }

        return maxID;
    }

    public int getORFID() {
        int maxID = 0;
        try {
            Connection c = getConnection();
            Statement getMax = c.createStatement();
            String maxIDquery = "SELECT MAX(ORFID) as maxORFID FROM ORF;";
            ResultSet rs = getMax.executeQuery(maxIDquery);
            while (rs.next()) {
                maxID = rs.getInt("maxORFID");
            }
        } catch (Exception e) {
            System.out.println("something went wrong while fetching maxORF");
            e.printStackTrace();
        }

        return maxID;
    }

}

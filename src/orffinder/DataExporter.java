/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orffinder;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class DataExporter {

    static private Connection connection = null;

    /**
     *
     * @return
     * @throws Exception
     */
    public static Connection
            getConnection() throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://xirect.nl:3306/pg16", "pg16", "blaat1234_16");
        }
        return connection;
    }

    /**
     *
     * @param seqID
     * @param originNseq
     * @param projectName
     * @param Organism
     * @param header
     */
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
            JOptionPane.showMessageDialog(null, "Something went wrong while exporting the sequence", "Error Message",
                    JOptionPane.ERROR_MESSAGE);;
        }
    }

    /**
     *
     * @param ORFID
     * @param ORFNSeq
     * @param RFNumber
     * @param seqID
     */
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
            JOptionPane.showMessageDialog(null, "Something went wrong while exporting ORF's", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @return
     */
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
            JOptionPane.showMessageDialog(null, "Something went wrong while fetching maxSeq", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }

        return maxID;
    }

    /**
     *
     * @return
     */
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
            JOptionPane.showMessageDialog(null, "Something went wrong while fetching maxORF", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
             
        

        return maxID;
    }

}

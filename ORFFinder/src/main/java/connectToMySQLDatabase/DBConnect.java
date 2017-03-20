/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectToMySQLDatabase;

/**
 *
 * @author Beheerder
 */
import java.sql.*;

public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
    }

    public void getData() {
        try {
            String query = "select * from tabelindatabase";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while (rs.next()) {
                String name = rs.getString("nameKolomInDatabase");
                String age = rs.getString("ageKolomInDatabase");
                System.out.println("Name: " + name + "  " + "Age: " + age);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}

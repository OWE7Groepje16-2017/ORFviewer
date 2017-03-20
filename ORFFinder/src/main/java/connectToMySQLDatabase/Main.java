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
public class Main {

    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        connect.getData();

    }

}

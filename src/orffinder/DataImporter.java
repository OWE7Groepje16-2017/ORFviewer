/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orffinder;

/**
 *
 * @author jdm
 */
public class DataImporter {
    
    public void importDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driverloaded!");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
}

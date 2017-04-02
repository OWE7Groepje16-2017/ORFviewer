/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orffinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jasper de Meijer
 */
public class FileHandler {
     //Start variable declaration
    private String filePath;
    private BufferedReader inFile1;  
    private ArrayList<String> fileContent = new ArrayList<>();
    //End variable declaration
    /**
     *
     * @return String Selected file path
     * Opens a file chooser and returns the path of the chosen file.
     */
    public String openFile() {

        JFileChooser fc1 = new JFileChooser();
        int returnValue = fc1.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc1.getSelectedFile();
            filePath = selectedFile.getPath();
        }
        return filePath;

    }

    /**
     *
     * @param filePath the path of selected path
     * @return Every line of the given file except for the header
     * Processes the file and returns every line except for the header.
     * The header will be saved for later use.
     * Catches FileNotFoundException and IOException.
     * An exception catch will give the user a popup with a notification what went wrong.
     */
    public ArrayList<String> readFile(String filePath) {
       

        String line;
        String tempLines = "";
        try {
            inFile1 = new BufferedReader(new FileReader(filePath));

            while ((line = inFile1.readLine()) != null) {
               if (line.contains(">")){
                   if( tempLines != ""){
                       fileContent.add(tempLines);
                       tempLines = "";
                   }
                   fileContent.add(line);
                   
               } else{
                   tempLines += line;
                   
               }

            }
            fileContent.add(tempLines);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "The selected file could not be located!", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There occured and input/output error!", "Error Message",
                    JOptionPane.ERROR_MESSAGE);

        }
        
        return fileContent;
    }

    /**
     *
     * @param interactionShortPhrase 
     * @param geneList
     * Itterates over the original gene list, if a gene contains the given interaction short phrase
     * it will be stored in a Hashmap
     * Creates a HashMap with a counter as key (can be used as index of the original genelist)
     * Gene ID1 of the corresponding gene is used as value. 
     */
    

    


    
}

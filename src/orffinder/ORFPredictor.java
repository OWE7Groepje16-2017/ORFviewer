/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orffinder;

import java.util.ArrayList;

/**
 *
 * @author Tim
 */
public class ORFPredictor {
    
    //creation of the fields. these variables are to be available throughout the entire class
    private ArrayList<String> headerList = new ArrayList();
    private ArrayList<String> sequenceList = new ArrayList();
    private ArrayList<String> ORFs = new ArrayList();
    
    //This method converts the input to two arraylists containing sequences and headers
    public void predictORF(ArrayList<String> sequence){
    
        for(String s : sequence){
            if(s.startsWith(">")){
                headerList.add(s);
            }
            else{
                sequenceList.add(s);
            }
        }
        
    }
    //this function generates a set of ORFs based on a set of given parameters, which RF should be used, and the Header which was selected.
    public void visualizeORF(int selectedRF, int selectedHeader){
        //a temporal variable is initiated, this is needed for building the ORFs
        char[] temporalRF;
        
        //if the selected reading frame is smaller or equal to three, the reading frame is forward, and a forward strand is given.
        if(selectedRF <= 3){
            //the desired sequence is added to the temporalstring and converted to a char array
            temporalRF = sequenceList.get(selectedHeader).toCharArray();
            
            //the sequence is then given to a method which will in turn build the ORFs, the sequence is given, it also takes the selected reading frame
            ORFBuilder(temporalRF, selectedRF);
                 }
        //if the selected reading frame is not smaller or equal to three, the reading frame is reverse, therefor a complementary strand must be given
        else {
            //the desired sequence is added to the temporal string and converted to a char array
            temporalRF = sequenceList.get(selectedHeader).toCharArray();
            //before executing the ORFbuilder, the strand is first made complementary with another method.
            ORFBuilder(makeComplementary(temporalRF).toCharArray(), selectedRF);
            
        }
    }
    //this method builds the ORFs
    public void ORFBuilder(char[] readingFrame, int requiredReadingFrame){
        ORFs.clear();
        //this string poses as a placeholder for codons
        String codon = "";
        //this string is used to add codons until an orf is complete
        String temporalORF = "";
        //this boolean is used to check whether codons must be added to the temporalORF string.
        boolean ORFcheck = false;
        //an if statement to determine how the codons must be divided
        if(requiredReadingFrame == 1 || requiredReadingFrame == 4){
            for(int i = 0; i < readingFrame.length; i++){
                codon += readingFrame[i];
                if(codon.length() == 3){
                    if(codon.equals("ATG") & ORFcheck == false){
                        temporalORF += codon;
                        codon = "";
                        ORFcheck = true;
                    } 
                    if(ORFcheck == true){
                        if(codon.equals("TAA") | codon.equals("TAG") | codon.equals("TGA")){
                            ORFcheck = false;
                            temporalORF += codon;
                            ORFs.add(temporalORF);
                            temporalORF = "";
                            codon = "";
                            
                        }
                        else{
                            temporalORF += codon;
                            codon = "";
                        }
                    }
                    else{
                        codon = "";
                    }
                }
                
            }
        }
              if(requiredReadingFrame == 2 || requiredReadingFrame == 5){
            for(int i = 1; i < readingFrame.length; i++){
                codon += readingFrame[i];
                if(codon.length() == 3){
                    if(codon.equals("ATG") & ORFcheck == false){
                        temporalORF += codon;
                        codon = "";
                        ORFcheck = true;
                    } 
                    if(ORFcheck == true){
                        if(codon.equals("TAA") | codon.equals("TAG") | codon.equals("TGA")){
                            ORFcheck = false;
                            temporalORF += codon;
                            ORFs.add(temporalORF);
                            temporalORF = "";
                            codon = "";
                            
                        }
                        else{
                            temporalORF += codon;
                            codon = "";
                        }
                    }
                    else{
                        codon = "";
                    }
                }
                
            }
                  if(requiredReadingFrame == 3 || requiredReadingFrame == 6){
            for(int i = 0; i < readingFrame.length; i++){
                codon += readingFrame[i];
                if(codon.length() == 3){
                    if(codon.equals("ATG") & ORFcheck == false){
                        temporalORF += codon;
                        codon = "";
                        ORFcheck = true;
                    } 
                    if(ORFcheck == true){
                        if(codon.equals("TAA") | codon.equals("TAG") | codon.equals("TGA")){
                            ORFcheck = false;
                            temporalORF += codon;
                            ORFs.add(temporalORF);
                            temporalORF = "";
                            codon = "";
                            
                        }
                        else{
                            temporalORF += codon;
                            codon = "";
                        }
                    }
                    else{
                        codon = "";
                    }
                }
                
            }
        }
        }
   
    }
    
    //this function turns dna into its complementary strand
    public String makeComplementary(char[] editSeq){
        String complementarySequence = "";
        for(char c : editSeq){
            if(c == 'A'){
                c = 'T';
            }
            else if(c == 'T'){
                c = 'A';
            }
            else if(c == 'G'){
                c = 'C';
            }
            else if(c == 'C'){
                c = 'G';
            }
            else {
                complementarySequence += c;
            }
            
            
        }
        return complementarySequence;
    }
//getters and setters for the ORFpredictor are found below
    public ArrayList<String> getHeaderList() {
        return headerList;
    }

    public void setHeaderList(ArrayList<String> headerList) {
        this.headerList = headerList;
    }

    public ArrayList<String> getSequenceList() {
        return sequenceList;
    }

    public void setSequenceList(ArrayList<String> sequenceList) {
        this.sequenceList = sequenceList;
    }

    public ArrayList<String> getORFs() {
        return ORFs;
    }

    public void setORFs(ArrayList<String> ORFs) {
        this.ORFs = ORFs;
    }
    
}


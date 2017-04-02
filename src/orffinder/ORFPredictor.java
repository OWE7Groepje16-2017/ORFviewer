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
    private ArrayList<String> headerList;
    private ArrayList<String> sequenceList;
    private ArrayList<String> ORFs;
    
    //This method converts the input to two arraylists containing sequences and headers
    public void predictORF(String sequence){
        //the input is converted to an array for easier manipulation
        String[] fileContent = sequence.split("\n");
        //creation of a temporal string and a counter for later use
        String temporalNucleotide = "";
        int counter = 0;
        
        // for each item in the earlier created array, it is determined whether it is a header or a fragment of sequence, based on that information
        // the item is added to the desired arraylist.
        for(String s : fileContent){
            //adding one to the counter created earlier for each loop
            counter += 1;
            //when the item starts with the '>' sign, it is a header.
            if(s.startsWith(">")){
                //when a header is found, the previous fragment of sequence is added to the list of sequences, if the string is not empty
                if(temporalNucleotide != ""){
                    sequenceList.add(temporalNucleotide.toUpperCase());
                }
                //the header is added to the list of headers
                headerList.add(s);
                
                //the temporal string is cleared so it may be used again
                temporalNucleotide = "";
            }
            //if the file has run out of headers, the last sequence still needs to be added, this happens when the counter is equal to the length of the 
            //array filled with data
            if(counter == fileContent.length){
                temporalNucleotide += s;
                sequenceList.add(temporalNucleotide.toUpperCase());
            }
            else {
                //if the item in the loop is not a header, it's a fragment of a sequence. it is added to the temporal string, to be added to the list in the future
                temporalNucleotide += s;
            }
        }
        
    }
    //this function generates a set of ORFs based on a set of given parameters, which RF should be used, and the Header which was selected.
    public void visualizeORF(int selectedRF, int selectedHeader){
        //a temporal variable is initiated, this is needed for building the ORFs
        char[] temporalRF;
        
        
        if(selectedRF <= 3){
            temporalRF = sequenceList.get(selectedHeader -1).toCharArray();
            ORFBuilder(temporalRF, selectedRF);
                 }
        else {
            temporalRF = sequenceList.get(selectedHeader -1).toCharArray();
            ORFBuilder(makeComplementary(temporalRF).toCharArray(), selectedRF);
            
        }
    }
    public void ORFBuilder(char[] readingFrame, int requiredReadingFrame){
        String codon = "";
        String temporalORF = "";
        boolean ORFcheck = false;
        
            if(requiredReadingFrame == 1 || requiredReadingFrame == 4){
                for(int i = 0; i < readingFrame.length; i++){
                    codon += readingFrame[i];
                    if(codon.length() == 3){
                        if(ORFcheck == false){
                            if(codon == "ATG"){
                                ORFcheck = true;
                                temporalORF += codon;
                                codon = "";
                            }
                        }
                        if(ORFcheck == true){
                            if(codon != "TAA" || codon != "TAG" || codon != "TGA"){
                                temporalORF += codon;
                                codon = "";
                            }
                            else{
                                ORFcheck = false;
                                temporalORF += codon;
                                ORFs.add(temporalORF);
                                temporalORF = "";
                                codon = "";
                            }
                        }
                        else {
                            codon = "";
                        }
                    }
                }
            }
            if(requiredReadingFrame == 2 || requiredReadingFrame == 5){
                for(int i = 1; i < readingFrame.length; i++){
                    codon += readingFrame[i];
                    if(codon.length() == 3){
                        if(ORFcheck == false){
                            if(codon == "ATG"){
                                ORFcheck = true;
                                temporalORF += codon;
                                codon = "";
                            }
                        }
                        if(ORFcheck == true){
                            if(codon != "TAA" || codon != "TAG" || codon != "TGA"){
                                temporalORF += codon;
                                codon = "";
                            }
                            else{
                                ORFcheck = false;
                                temporalORF += codon;
                                ORFs.add(temporalORF);
                                temporalORF = "";
                                codon = "";
                            }
                        }
                        else {
                            codon = "";
                        }
                    }
                }
            }
            if(requiredReadingFrame == 3 || requiredReadingFrame == 6){
                for(int i = 2; i < readingFrame.length; i++){
                    codon += readingFrame[i];
                    if(codon.length() == 3){
                        if(ORFcheck == false){
                            if(codon == "ATG"){
                                ORFcheck = true;
                                temporalORF += codon;
                                codon = "";
                            }
                        }
                        if(ORFcheck == true){
                            if(codon != "TAA" || codon != "TAG" || codon != "TGA"){
                                temporalORF += codon;
                                codon = "";
                            }
                            else{
                                ORFcheck = false;
                                temporalORF += codon;
                                ORFs.add(temporalORF);
                                temporalORF = "";
                                codon = "";
                            }
                        }
                        else {
                            codon = "";
                        }
                    }
                }
            }
   
    }
    
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
            complementarySequence += c;
            
        }
        return complementarySequence;
    }
}


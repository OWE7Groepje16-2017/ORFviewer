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
        
        //if the selected reading frame is smaller or equal to three, the reading frame is forward, and a forward strand is given.
        if(selectedRF <= 3){
            //the desired sequence is added to the temporalstring and converted to a char array
            temporalRF = sequenceList.get(selectedHeader -1).toCharArray();
            //the sequence is then given to a method which will in turn build the ORFs, the sequence is given, it also takes the selected reading frame
            ORFBuilder(temporalRF, selectedRF);
                 }
        //if the selected reading frame is not smaller or equal to three, the reading frame is reverse, therefor a complementary strand must be given
        else {
            //the desired sequence is added to the temporal string and converted to a char array
            temporalRF = sequenceList.get(selectedHeader -1).toCharArray();
            //before executing the ORFbuilder, the strand is first made complementary with another method.
            ORFBuilder(makeComplementary(temporalRF).toCharArray(), selectedRF);
            
        }
    }
    //this method builds the ORFs
    public void ORFBuilder(char[] readingFrame, int requiredReadingFrame){
        //this string poses as a placeholder for codons
        String codon = "";
        //this string is used to add codons until an orf is complete
        String temporalORF = "";
        //this boolean is used to check whether codons must be added to the temporalORF string.
        boolean ORFcheck = false;
        //an if statement to determine how the codons must be divided
            if(requiredReadingFrame == 1 || requiredReadingFrame == 4){
                //the codons start at the beginning for reading frame 1 and 4 (-1)
                for(int i = 0; i < readingFrame.length; i++){
                    //the current item is added to the codon placeholder
                    codon += readingFrame[i];
                    //when the size of the placeholder is equal to three, a codon is complete and action will be taken
                    if(codon.length() == 3){
                        //when the ORFcheck variable is not true, it is checked if the selected codon is a start codon.
                        if(ORFcheck == false){
                            //if the codon is a start codon, orfcheck is made true to allow further extention of the built orf
                            if(codon == "ATG"){
                                ORFcheck = true;
                                temporalORF += codon;
                                codon = "";
                            }
                            //if it's not a start codon, codon is emtpied so it may be used again
                            codon = "";
                        }
                        //when a stop codon is encountered, it is added to the orf and the orf is no longer extended.
                        //if it is not, the orf is extended without further action.
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
                        
                    }
                }
            }
            //exactly the same as the previous method, except the codon are shifted one position
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
            //the same as the previous method, the positions of the codons are shifted one final position.
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
}


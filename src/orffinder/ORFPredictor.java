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
    private String sequence;
    private ArrayList<String> headerList;
    private ArrayList<String> RFs;
    private ArrayList<String> ORFs;
    
    public void predictORF(){
        String[] fileContent = sequence.split("\n");
        String temporalNucleotide = "";
        for(String s : fileContent){
            if(s.startsWith(">")){
                if(temporalNucleotide != ""){
                    RFs.add(temporalNucleotide);
                }
                headerList.add(s);
                temporalNucleotide = "";
            }
            else {
                temporalNucleotide += s;
            }
        }
        
    }
    public void visualizeORF(int selectedRF, int selectedHeader){
        char[] temporalRF;
        
        
        if(selectedRF <= 3){
            temporalRF = RFs.get(selectedHeader -1).toCharArray();
            ORFBuilder(temporalRF, selectedRF);
                 }
        else {
            temporalRF = RFs.get(selectedHeader -1).toCharArray();
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


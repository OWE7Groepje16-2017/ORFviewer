/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orffinder;

import java.util.HashMap;

/**
 *
 * @author Jasper de Meijer
 * When the class is called upon the constructor will initialize a HashMap 
 * containing an amino acid codon table. To translate a codon to an amino acid
 * use the getAminoAcidSequence(codon) function.
 */
public class SequenceTranscriptor {
    //start of variable declaration
    HashMap table = new HashMap();
    String nucleotideSequence;
    String aminoSequence;
    //end of variable declaration
    
    /**
     *Constructor: will intialize the Hashmap containing AA codon table.
     */
    public SequenceTranscriptor(){
        initializeTable();
    }

    /**
     *
     * @param codon, a three letter string which needs to be translated to an AA
     * @return String containing the AA.
     * Calls upon the the initialized hashmap(table). Uses the 3 letter codon as a key
     * and returns the corresponding value (the AA).
     */
    public String getAminoAcidSequence(String codon){
        String uCodon = codon.toUpperCase();
        String AA = (String) table.get(uCodon);
        return AA;
    }
    
    /**
     *Initializes the hashmap containing the codons as keys and the AA's as values
     */
    private void initializeTable ()
{
  table.put ("TTT", "F");
  table.put ("TTC", "F");
  table.put ("TTA", "L");
  table.put ("TTG", "L");
  table.put ("TCT", "S");
  table.put ("TCC", "S");
  table.put ("TCA", "S");
  table.put ("TCG", "S");
  table.put ("TAT", "Y");
  table.put ("TAC", "Y");
  table.put ("TAA", "*");
  table.put ("TAG", "*");
  table.put ("TGT", "C");
  table.put ("TGC", "C");
  table.put ("TGA", "*");
  table.put ("TGG", "W");
  table.put ("CTT", "L");
  table.put ("CTC", "L");
  table.put ("CTA", "L");
  table.put ("CTG", "L");
  table.put ("CCT", "P");
  table.put ("CCC", "P");
  table.put ("CCA", "P");
  table.put ("CCG", "P");
  table.put ("CAT", "H");
  table.put ("CAC", "H");
  table.put ("CAA", "Q");
  table.put ("CAG", "Q");
  table.put ("CGT", "R");
  table.put ("CGC", "R");
  table.put ("CGA", "R");
  table.put ("CGG", "R");
  table.put ("ATT", "I");
  table.put ("ATC", "I");
  table.put ("ATA", "I");
  table.put ("ATG", "M");
  table.put ("ACT", "T");
  table.put ("ACC", "T");
  table.put ("ACA", "T");
  table.put ("ACG", "T");
  table.put ("AAT", "N");
  table.put ("AAC", "N");
  table.put ("AAA", "K");
  table.put ("AAG", "K");
  table.put ("AGT", "S");
  table.put ("AGC", "S");
  table.put ("AGA", "R");
  table.put ("AGG", "R");
  table.put ("GTT", "V");
  table.put ("GTC", "V");
  table.put ("GTA", "V");
  table.put ("GTG", "V");
  table.put ("GCT", "A");
  table.put ("GCC", "A");
  table.put ("GCA", "A");
  table.put ("GCG", "A");
  table.put ("GAT", "D");
  table.put ("GAC", "D");
  table.put ("GAA", "E");
  table.put ("GAG", "E");
  table.put ("GGT", "G");
  table.put ("GGC", "G");
  table.put ("GGA", "G");
  table.put ("GGG", "G");

} 
    
    
    
}

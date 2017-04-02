/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translation2;

/**
 *
 * @author Gerwin Smits
 * Date 01-04-2017
 * Translator
 */
import java.util.HashMap;
import java.util.Map;

public class SequenceTranslator {

    private static final Map<String, Character> table;
    public static String nucleotideSequence = "TAGATG";
    public static boolean checkDNABoolean;

    /**
     *
     * @param main for nucleotideSequence to aminoSequence converter
     */
    public static void main(String[] args) {

        // check if DNA is valid
        checkDNABoolean = isValidDNA(nucleotideSequence);

        //if DNA is valid
        if (checkDNABoolean == true) {
            //Translate nucleotideSequence to aminoSequence
            String aminoSequence = translateSequence(nucleotideSequence);
            System.out.println(aminoSequence);

        }
    }

    /**
     *
     * @param nucleotideSequence DNA 
     * @return returns true if DNA is valid. Returns false if DNA is not valid.
     */
    public static boolean isValidDNA(String nucleotideSequence) {
        boolean res = true;
        for (int i = 0; i < nucleotideSequence.length(); i++) {
            if ((nucleotideSequence.charAt(i) != 'A') && (nucleotideSequence.charAt(i) != 'T') && (nucleotideSequence.charAt(i) != 'C') && (nucleotideSequence.charAt(i) != 'G')) {
                res = false;
                break;
            }
        }
        return res;

    }

    static {
        //Hashmap to translate DNA into Protein
        table = new HashMap<String, Character>();
        table.put("TTT", 'F');
        table.put("TTC", 'F');
        table.put("TTA", 'L');
        table.put("TTG", 'L');
        table.put("TCT", 'S');
        table.put("TCC", 'S');
        table.put("TCA", 'S');
        table.put("TCG", 'S');
        table.put("TAT", 'Y');
        table.put("TAC", 'Y');
        //            TAA end
        //            TAG end
        table.put("TGT", 'C');
        table.put("TGC", 'C');
        //            TGA end
        table.put("TGG", 'W');
        table.put("CTT", 'L');
        table.put("CTC", 'L');
        table.put("CTA", 'L');
        table.put("CTG", 'L');
        table.put("CCT", 'P');
        table.put("CCC", 'P');
        table.put("CCA", 'P');
        table.put("CCG", 'P');
        table.put("CAT", 'H');
        table.put("CAC", 'H');
        table.put("CAA", 'Q');
        table.put("CAG", 'Q');
        table.put("CGT", 'R');
        table.put("CGC", 'R');
        table.put("CGA", 'R');
        table.put("CGG", 'R');
        table.put("ATT", 'I');
        table.put("ATC", 'I');
        table.put("ATA", 'I');
        table.put("ATG", 'M');
        table.put("ACT", 'T');
        table.put("ACC", 'T');
        table.put("ACA", 'T');
        table.put("ACG", 'T');
        table.put("AAT", 'N');
        table.put("AAC", 'N');
        table.put("AAA", 'K');
        table.put("AAG", 'K');
        table.put("AGT", 'S');
        table.put("AGC", 'S');
        table.put("AGA", 'R');
        table.put("AGG", 'R');
        table.put("GTT", 'V');
        table.put("GTC", 'V');
        table.put("GTA", 'V');
        table.put("GTG", 'V');
        table.put("GCT", 'A');
        table.put("GCC", 'A');
        table.put("GCA", 'A');
        table.put("GCG", 'A');
        table.put("GAT", 'D');
        table.put("GAC", 'D');
        table.put("GAA", 'E');
        table.put("GAG", 'E');
        table.put("GGT", 'G');
        table.put("GGC", 'G');
        table.put("GGA", 'G');
        table.put("GGG", 'G');

    }
 
    /**
     *
     * @param nucleotideSequence converted in aminoSequence
     * @return aminoSequence
     */
         //be sure that length of temp is a multiple of 3 and that every 3 characters correspond to a valid codon
        public static String translateSequence(String nucleotideSequence) {
        //Use StringBuilder for adding Characters, it is by far faster than adding chars to a mutable String
        StringBuilder finalreturn = new StringBuilder();
        String codon;
        for (int i = 0; i < nucleotideSequence.length() - 2; i++) {
            codon = nucleotideSequence.substring(i, i + 3);
            finalreturn.append(table.get(codon));

        }
        return finalreturn.toString();
    }
}

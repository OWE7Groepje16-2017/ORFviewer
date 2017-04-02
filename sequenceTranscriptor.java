package project16;

import java.util.HashMap;
import static project16.sequenceTranscriptor.complement;
/**
 *
 * @author aditi
 */
public class sequenceTranscriptor {
    public static HashMap<String, String> Transcriptor = new HashMap<>();
    private static String comp;
    private static int Nucleotides;
    
    public static String complement(String dna){
        System.out.println("generating complement DNA..");
        String com = null;
        try{
        comp = "";
         for (int k = 0; k < dna.length(); k++){
             if(dna.charAt(k) == 'A'){
                 comp = comp + 'T';}
             else if (dna.charAt(k) == 'T'){
                 comp = comp + 'A';}
             else if (dna.charAt(k) == 'C'){
                 comp = comp + 'G';}
             else if (dna.charAt(k) == 'G'){
                 comp = comp + 'C';}
             else{
                 comp = comp + dna.charAt(k);
             }
             
         }
            
            
        }
        catch(java.lang.NullPointerException ex){
            System.out.println("making complement");
        }
        
        return comp;
    }
    
    public static String TranscriptorSequence(String sequence){
        System.out.println("Transcripting DNA to aminoacid sequence");
        String NewSequence= "";
        Transcriptor.put("atg","M");
        Transcriptor.put("ttt","F");
        Transcriptor.put("ttc","F");
        Transcriptor.put("tta","L");
        Transcriptor.put("ttg","L");
        Transcriptor.put("ctt","L");
        Transcriptor.put("cta","L");
        Transcriptor.put("ctg","L");
        Transcriptor.put("att","I");
        Transcriptor.put("atc","I");
        Transcriptor.put("ata","I");
        Transcriptor.put("gta","V");
        Transcriptor.put("gtg","V");
        Transcriptor.put("gtt","V");
        Transcriptor.put("gtc","V");
        Transcriptor.put("tct","S");
        Transcriptor.put("tca","S");
        Transcriptor.put("tcg","S");
        Transcriptor.put("tcc","S");
        Transcriptor.put("cct","P");
        Transcriptor.put("cca","P");
        Transcriptor.put("ccg","P");
        Transcriptor.put("ccc","P");
        Transcriptor.put("act","T");
        Transcriptor.put("acg","T");
        Transcriptor.put("acc","T");
        Transcriptor.put("aca","T");
        Transcriptor.put("gct","A");
        Transcriptor.put("gca","A");
        Transcriptor.put("gcc","A");
        Transcriptor.put("gcg","A");
        Transcriptor.put("tat","Y");
        Transcriptor.put("tac","Y");
        Transcriptor.put("taa","STOP");
        Transcriptor.put("tag","STOP");
        Transcriptor.put("cat","H");
        Transcriptor.put("cac","H");
        Transcriptor.put("caa","Q");
        Transcriptor.put("cag","Q");
        Transcriptor.put("aat","N");
        Transcriptor.put("aac","N");
        Transcriptor.put("aaa","K");
        Transcriptor.put("aag","K");
        Transcriptor.put("gat","D");
        Transcriptor.put("gac","D");
        Transcriptor.put("gaa","E");
        Transcriptor.put("gag","E");
        Transcriptor.put("tgt","C");
        Transcriptor.put("tgc","C");
        Transcriptor.put("uta","STOP");
        Transcriptor.put("tgg","W");
        Transcriptor.put("cgt","R");
        Transcriptor.put("cgc","R");
        Transcriptor.put("cgg","R");
        Transcriptor.put("cga","R");
        Transcriptor.put("agt","S");
        Transcriptor.put("agc","S");
        Transcriptor.put("aga","R");
        Transcriptor.put("agg","R");
        Transcriptor.put("ggt","G");
        Transcriptor.put("gga","G");
        Transcriptor.put("ggc","G");
        Transcriptor.put("ggg","G");
        for(int i=0; i<Nucleotides;i++){
            String codon = (String) sequence.subSequence(i, i+3);
            if (Transcriptor.get(codon)== null){
                NewSequence+="**";
            } else{
                NewSequence+=Transcriptor.get(codon);
                
            }
            
        }
        return NewSequence;
      
    }
    public static HashMap<Integer, String> createsubstrings(String sequence){
        System.out.println("Splitting sequence in 200 base substrings");
        HashMap<Integer, String> newSubStrings = new HashMap<>();
        int substringnumber = 0;
        String tempchar = "";
        for (Character character : sequence.toCharArray()){
            tempchar += ""+character;
            if(tempchar.length()== 200){
                newSubStrings.put(substringnumber, tempchar.toUpperCase());
                substringnumber +=1;
                tempchar ="";
                
            }
        if (tempchar !=""){
            newSubStrings.put(substringnumber, tempchar.toUpperCase());
            
        }
        }
        return newSubStrings; 
    }
}

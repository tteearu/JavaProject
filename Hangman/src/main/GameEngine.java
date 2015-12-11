package main;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionListener;
import java.sql.Array;
import javax.swing.JButton;

public class GameEngine {

	private static int failCounter = 0;
	static int random(int min, int max)
	{
	   int range = (max - min) + 1;     
	   int a = (int)(Math.random() * range) + min;
	   return a;
	}
	
	public static String[] Engine() {
        ArrayList<String> lines = new ArrayList<String>();
        String[] letters = new String[1];	
        String kataloogitee = GameEngine.class.getResource(".").getPath();
        File file = new File(kataloogitee + "words.txt");
        int length = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String rida;

            while ((rida = in.readLine()) != null) {
                lines.add(rida);
                length += 1;
            }
           int k = random(0, length);
           String randomWord =lines.get(k);
           System.out.println(randomWord);
               
                     
       //    String[] letters = randomWord.split("");
           
           char[] c = randomWord.toCharArray();
           letters = new String[c.length];
           
           for (int i = 0; i < c.length; i++) {
               letters[i] = String.valueOf(c[i]);
           }
           System.out.println(Arrays.toString(letters));
        
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());           
        }
		return letters; 
    }	
	public static String[] kriips(String[] args){
		int i = 0;
		for(String str : args ) {
			args[i] = "_";
			i++;
			}
		return args;
	}
	public static String[] Just4Lulz(String[] args){
		return args;
	}

	public static String[] letterCheck(String guessLetter, String[] sona, String[] prevWord ) {
		System.out.println(guessLetter);
		boolean correct = false;
		for(int q = 0; q < sona.length; q++){
			if(guessLetter.equals(sona[q])){
				prevWord[q] = guessLetter;
				correct = true;
			}
		}return prevWord;
		
//         int ammount = letters.length;
//         System.out.println(ammount);
//         StringBuilder kriips = new StringBuilder();
//         
//         for(int q = 0; q < ammount; q++){
//      	   if(guessLetter == letters[q]){
//      		   kriips.append(guessLetter);
//      	   }else{
//      		   failCounter++;
//      		   if(failCounter == 9){
////      			   WinLoose();
//      		   }else{
//      			   kriips.append("_ ");
//      		   }
//  		   }
//         }
//         kriips.toString();
//         System.out.println(kriips);
//		return kriips.toString();	
	}
}
//	public static Object array() {
//	String[] words = {"heterotopia", "westwards", "theocracy","iota","hoe","etym","richweed","loci","sporulate","dinoceras","coexistence","gymnogynous","odea","dzhambul","loring","jaffna","deoxidised","belteshazzar","viscosimetric","nondefective"};  
//	int i = (int)(Math.random() * (words.length));
//	String randomWord = words[i];
//	String[] letters = randomWord.split("");
//	
//	int kriips = letters.length;
//	String[] array = new String[kriips];
//	for (int j =  0; j < kriips; j++) {
//		   array[j] = "_";
//		}
//		return array;
//	};
//	class Alphabet_and_wordlist{
//
//		int kriips = randomWord.length();
//		int failure = 0;
//		String[] tahed = randomWord.split("");
//		
//		///uustekst = tekst.replace('a', '_');
		

		



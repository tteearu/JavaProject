package main;

/**
 * Importing necessary libraries
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that gets called out to create initial state of Game.java
 */
public class GameEngine {

	public int failCounter = 0;
	String word2B;
	String prevWord;
	String[] letters;
	String[] initWord;
	boolean gOver = false;
	boolean wordGuessed = false;
	boolean linesExist = false;

	/**
	 * Picking random word form words.txt
	 */
	static int random(int min, int max) {
		int range = (max - min) + 1;
		int a = (int) (Math.random() * range) + min;
		return a;
	}

	GameEngine(String sõnaMidaArvada) {

		ArrayList<String> lines = new ArrayList<String>();
		String kataloogitee = GameEngine.class.getResource(".").getPath();
		File file = new File(kataloogitee + "words.txt");
		int length = 0;
		String rida;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));

			while ((rida = in.readLine()) != null) {
				lines.add(rida.trim());
				length += 1;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		/**
		 * All letters from random word to upper case
		 */
		int k = random(0, length);
		word2B = lines.get(k);
		word2B = word2B.toUpperCase();
		/**
		 * Creating two identical arrays with same content
		 */
		char[] c = word2B.toCharArray();
		letters = new String[c.length];
		initWord = new String[c.length];

		for (int i = 0; i < c.length; i++) {
			letters[i] = String.valueOf(c[i]);
			initWord[i] = String.valueOf(c[i]);
		}
		/**
		 * Replacing letters[] with underscores
		 */
		int kriips = initWord.length;
		for (int j = 0; j < kriips; j++) {
			letters[j] = "_";
		}

		/**
		 * DEBUG
		 * 
		 * for(int a = 0; a < letters.length; a++){
		 * System.out.print(letters[a]+" "); }
		 * 
		 * System.out.println("INTERNAL STATE IS:");
		 * System.out.println("word2b:"); System.out.println(word2B);
		 * System.out.println("letters:");
		 * System.out.println(Arrays.toString(letters));
		 * System.out.println("initWord");
		 * System.out.println(Arrays.toString(initWord));
		 */
	}

	/**
	 * @param guessLetter
	 *            Method that checks whether the picked letter is correct, if
	 *            true, replaces the underscore with picked letter, else adds
	 *            one to failCounter
	 */

	void letterCheck(String guessLetter) {
		System.out.println(guessLetter);
		boolean letterCorrect = false;
		System.out.println("initWord");
		System.out.println(Arrays.toString(initWord));

		/**
		 * DEBUG
		 * 
		 * System.out.println("INTERNAL STATE::");
		 * System.out.println("word2b:"); System.out.println(word2B);
		 * System.out.println("letters:");
		 * System.out.println(Arrays.toString(letters));
		 * System.out.println("initWord:");
		 * System.out.println(Arrays.toString(initWord));
		 */

		for (int q = 0; q < word2B.length(); q++) {

			/**
			 * DEBUG
			 * 
			 * System.out.println("gLetter::" + guessLetter);
			 * System.out.println("InitWordQ::" + initWord[q]);
			 */

			if (guessLetter.equals(initWord[q])) {
				letters[q] = guessLetter;
				letterCorrect = true;
			}
		}
		/**
		 * prevWord represents the new string put together from guessed letters
		 * and letters remaining to be guessed
		 */
		System.out.println("PREVWORD");
		prevWord = Arrays.toString(letters);

		if (letterCorrect == false) {
			failCounter++;
			System.out.println("Failed:: " + failCounter + "/9 times");
		}
		boolean gOver = false;
		linesExist = false;

		/**
		 * DEBUG
		 * 
		 * System.out.println(check);
		 * System.out.println(Arrays.toString(letters));
		 * System.out.println(linesExist);
		 * 
		 * 
		 * Following lines determine whether there are underscores to be
		 * replaced or whether the failCounter has reached 9, which ends the
		 * game automatically
		 */

		String check = "_";
		for (int q = 0; q < word2B.length(); q++) {
			if (check.equals(letters[q])) {
				linesExist = true;
			}
		}
		System.out.println(linesExist);
		if (!linesExist) {
			wordGuessed = true;
			WinLoose.main();
			gOver = true;

		}
		if (failCounter >= 9) {
			wordGuessed = false;
			WinLoose.main();
			gOver = true;
		}

	}
}
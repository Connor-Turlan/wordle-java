import java.util.ArrayList;
import java.util.Scanner;

/* 
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";

public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; 
*/

public class Wordle {
	private String word;
	private ArrayList<String> guesses = new ArrayList<String>();

	// ANSI codes for green, yellow, red, and white squares.
	private static String sqr = "\u2588"; 
	private String gs = "\u001B[32m" + sqr + "\u001B[0m";
	private String ys = "\u001B[33m" + sqr + "\u001B[0m";
	private String rs = "\u001B[31m" + sqr + "\u001B[0m";
	private String ws = "\u001B[37m" + sqr + "\u001B[0m";

	private String correctString = gs+' '+gs+' '+gs+' '+gs+' '+gs+' ';
	private String blankLine = ws+' '+ws+' '+ws+' '+ws+' '+ws+' ';

	public Wordle() {
		word = Word.GetRandom();
	};

	public String Compare(String guess) {
		String compString = "";

		for (int i = 0; i < guess.length(); i++) {
			char c = guess.charAt(i);

			if (word.charAt(i) == c) {
				compString += gs + " ";
			} else if (word.indexOf(c) >= 0) {
				compString += ys + " ";
			} else {
				compString += rs + " ";
			}
		}
		return compString;
	};

	public boolean Guess() {
		Scanner s = new Scanner(System.in);
		String guess = s.next();

		while (guess.length() != 5) {
			System.out.println("Guess must be 5 letters long.");
			guess = s.next();
		}

		String difference = Compare(guess);
		guesses.add(guess + ": " + difference);

		System.out.println(difference);
		return difference.equals(correctString);
	};

	public void printGuesses(int round) {
		for (int i = 0; i < 6; i++) {
			if (i < guesses.size()) {
				System.out.println(guesses.get(i));
			} else {
				System.out.println(blankLine);
			} 
		}
	}

	public boolean Play() {
		for (int i = 0; i < 6; i++) {
			if (Guess()) { 
				printGuesses(i);
				return true; 
			}
		}
		printGuesses(6);
		System.out.println("The word was " + word);
		return false;
	};

	private void updateHistory(boolean isWin) {
		// write to the score history file the win and loss count.
	}

	private String readHistory() {
		// read from the score history file the win and loss count.
		return "test";
	}
}

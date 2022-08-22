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
	private String gs = "\u001B[32m\u2588\u001B[0m";
	private String ys = "\u001B[33m\u2588\u001B[0m";
	private String rs = "\u001B[31m\u2588\u001B[0m";
	private String correctString = gs + ' ' + gs + ' ' + gs + ' ' + gs + ' ' + gs + ' ';

	public Wordle() {
		word = Word.GetRandom();
		System.out.println(word);
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
			System.out.println("Guess must be 5 characters long.");
			guess = s.next();
		}

		String difference = Compare(guess);
		Boolean correct = difference.equals(correctString);
		System.out.println("Your guess was: " + difference);
		return correct;
	};

	public boolean Play() {
		for (int i = 0; i < 6; i++) {
			if (Guess()) { return true; }
		}
		return false;
	};
}

import java.io.Console;
import java.util.Scanner;

public class Wordle {
	private String word;

	public Wordle() {
		word = Word.GetRandom();
		System.out.println(word);
	};

	public Boolean Compare(String guess) {
		return word.equals(guess);
	};

	public boolean Guess() {
		Scanner s = new Scanner(System.in);
		String guess = s.next();
		Boolean correct = Compare(guess);
		System.out.println("Your guess was: " + (correct ? "Correct!" : "Incorrect."));
		return correct;
	};

	public boolean Play() {
		for (int i = 0; i < 5; i++) {
			if (Guess()) { return true; }
		}
		return false;
	};
}

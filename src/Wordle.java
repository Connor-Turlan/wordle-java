public class Wordle {
	private String word;

	public Wordle() {
		word = Word.GetRandom();
	};

	public String Compare() {return "00000";};

	public boolean Guess() {return false;};

	public boolean Play() {return false;};
}

public class Main {
	public static void main(String[] args) {
		System.out.println("Creating new game.");
		Wordle game = new Wordle();

		boolean win = game.Play();
		System.out.println(win ? "Congratulations! :D" : "Bad luck. :'(");
	}
}
import java.io.FileReader;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;

public class Word {
	private static String path = "src/resources/word-list.json";

	public static String GetRandom() {
		try {
			// parse the JSON file.
			Object obj = new JSONParser().parse(new FileReader(path));
			JSONArray words = (JSONArray)obj;

			// get a random word.
			Random random = new Random();
			return (String)words.get(random.nextInt(words.size()));
		}
		catch(Exception e) {
			// let the user know there was an error.
			System.out.println("error opening file.");
			return "";
		}
	}
}

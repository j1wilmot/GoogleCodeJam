package alien_language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import alien_language.AlienLanguage.PatternProcessor;

public class AlienLanguage_2 {

	public static void main(String... args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] params = reader.readLine().split(" ");
		int wordLength = Integer.parseInt(params[0]);
		int numWords = Integer.parseInt(params[1]);
		int numCases = Integer.parseInt(params[2]);

		List<String> knownWords = new ArrayList<String>(numWords);
		for (int i = 0; i < numWords; i++) {
			knownWords.add(reader.readLine());
		}

		for (int i = 0; i < numCases; i++) {
			PatternProcessor processor = new PatternProcessor(knownWords, wordLength);
			int answer = processor.processPattern(reader.readLine());
			System.out.print("Case #" + (i + 1) + ": " + answer + "\n");
		}
	}

	
}

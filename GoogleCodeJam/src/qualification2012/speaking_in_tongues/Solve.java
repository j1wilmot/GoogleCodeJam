package qualification2012.speaking_in_tongues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solve {

	private static Map<Character, Character> translationMap;

	protected static void init() {
		String outputString = "our language is impossible to understand\n" +
				"there are twenty six factorial possibilities\n" +
				"so it is okay if you want to just give up";

		String inputString = "ejp mysljylc kd kxveddknmc re jsicpdrysi\n" +
				"rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd\n" +
				"de kr kd eoya kw aej tysr re ujdr lkgc jv";

		translationMap = createTranslationMap(outputString, inputString);
	}

	public static void main(String... args) throws IOException {
		init();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int numLines = Integer.parseInt(line);
		for (int i = 0; i < numLines; i++) {
			line = reader.readLine();
			System.out.print("Case #" + (i + 1) + ": ");
			for (char c : line.toCharArray()) {
				Character translated = translationMap.get(c);
				if (translated ==  null)
					System.err.print(c);
				else
					System.out.write(translated);
			}
			System.out.println();
		}
	}
	
	public static Map<Character, Character> getTranslationMap() {
		return translationMap;
	}

	private static Map<Character, Character> createTranslationMap(
			String outputString, String inputString) {
		Map<Character, Character> translate = new HashMap<Character, Character>();

		char[] output = outputString.toCharArray();
		char[] input = inputString.toCharArray();
		
		for (int i = 0; i < outputString.length(); i++) {
			translate.put(input[i], output[i]);
		}

		// Mappings determined outside of sample paragraph
		translate.put('a', 'y');
		translate.put('z', 'q');
		translate.put('q', 'z');
		return translate;
	}
}

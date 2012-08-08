package allYourBase;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStreamReader;
=======
import java.io.FileReader;
import java.io.IOException;
>>>>>>> aea6743f03e1d008a18e9c98074ea64405f1f388
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllYourBase {

	// XXX needs some clean up
	public static void main(String... args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numLines = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= numLines; i++) {
			String line = reader.readLine();
			int numUniqueChars = numberOfUniqueChars(line);
			int base = numUniqueChars < 2 ? 2 : numUniqueChars;
			Map<Character, Integer> charMapping = new HashMap<Character, Integer>();
			
			// assign values inversely to digit
			// this will create smallest value
			final char[] characters = line.toCharArray();
			
			// 0 cannot be leading digit, hardcode cases for first 2 digits as 1 and 0
			final char firstChar = characters[0];
			charMapping.put(firstChar, 1);
			
			if (characters.length > 1) {
				// find character that is in next largest digit
				// position that is different than first character
				// and assign value of 0
				for (int j = 1; j < characters.length; j++) {
					char ch = characters[j];
					if (ch != firstChar) {
						charMapping.put(ch, 0);
						break;
					}
				}
				
				// 2 is next smallest number > 1
				int characterValue = 2;
				for (char c : characters) {
					if (!charMapping.containsKey(c)) {
						charMapping.put(c, characterValue);
						characterValue++;
					}
					if (characterValue >= base)
						break;
				}
			}
			Integer total = calculateTotal(base, charMapping, characters);
			System.out.println("Case #" + i + ": " + total);
		}
	}

	private static Integer calculateTotal(int base,
			Map<Character, Integer> charMapping, char[] characters) {
		// Calculate total
		StringBuilder builder = new StringBuilder();
		for (char c : characters) {
			int charValue = charMapping.get(c);
			builder.append(charValue);
		}
		return Integer.valueOf(builder.toString(), base);
	}

	private static int numberOfUniqueChars(String string) {
		Set<Character> uniqueChars = new HashSet<Character>();
		for (char c : string.toCharArray()) {
			uniqueChars.add(c);
		}
		return uniqueChars.size();
	}
}

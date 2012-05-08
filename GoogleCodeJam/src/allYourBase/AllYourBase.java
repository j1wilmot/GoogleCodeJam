package allYourBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllYourBase {

	public static void main(String... args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(args[0]));
			int numLines = Integer.parseInt(reader.readLine());
			for (int i = 0; i < numLines; i++) {
				String line = reader.readLine();
				
				
				int numUniqueChars = numberOfUniqueChars(line);
				
				int base = numUniqueChars < 2 ? 2 : numUniqueChars;
				Map<Character, Integer> charMapping = new HashMap<Character, Integer>();
				int currentNum = 0;
				// assign values inversely to digit
				// this will create smallest value
				for (char c : line.toCharArray()) {
					if (!charMapping.containsKey(c)) {
						charMapping.put(c, currentNum);
						base++;
					}
					if (currentNum >= base)
						break;
				}
				
				//swap 0 and 1, as numbers cannot start with 0
				for (Map.Entry<Character, Integer> entry : charMapping.entrySet()) {
					
				}
				
				
				System.out.print("");
				
				
			}
			
			
		} catch (IOException e) {
			// test
		} finally {
			if (reader != null) 
				try {
					reader.close();
				} catch (IOException e) {
					//test
				}
		}
		
		
	}
	
	private static int numberOfUniqueChars(String string) {
		Set<Character> uniqueChars = new HashSet<Character>();
		for (char c : string.toCharArray()) {
			uniqueChars.add(c);
		}
		return uniqueChars.size();
	}
}

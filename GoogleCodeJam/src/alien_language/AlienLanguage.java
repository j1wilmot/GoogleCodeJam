package alien_language;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AlienLanguage {

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
			PatternProcessor processor = new PatternProcessorImpl(knownWords, wordLength);
			int answer = processor.processPattern(reader.readLine());
			System.out.print("Case #" + (i + 1) + ": " + answer + "\n");
		}
	}

	interface PatternProcessor {
		int processPattern(String pattern);
	}
	
	
	static class PatternProcessorImpl implements PatternProcessor {
		List<String> knownWords;
		int wordLength;
		
		PatternProcessorImpl(List<String> knownWords, int wordLength) {
			this.knownWords = knownWords;
			this.wordLength = wordLength;
		}

		@Override
		public int processPattern(String pattern) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	/**
	 * An early, ill-considered, brute-force solution to the Alien language problem. We solve by trying to expand all patterns
	 * out fully, and then compare these expansions to the potential word list. This gets ugly for large patterns with many
	 * "expandables". We can just swap out the PatternProcessor for a different implementation.
	 */
	static class BruteForcePatternProcessor {
		List<String> knownWords;
		int wordLength;
		
		BruteForcePatternProcessor(List<String> knownWords, int wordLength) {
			this.knownWords = knownWords;
			this.wordLength = wordLength;
		}
		
		int processPattern(String pattern) {
			List<String> potentialWords = new ArrayList<String>();
			List<String> patterns = new ArrayList<String>();
			patterns.add(pattern);

			while (!patterns.isEmpty()) {
				expandFirstParens(patterns, potentialWords);
			}
			return numMatchedWords(potentialWords);
		}

		private void expandFirstParens(List<String> patterns, List<String> potentialWords) {
			List<String> subPatterns = new ArrayList<String>();
			for (Iterator<String> iter = patterns.iterator(); iter.hasNext(); ) {
				String unfinalizedWord = iter.next();
				if (!unfinalizedWord.contains("(")) {
					potentialWords.add(unfinalizedWord);
					iter.remove();
				} else {
					addPossibilities(unfinalizedWord, subPatterns);
					iter.remove();
				}
			}
			patterns.addAll(subPatterns);
		}

		private int numMatchedWords(List<String> potentialWords) {
			int totalPotentialWords = 0;
			for (String potentialWord : potentialWords) {
				if (knownWords.contains(potentialWord)) {
					totalPotentialWords++;
				}
			}
			return totalPotentialWords;
		}

		void addPossibilities(String unfinalizedWord, List<String> newWords) {
			int openParen = unfinalizedWord.indexOf('(');
			int closeParen = unfinalizedWord.indexOf(')');
			String inside = unfinalizedWord.substring(openParen + 1, closeParen);
			String before = unfinalizedWord.substring(0, openParen);
			String after = unfinalizedWord.substring(closeParen + 1, unfinalizedWord.length());
			for (char c : inside.toCharArray()) {
				newWords.add(before + c + after);
			}
		}
	}
}


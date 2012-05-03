package qualification2012.speaking_in_tongues;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class SolveTest {
	private String path = "src/qualification2012/speaking_in_tongues/";
	private String expectedOutputFilePath = path + "testOutput.txt";
	private String inputFilePath = path + "testInput.txt";
	
	private Map<Character, Character> translation;
	private List<Character> letters;
	
	@Before
	public void getTranslationMap() {
		Solve.init();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		letters = new ArrayList<Character>(alphabet.length);
		for (char c : alphabet) {
			letters.add(c);
		}
		translation = Solve.getTranslationMap();
	}
	
	@Test
	public void verifySampleInput() throws IOException {
		// Capture stdout of Solve
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Set up stdin for Solve
		System.setIn(new FileInputStream(inputFilePath));
		Solve.main();
		
		// Gather expected text
		BufferedReader reader = new BufferedReader(new FileReader(expectedOutputFilePath));
		StringBuilder expectedOutput = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			expectedOutput.append(line + "\n");
		}
		assertEquals(expectedOutput.toString(), baos.toString());
	}
	
	@Test
	public void allLettersAreMapped() {
		List<Character> missingLetters = new ArrayList<Character>();
		for (char c : letters) {
			if (!translation.containsKey(c))
				missingLetters.add(c);
		}
		assertTrue("Translation map should contain all letters as keys but is missing " + missingLetters, missingLetters.isEmpty());
	}
	
	@Test
	public void allLettersAreMappedTo() {
		List<Character> missingValues = new ArrayList<Character>();
		for (char c : letters) {
			if (!translation.containsValue(c))
				missingValues.add(c);
		}
		assertTrue("Translation map should contain all letters as values but is missing " + missingValues, missingValues.isEmpty());
	}
}

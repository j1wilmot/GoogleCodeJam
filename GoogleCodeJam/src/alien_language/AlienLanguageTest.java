package alien_language;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import rope_intranet.RopeIntranet;


public class AlienLanguageTest {

	private final static String INPUT_PATH = "src/alien_language/SampleInput.txt";
	private final static String OUTPUT_PATH = "src/alien_language/SampleOutput.txt";
	
	@Test
	public void testReadAndWrite() throws IOException {
		File input = new File(INPUT_PATH);
		System.setIn(new FileInputStream(input));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		AlienLanguage.main();
		
		File output = new File(OUTPUT_PATH);
		StringBuilder expected = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(output));
		String line;
		while ((line = reader.readLine()) != null)
			expected.append(line + "\n");
		String actual = baos.toString();
		assertEquals(expected.toString(), actual);
	}
	
}

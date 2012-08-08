package allYourBase;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class AllYourBaseTest {

	private File testIn = new File("src/allYourBase/test.in");
	private File testOut = new File("src/allYourBase/test.out");
	
	@Test
	public void test() throws IOException {
		// Set input and output streams
		System.setIn(new FileInputStream(testIn));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Run program
		AllYourBase.main();
		
		// Verify results
		String expected = getExpected();
		String actual = baos.toString();
		assertEquals(expected, actual);
	}

	private String getExpected() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(testOut));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line + "\n");
		}
		String expected = builder.toString();
		return expected;
	}

}

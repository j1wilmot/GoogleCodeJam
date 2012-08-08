package storeCredit;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class StoreCreditTest {

	private File file = new File("src/storeCredit/A-small-practice_Store_Credit.in");
	private File outFile = new File("src/storeCredit/A-small-practice_Store_Credit.out");
	
	@Test
	public void verifyProvidedSample() throws IOException {
		// Send sample data to Store Credit
		System.setIn(new FileInputStream(file));
		// Capture output from Store Credit
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		StoreCredit.main();
		String actual = baos.toString();
		String expected = determineExpected();
		assertEquals(expected, actual);
	}

	private String determineExpected() throws FileNotFoundException,
			IOException {
		FileReader reader = new FileReader(outFile);
		StringBuilder builder = new StringBuilder();
		int i;
		while ((i = reader.read()) != -1) {
			char c = (char) i;
			builder.append(c);
		}
		String expected = builder.toString();
		return expected;
	}

}

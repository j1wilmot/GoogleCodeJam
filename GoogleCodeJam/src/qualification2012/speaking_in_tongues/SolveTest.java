package qualification2012.speaking_in_tongues;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolveTest {
	
	private String expectedOutputFilePath = "src/qualification2012/speaking_in_tongues/testOutput.txt";
	
	@Test
	public void test() throws IOException {
		// Capture stdout from solve
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		StringBuilder expectedOutput = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(expectedOutputFilePath));
		String line;
		while ((line = reader.readLine()) != null) {
			expectedOutput.append(line + "\n");
		}
		
		
		Solve.main("");
		
		
		assertEquals(expectedOutput.toString(), baos.toString());
	}

}

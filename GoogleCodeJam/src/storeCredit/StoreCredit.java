package storeCredit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StoreCredit {
	
	/**
	 * Brute force approach to google code jam StoreCredit practice problem
	 * @param args
	 * @throws IOException
	 */
	// TODO we should read file from standard in and put output to stdout
	public static void main(String... args) throws IOException {
		File file = new File("/Users/jeremywilmot/Documents/workspace/GoogleCodeJame/src/storeCredit/A-small-practice_Store_Credit.in");
		File outFile = new File("/Users/jeremywilmot/Documents/workspace/GoogleCodeJame/src/storeCredit/A-small-practice_Store_Credit.out");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
		String line = reader.readLine();
		int numCases = Integer.parseInt(line);
		for (int caseNum = 1; caseNum <= numCases; caseNum++) {
			int total = Integer.parseInt(reader.readLine());
			int numCredits = Integer.parseInt(reader.readLine());
			String[] creditString = reader.readLine().split(" ");
			int[] credits = new int[creditString.length];
			for (int i = 0; i < creditString.length; i++) {
				credits[i] = Integer.parseInt(creditString[i]);
			}
			
			for (int i = 0; i < numCredits; i++) {
				for (int j = i+1; j < numCredits; j++) {
					if (credits[i] + credits[j] == total)
						writer.println("Case #" + caseNum + ": " + (i+1) + " " + (j+1) );
				}
			}
		}
		writer.close();
	}
}

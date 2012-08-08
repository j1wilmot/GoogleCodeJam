package storeCredit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StoreCredit {
	
	/**
	 * Brute force approach to google code jam StoreCredit practice problem
	 * @param args
	 * @throws IOException
	 */
	// TODO we should read file from standard in and put output to stdout
	public static void main(String... args) throws IOException {
		// Set up input and outputs
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		
		// First line holds number of cases in file
		int numCases = Integer.parseInt(reader.readLine());
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

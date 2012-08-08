package rotate;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolveTest {

	@Test
	public void rotate() {
		String board = "..\n" +
					   ".x";
		
		String rotated = "..\n" +
						 "x.";
		
		assertEquals(rotated, Solve.rotateClockwise(board));
	}

}

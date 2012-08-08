package rope_intranet;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import rope_intranet.RopeIntranet.Point;

public class RopeIntranetTest {

	@Test
	public void test() {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 10));
		points.add(new Point(5, 5));
	
		RopeIntranet test = new RopeIntranet(points);
		assertEquals(1, test.getNumIntersections());
	}
	
	@Test
	public void test2() {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 10));
		points.add(new Point(5, 5));
		points.add(new Point(2, 2));
	
		RopeIntranet test = new RopeIntranet(points);
		assertEquals(2, test.getNumIntersections());
	}
	
	@Test
	public void test3() {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(5, 6));
		points.add(new Point(3, 9));
		points.add(new Point(1, 7));
		
		RopeIntranet test = new RopeIntranet(points);
		assertEquals(2, test.getNumIntersections());
	}
	
	@Test
	public void test4() {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 5));
		points.add(new Point(2, 2));
		points.add(new Point(3, 3));
		points.add(new Point(4, 4));
		RopeIntranet test = new RopeIntranet(points);
		assertEquals(3, test.getNumIntersections());
	}
	
	@Test
	public void testReadAndWrite() throws IOException {
		File input = new File("src/rope_intranet/test.in");
		System.setIn(new FileInputStream(input));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		RopeIntranet.main();
		
		File output = new File("src/rope_intranet/test.out");
		StringBuilder expected = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(output));
		String line;
		while ((line = reader.readLine()) != null)
			expected.append(line + "\n");
		String actual = baos.toString();
		assertEquals(expected.toString(), actual);
	}
	

}

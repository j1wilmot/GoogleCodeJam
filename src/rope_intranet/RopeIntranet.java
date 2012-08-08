package rope_intranet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RopeIntranet {

	List<Point> points;
	List<Intersection> intersections;
	
	
	public RopeIntranet(List<Point> points) {
		this.points = points;
		intersections = new ArrayList<Intersection>();
	}

	public int getNumIntersections() {
		for (int i = 0; i < points.size(); i++) {
			Point point1 = points.get(i);
			for (int j = 1; j < points.size(); j++) {
				Point point2 = points.get(j);
				if ((point1.x < point2.x && point1.y > point2.y) ||
						(point1.x > point2.x && point1.y < point2.y))
					intersections.add(new Intersection(point1, point2));
			}
		}
		return intersections.size();
	}

	public static void main(String... args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Integer numCases = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= numCases; i++) {
			List<Point> points = new ArrayList<Point>();
			Integer numPoints = Integer.parseInt(reader.readLine());
			for (int j = 0; j < numPoints; j++) {
				String[] pointLocs = reader.readLine().split(" ");
				int loc1 = Integer.parseInt(pointLocs[0]);
				int loc2 = Integer.parseInt(pointLocs[1]);
				Point p1 = new Point(loc1, loc2);
				points.add(p1);
			}
			RopeIntranet ri = new RopeIntranet(points);
			System.out.println("Case #" + i + ": " + ri.getNumIntersections());
		}
	}
	
	
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static class Intersection {
		Point a;
		Point b;
		
		Intersection(Point a, Point b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Intersection))
				return false;
			Intersection i = (Intersection) o;
			return i.a.equals(a) && i.b.equals(b);
		}
		
		@Override
		public int hashCode() {
			return a.hashCode() + b.hashCode();
		}
	}
	
}

public class BruteForce {
	public static void main(String[] args) {
		Graph g = new Graph(20000);
		g.graphPoints();
		
		long startTime = System.currentTimeMillis();
		Line[] xLines = g.getXLines();
		Line[] yLines = g.getYLines();
		int counter = 0;
		Line x = new Line();
		Line y = new Line();
		for (int i = 0; i < xLines.length; i++) {
			x = xLines[i];
			for (int j = 0; j < yLines.length; j++) {
				y = yLines[j];
				// Make sure Y's single x-value is between X's x-values
				if (x.getFirstPoint().getX() <= y.getFirstPoint().getX()
						&& x.getSecondPoint().getX() >= y.getFirstPoint()
								.getX()) {
					// Make sure X's single y-value is between Y's y-values
					if (y.getFirstPoint().getY() <= x.getFirstPoint().getY()
							&& y.getSecondPoint().getY() >= x.getFirstPoint()
									.getY()) {
						//System.out.println("Intersection @ (" + x.getFirstPoint().getY() + ", " + y.getFirstPoint().getX() + ")");
						counter++;
					}
				}
			}
		}
		System.out.println("Number of intersections: " + counter);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
	}
}
import java.util.*;

public class Graph {
	private int NUM_LINES;
	private int MAX_VALUE = 100000;
	private int LINE_LENGTH = 100;

	private Point[] allPoints;
	private Line[] xLines;
	private Line[] yLines;

	public Graph(int n) {
		this.NUM_LINES = n;
		this.allPoints = new Point[this.NUM_LINES * 3];
		this.xLines = new Line[this.NUM_LINES];
		this.yLines = new Line[this.NUM_LINES];
	}

	public void randomXCoordinates() {
		Point left_point;
		Point right_point;
		Random rand = new Random();
		for (int i = 0; i < this.NUM_LINES * 2; i += 2) {
			int rand_left_x = rand.nextInt(this.MAX_VALUE + 1);
			int rand_left_y = rand.nextInt(this.MAX_VALUE + 1);

			left_point = new Point(rand_left_x, rand_left_y);
			right_point = new Point(rand_left_x + LINE_LENGTH, rand_left_y);
			left_point.setPartner(right_point);
			right_point.setPartner(left_point);
            allPoints[i] = left_point;
			allPoints[i + 1] = right_point;
			// System.out.print("{"+left_point.toString()+" ,"+right_point.toString()+"}");

			xLines[i / 2] = new Line(left_point, right_point);
		}
	}

	public void randomYCoordinates() {
		Point point;
		Random rand = new Random();
		for (int i = this.NUM_LINES * 2; i < this.NUM_LINES * 3; i++) {
			int rand_bottom_x = rand.nextInt(this.MAX_VALUE + 1);
			int rand_bottom_y = rand.nextInt(this.MAX_VALUE + 1);

			point = new Point(rand_bottom_x, rand_bottom_y, rand_bottom_y
					+ LINE_LENGTH);
			allPoints[i] = point;
			// System.out.print("{"+point.toString()+"}");

			yLines[i - this.NUM_LINES * 2] = new Line(new Point(rand_bottom_x,
					rand_bottom_y), new Point(rand_bottom_x, rand_bottom_y
					+ LINE_LENGTH));
		}
	}

	public void graphPoints() {
		randomYCoordinates();
		randomXCoordinates();
	}

	public Point[] getAllPoints() {
		return this.allPoints;
	}

	public Line[] getXLines() {
		return this.xLines;
	}

	public Line[] getYLines() {
		return this.yLines;
	}
}

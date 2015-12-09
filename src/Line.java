public class Line {
	// Left point for x lines and bottom point for Y lines
	private Point firstPoint;
	// Right point for x lines and top point for Y lines
	private Point secondPoint;

	public Line(Point left, Point right) {
		this.firstPoint = left;
		this.secondPoint = right;
	}

	public Line() {
		this.firstPoint = new Point(0, 0);
		this.secondPoint = new Point(0, 0);
	}

	@Override
	public String toString() {
		return "{(" + this.firstPoint.getX() + ", " + firstPoint.getY() + ") ("
				+ secondPoint.getX() + ", " + secondPoint.getY() + ")}";
	}

	public Point getFirstPoint() {
		return this.firstPoint;
	}

	public Point getSecondPoint() {
		return this.secondPoint;
	}

}

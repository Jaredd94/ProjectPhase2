
public class Main {

	static Point point;
	static Point point2;
	static Graph graph;
	
	public static void main(String[] args){
		point = new Point(1, 2, 3);
		point2 = new Point(1, 4);
		
		// printing of a vertical line segment
		System.out.println(point.toString());
		
		// printing of a horizontal line segment
		System.out.println(point2.toString());
		
		// checking to see if line is vertical or not
		System.out.println(point.isY());
		
		// test graph created
		graph=new Graph(10);
		
		// prints out vertical line segment array and horizontal array
		graph.graphPoints();
	}
}
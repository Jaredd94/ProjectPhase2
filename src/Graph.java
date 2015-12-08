import java.util.*;

public class Graph {
	
	int NUM_LINES;
	int MAX_VALUE = 1000000;
	
	Point[] xPoints;
	Point[] yPoints;
	
	public Graph(int n){
		this.NUM_LINES = n;
		this.xPoints = new Point[this.NUM_LINES*2];
		this.yPoints = new Point[this.NUM_LINES];
	}
	
	public void randomXCoordinates(){
		Point left_point;
		Point right_point;
		Random rand = new Random();
		for (int i = 0; i < this.NUM_LINES*2; i+=2){
			int rand_left_x = rand.nextInt(this.MAX_VALUE+1);
			int rand_left_y = rand.nextInt(this.MAX_VALUE+1);
			
			left_point = new Point(rand_left_x, rand_left_y);
			xPoints[i] = left_point;
			right_point = new Point(rand_left_x+25, rand_left_y);
			xPoints[i+1] = right_point;
			System.out.print("{"+left_point.toString()+" ,"+right_point.toString()+"}");
		}
	}
	
	public void randomYCoordinates(){
		Point point;
		Random rand = new Random();
		for (int i = 0; i < this.NUM_LINES; i++){
			int rand_bottom_x = rand.nextInt(this.MAX_VALUE+1);
			int rand_bottom_y = rand.nextInt(this.MAX_VALUE+1);
			
			point = new Point(rand_bottom_x, rand_bottom_y, rand_bottom_y+25);
			yPoints[i] = point;
			System.out.print("{"+point.toString()+"}");
		}
	}
	
	public void graphPoints(){
		randomYCoordinates();
		System.out.println();
		randomXCoordinates();
	}
	
	public Point[] getYPoints(){
		return this.yPoints;
	}
	
	public Point[] getXPoints(){
		return this.getXPoints();
	}
}

import java.util.*;

public class Graph {
	
	private int NUM_LINES;
	private int MAX_VALUE = 1000000;
	
	private Point[] allPoints;
	
	public Graph(int n){
		this.NUM_LINES = n;
		this.allPoints = new Point[this.NUM_LINES*3];
	}
	
	public void randomXCoordinates(){
		Point left_point;
		Point right_point;
		Random rand = new Random();
		for (int i = 0; i < this.NUM_LINES*2; i+=2){
			int rand_left_x = rand.nextInt(this.MAX_VALUE+1);
			int rand_left_y = rand.nextInt(this.MAX_VALUE+1);
			
			left_point = new Point(rand_left_x, rand_left_y);
			left_point.setLeftPoint();
			allPoints[i] = left_point;
			
			right_point = new Point(rand_left_x+25, rand_left_y);
			right_point.setRightPoint();
			allPoints[i+1] = right_point;
			//System.out.print("{"+left_point.toString()+" ,"+right_point.toString()+"}");
		}
	}
	
	public void randomYCoordinates(){
		Point point;
		Random rand = new Random();
		for (int i = this.NUM_LINES*2; i < this.NUM_LINES*3; i++){
			int rand_bottom_x = rand.nextInt(this.MAX_VALUE+1);
			int rand_bottom_y = rand.nextInt(this.MAX_VALUE+1);
			
			point = new Point(rand_bottom_x, rand_bottom_y, rand_bottom_y+25);
			allPoints[i] = point;
			//System.out.print("{"+point.toString()+"}");
		}
	}
	
	public void graphPoints(){
		randomYCoordinates();
		randomXCoordinates();
	}
	
	public Point[] getAllPoints(){
		return this.allPoints;
	}
}

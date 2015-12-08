
public class Point {
	int xCord;
	int yCord;
	int y2Cord;
	
	public Point(int x, int y){
		this.xCord = x;
		this.yCord = y;
		this.y2Cord = -1;
	}
	
	public Point(int x, int y, int y2){
		this.xCord = x;
		this.yCord = y;
		this.y2Cord = y2;
	}
	
	public boolean isY(){
		return (this.y2Cord != -1);
	}
	
	public int getX(){
		return this.xCord;
	}
	
	public int getY(){
		return this.yCord;
	}
	
	public int getY2(){
		return this.y2Cord;
	}
	
	public void setX(int x){
		this.xCord = x;
	}
	
	public void setY(int y){
		this.yCord = y;
	}
	
	
	public void setY2(int y2){
		this.y2Cord = y2;
	}
	
	
	public String toString(){
		if (this.isY()){
			return "("+this.getX()+", "+this.getY()+", "+this.getY2()+")";
		}
		else{
			return "("+this.getX()+", "+this.getY()+")";
		}
	}
}

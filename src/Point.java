
public class Point {
	private int xCord;
	private int yCord;
	private int y2Cord;
	
	private boolean isLeft = false;
	private boolean isRight = false;
	
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
	
	public void setLeftPoint()
	{
		this.isLeft = true;
	}
	
	public void setRightPoint(){
		this.isRight = true;
	}
	
	public boolean isLeft()
	{
		return this.isLeft;
	}
	
	public boolean isRight()
	{
		return this.isRight;
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


public class Point {
    private int xCord;
    private int yCord;
    private int y2Cord;

    private Point partner;

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

    public boolean isLeft()
    {
        if (this.isY())
            return false;
        else
            return (this.getX() < this.getPartner().getX());
    }

    public boolean isRight()
    {
        if (this.isY())
            return false;
        else
            return (this.getX() > this.getPartner().getX());
    }

    public void setPartner(Point p)
    {
        this.partner = p;
    }

    public Point getPartner()
    {
        return this.partner;
    }

    @Override
    public String toString(){
        if (this.isY()){
            return "("+this.getX()+", "+this.getY()+", "+this.getY2()+")";
        }
        else{
            return "("+this.getX()+", "+this.getY()+")";
        }
    }

    @Override
    public boolean equals(Object v) {
        boolean retVal = false;
        if (v instanceof Point){
            retVal = (((Point) v).getX() == this.getX()) &&
                (((Point) v).getY() == this.getY()) &&
                (((Point) v).getY2() == this.getY2());
        }
        return retVal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.getX() + this.getY() + this.getY2();
        return hash;
    }
}

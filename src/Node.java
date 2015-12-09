/**
 * // -------------------------------------------------------------------------
 *  Node for the BST
 *
 *  @author Kevin Buchiane
 *  @version Dec 8, 2015
 */
public class Node
{
    private int key;
    private Point point;

	Node leftChild;
    Node rightChild;

    /**
     * Constructor.
     */
    public Node(int k, Point p)
    {
        key = k;
        point = p;
    }
    
    
    public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}

/**
 * // -------------------------------------------------------------------------
 *  Node for the BST
 *
 *  @author Kevin Buchiane
 *  @version Dec 8, 2015
 */
public class Node
{
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    /**
     * Constructor.
     */
    public Node(int k, String n)
    {
        key = k;
        name = n;
    }

    /**
     * Return the node description as a String.
     */
    public String toString()
    {
        return "Node " + name + "'s key is " + key;
    }
}

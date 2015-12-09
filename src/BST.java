/**
 *  A Binary Search Tree
 *
 *  @author Kevin Buchiane
 *  @version Dec 8, 2015
 */
public class BST
{
    Node root;

    /**
     * Add a node to the BST.
     */
    public void addNode(int key, Point point)
    {
        Node newNode = new Node(key, point);

        if (root == null)
        {
            root = newNode;
        }
        else
        {
            Node currentNode = root;
            Node parent;

            while (true)
            {
                parent = currentNode;
                if (key < currentNode.getKey())
                {
                    currentNode = currentNode.leftChild;

                    if (currentNode == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    currentNode = currentNode.rightChild;

                    if (currentNode == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


    /**
     * Print the tree using in order traversal.
     */
    public void inOrderTraverse(Node currentNode)
    {
        if (currentNode != null)
        {
            inOrderTraverse(currentNode.leftChild);

            System.out.println(currentNode);

            inOrderTraverse(currentNode.rightChild);
        }
    }


    /**
     * Print the tree using preorder traversal.
     */
    public void preOrderTraverse(Node currentNode)
    {
        if (currentNode != null)
        {
            System.out.println(currentNode);

            preOrderTraverse(currentNode.leftChild);

            preOrderTraverse(currentNode.rightChild);
        }
    }


    /**
     * Print the tree using postorder traversal.
     */
    public void postOrderTraverse(Node currentNode)
    {
        if (currentNode != null)
        {
            postOrderTraverse(currentNode.leftChild);

            postOrderTraverse(currentNode.rightChild);

            System.out.println(currentNode);
        }
    }


    public Node findRange(int min, int max){
    	Node currentNode = root;
    	
    	if (currentNode == null){
    		return null;
    	}
    	
        while (currentNode.getKey() > max || currentNode.getKey() < min)
        {
            if (currentNode.getKey() > max)
            {
                currentNode = currentNode.leftChild;
            }
            else
            {
                currentNode = currentNode.rightChild;
            }

            if (currentNode == null)
            {
                return null;
            }
        }

        return currentNode;
    }
    
    
    /**
     * Find a specific node.
     */
    public Node findNode(int key)
    {
        Node currentNode = root;

        while (currentNode.getKey() != key)
        {
            if (key < currentNode.getKey())
            {
                currentNode = currentNode.leftChild;
            }
            else
            {
                currentNode = currentNode.rightChild;
            }

            if (currentNode == null)
            {
                return null;
            }
        }

        return currentNode;
    }


    /**
     * Will delete a specific node from the BST.
     */
    public boolean delete(int key)
    {
        Node currentNode = root;
        Node parent = root;
        
        if (currentNode == null){
        	return false;
        }
        
        boolean isLeftChild = true;

        while (currentNode.getKey() != key)
        {
            parent = currentNode;

            if (key < currentNode.getKey())
            {
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            }
            else
            {
                isLeftChild = false;
                currentNode = currentNode.rightChild;
            }

            if (currentNode == null)
            {
                return false;
            }
        }

        if (currentNode.leftChild == null && currentNode.rightChild == null)
        {
            if (currentNode == root)
            {
                root = null;
            }
            else if (isLeftChild)
            {
                parent.leftChild = null;
            }
            else
            {
                parent.rightChild = null;
            }
        }
        else if (currentNode.rightChild == null)
        {
            if (currentNode == root)
            {
                root = currentNode.leftChild;
            }
            else if (isLeftChild)
            {
                parent.leftChild = currentNode.leftChild;
            }
            else
            {
                parent.rightChild = currentNode.leftChild;
            }
        }
        else if (currentNode.leftChild == null)
        {
            if (currentNode == root)
            {
                root = currentNode.rightChild;
            }
            else if (isLeftChild)
            {
                parent.leftChild = currentNode.rightChild;
            }
            else
            {
                parent.rightChild = currentNode.leftChild;
            }
        }
        else
        {
            Node shiftNode = getShiftingNode(currentNode);

            if (currentNode == root)
            {
                root = shiftNode;
            }
            else if (isLeftChild)
            {
                parent.leftChild = shiftNode;
            }
            else
            {
                parent.rightChild = shiftNode;
            }

            shiftNode.leftChild = currentNode.leftChild;
        }

        return true;
    }


    /**
     * Find the node that will replace the node to be deleted.
     */
    public Node getShiftingNode(Node deletedNode)
    {
        Node deleteNodeParent = deletedNode;
        Node shiftNode = deletedNode;

        Node currentNode = deletedNode.rightChild;

        while (currentNode != null)
        {
            deleteNodeParent = shiftNode;
            shiftNode = currentNode;
            currentNode = currentNode.leftChild;
        }

        if (shiftNode != deletedNode.rightChild)
        {
            deleteNodeParent.leftChild = shiftNode.rightChild;
            shiftNode.rightChild = deletedNode.rightChild;
        }

        return shiftNode;
    }
}

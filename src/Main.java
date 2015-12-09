import java.util.ArrayList;

public class Main
{
    static Point[] sortedPoints;
    static Graph graph;
    static BST tree;

    public static void main(String[] args)
    {
        // test graph created
        graph = new Graph(20000);

        // prints out vertical line segment array and horizontal array
        graph.graphPoints();

        // initialize empty sorted list
        sortedPoints = graph.getAllPoints();
        sort(sortedPoints, 0, sortedPoints.length);
        //printList();
        tree = new BST();
        algorithm(sortedPoints);
    }

    public static void algorithm(Point[] list)
    {
        int counter = 0;
        int loopIter = 0;
        for (Point curr : list)
        {
            // if left end point
            if (curr.isLeft())
            {
                tree.addNode(curr.getY(), curr);
            }
            // if right end point
            else if (curr.isRight())
            {
                // We are removing a horizontal line. Check for vertical lines at the same point
                if (loopIter + 1 < list.length && list[loopIter + 1] != null)
                {
                    int tmpIter = loopIter;
                    Point next = list[tmpIter + 1];
                    while (next.getX() == curr.getX())
                    {
                        if (next.isY())
                        {
                            int yMin = next.getY();
                            int yMax = next.getY2();
                            if (curr.getY() >= yMin && curr.getY() <= yMax)
                            {
                                Point intersection =
                                    new Point(next.getX(), curr.getY());
                                counter++;
                                System.out.println("Found an interection: "
                                    + intersection.toString() + " \n");
                            }
                        }
                        tmpIter++;
                        if (tmpIter + 1 < list.length
                            && list[tmpIter + 1] != null)
                        {
                            next = list[tmpIter + 1];
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                Node n = tree.delete(curr.getY());
                ArrayList<Point> wronglyRemoved = new ArrayList<Point>();
                while (!(n.getPoint().equals(curr.getPartner()))) {
                    wronglyRemoved.add(n.getPoint());
                    n = tree.delete(curr.getY());
                }
                for (Point p: wronglyRemoved) {
                    tree.addNode(p.getY(), p);
                }
            }
            // if vertical segment
            else
            {
                int yMin = curr.getY();
                int yMax = curr.getY2();
                ArrayList<Node> foundNodes =
                    tree.rangeSearchTree(
                        tree.root,
                        yMin,
                        yMax,
                        new ArrayList<Node>());
                if (foundNodes != null)
                {
                    for (Node found : foundNodes)
                    {
                        // in order to computer the intersection
                        Point xH = found.getPoint();
                        Point intersection = new Point(curr.getX(), xH.getY());
                        counter++;
                        System.out.println("Found an intersection: "
                            + intersection.toString() + " \n");
                    }
                }
            }
            loopIter++;
        }
        System.out.println("Number of intersections is " + counter);
    }


    /* Merge Sort function */
    public static void sort(Point[] a, int low, int high)
    {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N / 2;
        // recursively sort
        sort(a, low, mid);
        sort(a, mid, high);
        // merge two sorted subarrays
        Point[] temp = new Point[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++)
        {
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[j].getX() < a[i].getX())
                temp[k] = a[j++];
            else if (a[j].getX() == a[i].getX())
            {
                // In the instance of equal x values, give horizontal lines precedence
                if (a[j].isY())
                    temp[k] = a[i++];
                else if (a[i].isY())
                    temp[k] = a[j++];
                else if (a[j].getY() < a[i].getY())
                    temp[k] = a[j++];
                else
                    temp[k] = a[i++];
            }
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[low + k] = temp[k];
    }


    public static void printList()
    {
        for (int i = 0; i < sortedPoints.length; i++)
        {
            System.out.println(sortedPoints[i].toString());
        }
    }
}

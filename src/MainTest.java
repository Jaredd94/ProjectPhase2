import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class MainTest
{
    private BST tree;
    private Point[] points;

    /**
     * Set up for testing.
     */
    @Before
    public void setUp()
    {
        tree = new BST();
    }


    /**
     * Test
     */
    @Test
    public void testAlgo1()
    {
        points = new Point[11];
        Main.tree = tree;

        Point point1 = new Point(2, 6, 14);

        Point point2 = new Point(8, 2, 12);

        Point point3 = new Point(2, 8);
        Point point4 = new Point(4, 8);
        point3.setPartner(point4);
        point4.setPartner(point3);

        Point point5 = new Point(8, 8, 16);

        Point point6 = new Point(4, 10);
        Point point7 = new Point(14, 10);
        point7.setPartner(point6);
        point6.setPartner(point7);

        Point point8 = new Point(6, 14);
        Point point9 = new Point(12, 14);
        point8.setPartner(point9);
        point9.setPartner(point8);

        Point point10 = new Point(4, 3);
        Point point11 = new Point(8, 3);
        point10.setPartner(point11);
        point11.setPartner(point10);

        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
        points[3] = point4;
        points[4] = point5;
        points[5] = point6;
        points[6] = point7;
        points[7] = point8;
        points[8] = point9;
        points[9] = point10;
        points[10] = point11;

        Main.sort(points, 0, points.length);

        //Testing sorting
        Point[] expectedSort = new Point[points.length];
        expectedSort[0] = point3;
        expectedSort[1] = point1;
        expectedSort[2] = point10;
        expectedSort[3] = point4;
        expectedSort[4] = point6;
        expectedSort[5] = point8;
        expectedSort[6] = point11;
        expectedSort[7] = point2;
        expectedSort[8] = point5;
        expectedSort[9] = point9;
        expectedSort[10] = point7;
        for (int i = 0; i < expectedSort.length; i++) {
            if (points[i] == null) {
                break;
            }
            assertEquals(expectedSort[i], points[i]);
        }

        Main.algorithm(points);
    }


    /**
     * Test
     */
    @Test
    public void testAddDeleteBST() {
        Point point1 = new Point(1, 3);
        Point point2 = new Point(12, 3);
        tree.addNode(3, point1);
        tree.addNode(3, point2);
        Point point3 = new Point(4, 3);
        Point point4 = new Point(8, 3);
        tree.addNode(3, point3);
        tree.addNode(3, point4);

        tree.delete(8);
        System.out.println("poop");
    }
    /**
     * Test
     */
    @Test
    public void testRangeSearch() {
        BST tmpTree = new BST();

        Point point3 = new Point(2, 8);
        Point point4 = new Point(4, 8);
        point4.setPartner(point3);
        point3.setPartner(point4);

        tmpTree.addNode(point3.getY(), point3);
        tmpTree.addNode(point4.getY(), point4);

        Point point6 = new Point(4, 10);
        Point point7 = new Point(14, 10);
        point7.setPartner(point6);
        point6.setPartner(point7);

        tmpTree.addNode(point6.getY(), point6);
        tmpTree.addNode(point7.getY(), point7);

        ArrayList<Node> returnedList = tmpTree.rangeSearchTree(tmpTree.root, 2, 14, new ArrayList<Node>());
        ArrayList<Node> expectedSearch = new ArrayList<Node>();
        expectedSearch.add(new Node(8, point3));
        expectedSearch.add(new Node(8, point4));
        expectedSearch.add(new Node(10, point6));
        expectedSearch.add(new Node(10, point7));

        for (int i = 0; i < expectedSearch.size(); i++) {
            assertEquals(expectedSearch.get(i).getPoint(), returnedList.get(i).getPoint());
        }
    }

}

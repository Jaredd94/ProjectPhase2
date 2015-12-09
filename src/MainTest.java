import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
        points = new Point[7];
        Main.tree = tree;

        Point point1 = new Point(2, 6, 14);

        Point point2 = new Point(8, 2, 12);

        Point point3 = new Point(2, 8);
        point3.setLeftPoint();

        Point point4 = new Point(4, 8);
        point4.setRightPoint();

        Point point5 = new Point(8, 8, 16);

        Point point6 = new Point(4, 10);
        point6.setLeftPoint();

        Point point7 = new Point(14, 10);
        point7.setRightPoint();

        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
        points[3] = point4;
        points[4] = point5;
        points[5] = point6;
        points[6] = point7;


        Main.sort(points, 0, points.length);

        Main.algorithm(points);
    }

}

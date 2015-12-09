package bin;

import Node;
import java.util.ArrayList;

public class Temporary
{
//  Line testLineX = new Line(new Point(0, 0), new Point(4, 0));
//
//  Line testLineY = new Line(new Point(2, -4), new Point(2, 3));
//
//  if (testLineX.getFirstPoint().getX() <= testLineY.getFirstPoint().getX()
//      && testLineX.getSecondPoint().getX() >= testLineY.getFirstPoint().getX()) {
//  //Make sure X's y-value is between Y's y-values
//      if (testLineY.getFirstPoint().getY() <= testLineX.getFirstPoint().getY()
//          && testLineY.getSecondPoint().getY() >= testLineX.getFirstPoint().getY()) {
//          System.out.println("Intersection @ lines x: " + testLineX + " and y: " + testLineY);
//      }
//  }



    //                // if found is not null then there is an intersection
    //                while (found != null) {
    //                    // in order to computer the intersection
    //                    Point xH = found.getPoint();
    //                    Point intersection = new Point(curr.getX(), xH.getY());
    //                    System.out.println("Found an interection: "+intersection.toString()+" \n");
    //                    counter++;
    //
    //                    // check to see if there are any other intersections
    //                    tempTree.delete(xH.getY());
    //                    found = tempTree.findRange(yMin, yMax);
    //                }


    ArrayList<Node> tmp = rangeSearchTree(rightChild, lower, upper, found);
//  if (tmp != null && !tmp.isEmpty()) {
//      ret.addAll(tmp);
//  }
}

public class Main {

	static Point[] sortedPoints;
	static Graph graph;
	static BST tree;

	public static void main(String[] args) {

		// test graph created
		graph = new Graph(20000);

		// prints out vertical line segment array and horizontal array
		graph.graphPoints();

		// initialize empty sorted list
		sortedPoints = graph.getAllPoints();
		sort(sortedPoints,0,sortedPoints.length);
		printList();
		tree = new BST();
		algorithm(sortedPoints);
	}
	
	public static void algorithm(Point[] list){
		int counter = 0;
		for (Point curr: list) {
			// if left end point
			if (curr.isLeft()){
				tree.addNode(curr.getY(), curr);
			}
			// if right end point
			else if (curr.isRight()){
				tree.delete(curr.getY());
			}
			// if vertical segment
			else {
				int yMin = curr.getY();
				int yMax = curr.getY2();
				
				BST tempTree = tree;
				Node found = tempTree.findRange(yMin, yMax);
				// if found is not null then there is an intersection
				while (found != null) {
					// in order to computer the intersection
					Point xH = found.getPoint();
					Point intersection = new Point(xH.getX()+curr.getX(), xH.getY());
					System.out.println("Found an interection: "+intersection.toString()+" \n");
					counter++;
					
					// check to see if there are any other intersections
					tempTree.delete(xH.getY());
					found = tempTree.findRange(yMin, yMax);
				}
			}
		}
		System.out.println("Number of intersections is " + counter);
	}

	/* Merge Sort function */
	public static void sort(Point[] a, int low, int high) {
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
		for (int k = 0; k < N; k++) {
			if (i == mid)
				temp[k] = a[j++];
			else if (j == high)
				temp[k] = a[i++];
			else if (a[j].getX() < a[i].getX())
				temp[k] = a[j++];
			else
				temp[k] = a[i++];
		}
		for (int k = 0; k < N; k++)
			a[low + k] = temp[k];
	}
	
	public static void printList(){
		for (int i = 0; i < sortedPoints.length; i++){
			System.out.println(sortedPoints[i].toString());
		}
	}
}
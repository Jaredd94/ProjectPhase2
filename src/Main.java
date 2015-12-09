public class Main {

	static Point[] sortedPoints;
	static Graph graph;

	public static void main(String[] args) {

		// test graph created
		graph = new Graph(10);

		// prints out vertical line segment array and horizontal array
		graph.graphPoints();

		// initialize empty sorted list
		sortedPoints = graph.getAllPoints();
		sort(sortedPoints,0,sortedPoints.length);
		printList();
		
		
		
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
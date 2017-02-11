import java.util.*;
import java.io.*;
import java.util.Scanner;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 * Add your name here: 
 */
public class MyGraph {
	private ArrayList<Vertex> vertices;

	/**
	 *
	 * @param vertexFileName
	 * @return
	 */
   	public static Collection<Vertex> loadVertices(String vertexFileName) {
   		ArrayList<Vertex> vertexList = new ArrayList<>();

		try {
			Scanner sc = new Scanner(new File(vertexFileName));
			String start;
			while (sc.hasNextLine()) {
				start = sc.nextLine();
				vertexList.add(new Vertex(start));
			}
		} catch (FileNotFoundException err) {
			System.out.println("Error in loadVertices()\n" + err);
		}
        return vertexList;
   	}

   	public static Collection<Edge> loadEdges(Edge edgeFileName) {
        ArrayList <Edge> edge = new ArrayList<>();
        // Your code here          
        return edge;   
   	}
      
   	public static void displayVertices(Collection<Vertex> vertex) {
   	    // YOUR CODE HERE               
        return;			   
   	}
         
   	public static void displayEdges(Collection<Edge> edge) {
		// YOUR CODE HERE                 
        return;   
   	}

   	public static void displayGraph(Collection<Vertex> vertex, Collection<Edge> edge) {
		// YOUR CODE HERE                 
        return;
   	}

	//NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
	public static Collection<Vertex> findAdjacentVertices(String vertex) {
        // YOUR CODE HERE
//        return adjVertices;
		return null;
   	}

	//NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
	public static boolean checkIsAdjacent(String startVertex, String endVertex) {
   		/*
   		Just look at this bs. checkIsAdjacent returns an integer array? What the fuck?
   		It's 180%, absolutely, without a doubt, should be a boolean return.
   		 */
//   	public static int[] checkIsAdjacent(String startVertex, String endVertex) {
//		int [] value = {-1, 0};
//        return value;
		return false;
   	}

   	//NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
   	public static int findShortestRoute(String startVertex, String endVertex, List<String> route) {
   	    // YOUR CODE HERE
          return 0;   
   	}

   	//NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
   	public static int findCheapestRoute(String startVertex, String endVertex, List<String> route) {
   	    // YOUR CODE HERE
          return 0;   
   	}

   	//NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
   	public static int findFastestRoute(String startVertex, String endVertex, List<String> route) {
   	    // YOUR CODE HERE
        return 0;   
   	}
}
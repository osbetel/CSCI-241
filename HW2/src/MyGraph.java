import java.util.*;
import java.io.*;
import java.util.Scanner;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 * Add your name here: 
 */
public class MyGraph {
	private ArrayList vertices;
	private ArrayList edges;

	/**
	 *
	 * @param vertexFileName
	 * @return
	 */
   	public static Collection<String> loadVertices(String vertexFileName) {
   		ArrayList <String> vertices = new ArrayList<String>();
		// Your code here
        return vertices;   
   	}

   	public static Collection<String> loadEdges(String edgeFileName) {
        ArrayList <String> edge = new ArrayList<String>();
        // Your code here          
        return edge;   
   	}
      
   	public static void displayVertices(Collection<String> vertex) {
   	    // YOUR CODE HERE               
        return;			   
   	}
         
   	public static void displayEdges(Collection<String> edge) {
		// YOUR CODE HERE                 
        return;   
   	}

   	public static void displayGraph(Collection<String> vertex, Collection<String> edge) {
		// YOUR CODE HERE                 
        return;   
   	}

         
   	public static Collection<String> findAdjacentVertices(String vertex) {
        // YOUR CODE HERE
//        return adjVertices;
		return null;
   	}
         	 
   	public static int[] checkIsAdjacent(String a, String b) {
		int [] value = {-1, 0};
		// YOUR CODE HERE
        return value;   
   	}
   
   	public static int findShortestRoute(String start_point, String end_point, List<String> route) {
   	    // YOUR CODE HERE
          return 0;   
   	}
      
      
   	public static int findCheapestRoute(String start_point, String end_point, List<String> route) {
   	    // YOUR CODE HERE
          return 0;   
   	}
      
   	public static int findFastestRoute(String start_point, String end_point, List<String> route) {
   	    // YOUR CODE HERE
        return 0;   
   	}
}
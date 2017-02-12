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

	public MyGraph(String vertexFileName, String edgeFileName) {
		vertices = new ArrayList<>();
		loadVertices(vertexFileName);
		loadEdges(edgeFileName);
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < vertices.size(); i++) {
			result += vertices.get(i).toString();
			result += "\n";
		}
		return result;
	}

	/**
	 *
	 * @param vertexFileName
	 * @return
	 */
   	public Collection<Vertex> loadVertices(String vertexFileName) {
//   		ArrayList<Vertex> vertexList = new ArrayList<>();

		try {
			Scanner sc = new Scanner(new File(vertexFileName));
			String start;
			while (sc.hasNextLine()) {
				start = sc.nextLine();
				vertices.add(new Vertex(start));
			}
		} catch (FileNotFoundException err) {
			System.out.println("Error in loadVertices()\n" + err);
		}
        return vertices;
   	}

   	public Collection<Edge> loadEdges(String edgeFileName) {
   		/*
   		Edges are read in the format:
   			startVertex
   			endVertex
   			distance
   			time
   			cost
   		 */
        ArrayList <Edge> edgeList = new ArrayList<>();

        try {
        	Scanner sc = new Scanner(new File(edgeFileName));
        	String start, end; int distance, time, cost;
			while(sc.hasNextLine()) {
				start = sc.nextLine();
				end = sc.nextLine();
				distance = Integer.parseInt(sc.nextLine());
				time = Integer.parseInt(sc.nextLine());
				cost = Integer.parseInt(sc.nextLine());
				vertices.get(vertexSearchIndex(start)).addEdge(
						vertexSearch(start), vertexSearch(end), distance, time, cost);
			}
		} catch (FileNotFoundException err) {
			System.out.println("Error in loadEdges()\n" + err);
		}
        return edgeList;
   	}

   	public int vertexSearchIndex(String targetVertex) {
   		for (int i = 0; i < vertices.size(); i++) {
   		    if (vertices.get(i).getName().equals(targetVertex)) {
   		    	return i;
			}
   		}
   		return -1;
	}

	public Vertex vertexSearch(String targetVertex) {
   		for (Vertex v : vertices) {
   		    if (v.getName().equals(targetVertex)) {
   		    	return v;
			}
   		}
   		return null;
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
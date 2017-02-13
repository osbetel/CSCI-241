import java.util.*;
import java.io.*;
import java.util.Scanner;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 * Add your name here: 
 */
public class DeprecatedMyGraph {
	private ArrayList<Vertex> vertices;

	public DeprecatedMyGraph(String vertexFileName, String edgeFileName) {
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

	/**
	 * Prints out a list of all the existing vertices in the graph.
	 * Recommended to use the toString() method instead as it has the functionality of both
	 * the displayVertices() and displayEdges() methods.
	 */
   	public void displayVertices() {
   		String[] str = new String[vertices.size()];
   		int i = 0;
		for (Vertex v : vertices) {
			str[i] = v.getName();
			i++;
		}
		System.out.println(Arrays.toString(str));
   	}

	/**
	 * Prints out a list of all the existing edges in the graph, as well as their information.
	 * Recommended to use the toString() method instead as it has the functionality of both
	 * the displayVertices() and displayEdges() methods.
	 */
   	public void displayEdges() {
   		ArrayList<Edge> edges;
        for (Vertex v : vertices) {
        	edges = v.getEdges();
        	for (Edge e : edges) {
				System.out.println(e.toString());
			}
		}
   	}
	
	//Graphic representation?
   	public static void displayGraph(Collection<Vertex> vertex, Collection<Edge> edge) {
		// YOUR CODE HERE                 
        return;
   	}

	//NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
	public ArrayList<Vertex> findAdjacentVertices(String vertex) {
   		Vertex startVertex = vertexSearch(vertex);
   		ArrayList<Vertex> adjacent = new ArrayList<>();

   		for (Edge e : startVertex.getEdges()) {
   		    adjacent.add(vertexSearch(e.getEnd()));
   		}
		return adjacent;
   	}

	//NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
	/*
	checkIsAdjacent does not return boolean but an array of intergers
	that contain distance, time, and price
	Potentially use a method, getEdgeData() instead then. The format isXYZ is
	usually used to return a boolean value.
	*/
	public boolean checkIsAdjacent(String startVertex, String endVertex) {
		for (Edge e : vertexSearch(startVertex).getEdges()) {
		    if (e.getStart().equals(startVertex) && e.getEnd().equals(endVertex)) {
		    	return true;
			}
		}

		return false;
   	}
	
	/*
	Possible use of recursion for next 3 functions
	Explore the graph starting at startVertex
	Check all possible routes through recursion
	Stop recursing when hits endVertex
	How to return cheapest price with recursion?
	How to use List<String> route? 
	Does it already contain shortest route? Or need to compare to all other possible routes?

	Djikstra's algorithm can be used to determine the route from vertex A to vertex B with the least
	possible cost. This cost can be in terms of distance, time, or price. Effectively, we'd
	only have to write one algorithm, specify the start, end, and what parameter (D, T, C) we want
	to calculate with.

	Only one downside, it calculates all routes at once and then selects the cheapest one. I can't
	think of a way around this though since the computer cannot objectively view all routes at once.
	Possible to simply calculate the entire set of shortest distances, times, etc. from every vertex
	to every other vertex at the start. And then when queried, look it up in the set.
	Undoubtedly real travel websites do this. I doubt they would recalculate every single time.
	They store the most popular results to return them in constant time. Hundreds of thousands fly
	NYC to SFO every day. No need to calculate it hundreds of thousands of times right?
	*/

   	//NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
   	public static int findShortestRoute(String startVertex, String endVertex, List<String> route) {
            // YOUR CODE HEREd
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

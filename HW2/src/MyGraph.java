import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Andrew Nguyen & Sam Tang
 * @since 02 Feb 2017
 *
 * CSCI 241, WWU - Professor Ahmed, Winter 2017
 */
public class MyGraph {

    //HashMap appears to be the best case.
    public HashMap<String, Node> graph;

    /**
     * Constructor for MyGraph
     * @param nodeFileName filename of nodes
     * @param edgeFileName filename of edges (start, end, distance, time, cost)
     */
    public MyGraph(String nodeFileName, String edgeFileName) {
        //try-catch because readInputData() throws a FNF Exception
        try {
            graph = readInputData(nodeFileName, edgeFileName);
        } catch (FileNotFoundException err) {
            System.out.println(err + "\n^^Call to MyGraph constructor.");
        }
    }

    /**
     * Method to read input files for nodes and edges, and then creates and returns a graph (HashMap representation)
     * @param nodeFileName Passed in from the constructor, filename containing nodes
     * @param edgeFileName Passed in from constructor, filename containing edges
     * @return Returns a graph to the constructor, which sets it as this object's graph member
     * @throws FileNotFoundException Self-explanatory
     */
    private static HashMap<String, Node> readInputData(String nodeFileName, String edgeFileName) throws FileNotFoundException {
        //Creation of the graph, represented via a hashmap of nodes.
        //Each node also contains a method, getData() that returns a String
        //Of their start, end, distance, cost, time. Via graph.get(key).getData()
        HashMap<String, Node> graph = new HashMap<>();

        //Creation of all nodes. Nodes are just names for now, they contain null edges.
        Scanner sc = new Scanner(new File(nodeFileName));
        String start;

        while (sc.hasNext()) {
            start = sc.nextLine();
            graph.put(start, new Node(start));
        }

        //Read in the edges file. Edges are added to nodes/
        sc = new Scanner(new File(edgeFileName));
        String end; int distance, time, cost;

        while (sc.hasNext()) {
            start = sc.nextLine();
            end = sc.nextLine();
            distance = Integer.parseInt(sc.nextLine());
            time = Integer.parseInt(sc.nextLine());
            cost = Integer.parseInt(sc.nextLine());

            //edges are added to nodes via addEdge(start, end, d, t, c);
            graph.get(start).addEdge(graph.get(start), graph.get(end), distance, time, cost);
        }
        return graph;
    }

    /**
     * Override of toString().
     * @return Returns a big, multi-line string to be printed that shows all info in this format:
     * NodeName: [Start --> End (distance, time, cost), ...]
     */
    public String toString() {
        String result = "";
        Set<String> keys = graph.keySet();
        for (String str : keys) {
//            System.out.println(graph.get(str));
            result += (graph.get(str).toString() + "\n");
        }
        return (result);
    }

    //Recursive
    public static Node[] distanceTrip(Node start, Node end) {
        return null;
    }

    //Recursive
    public static Node[] timeTrip(Node start, Node end) {
        return null;
    }

    //Recursive
    public static Node[] costTrip(Node start, Node end) {
        return null;
    }

}

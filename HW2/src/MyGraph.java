import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Andrew Nguyen & Sam Tang
 * @since 02 Feb 2017
 *
 * CSCI 241, WWU - Professor Ahmed, Winter 2017
 */
public class MyGraph {

    //HashMap appears to be the best case.
    private HashMap<String, Vertex> graph;

    /**
     * @param vertexFileName filename of nodes
     * @param edgeFileName filename of edges (start, end, distance, time, cost)
     */
    public MyGraph(String vertexFileName, String edgeFileName) {
        graph = new HashMap<>();

        //try-catch because readInputData() throws a FNF Exception
        try {
            loadVertices(vertexFileName);
            loadEdges(edgeFileName);
        } catch (FileNotFoundException err) {
            System.out.println(err + "\n^^Call to DeprecatedMyGraph constructor.");
        }
    }

    private void loadVertices(String vertexFileName) throws FileNotFoundException {
        //Each node also contains a method, getData() that returns a String
        //Of their start, end, distance, cost, time. Via graph.get(key).getData()
        //Creation of all nodes. Nodes are just names for now, they contain null edges.
        Scanner sc = new Scanner(new File(vertexFileName));
        String start;

        while (sc.hasNext()) {
            start = sc.nextLine();
            graph.put(start, new Vertex(start));
        }
    }

    private void loadEdges(String edgeFileName) throws FileNotFoundException {
        //Read in the edges file. Edges are added to nodes/
        Scanner sc = new Scanner(new File(edgeFileName));
        String start;
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

    public HashMap<String, Vertex> getGraph() {
        return graph;
    }
    
    public ArrayList<Vertex> findAdjacentVertices(Vertex v){
         ArrayList<Vertex> adjacent = new ArrayList<>();
         for(Edge e : graph.get(v).getEdges()){
            adjacent.add(graph.get(e.getEnd()));
         }
         return adjacent;
    }
    
    public boolean checkIsAdjacent(Vertex start, Vertex end){
        for(Edge e : graph.get(start).getEdges()){
            if(e.getStart().equals(start) && e.getEnd().equals(end)){
               return true;
            }
        }
        
        return false;
    }

    private Vertex[] djikstraAlg(Vertex start, Vertex end) {
        //Calculate every route as per djikstra's algo
        //return route for start and end
        
        //Method incomplete needs testing
        //Need to add a weight
        
        Vertex route[] = new Vertex[graph.size()];
        Set keys = graph.keySet();
        route[0] = start;
        Vertex curr = start;
        if(checkIsAdjacent(start, end)){
               route[1] = end;
            }
        else{
            ArrayList<Vertex> adjacent = findAdjacentVertices(curr);
            for(int i = 0; i < adjacent.size(); i++){
               curr = adjacent.get(i);
               route[i + 1] = djikstraAlg(curr, end)[0];
            }
        }
        return route;
    }


    //Recursive
    public Vertex[] distanceTrip(Vertex start, Vertex end) {
        return djikstraAlg(start, end);

    }

    //Recursive
    public Vertex[] timeTrip(Vertex start, Vertex end) {
        return djikstraAlg(start, end);
    }

    //Recursive
    public Vertex[] costTrip(Vertex start, Vertex end) {
        return djikstraAlg(start, end);

    }

    public int findShortestRoute(String startVertex, String endVertex) {
        ArrayList<Integer> distance = new ArrayList<>();
        return 0;
    }

    //NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
    public int findCheapestRoute(String startVertex, String endVertex) {
        ArrayList<Integer> cost = new ArrayList<>();
        return 0;
    }

    //NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
    public int findFastestRoute(String startVertex, String endVertex) {
        ArrayList<Integer> time = new ArrayList<>();
        return 0;
    }

}

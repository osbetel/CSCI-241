import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
     * Constructor for MyGraph
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
            System.out.print(err + "\n^^Call to MyGraph constructor.");
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

    private Vertex extractMin(ArrayList<Vertex> vList){
        Vertex min = new Vertex("min");
        min.value = Integer.MAX_VALUE;
        for(Vertex v : vList){
            if(v.value < min.value){
                min = v;
                return min;
            }
            min = v;
        }
        return min;
    }

    //Recursive
    public ArrayList<Vertex> distanceTrip(Vertex start) {
        ArrayList<Vertex> route = new ArrayList<>();
        ArrayList<Vertex> vertexList = new ArrayList<>();
        Set<String> keys = graph.keySet();
        for (String str : keys) {
            vertexList.add(graph.get(str));
        }
        for(Vertex v : vertexList){
            v.value = Integer.MAX_VALUE;
        }
        start.value = 0;
        while(!vertexList.isEmpty()){
            Vertex u = extractMin(vertexList);
            vertexList.remove(u);
            route.add(u);
            for(Edge e : u.getEdges()){
                if(graph.get(e.getEnd()).value > u.value + e.getDistance()){
                    graph.get(e.getEnd()).value = u.value + e.getDistance();
                    graph.get(e.getEnd()).prev = u;
                }
            }
        }
        return route;
    }

    //Recursive
    public ArrayList<Vertex> timeTrip(Vertex start) {
        ArrayList<Vertex> route = new ArrayList<>();
        ArrayList<Vertex> vertexList = new ArrayList<>();
        Set<String> keys = graph.keySet();
        for (String str : keys) {
            vertexList.add(graph.get(str));
        }
        for(Vertex v : vertexList){
            v.value = Integer.MAX_VALUE;
        }
        start.value = 0;
        while(!vertexList.isEmpty()){
            Vertex u = extractMin(vertexList);
            vertexList.remove(u);
            route.add(u);
            for(Edge e : u.getEdges()){
                if(graph.get(e.getEnd()).value > u.value + e.getTime()){
                    graph.get(e.getEnd()).value = u.value + e.getTime();
                    graph.get(e.getEnd()).prev = u;
                }
            }
        }
        return route;
    }

    //Recursive
    public ArrayList<Vertex> costTrip(Vertex start) {
        ArrayList<Vertex> route = new ArrayList<>();
        ArrayList<Vertex> vertexList = new ArrayList<>();
        Set<String> keys = graph.keySet();
        for (String str : keys) {
            vertexList.add(graph.get(str));
        }
        for(Vertex v : vertexList){
            v.value = Integer.MAX_VALUE;
        }
        start.value = 0;
        while(!vertexList.isEmpty()){
            Vertex u = extractMin(vertexList);
            vertexList.remove(u);
            route.add(u);
            for(Edge e : u.getEdges()){
                if(graph.get(e.getEnd()).value > u.value + e.getCost()){
                    graph.get(e.getEnd()).value = u.value + e.getCost();
                    graph.get(e.getEnd()).prev = u;
                }
            }
        }
        return route;
    }

    public int findShortestRoute(String startVertex, String endVertex) {
        int value = 0;
        ArrayList<Vertex> route = distanceTrip(graph.get(startVertex));
        for(Vertex v : route){
            if(v == graph.get(endVertex)){
                value = v.value;
                return value;
            }
        }
        return value;
    }

    //NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
    public int findCheapestRoute(String startVertex, String endVertex) {
        int value = 0;
        ArrayList<Vertex> route = costTrip(graph.get(startVertex));
        for(Vertex v : route){
            if(v == graph.get(endVertex)){
                value = v.value;
                return value;
            }
        }
        return value;
    }

    //NOTE: THE PARAMETER DATA TYPES MAY BE CHANGED TO VERTEX LATER ON
    public int findFastestRoute(String startVertex, String endVertex) {
        int value = 0;
        ArrayList<Vertex> route = timeTrip(graph.get(startVertex));
        for(Vertex v : route){
            if(v == graph.get(endVertex)){
                value = v.value;
                return value;
            }
        }
        return value;
    }
}


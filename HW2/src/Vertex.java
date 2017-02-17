import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Andrew Nguyen & Sam Tang
 * @since 02 Feb 2017
 *
 * CSCI 241, WWU - Professor Ahmed, Winter 2017
 */
public class Vertex {
    private String name;
    private ArrayList<Edge> edges;
    public int value;
    public Vertex prev;



    public Vertex(String name, ArrayList<Edge> edges) {
        this.name = name;
        this.edges = edges;
        value = 0;
        prev = null;
    }

    public Vertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
        value = 0;
        prev = null;
    }

    public void addEdge(Vertex start, Vertex end, int distance, int time, int cost) {
        edges.add(new Edge(start, end, distance, time, cost));
    }

    /**
     * Retrieves just the name of this Node without any extra information
     * @return Returns this Node's name
     */
    public String getName() {
        return name;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    /**
     * Override of toString()
     * @return Returns the name of this Node and an array of all its edges as a String.
     * The array of edges also includes distance, time, and cost.
     */
    public String toString() {
        return (name + ": " + Arrays.toString(edges.toArray()));
    }

    public boolean equals(Vertex end){
        if(name.equals(end.getName())){
            return true;
        }
        return false;
    }

}

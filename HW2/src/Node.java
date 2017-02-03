import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Andrew Nguyen & Sam Tang
 * @since 02 Feb 2017
 *
 * CSCI 241, WWU - Professor Ahmed, Winter 2017
 */
public class Node {
    private String name;
    private LinkedList<Edge> edges;



    public Node(String name, LinkedList<Edge> edges) {
        this.name = name;
        this.edges = edges;
    }

    public Node(String name) {
        this.name = name;
        edges = new LinkedList<>();
    }

    public void addEdge(Node start, Node end, int distance, int time, int cost) {
        edges.add(new Edge(start, end, distance, time, cost));
    }

    public String toString() {
        return name;
    }

    public String getData() {
        return (name + ": " + Arrays.toString(edges.toArray()));
    }

}

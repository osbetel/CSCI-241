/**
 * @author Andrew Nguyen & Sam Tang
 * @since 02 Feb 2017
 *
 * CSCI 241, WWU - Professor Ahmed, Winter 2017
 */
public class Edge {
    private String name;
    private Node start;
    private Node end;
    private int distance;
    private int time;
    private int cost;

    /**
     * Constructor for an edge
     * @param start Starting Node
     * @param end Ending Node
     * @param distance distance between nodes as an int
     * @param time travel time as an int
     * @param cost cost of the trip as an int (in dollars)
     */
    public Edge(Node start, Node end, int distance, int time, int cost) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.time = time;
        this.cost = cost;

        name = (start.getName() + " --> " + end.getName());

    }

    /**
     * Override of toString()
     * @return Returns edge information in the format:
     * "Start --> End (d, t, c)"
     */
    public String toString() {
        return name + " (" + distance + ", " + time + ", " + cost +")";
    }


}

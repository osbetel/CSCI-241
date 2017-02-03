/**
 * @author ADKN
 * @since 02 Feb 2017
 */
public class Edge {
    private String name;
    private Node start;
    private Node end;
    private int distance;
    private int time;
    private int cost;

    public Edge(Node start, Node end, int distance, int time, int cost) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.time = time;
        this.cost = cost;

        name = (start.toString() + " --> " + end.toString());

    }

    public String toString() {
        return name;
    }


}

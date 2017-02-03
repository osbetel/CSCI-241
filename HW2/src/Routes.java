import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Andrew Nguyen & Sam Tang
 * @since 02 Feb 2017
 *
 * CSCI 241, WWU - Professor Ahmed, Winter 2017
 */
public class Routes {

    public static void main(String[] args) {
        //Routes.java is the main class

//        MyGraph travelMap = new MyGraph();
//        DrawGraph paint = new DrawGraph(travelMap);

        try {
            testNodeClass();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void testNodeClass() throws FileNotFoundException {
        //Creation of all nodes
        Scanner sc = new Scanner(new File("vertex.txt"));
        HashMap<String, Node> graph = new HashMap<>();

        String start;
        while (sc.hasNext()) {
            start = sc.nextLine();
            graph.put(start, new Node(start));
        }

        sc = new Scanner(new File("edge.txt"));

        String end; int distance, time, cost;
        while (sc.hasNext()) {
            start = sc.nextLine();
            end = sc.nextLine();
            distance = Integer.parseInt(sc.nextLine());
            time = Integer.parseInt(sc.nextLine());
            cost = Integer.parseInt(sc.nextLine());

            graph.get(start).addEdge(graph.get(start), graph.get(end), distance, time, cost);
        }
        System.out.println(graph.get("ATL").getData());

    }

}

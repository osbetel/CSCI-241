import java.io.FileNotFoundException;

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
            testGraphInstantiation();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    //TestMethod
    public static void testGraphInstantiation() throws FileNotFoundException {
        MyGraph graph = new MyGraph("vertex.txt", "edge.txt");
        System.out.println(graph.toString());

    }

}

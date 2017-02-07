import java.io.FileNotFoundException;

/**
 * @author Andrew Nguyen & Sam Tang
 * @since 02 Feb 2017
 *
 * CSCI 241, WWU - Professor Ahmed, Winter 2017
 */
public class Routes {

    public static void main(String[] args) {
        /*
        check number of arguments, should be executable from the terminal
        read vertex files and edge files
        vertex = graph.readVertex() etc...
        displayVertices()
        edges = graph.readEdges() etc...
        displayEdges()
         */



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
        //Deprecated test
        DeprecatedMyGraph graph = new DeprecatedMyGraph("vertex.txt", "edge.txt");
        System.out.println(graph.toString());

    }

}

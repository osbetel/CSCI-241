import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ADKN
 * @since 25 Feb 2017
 */
public class NameData {
    private static BSTree tree;
    private static Hash hash;
    private static NameList list;

    public NameData(String inputFile) throws FileNotFoundException{
        createTree(inputFile);
//        createHashMap();
//        createArrayList();
    }

    public static void createTree(String inputFile) throws FileNotFoundException {

//        tree = new BSTree();

        Scanner sc = new Scanner(new File(inputFile));
        String str = "";

        while (sc.hasNextLine()) {
            str += sc.nextLine() + "\n";
        }
        String[] arr = str.split("\n");
        Arrays.sort(arr);
//        System.out.println(Arrays.binarySearch(arr, "Rayan,F,53"));
//        System.out.println(arr[25979]);
//        System.out.println(arr[25978]);
//        System.out.println(Arrays.toString(arr));
        tree = new BSTree(arr);
    }

    public BSTree getTree() {
        return tree;
    }

    public static void createHashMap() {
        hash = new Hash();  //Hashmap obviously
    }

    public static void createArrayList() {
        list = new NameList();  //Make sure this uses arraylist and not an array!
    }
}

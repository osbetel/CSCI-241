import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kickstart {

    private static BSTree tree;
    private static Hash hash;
    private static NameList list;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("yob2014.txt"));
        //read input
        list = new NameList();
        hash = new Hash();
        tree = new BSTree();

        //user input from terminal
        //parse.... list.mostPopular()
        //parse... tree.searchName()



    }
}

import java.io.FileNotFoundException;

public class Kickstart {

    private static BSTree tree;
    private static Hash hash;
    private static NameList list;

    public static void main(String[] args) throws FileNotFoundException {

        //example test. Run this and it'll create the structures
        //Currently set to print out the binary tree from in-order traversal,
        //The tree is sorted by the occurrences number. Lowest numbers on the
        //left subtree, greatest on the right subtree
        NameData dataStructures = new NameData("yob2014.txt");
//        dataStructures.getTree().searchName("Michael");




        //user input from terminal
        //parse.... list.mostPopular()
        //parse... tree.searchName()
        ///...etc.

        /*
        String str = "Abigail";

        char[] array = new char[26];
        array[0] = 'A'; array[1] = 'B'; array[2] = 'C'; array[3] = 'D';
        array[4] = 'E'; array[5] = 'F'; array[6] = 'G'; array[7] = 'H';
        array[8] = 'I'; array[9] = 'J'; array[10] = 'K'; array[11] = 'L';

        array[12] = 'M'; array[13] = 'N'; array[14] = 'O'; array[15] = 'P';
        array[16] = 'Q'; array[17] = 'R'; array[18] = 'S'; array[19] = 'T';
        array[20] = 'U'; array[21] = 'V'; array[22] = 'W'; array[23] = 'X';

        array[24] = 'Y'; array[25] = 'Z';

        char[] array1 = new char[26];
        array1[0] = 'a'; array1[1] = 'b'; array1[2] = 'c'; array1[3] = 'd';
        array1[4] = 'e'; array1[5] = 'f'; array1[6] = 'g'; array1[7] = 'h';
        array1[8] = 'i'; array1[9] = 'j'; array1[10] = 'k'; array1[11] = 'l';

        array1[12] = 'm'; array1[13] = 'n'; array1[14] = 'o'; array1[15] = 'p';
        array1[16] = 'q'; array1[17] = 'r'; array1[18] = 's'; array1[19] = 't';
        array1[20] = 'u'; array1[21] = 'v'; array1[22] = 'w'; array1[23] = 'x';

        array1[24] = 'y'; array1[25] = 'z';

        for (char c : array1) {
            System.out.println(Character.getNumericValue(c));
        }
        */



    }
}

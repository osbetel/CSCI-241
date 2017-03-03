import java.util.Arrays;

/**
 * @author ADKN
 * @since 02 Mar 2017
 */
public class Node {
    private Node leftChild;
    private Node rightChild;
    private String[] values;

        /*
        In order to sort alphabetically, we will consider the numbers 10 - 35.
        These numbers correspond to Character.getNumericValue(char c), which maps A to 10,
        B to 11... Etc. Case does not matter. A lowercase a and an uppercase A have the same
        numeric value. We can use this value (which is the ASCII value by the way) to sort the tree.
         */

    public Node(String readLine, Node left, Node right) {
        leftChild = left;
        rightChild = right;
        values = readLine.split(",");
        //values[0] = name
        //values[1] = gender
        //values[2] = occurences
    }

    public String toString() {
        return Arrays.toString(values);
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public String getName() {
        return values[0];
    }

    public int getAlphabeticalValue() {
        return Character.getNumericValue(values[0].charAt(0));
    }

    public String[] getValues() {
        return values;
    }

    public String getGender() {
        return values[1];
    }

    public int getOccurences() {
        return Integer.parseInt(values[2]);
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setName(String name) {
        values[0] = name;
    }

    public void setGender(char c) {
        //must be M or F!!!
        values[1] = String.valueOf(c);
    }

    public void setOccurrences(int num) {
        values[2] = String.valueOf(num);
    }
}
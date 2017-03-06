import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ADKN
 * @since 25 Feb 2017
 */
public class BSTree {
    private Node root;

    /*
    The tree can be constructed in several ways.
        -It can be made alphabetically, with A's on the left subtree and Z's on the right.
         If I choose this route, each of the letters will have to be assigned a value, 1 - 26
         Perhaps this would implement a hashmap to use as a dictionary (in the form of python's
         dictionary structures)

        -The second route is to simply store the names by number. This is the easiest.
         Names with the most occurrences will be on the left subtree and names with the least
         will be on the right subtree. This makes showing names alphabetically a huge pain
         though, since the entire tree would have to be sorted alphabetically and then
         printed before running showNameAlphabetically().

         -Another option is to have two trees, maleRoot and femaleRoot where each tree is
          organized by one of the above two methods, except that genders are divided into
          two trees. This makes the mostPopularNames() very easy, but complicates the
          other two operations of searching and alphabetically sorting.

     Best option so far looks to be sorting alphabetically. Numerical popularity can be
     determined later by sorting all the names into a 10 space array, and then removing
     or modifying the elements as we encounter more while traversing the tree.

     Searching a name is simple this way. Simply traverse the tree and determine if the name
     matches. Alphabetical printing is also easy this way.
     */

    public BSTree(String[] lines) {
        //input file converted into an array

        for (String v : lines) {
            addNode(v.split(","));
        }
        System.out.println(root.getRightChild().getLeftChild().toString());
        System.out.println(root.toString());
        System.out.println(root.getRightChild().toString());

//        print(root);



    }

    private void addNode(String[] values) {
        if (root == null) {
            root = new Node(values, null, null);
        } else {
            addNode(root, values, 0);
        }
    }

    private void addNode(Node parent, String[] values, int charIndex) {
        String childName = values[0];
        String parentName = parent.getName();

        int childLength = childName.length();
        int parentLength = parentName.length();

        int childValue = Character.getNumericValue(values[0].charAt(charIndex));
        int parentValue = parent.getAlphabeticalValue(charIndex);

        if (childValue < parentValue) {

            if (parent.getLeftChild() == null) {
                parent.setLeftChild(new Node(values, null, null));
            } else {
                addNode(parent.getLeftChild(), values, charIndex);
            }

        } else if (childValue > parentValue) {

            if (parent.getRightChild() == null) {
                parent.setRightChild(new Node(values, null, null));
            }
            else {
                addNode(parent.getRightChild(), values, charIndex);
            }

        } else if (childValue == parentValue) {
            //If values are the same, and we've hit the end of a name, ie: John and Johnathan, we put
            //the shorter name first and the longer name last.
            if (charIndex < childLength && charIndex < parentLength) {
                addNode(parent, values, charIndex + 1);
            }
        }
    }

    public void searchName(String name) {
        return;
    }

    public void mostPopularName() {
        return;
    }

    public void showNameAlphabetically() {
        return;
    }

    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.getRightChild());
            System.out.println(root.toString());
            print(root.getLeftChild());

        }
    }
}

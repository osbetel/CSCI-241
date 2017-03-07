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
    private int totalNames;

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
        root = buildTree(lines, 0, lines.length - 1);
        totalNames = totalOccurrences();


        Node[] nodes = searchName("Jamie");
        System.out.println(Arrays.toString(nodes));

//        showNameAlphabetically();
//        System.out.println(totalOccurrences());
//        System.out.println(Arrays.toString(mostPopularName()));
    }

    private Node buildTree(String[] data, int start, int end) {

        //Base case
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(data[mid].split(","), null, null);

        node.setLeftChild(buildTree(data, start, mid - 1));
        node.setRightChild(buildTree(data, mid + 1, end));

        return node;
    }

    //METHOD DEPRECATED
    private void addNode(String[] values) {
        if (root == null) {
            root = new Node(values, null, null);
        } else {
            addNode(root, values, 0);
        }
    }

    //METHOD DEPRECATED
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
                addNode(parent.getLeftChild(), values, 0);
            }

        } else if (childValue > parentValue) {

            if (parent.getRightChild() == null) {
                parent.setRightChild(new Node(values, null, null));
            }
            else {
                addNode(parent.getRightChild(), values, 0);
            }
        } else if (childValue == parentValue) {
            if (charIndex + 1 < childLength && charIndex + 1 < parentLength) {
                addNode(parent, values, charIndex + 1);
            } else { //ran out of index
                //incomplete
            }
        }
    }

    public Node[] searchName(String name) {
        //need to find out if there are two genders, end up searching tree anyway
        //First node encountered will be male or female, if there is a duplicate
        //Name of the opposite gender, it will be a child node of that parent node
        Node[] nodes = new Node[2];

        nodes[0] = searchName(name, root);
        nodes[1] = searchName(name, nodes[0].getLeftChild());

        if (nodes[1] == null) {
            nodes[1] = searchName(name, nodes[0].getRightChild());
        }

        return nodes;
    }

    private Node searchName(String name, Node node) {
        if (node == null) return null;
        if (node.getName().equals(name)) {
            return node;
        } else {
            if (isAlphabetical(name, node.getName())) {
                return searchName(name, node.getLeftChild());
            } else {
                return searchName(name, node.getRightChild());
            }
        }
    }

    private boolean isAlphabetical(String name1, String name2) {
        String[] arr = {name1, name2};
        Arrays.sort(arr);
        return (arr[0]).equals(name1);
    }

    public Node[] mostPopularName() {
        //collect 10 male names
        Node[] male = new Node[10];
//        male[0] = extractMax(root, 0, 'F');
        Node mNode;
        ArrayList<Integer> mIgnoreValues = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mNode = extractMax(root, mIgnoreValues, 'F');
            male[i] = mNode;
            mIgnoreValues.add(mNode.getOccurences());
        }

        //collect 10 female names
        Node[] female = new Node[10];
//        female[0] = extractMax(root, 0, 'M');
        Node fNode;
        ArrayList<Integer> fIgnoreValues = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            fNode = extractMax(root, fIgnoreValues, 'M');
            female[i] = fNode;
            fIgnoreValues.add(fNode.getOccurences());
        }

        Node[] result = new Node[20];
        for (int i = 0; i < 10; i++) {
            result[i] = male[i];
            result[i+10] = female[i];
        }
        return result;
    }

    public static Node extractMax(Node node, ArrayList<Integer> ignoreVal, char ignoreGender) {
        int max = node.getOccurences();
        Node maxNode = node;

        // only check if this node is not a leaf
        if (node.getRightChild() != null) {
            Node maxRight = extractMax(node.getRightChild(), ignoreVal, ignoreGender);
            if (maxRight.getOccurences() > max &&
                    !ignoreVal.contains(maxRight.getOccurences()) &&
                    maxRight.getGender() != ignoreGender) {
                max = maxRight.getOccurences();
                maxNode = maxRight;
            }
        }

        if (node.getLeftChild() != null) {
            Node maxLeft = extractMax(node.getLeftChild(), ignoreVal, ignoreGender);
            if (maxLeft.getOccurences() > max &&
                    !ignoreVal.contains(maxLeft.getOccurences()) &&
                    maxLeft.getGender() != ignoreGender) {
//                max = maxLeft.getOccurences();
                maxNode = maxLeft;

            }
        }

        return maxNode;
    }

    private boolean contains(Node[] arr, Node n) {
        for (Node node : arr) {
            if (n == node) {
                return true;
            }
        }
        return false;
    }

    public void showNameAlphabetically() {
        showNameAlphabetically(root);
    }

    private void showNameAlphabetically(Node node) {
        if (node != null) {
            showNameAlphabetically(node.getLeftChild());
            System.out.println(node);
            showNameAlphabetically(node.getRightChild());
        }
    }

    private int totalOccurrences() {
        return totalOccurrences(root);
    }

    private int totalOccurrences(Node node) {
        if (node != null) {
            return node.getOccurences() + totalOccurrences(node.getRightChild())
                    + totalOccurrences(node.getLeftChild());
        } else return 0;
    }

    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.getLeftChild());
            System.out.println(root.toString());
            print(root.getRightChild());

        }
    }
}

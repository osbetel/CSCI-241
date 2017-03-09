import java.io.*;
import java.util.*;
/**
 * Created by SammyTang on 3/8/17.
 */
public class NameList {
    private String name;
    private char gender;
    private int occurrences;
    private int totalOccurrences = 0;
    ArrayList<Node> peopleList;

    //Change error message as desired
    
    public NameList(String filename){
        peopleList = new ArrayList<>();
        try{
            loadArrayList(filename);
        }
        catch(FileNotFoundException err){
            System.out.println(err);
        }
    }

    //kept the ranking for each gender as seperate, however does not affect totalOccurrence count    
    
    private void loadArrayList(String fileName)throws FileNotFoundException{
        int count = 0;
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            totalOccurrences++;
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            name = lineScan.next();
            gender = lineScan.next().charAt(0);
            occurrences = lineScan.nextInt();
            if(gender == 'F') {
                Node person = new Node(name, gender, occurrences, totalOccurrences);
                peopleList.add(person);
            }
            else {
                count++;
                Node person = new Node(name, gender, occurrences, count);
                peopleList.add(person);
            }
        }
    }

    //Used to sort for ranking in mostPopularName
    
    private ArrayList<Node> sortRank(ArrayList<Node> aList){
        Node temp;
        for(int i = 1; i < aList.size(); i++){
            for(int j = i; j > 0; j--){
                if(aList.get(j).getRank() < aList.get(j - 1).getRank()){
                    temp = aList.get(j);
                    aList.set(j, aList.get(j-1));
                    aList.set(j-1, temp);
                }
            }
        }
        return aList;
    }
    
    //Sorts the entire ArrayList alphabetically
    
    private ArrayList<Node> sortAlphabetically(ArrayList<Node> aList){
        Node temp;
        for(int i = 1; i < aList.size(); i++){
            for(int j = i; j > 0; j--){
                if(aList.get(j - 1).getName().compareTo(aList.get(j).getName()) > 0){
                    temp = aList.get(j);
                    aList.set(j, aList.get(j - 1));
                    aList.set(j - 1, temp);
                }
            }
        }
        return aList;
    }

    /*Returns an ArrayList of nodes containing the female and male versions of each name, will need to read
    the ArrayList in kickstarter and print out data such as gender and occurances for each name.
    */
    
    public ArrayList<Node> searchName(String aName){
        ArrayList people = new ArrayList<Node>();
        for(Node node : peopleList){
            if(aName.equals(node.getName())){
                people.add(node);
            }
        }
        return people;
    }
    
    /*Returns an ArrayList containing first the top 10 girl names, and then the top 10 boy names in the correct order
    will need to read into the ArrayList in Kickstarter to display needed information
    */

    public ArrayList<Node> mostPopularName() {
        ArrayList<Node> people = new ArrayList<>();
        ArrayList<Node> girls = new ArrayList<>();
        ArrayList<Node> boys = new ArrayList<>();
        for(Node node : peopleList){
            if(node.getGender() == 'F'){
                if(node.getRank() <= 10){
                    girls.add(node);
                }
            }
        }
        for(Node node : peopleList){
            if(node.getGender() == 'M'){
                if(node.getRank() <= 10){
                    boys.add(node);
                }
            }
        }
        ArrayList<Node> sortedGirls = sortRank(girls);
        ArrayList<Node> sortedBoys = sortRank(boys);
        for(Node node : sortedGirls){
            people.add(node);
        }
        for(Node node : sortedBoys){
            people.add(node);
        }
        return people;
    }

    //Prints out the entire list of names in alphabetical order, change the print statement to correct data as needed
    
    public void showNameAlphabetically(){
        ArrayList<Node> sortedList = sortAlphabetically(peopleList);
        for(Node node : sortedList){
            double occurrencePercent = ((double)node.getOccurences() / (double)totalOccurrences) * 100;
            System.out.println(node.getName() + ", " + node.getGender() + ", " + node.getOccurences() + ", " +
                    occurrencePercent + "%");
        }
    }
}

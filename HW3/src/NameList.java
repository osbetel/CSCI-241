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

    public NameList(String filename){
        peopleList = new ArrayList<>();
        try{
            loadArrayList(filename);
        }
        catch(FileNotFoundException err){
            System.out.println(err);
        }
    }

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

    public ArrayList<Node> searchName(String aName){
        ArrayList people = new ArrayList<Node>();
        for(Node node : peopleList){
            if(aName.equals(node.getName())){
                people.add(node);
            }
        }
        return people;
    }

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

    public void showNameAlphabetically(){
        ArrayList<Node> sortedList = sortAlphabetically(peopleList);
        for(Node node : sortedList){
            double occurrencePercent = ((double)node.getOccurences() / (double)totalOccurrences) * 100;
            System.out.println(node.getName() + ", " + node.getGender() + ", " + node.getOccurences() + ", " +
                    occurrencePercent + "%");
        }
    }
}

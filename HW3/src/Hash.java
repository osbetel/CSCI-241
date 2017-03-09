import java.io.*;
import java.util.*;
/**
 * Created by SammyTang on 3/8/17.
 */
public class Hash {
    private String name;
    private char gender;
    private int occurrences;
    private int totalOccurrences = 0;
    private HashMap<String, Node> maleHash;
    private HashMap<String, Node> femaleHash;

    public Hash(String fileName){
        maleHash = new HashMap<>();
        femaleHash = new HashMap<>();

        try{
            loadMaleHashMap(fileName);
            loadfemaleHashMap(fileName);
        }
        catch(FileNotFoundException err){
            System.out.println(err);
        }
    }

    //Decided to split the assignment up into 2 hashmaps, 1 for boys and 1 for girls as it seemed it would

    private void loadMaleHashMap(String fileName)throws FileNotFoundException{
        int count = 0;
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            name = lineScan.next();
            gender = lineScan.next().charAt(0);
            occurrences = lineScan.nextInt();
            if(gender == 'M') {
                count++;
                Node person = new Node(name, gender, occurrences, count);
                maleHash.put(name, person);
                totalOccurrences = totalOccurrences + occurrences;
            }
        }
    }

    private void loadfemaleHashMap(String fileName)throws FileNotFoundException{
        int count = 0;
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            name = lineScan.next();
            gender = lineScan.next().charAt(0);
            occurrences = lineScan.nextInt();
            if(gender =='F') {
                count++;
                Node person = new Node(name, gender, occurrences, count);
                femaleHash.put(name, person);
                totalOccurrences = totalOccurrences + occurrences;
            }
        }
    }

    //Insertion sorting algorithm to sort names by highest to lowest ranking in order for mostPopularName to be in order

    private ArrayList<Node> sort(ArrayList<Node> aList){
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

    /*Returns an ArrayList of nodes containing the female and male versions of each name, will need to read
    the ArrayList in kickstarter and print out data such as gender and occurrences for each name.
    */

    public ArrayList<Node> searchName(String aName){
        ArrayList<Node> people = new ArrayList<>();
        if(femaleHash.containsKey(aName)){
            people.add(femaleHash.get(aName));
        }
        if(maleHash.containsKey(aName)){
            people.add(maleHash.get(aName));
        }
        return people;
    }

    /*Returns an ArrayList containing first the top 10 girl names, and then the top 10 boy names in the correct order
    will need to read into the ArrayList in Kickstarter to display needed information
    */

    public ArrayList<Node> mostPopularName() {
        ArrayList<Node> people = new ArrayList<>();
        ArrayList<Node> boy = new ArrayList<>();
        ArrayList<Node> girl = new ArrayList<>();
        Set<String> femaleSet = femaleHash.keySet();
        Set<String> maleSet = maleHash.keySet();
        for(String str : femaleSet){
            int femaleRank = femaleHash.get(str).getRank();
            if (femaleRank <= 10){
                girl.add(femaleHash.get(str));
            }
        }
        for(String str : maleSet){
            int maleRank = maleHash.get(str).getRank();
            if (maleRank <= 10){
                boy.add(maleHash.get(str));
            }
        }
        ArrayList<Node> sortedGirls = sort(girl);
        ArrayList<Node> sortedBoys = sort(boy);
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
        HashMap<String, Node> allNames = new HashMap<>();
        Set<String> girlKeys = femaleHash.keySet();
        Set<String> boyKeys = maleHash.keySet();
        for(String key : girlKeys){
            allNames.put(key, femaleHash.get(key));
        }
        for(String key : boyKeys){
            allNames.put(key, maleHash.get(key));
        }
        Set<String> allKeys = allNames.keySet();
        String[] sortingArray = allKeys.toArray(new String[allKeys.size()]);
        Arrays.sort(sortingArray);
        for(String key : sortingArray){
            double occurrencePercent = ((double)allNames.get(key).getOccurences() / (double)totalOccurrences) *100;
            System.out.println(allNames.get(key).getName() + ", " + allNames.get(key).getGender() + ", " +
                    allNames.get(key).getOccurences() + ", " + occurrencePercent + "%");
        }
    }

}

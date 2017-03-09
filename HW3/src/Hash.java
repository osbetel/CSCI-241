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


    public ArrayList<Node> searchName(String aName){
        ArrayList people = new ArrayList<Node>();
        if(femaleHash.containsKey(aName)){
            people.add(femaleHash.get(aName));
        }
        if(maleHash.containsKey(aName)){
            people.add(maleHash.get(aName));
        }
        return people;
    }

    public ArrayList<Node> mostPopularName() {
        ArrayList people = new ArrayList<Node>();
        ArrayList boy = new ArrayList<Node>();
        ArrayList girl = new ArrayList<Node>();
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
        

        return people;
    }

}

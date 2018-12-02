import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Program {

    static List<String> fileLines = new ArrayList<>();
    public static void main(String[]args){
        if(args.length == 0)
            readFile("input.txt");
        else
            readFile(args[0]);

        part1();
        part2();

    }

    private static void readFile(String filePath){
        try {
            fileLines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void part1(){
        int twos = 0;
        int threes = 0;

        for(String line : fileLines){
            boolean found2 = false;
            boolean found3 = false;

            HashMap<Character, Integer> charAndFreq = new HashMap<>();

            //Go through the line and add each letter
            for(int i = 0; i < line.length();i++){
                char c = line.charAt(i);
                charAndFreq.put(c, charAndFreq.getOrDefault(c,0)+1);
            }

            for(Map.Entry<Character,Integer> dictionary : charAndFreq.entrySet()){
                if (!found2 && dictionary.getValue() == 2) {
                    twos++;
                    found2 = true;
                }
                if (!found3 && dictionary.getValue() == 3) {
                    threes++;
                    found3 = true;
                }
            }
        }
        System.out.println("Checksum: "+ (threes * twos));
    }

    private static void part2(){
        for (int i = 0; i < fileLines.size(); i++) {
            for (int j = 0; j < fileLines.size(); j++) {
                if (i == j || j < i)
                    continue;

                int numberOfDifferentLetters = 0;

                String firstLine = fileLines.get(i);
                String secondLine = fileLines.get(j);

                for (int x = 0; x < firstLine.length(); x++) {
                    if (firstLine.charAt(x) != secondLine.charAt(x))
                        numberOfDifferentLetters++;
                }
                if (numberOfDifferentLetters == 1) {
                    System.out.print("Identical Letters: ");
                    for(int x = 0; x < firstLine.length();x++){
                        if (firstLine.charAt(x) == secondLine.charAt(x))
                            System.out.print(firstLine.charAt(x));
                    }
                    //fuck off i'm tired and this works
                }
            }
        }
    }
}





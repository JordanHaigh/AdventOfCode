import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        int currentFrequency = 0;

        for(String line : fileLines){
            currentFrequency += Integer.parseInt(line);
        }
        System.out.println("Part 1 - Current Frequency: "+ currentFrequency);
    }

    private static void part2(){
        int currentFrequency = 0;
        HashSet<Integer> pastFrequencies = new HashSet<>();
        pastFrequencies.add(currentFrequency);

        boolean flag = false;

        while(!flag){ //Read the question - Needs to keep looping through the dataset over and over again until it finds dup
            for(String line : fileLines){
                currentFrequency += Integer.parseInt(line);

                if(pastFrequencies.contains(currentFrequency) && !flag){
                    System.out.println("Part 2 - Duplicate: " + currentFrequency);
                    flag = true;
                }
                pastFrequencies.add(currentFrequency);
            }
        }
    }

}

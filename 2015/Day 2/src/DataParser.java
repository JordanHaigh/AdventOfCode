import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public List<Dimensions> readFile(String filePath) {
        List<String> fileLines = new ArrayList<>();
        List<Dimensions> allDimensions = new ArrayList<>();

        try {
            fileLines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : fileLines) {
            allDimensions.add(readSingleLine(line));
        }
        return allDimensions;
    }

    private Dimensions readSingleLine(String line) {
        String[] splittedDimensions = line.split("x");
        //Length, width, height

        int length = Integer.parseInt(splittedDimensions[0]);
        int width = Integer.parseInt(splittedDimensions[1]);
        int height = Integer.parseInt(splittedDimensions[2]);
        return new Dimensions(length, width, height);
    }
}
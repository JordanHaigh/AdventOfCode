import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Program {

    static List<String> fileLines = new ArrayList<>();
    public static void main(String[]args){
        if(args.length == 0)
            readFile("input.txt");
        else
            readFile(args[0]);

        part1();

    }

    private static void readFile(String filePath){
        try {
            fileLines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void part1(){
        //Populate dot array
        int xAxis = 1000;
        int yAxis = 1000;
        int[][] dotArray = new int[xAxis][yAxis];

        for(int i = 0;i < xAxis;i++){
            for(int j = 0;j < yAxis;j++){
                dotArray[i][j] = 0;
            }
        }

        int squareInchOverlap = 0;
        //Go through each line of file lines

        for(String line : fileLines){
            //Parse claim
            Claim claim = parseClaim(line);

            //Work out its positioning in the dot array and print it
            for(int i = claim.getInchesFromTopEdge(); i < claim.getInchesFromTopEdge()+ claim.getHeight();i++){
                for(int j = claim.getInchesFromLeftEdge(); j < claim.getInchesFromLeftEdge()+ claim.getWidth();j++){
                    dotArray[i][j]++;
                }
            }
        }

        for(int i = 0;i < xAxis;i++){
            for(int j = 0;j < yAxis;j++){
                if(dotArray[i][j] > 1)
                    squareInchOverlap++;
            }
        }
        System.out.println(squareInchOverlap);
    }

    private static Claim parseClaim(String line){
        String id = line.substring(1,line.indexOf("@")-1);
        line = line.substring(line.indexOf("@")+1);
        int inchesFromLeftEdge = Integer.parseInt(line.substring(1,line.indexOf(",")));
        line = line.substring(line.indexOf(",")+1);
        int inchesFromTopEdge = Integer.parseInt(line.substring(0,line.indexOf(":")));
        line = line.substring(line.indexOf(":")+1);
        int width = Integer.parseInt(line.substring(1,line.indexOf("x")));
        line = line.substring(line.indexOf("x")+1);
        int height = Integer.parseInt(line);

        return new Claim(id,inchesFromLeftEdge,inchesFromTopEdge,height,width);
    }


    private static class Claim{
        private String id;
        private int inchesFromLeftEdge;
        private int inchesFromTopEdge;
        private int height;
        private int width;

        public Claim(String id, int inchesFromLeftEdge, int inchesFromTopEdge, int height, int width) {
            this.id = id;
            this.inchesFromLeftEdge = inchesFromLeftEdge;
            this.inchesFromTopEdge = inchesFromTopEdge;
            this.height = height;
            this.width = width;
        }

        public String getId() {return id; }
        public int getInchesFromLeftEdge() { return inchesFromLeftEdge; }
        public int getInchesFromTopEdge() { return inchesFromTopEdge; }
        public int getHeight() { return height; }
        public int getWidth() { return width; }
    }


}

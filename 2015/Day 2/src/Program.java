import java.util.List;

public class Program {

    public static void main(String[]args){
        String filePath = null;
        filePath  = args.length == 0 ? "src/wrappingPaperData.txt": args[0];

        DataParser dataParser = new DataParser();
        List<Dimensions> allDimensions = dataParser.readFile(filePath);

        int totalWrappingPaperAndRibbon = 0;
        for(Dimensions d : allDimensions){
            //totalWrappingPaperAndRibbon += d.totalPaperRequiredForDimensions();
            totalWrappingPaperAndRibbon += d.totalRibbonRequired();
        }
        System.out.println(totalWrappingPaperAndRibbon);
    }
}

public class Dimensions {

    private int width;
    private int height;
    private int length;


    public int getLength() { return length; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setLength(int length) { this.length = length; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    public Dimensions(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int findSmallestDimension(){
        int firstDimension = (length*width);
        int secondDimension = (width*height);
        int thirdDimension = (height*length);

        if(firstDimension <= secondDimension && firstDimension <= thirdDimension) return firstDimension;
        if(secondDimension <= firstDimension && secondDimension <= thirdDimension) return secondDimension;
        if(thirdDimension <= firstDimension && thirdDimension <= secondDimension) return thirdDimension;

        return firstDimension;//all are equal
    }

    public int calculateSurfaceArea(){
        //2*l*w + 2*w*h + 2*h*l
        return (2*length*width) + (2*width*height) + (2*height*length);
    }

    public int totalPaperRequiredForDimensions(){
        int total = calculateSurfaceArea();
        total += findSmallestDimension();
        return total;
    }
}

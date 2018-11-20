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

    public int findSmallestArea(){
        return findSmallestDimension(length * width, width * height, height * length);
    }

    private int findSmallestDimension(int i, int i2, int i3) {

        if((i) <= (i2) && (i) <= (i3)) return (i);
        if((i2) <= (i) && (i2) <= (i3)) return (i2);
        return (i3);

    }

    public int findSmallestPerimeter(){
        return findSmallestDimension(length+width, width+height, height+length);
    }

    public int calculateSurfaceArea(){
        //2*l*w + 2*w*h + 2*h*l
        return (2*length*width) + (2*width*height) + (2*height*length);
    }

    public int calculateVolume(){
        return length*width*height;
    }
    public int totalRibbonRequired(){
        int total = 2* findSmallestPerimeter();
        total += calculateVolume();
        return total;
    }

    public int totalPaperRequiredForDimensions(){
        int total = calculateSurfaceArea();
        total += findSmallestArea();
        return total;
    }
}

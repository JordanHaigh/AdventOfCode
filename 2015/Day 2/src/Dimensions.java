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
}

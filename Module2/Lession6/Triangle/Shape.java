public class Shape {
    private String color = "black";
    private int sides = 3;

    public Shape() {
    }

    public Shape(int sides) {
        this.sides = sides;
    }

    public Shape(String color) {
        this.color = color;
    }

    public Shape(String color, int sides) {
        this.color = color;
        this.sides = sides;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    @Override
    public String toString() {
        return "Shape: color = " + color;
    }
}

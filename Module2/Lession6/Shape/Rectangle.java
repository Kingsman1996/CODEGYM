public class Rectangle extends Shape {
    private double width = 1.0d;
    private double length = 1.0d;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * Math.PI * width;
    }

    @Override
    public String toString() {
        return "A Rectangle with width= "
                + getWidth() + " and length= "
                + getLength() + ", which is a subclass of "
                + super.toString();
    }
}

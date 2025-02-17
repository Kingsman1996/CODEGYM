public class Triangle extends Shape {
    private double side1 = 1.0d;
    private double side2 = 1.0d;
    private double side3 = 1.0d;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2) + Math.pow(side3, 2));
    }

    public double getPerimeter() {
        return 2 * Math.PI * side1 + 2 * Math.PI * side2 + 2 * Math.PI * side3;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", side1 = " + side1
                + ", side2 = " + side2
                + ", side3 = " + side3
                + ", Area = " + getArea()
                + ", Perimeter = " + getPerimeter();
    }
}

public class Circle {
    private double radius = 1.0d;
    private String color = "red";

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    Circle(double radius) {
        this.radius = radius;
    }

    Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public String toString() {
        return "Circle: radius = " + getRadius() + ", color = " + getColor()
                +", Area " + getArea() ;

    }
}


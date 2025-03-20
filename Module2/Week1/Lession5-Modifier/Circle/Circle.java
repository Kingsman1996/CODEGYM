class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    private double getArea() { // Lỗi khi đặt private
        return Math.PI * radius * radius;
    }
}

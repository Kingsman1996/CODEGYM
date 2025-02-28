public class Square extends Rectangle implements Colorable {
    Square() {
    }

    Square(double side) {
        super(side, side);
    }

    @Override
    public void howToColor() {
        System.out.println(", 4 sides colored");
    }
    @Override
    public String toString() {
        return "A Square, area = " + getArea();
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        try {
            shapes[0] = ShapeFactory.createShape("circle");
            shapes[1] = ShapeFactory.createShape("rectangle");
            shapes[2] = ShapeFactory.createShape("square");
            shapes[3] = ShapeFactory.createShape("triangle");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        for (Shape item : shapes) {
            if (item != null) {
                item.draw();
            }
        }
    }
}

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        moveablePoint.setXY(7, 8);
        moveablePoint.setSpeed(10, 10);
        System.out.println(moveablePoint.toString());
        moveablePoint.move();
        System.out.println(moveablePoint.toString());
    }
}

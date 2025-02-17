public class Fan {
    public final int SLOW = 1;
    public final int MEDIUM = 2;
    public final int FAST = 3;
    private int speed = 1;
    private boolean isOn = false;
    private double radius = 5.0d;
    private String color = "blue";

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean on) {
        this.isOn = on;
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


    public String toString() {
        if (isOn) {
            return "Speed: " + this.speed + ", Radius: " + this.radius + ", Color: " + this.color + ", fan is on";
        }
        return "Radius: " + this.radius + ", Color: " + this.color + ", fan is off";
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setIsOn(true);
        fan1.setRadius(10.0d);
        fan1.setColor("yellow");
        fan1.setSpeed(3);
        System.out.println(fan1.toString());
        Fan fan2 = new Fan();
        fan2.setSpeed(2);
        System.out.println(fan2.toString());
    }
}

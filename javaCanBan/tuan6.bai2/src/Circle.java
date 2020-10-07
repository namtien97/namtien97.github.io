public class Circle extends GeometricObject {
    private double radius;
    private final double PI = 3.14;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public int getArea() {
        return (int)(Math.pow(radius, 2) * PI);
    }
}

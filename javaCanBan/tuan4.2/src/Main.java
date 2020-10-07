public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(1, 2, 40, 4);
        Rectangle rectangle2 = new Rectangle(4, 4, 35.9, 3.5);
        String result = RectangleCompare.rectangleCompare(rectangle1, rectangle2);
        System.out.println(result);
    }
}


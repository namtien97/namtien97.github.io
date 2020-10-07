package tuan4;

public class Main {
    public static void main(String [] args){
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setWidth(40);
        rectangle1.setHeight(4);
        System.out.println(rectangle1.getArea());
        System.out.println(rectangle1.getPerimeter());

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setWidth(35.9);
        rectangle2.setHeight(3.5);
        System.out.println(rectangle2.getArea());
        System.out.println(rectangle2.getPerimeter());
    }
}

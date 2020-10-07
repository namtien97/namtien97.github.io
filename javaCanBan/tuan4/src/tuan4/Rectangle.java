package tuan4;

public class Rectangle {
    private double width;
    private double height;

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return width * 2 + height * 2;
    }

    public void setWidth(double width){
        this.width=width;
    }

    public void setHeight(double height){
        this.height = height;
    }
}

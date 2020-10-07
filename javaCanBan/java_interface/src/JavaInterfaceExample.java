//interface trong java
//mục đích: đạt được tính trừu tượng hoàn toàn

public class JavaInterfaceExample {
    public static void main (String[]args){
        Animal animal = new Fish();
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();

        animal1.sleep();
        animal2.sleep();
        animal.eat();
    }
}

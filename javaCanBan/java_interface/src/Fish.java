public class Fish implements Animal {
    @Override
    public void move() {
        System.out.println("Fish is swimming");
    }

    @Override
    public void eat() {
        System.out.println("Fish like worm");
    }

    @Override
    public void sleep() {
        System.out.println("Fish sleep when she is stopped");
    }
}

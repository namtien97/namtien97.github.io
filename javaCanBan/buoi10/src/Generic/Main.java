package Generic;

public class Main {
    public static void main(String[] args) {
        Pair<String, String> one = new Pair<>("One", "So 1");
        Pair<String, String> cat = new Pair<>("Cat", "Con meo");
        Pair<String, String> dog = new Pair<>("Dog", "Con cho");

        Pair<String, Integer> iphone12 = new Pair<>("Iphone 12", 12_000_000);

        Person male = new Person("Hung");
        Person female = new Person("Ha");

        Pair<Person, Person> couple1 = new Pair<>(male, female);

       System.out.println(one.getKey() + " - " + one.getValue());
    }
}

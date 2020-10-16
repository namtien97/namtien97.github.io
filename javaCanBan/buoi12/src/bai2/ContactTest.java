package bai2;

public class ContactTest {
    public static void test() {
        var book1 = new AddressBookV1();
        book1.add(new Person("da",20,'m'));
        book1.add(new Person("da",20,'m'));
        book1.add(new Person("da",20,'m'));

        System.out.println(book1.search("a"));
        System.out.println(book1.sort());

    }
}

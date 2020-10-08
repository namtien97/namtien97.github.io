package bai2;

import java.util.HashMap;
import java.util.Map;

public class AddressBookV2 implements AddressBook<Person> {
    private int size;

    public AddressBookV2(int size) {
        this.size = size;
    }

    Map<String, Person> personMap = new HashMap<>();

    @Override
    public void add(String k, Person o) {
        personMap.put(k, o);
    }

    @Override
    public Person search(String o) {
        return null;
    }

    @Override
    public void sort() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

package bai2;

import java.util.ArrayList;
import java.util.Collections;


public class AddressBookV1 implements AddressBook<Person> {

    ArrayList<Person> person = new ArrayList<>();

    @Override
    public void add(Person newPerson, Object o2) {
        person.add(newPerson);
    }

    @Override
    public Person search(String name) {
        Person result = null;
        for (int i = 0; i < person.size(); i++) {
            if (person.contains(name)) {
                result = person.get(i);
            } else {
                continue;
            }
        }
        return result;
    }

    @Override
    public void sort() {
        Collections.sort(person);
    }



    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

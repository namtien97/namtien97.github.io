package bai2;

import java.util.*;

public class AddressBookV2 implements AddressBook<Person> {
    private Map<Integer, Person> map;
    private static int index;

    public AddressBookV2(int size) {
        map = new HashMap(size);
    }


    @Override
    public void add(Person o) {
        map.put(index++, o);
    }

    @Override
    public boolean search(String name) {
        for(var item:map.entrySet()){
            if(item.getValue().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Person> sort() {
        Person[] sortedList = (Person[])map.values().toArray();
        var sorted = (Arrays.asList(sortedList));
        Collections.sort(sorted);
        return sorted;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

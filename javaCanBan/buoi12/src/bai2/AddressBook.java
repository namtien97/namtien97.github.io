package bai2;

import java.util.List;

public interface AddressBook<T> extends Comparable<T> {

    void add(T o);

    boolean search(String name);

    List<T> sort(int compareAttribute);
}

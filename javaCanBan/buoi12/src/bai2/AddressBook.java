package bai2;

public interface AddressBook<?> extends Comparable<?> {

    void add(K key, V value);

    K search(K V);

    void sort();
}

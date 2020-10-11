package bai2;

import java.util.Comparator;

public class getComparator {
    public Comparator getComparator(String name) {
        return new NameComparator();
    }

    public Comparator getComparator(int age) {
        return new AgeComparator();
    }
}

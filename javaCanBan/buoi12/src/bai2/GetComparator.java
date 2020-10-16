package bai2;

import java.util.Comparator;

public class GetComparator {
    public Comparator getComparator(String name) {
        return new NameComparator();
    }

    public Comparator getComparator(int comparaAtributte) {
        return new AgeComparator();
    }
}

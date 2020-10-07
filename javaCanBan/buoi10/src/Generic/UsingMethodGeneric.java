package Generic;

public class UsingMethodGeneric {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        Double[] arr2 = new Double[]{1.2, 2.3, 3.3};
        String[] strings = new String[]{"One", "Two", "Three"};
        Person[] people = new Person[]{new Person("A"), new Person("Ha")};

        MethodGeneric.sort(people);

        MethodGeneric.showArray(arr1);
        MethodGeneric.showArray(arr2);
        MethodGeneric.showArray(strings);
        MethodGeneric.showArray(people);
    }

}

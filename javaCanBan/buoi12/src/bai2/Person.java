package bai2;

import java.util.Comparator;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private char sex;
    private int compareAttribute;

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        return compare(o, compareAttribute);
    }

    private int compare(Person o, int compareAttribute) {
        if (compareAttribute == 1) {
            return this.getAge() - o.getAge();
        } else {
            return this.getName().compareTo(o.getName());
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex + "\n";
    }

    public void setCompareAttribute(int compareAttribute) {
        this.compareAttribute = compareAttribute;
    }

    private Comparator getComparator(int compareAttribute)
}

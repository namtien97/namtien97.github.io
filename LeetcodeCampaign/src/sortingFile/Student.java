package sortingFile;

public class Student implements Comparable {
    public String fullName;
    public int age;
    public int GPA;

    public Student(String fullName, int age, int GPA) {
        this.fullName = fullName;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' + "\t" + ",age = " + age + " , \t GPA = " + GPA + "}";
    }

    @Override
    public int compareTo(Object o) {
        return this.fullName.compareTo(((Student)o).fullName);
    }
}

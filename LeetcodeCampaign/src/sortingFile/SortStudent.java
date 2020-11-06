package sortingFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudent {
    public static void main(String[] args) {
        SoSanhTuoi sst = new SoSanhTuoi();
        SoSanhGPA ssGPA = new SoSanhGPA();
        List<Student> class01 = new ArrayList<>();
        class01.add(new Student("Pham Van A", 10, 1));
        class01.add(new Student("Pham Van S", 9, 2));
        class01.add(new Student("Pham Va D", 5, 3));
        class01.add(new Student("Pham Van B", 10, 4));
        class01.add(new Student("Pham Van G", 5, 5));
        class01.add(new Student("Pham Van H", 4, 6));
        class01.add(new Student("Pham Van J", 10, 7));
        class01.add(new Student("Pham Van K", 2, 8));
        class01.add(new Student("Pham Van L", 1, 9));
        class01.add(new Student("Pham Van P", 7, 10));

        String task1 = "#1. Sắp xếp học sinh theo fullName, nếu giống fullName thì ai nhiều tuổi hơn thì đứng trước: ";
        class01.sort(Student::compareTo);
        class01.sort(sst);

        System.out.println(task1);
        for (int i = 0; i < class01.size(); i++) {
            System.out.println(i + ")" + class01.get(i));
        }

        String task2 = "\n\n#2. Sắp xếp học sinh theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần ";
        class01.sort(sst);
        class01.sort(ssGPA);

        System.out.println(task2);
        for (int i = 0; i < class01.size(); i++) {
            System.out.println(i + ")" + class01.get(i));
        }

        String task3 = "\n\n#3. Sắp xếp theo tên";
        class01.sort(Student::compareTo);

        System.out.println(task3);
        for (int i = 0; i < class01.size(); i++) {
            System.out.println(i + ")"+class01.get(i));
        }
    }
}


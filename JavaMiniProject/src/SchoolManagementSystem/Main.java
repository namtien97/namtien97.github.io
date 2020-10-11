package SchoolManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var ha = new Teacher("Ha", 5_000_000);
        var hao = new Teacher("Hao", 6_000_000);
        var thao = new Teacher("Thao", 7_000_000);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(thao);
        teacherList.add(hao);
        teacherList.add(ha);

        var nam = new Student("Nam", 4);
        var lam = new Student("Lam", 5);
        var cam = new Student("Cam", 5);

        List<Student> studentList = new ArrayList<>();
        studentList.add(cam);
        studentList.add(nam);
        studentList.add(lam);

        var tqt = new School(teacherList, studentList);

        cam.payFees(10_000_000);
        cam.payFees(10_000_000);
        cam.payFees(10_000_000);



        ha.receiveSalary(ha.getSalary());
        System.out.println("Total money earned: "+tqt.getTotalMoneyEarned());
        System.out.println("Total profit: "+tqt.getTotalProfit());




    }
}

package sortingFile;

import java.util.Comparator;
public class SoSanhGPA implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.GPA==o2.GPA){
            return 0;
        }else if(o1.GPA>o2.GPA){
            return 1;
        }else{
            return -1;
        }
    }
}

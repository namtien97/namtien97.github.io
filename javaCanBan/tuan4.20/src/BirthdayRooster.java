import java.text.ParseException;

public class BirthdayRooster {
    public static void main(String[] args) throws ParseException {
        Employee employee1 = new Employee("Chu Chi Cuong", "7/8/1974", "IT");
        Date dateEmployye1 = new Date();
        String date1 = dateEmployye1.dayOfWeek(employee1.getDatePerson());
        Employee employee2 = new Employee("Nguyen Xuan Phuc", "4/29/1980", "AC");
        Date dateEmployye2 = new Date();
        String date2 = dateEmployye2.dayOfWeek(employee2.getDatePerson());
        Employee employee3 = new Employee("Pham Sy Tam", "10/25/1991", "HR");
        Date dateEmployye3 = new Date();
        String date3 = dateEmployye3.dayOfWeek(employee3.getDatePerson());
        System.out.println(employee1 + date1 + "\n");
        System.out.println(employee2 + date2 + "\n");
        System.out.println(employee3 + date3 + "\n");
    }
}

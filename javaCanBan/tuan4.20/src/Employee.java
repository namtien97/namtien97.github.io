public class Employee extends Person {
    private String department;
    private int idEmployee;
    private static int idTemp = 1;

    public Employee(String name, String datePerson, String department) {
        super(name, datePerson);
        this.department = department;
        this.idEmployee = idTemp++;
    }


    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {

        String stringEmployee = String.format("ID: " + getIdEmployee() + "\n" + "Department: " + getDepartment() + "\n" + "Name: " + getName() + "\n" + "BirthDate: " + getDatePerson() + " ");
        return stringEmployee;
    }
}

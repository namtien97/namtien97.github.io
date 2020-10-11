package SchoolManagementSystem;

public class Teacher {
    private int id;
    private String name;
    private int salary;
    private int salaryEared;
    private static int idAutoIncrease = 1;

    public Teacher(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.salaryEared = 0;
        this.id = idAutoIncrease++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void receiveSalary(int salary) {
        salaryEared = +salary;
        School.updateTotalMoneySpent(salary);
    }

    @Override
    public String toString() {
        return "Name of teacher: " + name + "\nTotal salary earned so far: " + salaryEared + "VND";
    }
}

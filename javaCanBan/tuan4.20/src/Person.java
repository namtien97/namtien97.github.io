import java.text.SimpleDateFormat;

public class Person {

    private String name;
    private String datePerson;

    public Person(String name,String datePerson) {
        this.name = name;
        this.datePerson = datePerson;
    }

    public String getDatePerson() {
        return datePerson;
    }

    public void setDatePerson(String datePerson) {
        datePerson = datePerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    @Override
    public String toString() {
        String stringPerson = String.format("Name: " + getName() + "\n" + "BirthDate: " + getDatePerson());
        return stringPerson;
    }
}

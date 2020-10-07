package bai3;

public class Staff {
    StaffMember[] staffList = {new Volunteer("Nam", "Ha Noi", "0985823686", "1212", 0),
            new Employee("Nam", "Ha Noi", "0985823686", "1212", 7_000_000),
            new Executive("Nam", "Ha Noi", "0985823686", "1212", 7_000_000),
            new Hourly("Nam", "Ha Noi", "0985823686", "1212", 200, 100)
    };

    public void payday(){
        for(int i = 0;i<staffList.length;i++){
            staffList[i].pay();
            System.out.println(staffList[i]);
        }
    }
}

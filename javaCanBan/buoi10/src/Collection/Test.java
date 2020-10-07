package Collection;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void run() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ha"));
        users.add(new User("Thanh1"));
        for (var user : users) {
            System.out.println(user);
        }
    }
}

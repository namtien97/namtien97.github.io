package bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AddressBookV1 implements AddressBook<Person> {

    private ArrayList<Person> list;

    public AddressBookV1() {
        this.list = new ArrayList<>();
    }



    @Override
    public void add(Person o) {
        list.add(o);
    }

    @Override
    public boolean search(String name) {
       for(var item:list){
           if(item.getName().contains(name)){
               return true;
           }
       }
        return false;
    }

    @Override
    public List<Person> sort() {
        Collections.sort(list);
        return list;
    }



    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

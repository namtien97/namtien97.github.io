package SalesApplication;

import java.util.ArrayList;
import java.util.List;

public class Sale implements SaleLoop {
    public List<Customer> customerList = new ArrayList<>();
    public List<Supplier> supplierList = new ArrayList<>();

    @Override
    public void decreaseMoney() {

    }

    @Override
    public void increaseMoney() {

    }
}

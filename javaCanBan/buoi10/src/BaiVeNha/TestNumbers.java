package BaiVeNha;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestNumbers {
    public static void test() {
        List<ComparableNumber<?>> list= new ArrayList<>();

        var doubleNumber1 = new DoubleNumber(7.5);
        var doubleNumber2 = new DoubleNumber(8.5);

        var rationalNum1 = new RationalNumber(-3,9);
        var rationalNum2 = new RationalNumber(6,8);

        list.add(doubleNumber1);
        list.add(doubleNumber2);

        list.add(rationalNum1);
        list.add(rationalNum2);

        Collections.sort(list);

        System.out.println(list);
    }
}

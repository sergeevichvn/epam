package Ver2;

import java.util.List;

/**
 * Class Employee;
 * Created by nazarov on 21.01.2015.
 */
public class Employee {
    private String lastname;
    private Menu menu;
    private Bill bill = new Bill();

    public Employee(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void getMenu(Menu menu) {
        this.menu = menu;
    }

    //order dish
    public void addDishInBill(Dish dish) {
        bill.addDishInBill(dish);
    }

    //get count order dish
    public int getCountDish(Dish dish) {
        return bill.getCountDish(dish);
    }

    public List<Dish> getListDish() {
        return bill.getListDish();
    }

    //return toString object Bill
    public String getToStringBill() {
        return bill.toString();
    }

    @Override
    public String toString() {
        return "Employee[" +
                "lastname=" + lastname + ";"
                + getToStringBill() + ']';
    }
}
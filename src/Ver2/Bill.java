package Ver2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  Class Bill.
 *  Bill about pay, which is received by employee.
 *  Created by nazarov 1.02.2015
 */
public class Bill {
    private Map<Dish, Integer> billMap = new HashMap<Dish, Integer>();

    
    public void addDishInBill(Dish dish) {
        int count = 1;
        for (Dish d : billMap.keySet()) {
            if (d.getName().contentEquals(dish.getName())){
                count += billMap.get(d);
            }
        }

        billMap.put(dish, count);
    }

    
    public int getCountDish(Dish dish) {
        return billMap.get(dish);
    }

    
    public List<Dish> getListDish() {
        List<Dish> listKeySet = new ArrayList<Dish>();
        for (Dish dish : billMap.keySet()) {
            listKeySet.add(dish);
        }
        return listKeySet;
    }

    @Override
    public String toString() {
        String str = "Bill[billMap = ";
        for (Dish b : billMap.keySet()) {
            int count = billMap.get(b);
            str += b.getName() + " - " + count + " шт.\n";
        }
        str += "]";
        return str;
    }
}

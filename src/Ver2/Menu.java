package Ver2;

import java.util.HashMap;

/**
 * Class Menu.
 * Menu with dishes;
 * Created by nazarov on 1.02.2015.
 */
public class Menu {
    private HashMap<String, Dish> mapMenu = new HashMap<String, Dish>();

  
    public void addDishInMenu(Dish dish) {
        mapMenu.put(dish.getName(), dish);
    }


    public Dish getDishFromMenu(String nameDish) {
        return mapMenu.get(nameDish);
    }

    public double getPriceDish(String dish) {
        return mapMenu.get(dish).getPrice();
    }
    
    @Override
    public String toString() {
        String str = "Menu[mapMenu.keySet;value = \n";
        Dish dish = null;
        for (String s : mapMenu.keySet()) {
            dish = mapMenu.get(s);
            str += s + "; " + dish.toString() + "; \n";
        }
        str += "]";
        return str;
    }

}

package Ver2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;

/*
 * The programm assistant orders lunches in office.
 * Created by nazarov on 1.02.2015
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	
        List<Employee> employees = DataBase.exportEmployee();
        Menu menu = DataBase.exportDish();
        Map<Dish, Integer> billForCookShop;
        List<Dish> dishes;

        //give to all employees of the menu
        getMenu(employees, menu);
  
        //do order
        employees.get(0).addDishInBill(menu.getDishFromMenu("Салат Изюминка"));
        employees.get(0).addDishInBill(menu.getDishFromMenu("Печень по королевски"));
        employees.get(0).addDishInBill(menu.getDishFromMenu("Рис отварной с маслом"));
        employees.get(0).addDishInBill(menu.getDishFromMenu("Рулет с изюмом"));
        employees.get(1).addDishInBill(menu.getDishFromMenu("Салат Лукошко"));
        employees.get(1).addDishInBill(menu.getDishFromMenu("Суп куриный с грибами"));
        employees.get(1).addDishInBill(menu.getDishFromMenu("Свинина запеченная \"По-гусарский\""));
        employees.get(1).addDishInBill(menu.getDishFromMenu("Макароны отварные"));
        employees.get(1).addDishInBill(menu.getDishFromMenu("Пирог с яблоками"));
        employees.get(2).addDishInBill(menu.getDishFromMenu("Суп болгарский вегетарианский"));
        employees.get(2).addDishInBill(menu.getDishFromMenu("Рыбное филе с помидоркой"));
        employees.get(2).addDishInBill(menu.getDishFromMenu("Рулет с изюмом"));
        employees.get(2).addDishInBill(menu.getDishFromMenu("Пирог с повидлом"));
        employees.get(3).addDishInBill(menu.getDishFromMenu("Салат Изюминка"));
        employees.get(3).addDishInBill(menu.getDishFromMenu("Суп куриный с грибами"));
        employees.get(3).addDishInBill(menu.getDishFromMenu("Печень по королевски"));
        employees.get(3).addDishInBill(menu.getDishFromMenu("Макароны отварные"));
        employees.get(3).addDishInBill(menu.getDishFromMenu("Пирог с повидлом"));

        //time to pay :))
        billForCookShop = getBillForCookShop(employees);
        
        printBillForCookShop(billForCookShop);
        getBill(employees);  
        
        //get list ready dishes
        dishes = DishFactory.createDish(billForCookShop);
        printDish(dishes);
        
    }

    //get bill for employee
    private static void getBill(List<Employee> employees) {
        double fullPrice = 0;
        System.out.println("\nОтчет №2");
        System.out.format("\n%s%40s%30s\n", "Фамилия сотрудника", "Название блюда/цена/кол-во", "Стоимость");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee.getLastname());
            for (Dish dish : employee.getListDish()) {
                int countDish = employee.getCountDish(dish);
                fullPrice += countDish * dish.getPrice();
                System.out.format("%45s / %s руб. / %s шт. ", dish.getName(), dish.getPrice(), countDish);
                System.out.println();
            }
            System.out.format("%70s Итого: %s руб.\n", "", fullPrice);
            System.out.println("-------------------------------------------------------------------------------------------");
            fullPrice = 0;
        }
    }

    //get bill for cookshop
    private static Map<Dish, Integer> getBillForCookShop(List<Employee> employees) {
        Map<Dish, Integer> dishMap = new HashMap<Dish, Integer>();

        for (Employee employee : employees) { //take every employee
            for (Dish dish : employee.getListDish()) { //get all order dishes from his bill
                int countDish = employee.getCountDish(dish); //count one dish
                if (dishMap.containsKey(dish)) { //if in dishMap there exists such a dish
                    int countDishFromMap = dishMap.get(dish); //get count dishes from dishMap
                    dishMap.put(dish, countDish + countDishFromMap);
                } else {
                    dishMap.put(dish, countDish); //if there exists such dish, create this dish 
                }
            }
        }

        return dishMap;
    }

    //print bill for cook shop
    private static void printBillForCookShop(Map<Dish, Integer> dishMap){
    	double fullPrice = 0;
    	
    	System.out.println("Отчет №1");
        System.out.format("\n%s%30s%20s\n", "Название блюда", "Кол-во", "Стоимость");
        System.out.println("-----------------------------------------------------------------");
        
        for (Dish dish : dishMap.keySet()) { //take every order dishes
            int countDish = dishMap.get(dish); //get count dishes
            double priceDish = dish.getPrice() * countDish; 

            System.out.format("%5s\n%40s шт. \n%60s руб.\n", dish.getName(), countDish, priceDish);
            fullPrice += priceDish; 
        }
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Итого: " + fullPrice + " руб.");
        System.out.println("-----------------------------------------------------------------");
    }

    //distribute menu
    private static void getMenu(List<Employee> employees, Menu menu) {
    	for(Employee employee: employees){
    		employee.getMenu(menu);
    	}
    } 
    
    //print prepare dish
    private static void printDish(List<Dish> listDish){
    	System.out.println("Приготовленные блюда: ");
    	for(Dish dish: listDish)
    		System.out.println(dish.getName() + "; ");
    }
}

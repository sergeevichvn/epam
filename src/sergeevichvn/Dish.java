package sergeevichvn;

/**
 * Class Dish;
 * Created by nazarov on 1.02.2015.
 */
public class Dish {
    private String name;
    private double weight;
    private double price;


    Dish(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dish[" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ']';
    }
}

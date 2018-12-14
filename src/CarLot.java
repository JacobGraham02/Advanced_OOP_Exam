//@author Nicholas Gardner, 200349007
import java.util.*;

public class CarLot {

    private TreeMap<String, TreeSet<Car>> carLot;

    /**
     * constructor for CarLot
     *
     * @param carLot
     */
    public CarLot(TreeMap<String, TreeSet<Car>> carLot)
    {
        this.carLot = carLot;
    }

    /**
     * returns a Set of Strings representing the brands of cars in the lot
     */
    public Set<String> getBrands()
    {
        return carLot.keySet();
    }

    /**
     * accepts a String, and returns a TreeSet of cars representing the cars in the lot of the given brand
     *
     * @param brand
     */
    public TreeSet<Car> getCars(String brand)
    {
        if (brand == "All Brands")
        {
            TreeSet<Car> list = new TreeSet<>();
            for(String str: carLot.keySet())
            {
                list.addAll(carLot.get(str));
            }
            return list;
        }
        else
        {
            return carLot.get(brand);
        }
    }

    /**
     * accepts a Car, removes that car from the lot
     *
     * @param car
     */
    public void sellCar(Car car)
    {
        carLot.get(car.getBrand()).remove(car);
    }

    /**
     * accepts a String, and returns a String of representing total price of all cars of that given brand
     */
    public String getInventoryValue(String brand)
    {
        if (brand == "All Brands")
        {
            TreeSet<Car> list = new TreeSet<>();
            for(String str: carLot.keySet())
            {
                list.addAll(carLot.get(str));
            }
            return ""+list.stream().mapToDouble(car -> car.getPriceDouble()).sum();
        }
        else
        {
            return ""+carLot.get(brand).stream().mapToDouble(car -> car.getPriceDouble()).sum();
        }
    }
}

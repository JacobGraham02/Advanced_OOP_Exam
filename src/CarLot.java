import java.util.*;

public class CarLot {

    private TreeMap<String, TreeSet<Car>> carLot;

    public CarLot(TreeMap<String, TreeSet<Car>> carLot)
    {
        this.carLot = carLot;
    }

    public Set<String> getBrands()
    {
        return carLot.keySet();
    }

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

    public void sellCar(Car car)
    {
        carLot.get(car.getBrand()).remove(car);
    }

    public double getInventoryValue(String brand)
    {
        if (brand == "All Brands")
        {
            TreeSet<Car> list = new TreeSet<>();
            for(String str: carLot.keySet())
            {
                list.addAll(carLot.get(str));
            }
            return list.stream().mapToDouble(car -> car.getPriceDouble()).sum();
        }
        else
        {
            return carLot.get(brand).stream().mapToDouble(car -> car.getPriceDouble()).sum();
        }
    }
}

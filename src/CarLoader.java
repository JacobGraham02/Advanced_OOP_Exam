import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class CarLoader {
    public static TreeMap<String, TreeSet<Car>> loadCars()
    {
        

        TreeMap<String, TreeSet<Car>> cars = new TreeMap<>();

        File file = new File("./src/cars.csv");
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);

            while (fileReader.hasNext())
            {
                String[] carInfo = fileReader.nextLine().split(",");
                if (!carInfo[0].equalsIgnoreCase("year"))
                {
                    int year = Integer.parseInt(carInfo[0]);
                    String make = carInfo[1];
                    String model = carInfo[2];
                    int kilo = Integer.parseInt(carInfo[3]);
                    double price = Double.parseDouble(carInfo[4]);

                    if (cars.get(make) == null)
                        cars.put(make, new TreeSet<>());

                    cars.get(make).add(new Car(year, make, model, kilo, price));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            if (fileReader != null)
                fileReader.close();
        }
        return cars;
    }
}

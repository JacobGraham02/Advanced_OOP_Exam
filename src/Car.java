// @author Nicholas Gardner, 200349007
import java.time.LocalDate;

public class Car implements Comparable<Car>{

    private int year, kilometer;
    private String brand, model;
    private double price;

    /**
     * constructor that builds the Car object
     * Accepts 5 arguments and calls the setters for the 5 coresponding values
     *
     * @param year
     * @param brand
     * @param model
     * @param kilometer
     * @param price
     */
    public Car(int year, String brand, String model, int kilometer, double price)
    {
        setYear(year);
        setBrand(brand);
        setModel(model);
        setKilometer(kilometer);
        setPrice(price);
    }

    /**
     * return an int representing the car's year value
     */
    public int getYear() {
        return year;
    }

    /**
     * accepts and int, and sets the car's year value to it
     *
     * @param year
     */
    public void setYear(int year) {
        if (year >= 1902 && year <= (LocalDate.now().getYear()+1))
        {
            this.year = year;
        }
        else
        {
            throw new IllegalArgumentException("wow, a car from the future! Does it fly?");
        }
    }

    /**
     * return an int representing the car's kilometers value
     */
    public int getKilometer() {
        return kilometer;
    }

    /**
     * sets the car's kilometers value
     * accepts an int, validates that it is greater than 0, and sets the car's kilometers value to it
     */
    public void setKilometer(int kilometer) {
        if (kilometer >= 0)
        {
            this.kilometer = kilometer;
        }
        else
        {
            throw new IllegalArgumentException("how does this car have negative kilometers?");
        }
    }

    /**
     * returns a String representing the car's brand value
     */
    public String getBrand() {
        return brand;
    }

    /**
     * sets the car's brand value
     * accepts a String, validates that it is no larger than 30 characters, and sets the car's brand value to it
     *
     * @param brand
     */
    public void setBrand(String brand) {
        if (brand.length() <= 30)
        {
            this.brand = brand;
        }
        else
        {
            throw new IllegalArgumentException("why is your brand name so long?");
        }
    }

    /**
     * returns a String representing the car's model value
     */
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (brand.length() <= 30)
        {
            this.model = model;
        }
        else
        {
            throw new IllegalArgumentException("why is your model name so long?");
        }
    }

    /**
     * returns a String representing the car's price value
     */
    public String getPrice() {
        return ""+price;
    }

    /**
     * returns a double representing the car's price value
     */
    public double getPriceDouble() {
        return price;
    }


    public void setPrice(double price) {
        if (price >= 0)
        {
            this.price = price;
        }
        else
        {
            throw new IllegalArgumentException("wow, you must really hate this car if you're trying to pay people to buy it off you");
        }
    }

    /**
     * compares the car to another car by brand, then by model
     * Accepts a Car as an argument
     *
     * @param o
     */
    @Override
    public int compareTo(Car o) {
        if (this.getBrand().compareToIgnoreCase(o.getBrand()) == 1)
        {
            return 1;
        }
        else if (this.getBrand().compareToIgnoreCase(o.getBrand()) == -1)
        {
            return -1;
        }
        else if (this.getModel().compareToIgnoreCase(o.getModel()) == 1)
        {
            return 1;
        }
        else if (this.getModel().compareToIgnoreCase(o.getModel()) == -1)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}

import java.time.LocalDate;

public class Car implements Comparable<Car>{

    private int year, kilometer;
    private String brand, model;
    private double price;

    public Car(int year, String brand, String model, int kilometer, double price)
    {
        setYear(year);
        setBrand(brand);
        setModel(model);
        setKilometer(kilometer);
        setPrice(price);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1902 && year < LocalDate.now().getYear())
        {
            this.year = year;
        }
        else
        {
            throw new IllegalArgumentException("wow, a car from the future! Does it fly?");
        }
    }

    public int getKilometer() {
        return kilometer;
    }

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

    public String getBrand() {
        return brand;
    }

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

    public String getPrice() {
        return ""+price;
    }

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

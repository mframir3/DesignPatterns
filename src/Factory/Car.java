package Factory;
public class Car {

    private int topSpeed;
    private String color;
    private int fuelMilage;
    private int seats;
    private CarType type;
    private int price;
    
    protected Car(CarType type, String color, int topSpeed, int fuelMilage, int seats, int price) {
        this.type = type;
        this.color = color;
        this.topSpeed = topSpeed;
        this.fuelMilage = fuelMilage;
        this.seats = seats;
        this.price = price;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public String getColor() {
        return color;
    }

    public int getFuelMilage() {
        return fuelMilage;
    }

    public int getSeats() {
        return seats;
    }

    public int getPrice() {
        return price;
    }
    
    public CarType getType() {
        return type;
    }
    
    public boolean isSport() {
        return false;
    }
    
    public boolean isHybrid() {
        return false;
    }
    
    public boolean isTruck() {
        return false;
    }
}

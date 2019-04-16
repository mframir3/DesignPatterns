package Factory;

public class Car {

    private int topSpeed;
    private Color color;
    private int mpg;
    private int seats;
    private CarType type;
    private int price;
    
    protected Car(CarType type, Color color, int topSpeed, int mpg, int seats, int price) {
        this.type = type;
        this.color = color;
        this.topSpeed = topSpeed;
        this.mpg = mpg;
        this.seats = seats;
        this.price = price;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public Color getColor() {
        return color;
    }

    public int getMpg() {
        return mpg;
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

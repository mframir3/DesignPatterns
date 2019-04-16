package Factory;

public class Truck extends Car {

    protected Truck(Color color, int price) {
        super(CarType.TRUCK, color, 140, 18, 4, price);
    }
    
    @Override
    public boolean isTruck() {
        return true;
    }
}

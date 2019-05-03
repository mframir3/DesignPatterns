package Factory;

public class HybridCar extends Car {
    
    protected HybridCar(Color color, int price) {
        super(CarType.HYBRID, color, 120, 46, 5, price);
    }
    
    @Override
    public boolean isHybrid() {
        return true;
    }
}

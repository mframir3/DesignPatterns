package Factory;

public class hybridCar extends Car{
    
    protected hybridCar(Color color, int price) {
        super(CarType.HYBRID, color, 120, 46, 5, price);
    }
    
    @Override
    public boolean isHybrid() {
        return true;
    }
}

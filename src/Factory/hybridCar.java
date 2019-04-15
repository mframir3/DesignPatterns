package Factory;

public class hybridCar extends Car{
    
    protected hybridCar(String Color, int price) {
        super(CarType.HYBRID, Color, 120, 46, 5, price);
    }
    
    @Override
    public boolean isHybrid() {
        return true;
    }
}

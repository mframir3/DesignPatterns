package Factory;

public class SportsCar extends Car{
    protected SportsCar(Color color, int price) {
        super(CarType.SPORT, color, 120, 24, 2, price);
    }
    
    @Override
    public boolean isSport() {
        return true;
    }
}

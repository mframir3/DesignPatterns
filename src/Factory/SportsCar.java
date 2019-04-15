package Factory;

public class SportsCar extends Car{
    protected SportsCar(String Color, int price) {
        super(CarType.SPORT, Color, 120, 24, 2, price);
    }
    
    @Override
    public boolean isSport() {
        return true;
    }
}

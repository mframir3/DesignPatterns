package Factory;

public class truck extends Car{

    protected truck(String Color, int price) {
        super(CarType.TRUCK, Color, 140, 18, 4, price);
    }
    
    @Override
    public boolean isTruck() {
        return true;
    }
}

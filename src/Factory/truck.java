package Factory;

public class truck extends Car{

    protected truck(Color color, int price) {
        super(CarType.TRUCK, color, 140, 18, 4, price);
    }
    
    @Override
    public boolean isTruck() {
        return true;
    }
}

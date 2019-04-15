package Factory;

public class CarFactory {
    private int price;
    private CarType model;
    public CarFactory(int price, CarType model) {
        this.price = price;
        this.model = model; 
    }
    
    public Car produce(String color) {
        if(model == CarType.SPORT) {
            return new SportsCar(color, price);
        }
        
        else if(model == CarType.HYBRID) {
            return new hybridCar(color, price);
        }
        
        else if(model == CarType.TRUCK) {
            return new truck(color, price);
        }
        
        return null;
    }
}

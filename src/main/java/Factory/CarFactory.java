package Factory;

public class CarFactory {
    private int price;
    private CarType model;
    
    public CarFactory(int price, CarType model) {
        this.price = price;
        this.model = model; 
    }
    
    /**Produce will create and return a car with the color specified.
     * @param color is a color of type Color
     * @return a car with model, price and color previously specified
     */
    public Car produce(Color color) {
        if (model == CarType.SPORT) {
            return new SportsCar(color, price);
        } else if (model == CarType.HYBRID) {
            return new HybridCar(color, price);
        } else if (model == CarType.TRUCK) {
            return new Truck(color, price);
        }
        
        return null;
    }
}

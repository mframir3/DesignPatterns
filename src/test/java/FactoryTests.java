import static org.junit.Assert.*;
import Factory.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactoryTests {
    CarFactory factory = new CarFactory(20000, CarType.SPORT);
    CarFactory factory1 = new CarFactory(20000, CarType.HYBRID);
    CarFactory factory2 = new CarFactory(20000, CarType.TRUCK);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFactorySportsCar() {
        Car car = factory.produce(Color.RED);
        assertTrue(car.getPrice() == 20000);
        assertTrue(car.getType() == CarType.SPORT);
        assertTrue(car.getMPG() == 24);
        assertTrue(car.getTopSpeed() == 220);
        assertTrue(car.getSeats() == 2);
        assertTrue(car.getColor() == Color.RED);
        assertTrue(car.isSport());
        assertTrue(!car.isHybrid());
        assertTrue(!car.isTruck());
    }

    @Test
    public void testFactoryHybridCar() {
        Car car = factory1.produce(Color.RED);
        assertTrue(car.getPrice() == 20000);
        assertTrue(car.getType() == CarType.HYBRID);
        assertTrue(car.getMPG() == 46);
        assertTrue(car.getTopSpeed() == 120);
        assertTrue(car.getSeats() == 5);
        assertTrue(car.getColor() == Color.RED);
        assertTrue(!car.isSport());
        assertTrue(car.isHybrid());
        assertTrue(!car.isTruck());
    }

    @Test
    public void testFactoryTrucks() {
        Car car = factory2.produce(Color.RED);
        assertTrue(car.getPrice() == 20000);
        assertTrue(car.getType() == CarType.TRUCK);
        assertTrue(car.getMPG() == 18);
        assertTrue(car.getTopSpeed() == 140);
        assertTrue(car.getSeats() == 4);
        assertTrue(car.getColor() == Color.RED);
        assertTrue(!car.isSport());
        assertTrue(!car.isHybrid());
        assertTrue(car.isTruck());
    }
}

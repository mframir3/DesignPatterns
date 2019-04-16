import static org.junit.Assert.*;
import Composite.*;
import Factory.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompositeTest {
    manufacturer shop = new manufacturer(CarType.HYBRID, "Honda", 20000, 400000);
    manufacturer child = new manufacturer(CarType.SPORT, "Honda2", 20000, 400000);
    manufacturer shop1 = new manufacturer(CarType.HYBRID, "Honda", 20000000, 400000);
    manufacturer child1 = new manufacturer(CarType.SPORT, "Honda2", 20000, 400000);
    
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
    public void testChild() {
        shop.addChild(child);
        child.addParent(shop);
        assertTrue(shop.owns(child));
        assertTrue(child.getParent() == shop);
        assertTrue(child.isChild());
    }
    
    @Test
    public void testProduce() {
        shop.produce(Color.RED);
        Car car = shop.getCarHold().get();
        assertTrue(car.getColor() == Color.RED);
    }
    
    @Test
    public void testRestock() {
        shop.restock();
        Car car = shop.getCarHold().get();
        assertTrue(car == null);
    }
    
    @Test
    public void testBuy() {
        shop1.buy(child1);
        assertTrue(shop1.owns(child1));
        assertTrue(child1.getParent() == shop1);
        assertTrue(child1.isChild());
    }

}

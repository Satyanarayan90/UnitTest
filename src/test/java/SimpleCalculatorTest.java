import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {
    @Test
    void twoPlusTwoIsFour(){
        SimpleCalculator simpleCalculator= new SimpleCalculator();
        //assertEquals(4,simpleCalculator.sum(2,2));
        //assertNotEquals(5,simpleCalculator.sum(2,2));
        assertTrue(simpleCalculator.sum(2,2));
    }
}
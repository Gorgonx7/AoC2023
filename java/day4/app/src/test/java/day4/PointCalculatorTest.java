package day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PointCalculatorTest {
    public void initCountTest(){

    }
    @Test public void TestPointCalc(){
        PointCalculator.ticket_count.put(1, 1);
        PointCalculator.ticket_count.put(2, 1);
        PointCalculator.ticket_count.put(3, 1);
        PointCalculator.ticket_count.put(4, 1);
        PointCalculator.ticket_count.put(5, 1);
        PointCalculator.calculatePoints("Card 1: 41 48 83 86 17 | 83 86 6 31 17  9 48 53");
        assertEquals(PointCalculator.ticket_count.get(1), 1);
        assertEquals(PointCalculator.ticket_count.get(2), 2);
        assertEquals(PointCalculator.ticket_count.get(3), 2);
        assertEquals(PointCalculator.ticket_count.get(4), 2);
        assertEquals(PointCalculator.ticket_count.get(5), 2);
        PointCalculator.calculatePoints("Card       2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19");
        assertEquals(PointCalculator.ticket_count.get(1), 1);
        assertEquals(PointCalculator.ticket_count.get(2), 2);
        assertEquals(PointCalculator.ticket_count.get(3), 4);
        assertEquals(PointCalculator.ticket_count.get(4), 4);
        assertEquals(PointCalculator.ticket_count.get(5), 2);

    }
    @Test public void TestCountInit(){
        PointCalculator.init_ticket_count();
        assertEquals(189, PointCalculator.ticket_count.size());
        assertEquals(1, PointCalculator.ticket_count.get(1));
        assertEquals(1, PointCalculator.ticket_count.get(189));

    }
}

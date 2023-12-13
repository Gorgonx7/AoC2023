package day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PointCalculatorTest {
    @Test public void TestPointCalc(){
        assertEquals(8, PointCalculator.calculatePoints("Card 1: 41 48 83 86 17 | 83 86 6 31 17  9 48 53"));
    }
}

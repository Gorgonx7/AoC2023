package day2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RoundTest {
    @Test public void roundIsPossible(){
        Round round = new Round(2,5,1);
        assertTrue(round.isPossible(2, 5, 1));
    }
     @Test public void roundIsNotPossible(){
        Round round = new Round(2,5,1);
        assertFalse(round.isPossible(1, 5, 1));
    }
    @Test public void addFiveRed(){
        Round round = new Round();
        round.add(Colour.RED,5);
        int result = round.get(Colour.RED);
        assertEquals(5, result);
    }
    @Test public void addSevenBlue(){
        Round round = new Round();
        round.add(Colour.BLUE,7);
        int result = round.get(Colour.BLUE);
        assertEquals(7, result);
    }
    @Test public void addTwoGreen(){
        Round round = new Round();
        round.add(Colour.GREEN,2);
        int result = round.get(Colour.GREEN);
        assertEquals(2, result);
    }
}

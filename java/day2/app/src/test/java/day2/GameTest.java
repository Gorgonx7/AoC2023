package day2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {
    @Test 
    public void addRoundAddsARound(){
        Game game = new Game(1);
        game.addRound(new Round());
        assertEquals(1, game.getNumberOfRounds());
    }
    @Test
    public void getIDReturnsID(){
        Game game = new Game(4);
        assertEquals(4, game.getID());
    }
    @Test
    public void isPossibleIsTrue(){
        Game game = new Game(1);
        game.addRound(new Round(2,5,10));
        game.addRound(new Round(3,5,9));
        assertTrue(game.isPossible(3,5,10));
    }
     @Test
    public void isPossibleIsFalse(){
        Game game = new Game(1);
        game.addRound(new Round(2,5,10));
        game.addRound(new Round(3,5,9));
        assertFalse(game.isPossible(2,5,10));
    }
}

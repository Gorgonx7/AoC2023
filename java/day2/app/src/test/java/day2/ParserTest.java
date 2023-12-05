package day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParserTest {
    @Test public void idIsParsedCorrectly(){
        Game game = Parser.getGame("Game 19: 6 red, 9 green; 1 blue, 4 red; 12 green; 5 green, 2 blue, 9 red");
        assertEquals(19, game.getID());
    }
    @Test public void testRoundsParsedCorrectly(){
        Game game = Parser.getGame("Game 19: 6 red, 9 green; 1 blue, 4 red; 12 green; 5 green, 2 blue, 9 red");
        assertEquals(4, game.getNumberOfRounds());
    }
    @Test public void testRoundsParsedColoursCorrectly(){
        Game game = Parser.getGame("Game 19: 6 red, 9 green; 1 blue, 4 red; 12 green; 5 green, 2 blue, 9 red");
        Round round = game.getRound(0);
        assertEquals(6, round.get(Colour.RED));
        assertEquals(9, round.get(Colour.GREEN));
    }
}

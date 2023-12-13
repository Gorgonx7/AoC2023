package day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class TestState {
    @Test public void TestContainsSpecialCharacter(){
        State testState = new State();
        boolean result = testState.containsSpecialCharacter("*");
        assertTrue(result);
        result = testState.containsSpecialCharacter("R");
        assertFalse(result);
        result = testState.containsSpecialCharacter("%");
        assertFalse(result);
    }
    @Test public void TestReadInStateNoState(){
        ArrayList<String> worldMap = new ArrayList<String>();
        State testState = new State(worldMap);
        assertEquals(new HashMap<Integer, ArrayList<String>>(), testState.world);
    }
    @Test public void TestReadInStateSimpleChar(){
        ArrayList<String> worldMap = new ArrayList<String>();
        worldMap.add("1");
        State testState = new State(worldMap);
        Map<Integer, ArrayList<String>> wantWorld = new HashMap<Integer, ArrayList<String>>();
        wantWorld.put(0, worldMap);
        assertEquals(wantWorld, testState.world);
        Map<Integer, ArrayList<Integer>> chars = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> wantPositions = new ArrayList<Integer>();
        wantPositions.add(0);
        chars.put(0, wantPositions);
        assertEquals(chars, testState.characters);
    }
    @Test public void TestReadInStateSimpleSymbol(){
        ArrayList<String> worldMap = new ArrayList<String>();
        worldMap.add("1*");
        //worldMap.add("1");
        State testState = new State(worldMap);
        Map<Integer, ArrayList<String>> wantWorld = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> wantLine = new ArrayList<String>();
        wantLine.add("1");
        wantLine.add("*");
        wantWorld.put(0, wantLine);
        assertEquals(wantWorld, testState.world);
        Map<Integer, ArrayList<Integer>> chars = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> wantPositions = new ArrayList<Integer>();
        wantPositions.add(1);
        chars.put(0, wantPositions);
        assertEquals(chars, testState.symbols);
    }

    @Test public void TestNumberIsFound(){
        ArrayList<String> world = new ArrayList<String>();
        world.add("123");
        State state = new State(world);
        int got = state.findNumber(0, 0);
        assertEquals(123, got);
    }
    @Test public void TestNumberIsFoundEnd(){
        ArrayList<String> world = new ArrayList<String>();
        world.add("123");
        State state = new State(world);
        int got = state.findNumber(0, 2);
        assertEquals(123, got);
    }
    @Test public void TestNoNumberReturnsZero(){
        ArrayList<String> world = new ArrayList<String>();
        world.add("...123");
        State state = new State(world);
        int got = state.findNumber(0, 0);
        assertEquals(0, got);
    }
    @Test public void TestNumberIsFoundAndRemoved(){
        ArrayList<String> world = new ArrayList<String>();
        world.add("123");
        State state = new State(world);
        int got = state.findNumber(0, 0);
        assertEquals(123, got);
        Map<Integer, ArrayList<Integer>> wantWorld = new HashMap<Integer, ArrayList<Integer>>();
        wantWorld.put(0, new ArrayList<Integer>());
        assertEquals(wantWorld, state.characters);
    }
    @Test public void TestScan(){
        String world = "467..114..\n"+
        "...*......\n" +
        "..35..633.\n" +
        "......#...\n" +
        "17*......\n" +
        ".....+.58.\n" +
        "..592.....\n" +
        "......755.\n" +
        "...$.*....\n" +
        ".664.598..\n";
        int want = 467835;
        State state = new State(parseStringToLines(world));

        int got = state.scan();
        assertEquals(want, got);
    }
    @Test public void TestScanUpperLeft(){
        String world = "..7.\n"+
        "..2*";
        int want = 14;
        
        State state = new State(parseStringToLines(world));
        int got = state.scan();
        assertEquals(want, got);
    }
    private ArrayList<String> parseStringToLines(String line){
        return new ArrayList<String>(Arrays.asList(line.split("\n")));
    }
}

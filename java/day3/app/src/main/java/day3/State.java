package day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class State {
    public Map<Integer,ArrayList<Integer>> characters = new HashMap<Integer, ArrayList<Integer>>();
    public Map<Integer,ArrayList<Integer>> symbols = new HashMap<Integer, ArrayList<Integer>>();
    public Map<Integer, ArrayList<String>> world = new HashMap<Integer, ArrayList<String>>();
    public State(){}
    public State(ArrayList<String> worldMap){
       parseMap(worldMap);
    }
    public void parseMap(ArrayList<String> worldMap){
         int y = 0;
        for (String line : worldMap) {
            int x = 0;
            for(char sym : line.toCharArray()){
                ArrayList<String> current_line = world.get(y);
                if (current_line == null){
                    current_line = new ArrayList<String>();
                }
                current_line.add(sym + "");
                world.put(y, current_line);
                if(sym == '.'){
                    x++;
                    continue;
                }

                if (containsSpecialCharacter(sym + "")){
                    ArrayList<Integer> sc = symbols.get(y);
                    if (sc == null){
                        sc = new ArrayList<Integer>();
                    }
                    sc.add(x);
                    symbols.put(y, sc);
                } else {
                    ArrayList<Integer> sc = characters.get(y);
                    if (sc == null) {
                        sc = new ArrayList<Integer>();
                    }
                    sc.add(x);
                    characters.put(y, sc);
                }
                x++;
            }
            y++;
        }
    }
    public boolean containsSpecialCharacter(String s) {
        return (s == null) ? false : s.matches("[^A-Za-z0-9 ]");
    }
    // find a number and remove it from the world state (replace it with dots)
    public int findNumber(int y, int x) {
        ArrayList<Integer> characterLine = characters.get(y);
        if (characterLine == null){
            return 0;
        }
        
        if (!characterLine.contains(x)){
            return 0;
        }
        ArrayList<Integer> locations_to_query = new ArrayList<Integer>();
        //backtrack to the start of the number
        while (true) {
            if (characterLine.contains(x - 1)){
                --x;
                continue;
            }
            break;
        }

        locations_to_query.add(x);

        while (true) {
            if (characterLine.contains(x + 1)){
                locations_to_query.add(++x);
                continue;
            }
            break;
        }
        String number = "";
        ArrayList<String> line = world.get(y);
        for(int loc : locations_to_query){
            characterLine.remove(characterLine.indexOf(loc));
            number += line.get(loc);
        }
        characters.put(y, characterLine);
        return Integer.parseInt(number);
    }
    public int scan(){
        int total = 0;
        for(int row : symbols.keySet()){
            for(int loc : symbols.get(row)){
                System.out.println("Scanning row: " + row + ", location: " + loc);
                total += findNumber(row-1 , loc - 1);
                total += findNumber(row-1 , loc);
                total += findNumber(row-1 , loc+1);
                total += findNumber(row , loc-1);
                total += findNumber(row , loc+1);
                total += findNumber(row+1 , loc-1);
                total += findNumber(row+1 , loc);
                total += findNumber(row+1 , loc+1);



            }
        }
        return total;
    }
}

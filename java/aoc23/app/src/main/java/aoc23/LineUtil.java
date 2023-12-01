package aoc23;

import java.util.HashMap;
import java.util.Map;

import org.checkerframework.checker.units.qual.kmPERh;

public class LineUtil {
    public static int parse(String line) {
        String firstNumber = "";
        String secondNumber = "";
        int firstWordIndex = findFirstWordIndex(line);
        for(int x = 0; x < line.length(); x++){
            char ch = line.charAt(x);
            try{
            String value = String.valueOf(ch);
            Integer.parseInt(String.valueOf(value));
            firstNumber = value;
            break;
            } catch(NumberFormatException e) {
                continue;
            }
        }

        for(int y = 0; y < line.length(); y++){
            char ch = line.charAt(line.length() - y - 1);
            try{
            String value = String.valueOf(ch);
            Integer.parseInt(String.valueOf(value));
            secondNumber = value;
            break;
            } catch(NumberFormatException e) {
                continue;
            }
        }

        return Integer.parseInt(firstNumber + secondNumber);
    }
    private static final Map<String,Integer> words = new HashMap<String,Integer>();
    static{
        words.put("one", 1);
        words.put("two", 2);
        words.put("three", 3);
        words.put("four", 4);
        words.put("five", 5);
        words.put("six", 6);
        words.put("seven", 7);
        words.put("eight", 8);
        words.put("nine", 9);

    }
    public String findFirstWord(String line){
        int currentSmallestIndex = -1;
        String currentWord = "";
        for(String key : words.keySet()){
            int firstLocation = line.toLowerCase().indexOf(key);
            if(firstLocation != -1) {
                if(currentSmallestIndex == -1){
                    currentSmallestIndex = firstLocation;
                    currentWord = key;
                    continue;
                }
                if(firstLocation < currentSmallestIndex){
                    currentSmallestIndex = firstLocation;
                    currentWord = key;
                    continue;
                }
            }   
        }
        return currentWord;
    }
    public static int findLastWordIndex(String line){
        int result  = -1;
        for(String key : words.keySet()){
            int firstLocation = line.toLowerCase().lastIndexOf(key);
            if(firstLocation != -1) {
                if(firstLocation > result){
                    result = firstLocation;
                    continue;
                }
            }   
        }
        return result;
    }
    
}
package day4;

import java.util.ArrayList;
import java.util.Arrays;

public class PointCalculator {
    public static int calculatePoints(String line) throws NumberFormatException {
        //Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        String combined_numbers = line.split(":")[1].trim();
        ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(combined_numbers.split("\\|")[0].trim().split(" ")));
        ArrayList<String> winning_numbers = new ArrayList<String>(Arrays.asList(combined_numbers.split("\\|")[1].trim().split(" ")));
        ArrayList<String> all_winning_numbers = new ArrayList<String>();
        for (String number : numbers){
            if (number.trim() == ""){
                continue;
            }
            if (winning_numbers.contains(number.trim())){
                all_winning_numbers.add(number);
            }
        }
        if (all_winning_numbers.size() > 0){
            int total = 1;
            for (int x = 1; x < all_winning_numbers.size(); x++){
                total *= 2;
            }
            return total;
        }
        return 0;
    }
}

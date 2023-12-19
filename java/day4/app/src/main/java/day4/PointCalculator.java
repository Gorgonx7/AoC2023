package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PointCalculator {
    public static Map<Integer, Integer> ticket_count = new HashMap<Integer, Integer>();
    public static void init_ticket_count(){
        for (int x = 1; x < 190; x++){
            ticket_count.put(x, 1);
        }
    }
    public static void calculatePoints(String line) throws NumberFormatException {
        //Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        String combined_numbers = line.split(":")[1].trim();
        String[] start_string = line.split(":")[0].trim().split(" ");
        int game_number = Integer.parseInt(start_string[start_string.length - 1].trim());
        ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(combined_numbers.split("\\|")[0].trim().split(" ")));
        ArrayList<String> winning_numbers = new ArrayList<String>(Arrays.asList(combined_numbers.split("\\|")[1].trim().split(" ")));
        ArrayList<String> all_winning_numbers = new ArrayList<String>();
        for (String number : numbers){
            if (number.trim() == ""){
                continue;
            }
            if (winning_numbers.contains(number.trim())){
                all_winning_numbers.add(number.trim());
            }
        }
        // for each copy of this ticket I have
        for(int ticket_number = 0; ticket_number < ticket_count.get(game_number); ticket_number++){
            for (int won_ticket = 0; won_ticket < all_winning_numbers.size(); won_ticket++){
                int current_count = ticket_count.get(game_number + won_ticket + 1);
                ticket_count.put(game_number + won_ticket + 1, current_count + 1);
            }
        }
    }
}

package day2;

public class Parser {
    public static Game getGame(String line){
        // technically we don't need to do this we could just loop through all the lines and use the index as the game number
        String[] colon_split = line.split(":");
        String number_string = colon_split[0].split(" ")[1];
        int gameNumber = Integer.parseInt(number_string);
        Game game = new Game(gameNumber);
        String rounds_string = colon_split[1];
        //Game 19: 6 red, 9 green; 1 blue, 4 red; 12 green; 5 green, 2 blue, 9 red
        String[] rounds_strings = rounds_string.split(";");
        for(String round_string : rounds_strings){
            String[] colour_strings = round_string.split(",");
            Round round = new Round();
            for(String colour_string :  colour_strings){
                String[] parsed_colour = colour_string.trim().split(" ");
                int amount = Integer.parseInt(parsed_colour[0]);
                switch (parsed_colour[1]) {
                    case "red":
                        round.add(Colour.RED, amount);
                        break;
                    case "blue":
                        round.add(Colour.BLUE, amount);
                        break;
                    case "green":
                        round.add(Colour.GREEN, amount);
                        break;
                }
            }
            game.addRound(round);
        }
        return game;
    }
}

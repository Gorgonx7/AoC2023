package aoc23;

public class LineUtil {
    public static int parse(String line) {
        int result = 0;
        
        for(int x = 0; x < line.length(); x++){
            char ch = line.charAt(x);
            try{
            result += Integer.parseInt(String.valueOf(ch));
            break;
            } catch(NumberFormatException e) {
                continue;
            }
        }

        for(int y = 0; y < line.length(); y++){
            char ch = line.charAt(line.length() - y - 1);
            try{
            result += Integer.parseInt(String.valueOf(ch));
            break;
            } catch(NumberFormatException e) {
                continue;
            }
        }

        return result;
    }
}
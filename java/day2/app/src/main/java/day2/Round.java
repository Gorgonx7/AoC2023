package day2;

public class Round {
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    public Round(){}
    public Round(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    public void add(Colour colour, int amount) {
        switch (colour) {
            case RED:
                red += amount;
                return;
            case BLUE:
                blue += amount;
                return;
            case GREEN:
                green += amount;
                return;
        }
    }
    public int get(Colour colour){
        switch (colour) {
            case RED:
                return red;
            case BLUE:
                return blue;
            case GREEN:
                return green;
        }
        return 0;
    }
    public boolean isPossible(int max_red, int max_green, int max_blue) {
        if(this.red > max_red){
            return false;
        }
        if (this.green > max_green) {
            return false;
        }
        if (this.blue > max_blue){
            return false;
        }
        return true;
    }
}

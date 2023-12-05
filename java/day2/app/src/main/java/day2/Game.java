package day2;

import java.util.ArrayList;

public class Game {
    private int Id;
    private ArrayList<Round> rounds = new ArrayList<Round>();
    public Game(int Id){
        this.Id = Id;
    }
    public int getID(){
        return Id;
    }
    public int getNumberOfRounds(){
        return rounds.size();
    }
    public void addRound(Round round){
        rounds.add(round);
    }
    public Round getRound(int roundNumber) {
        return rounds.get(roundNumber);
    }
    public boolean isPossible(int max_red, int max_green, int max_blue){
        for(Round round : rounds){
            if (!round.isPossible(max_red, max_green, max_blue)){
                return false;
            }
        }
        return true;
    }
}

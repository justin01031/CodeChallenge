package com.interview.matchmaking;

/**
 * <p>
 * Representation of a player.
 * </p>
 * <p>
 * As indicated in the challenge description, feel free to augment the Player
 * class in any way that you feel will improve your final matchmaking solution.
 * <strong>Do NOT remove the name, wins, or losses fields.</strong> Also note
 * that if you make any of these changes, you are responsible for updating the
 * {@link SampleData} such that it provides a useful data set to exercise your
 * solution.
 * </p>
 */
public class Player {

    private final String name;
    private final long wins;
    private final long losses;
    private  int rankScore;
    public Player(String name, long wins, long losses) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        double winRate= (double)((double)wins/(double)(wins+losses));
        int total=(int)(winRate*1000+1000);
        this.rankScore=(wins+losses==0)?1000:total;

    }
    
    
    public Player(String name, long wins, long losses,int score) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.rankScore=score;
    }

    public String getName() {
        return name;
    }

    public long getWins() {
        return wins;
    }

    public long getLosses() {
        return losses;
    }
    public int getScore(){
    	return rankScore;
    }

    public void setScore(int rankScore){
    		this.rankScore=rankScore;
    }
    
}

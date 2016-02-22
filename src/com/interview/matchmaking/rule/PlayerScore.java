package com.interview.matchmaking.rule;

import com.interview.matchmaking.Player;

/**
 * @author justin01031
 *a object which stores the score of the player
 */
public class PlayerScore implements Comparable<PlayerScore> {
	Player player;
	int score;
	public PlayerScore(Player player, int score){
		this.player=player;
		this.score=score;
	}
	public int getScore(){
		return score;
	}
	public Player getPlayer(){
		return player;
	}


	@Override
	public int compareTo(PlayerScore anotherPlayerS) {
		// TODO Auto-generated method stub
		return anotherPlayerS.getScore()-this.getScore();
	}

}

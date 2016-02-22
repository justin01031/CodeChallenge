package com.interview.matchmaking.rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.interview.matchmaking.Player;

/**
 * @author justin01031
 *This is the basic algorithm which select a player after sorting through player's score
 *And it will find the players who have the nearest score
 */
public class BasicMatchingRule implements MatchingRule  {
	private int playersPerTeam;

	public BasicMatchingRule(int playersPerTeam){
		this.playersPerTeam=playersPerTeam;
	}
	@Override
	public ArrayList<Set<Player>> getMatching(Set<Player> totalPlayers){
		ArrayList<Set<Player>> teams= new ArrayList<Set<Player>>();
		ArrayList<PlayerScore> scoreTable= new ArrayList<PlayerScore>();
		//using a scoreTable to sort the players by score
		for(Player now : totalPlayers){
			//we just sort the player based on the score
			//can change its sorting rule====
			scoreTable.add(new PlayerScore(now,now.getScore()));
		}

		Collections.sort(scoreTable);
		/*for(PlayerScore now: scoreTable){
			System.out.println(now.getScore()+now.getPlayer().getName());

		}*/
		
		//create a random number to select a player
		int randNum= new Random().nextInt(totalPlayers.size()-playersPerTeam*2);
		Set<Player> team1=new HashSet<Player>();
		Set<Player> team2=new HashSet<Player>();
		
		//find the other teammates who are close to this players
		for(int i=0;i<playersPerTeam*2;i++){
			if(i%2==0){
				team1.add(scoreTable.get(randNum+i).getPlayer());
				//System.out.println(scoreTable.get(randNum+i).getPlayer().getName());
			}
			else{
				team2.add(scoreTable.get(randNum+i).getPlayer());
				
			}
		}
		teams.add(team1);
		teams.add(team2);
		return teams;
		
	}

}

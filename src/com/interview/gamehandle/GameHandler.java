package com.interview.gamehandle;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.interview.matchmaking.Match;
import com.interview.matchmaking.MatchmakerImpl;
import com.interview.matchmaking.Player;
import com.interview.matchmaking.SampleData;
import com.interview.score.rule.ScoreRule;
/**
 * 
 * @author justin01031
 * GameHandler will store a list of onlinePlayers, and a score rule that will update player's score after each match.
 *
 */
public class GameHandler {
	private List<Player> onlinePlayers;
	private ScoreRule scoreRule;
	/**
	 * @param onlinePlayers  This is the players that is going to  be in the online pool
	 * @param scoreRule	 This is the rule class that administrator wants to use to update the player's score
	 * 
	 */
	public GameHandler(List<Player>onlinePlayers,ScoreRule scoreRule){
		this.onlinePlayers=onlinePlayers;
		this.scoreRule=scoreRule;
		
	}

	/**
	 * @param playersPerTeam how many players per team can be 3 for 3v3 or 5 for 5v5
	 * @param searchNum: how many people are going to be in the searching pool to match the fight
	 */
	public void startMatch(int playersPerTeam,int searchNum){

		MatchmakerImpl matchmaker=new MatchmakerImpl(); //init the matchmaker handler
		//insert the player into the search pool based on the searchNum.
		for(int i=0, insert=0;i<onlinePlayers.size();i++){
			if(this.isValidPlayer(onlinePlayers.get(i))){
				matchmaker.enterMatchmaking(onlinePlayers.get(i));
				insert++;
			}
			
			if(insert==searchNum)break;
		}
		//find the match
		Match now=matchmaker.findMatch(playersPerTeam);
		if(now==null){
			System.out.println("Error :matchmaker");
			System.out.println(matchmaker.getLog());
		}
		Set<Player> team1=now.getTeam1();
		Set<Player> team2=now.getTeam2();
		System.out.println("==The team1 members are==");
		int sum1=0;
		for(Player player:team1){
			System.out.println(player.getName()+" the score is :" +player.getScore());
			sum1+=player.getScore();
		}
		System.out.println("Average Score is :"+sum1/team1.size());
		System.out.println("===The team2 members are==");
		int sum2=0;
		for(Player player:team2){
			System.out.println(player.getName()+" the score is :" +player.getScore());
			sum2+=player.getScore();
		}
		System.out.println("Average Score is :"+ sum2/team2.size());
		System.out.println("=====");
		
		//update the score  I use random number to create who win and who lose on the match.
		// 1 = team1 wins   2=team2 win.
		this.endMatch(now, new Random().nextInt(2)+1);
	}
	
	/**
	 * update the player's score after the matching
	 * @param match  the match just ended
	 * @param whoWin  pass a integer indicate who wins 1=team1 win 2=team2 win.
	 */
	private void endMatch(Match match,int whoWin){
		Set<Player> team1=match.getTeam1();
		Set<Player> team2=match.getTeam2();
		for(Player now: team1){
			//using the scoreRule to calculate the score after the match
			now.setScore(scoreRule.getScore(now, match, whoWin));
		}
		for(Player now: team2){
			now.setScore(scoreRule.getScore(now, match, whoWin));
		}
		
		
	}
	
	
	/**
	 * make sure the player is valid
	 * @param player  the target player
	 * @return return true if it is a valid player return false if it is not
	 */
	private boolean isValidPlayer(Player player){
		if(player==null)return false;
		if(player.getName()==null) return false;

		if(player.getWins()>=0&&player.getLosses()>=0&&player.getScore()>=1000){
			return true;
		}
		return false;
		
	}
	
	
	
	

}


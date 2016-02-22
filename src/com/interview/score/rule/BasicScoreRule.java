package com.interview.score.rule;

import java.util.Set;

import com.interview.matchmaking.Match;
import com.interview.matchmaking.Player;
/**
 * 
 * @author justin01031
 * This is class implemnts the scorerule
 * It will calculate a player's score after the match result
 * We update a player's score base on the team total average score
 * Example:
 * player1 is at team1 and team 1 wins.
 * If player1 has a higher score than the average score in team1 his score will just add up a little
 * If player1 has lower score than the average score in team1 his score will increase a lot.
 * 
 * 
 */
public class BasicScoreRule implements ScoreRule {

	@Override
	public int getScore(Player player, Match match, int whoWin) {
		//System.out.println("player:"+ player.getName() +"score:"+ player.getScore());
		Set<Player> team1=match.getTeam1();
		Set<Player> team2=match.getTeam2();
		int team1TotalScore=0;
		for(Player now :team1){
			team1TotalScore+=now.getScore();
		}
		int team1AveScore=team1TotalScore/team1.size();
		int team2TotalScore=0;
		for(Player now :team2){
			team2TotalScore+=now.getScore();
		}
		int team2AveScore=team2TotalScore/team2.size();
		int increment=0;
		if(whoWin==1){//team1 win
			if(team1.contains(player)){ //win
				int distance=player.getScore()-team1AveScore;
				if(distance>=160){
					increment=5;
				}
				else if(distance<160&&distance>=80){
					increment=8;
				}
				else if(distance<80&&distance>=20){
					increment=15;
				}
				else if (distance<20&&distance>=0){
					increment=20;
				}
				else if(distance<0&&distance>=-20){
					increment=20;
				}
				else if(distance<-20&&distance>=-80){
					increment=25;
				}
				else if(distance<-80&&distance>=-160){
					increment=35;
				}
				else{
					increment=40;
				}
				
			}
			else{//lose
				int distance=player.getScore()-team2AveScore;
				if(distance>=160){
					increment=-40;
				}
				else if(distance<160&&distance>=80){
					increment=-35;
				}
				else if(distance<80&&distance>=20){
					increment=-25;
				}
				else if (distance<20&&distance>=0){
					increment=-20;
				}
				else if(distance<0&&distance>=-20){
					increment=-20;
				}
				else if(distance<-20&&distance>=-80){
					increment=-15;
				}
				else if(distance<-80&&distance>=-160){
					increment=-8;
				}
				else{
					increment=-5;
				}

				
			}
		}
		else{//team2 win
			if(team1.contains(player)){
				int distance=player.getScore()-team1AveScore;
				if(distance>=160){
					increment=-40;
				}
				else if(distance<160&&distance>=80){
					increment=-35;
				}
				else if(distance<80&&distance>=20){
					increment=-25;
				}
				else if (distance<20&&distance>=0){
					increment=-20;
				}
				else if(distance<0&&distance>=-20){
					increment=-20;
				}
				else if(distance<-20&&distance>=-80){
					increment=-15;
				}
				else if(distance<-80&&distance>=-160){
					increment=-8;
				}
				else{
					increment=-5;
				}
			}
			else{
				int distance=player.getScore()-team2AveScore;
				if(distance>=160){
					increment=5;
				}
				else if(distance<160&&distance>=80){
					increment=8;
				}
				else if(distance<80&&distance>=20){
					increment=15;
				}
				else if (distance<20&&distance>=0){
					increment=20;
				}
				else if(distance<0&&distance>=-20){
					increment=20;
				}
				else if(distance<-20&&distance>=-80){
					increment=25;
				}
				else if(distance<-80&&distance>=-160){
					increment=35;
				}
				else{
					increment=40;
				}
			}
			
		}
		//System.out.println(finalScore-player.getScore());
		//System.out.println("finalScore:"+ finalScore);
		return player.getScore()+increment;
	}

}

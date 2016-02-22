package com.interview.matchmaking;

import java.util.*;

import com.interview.matchmaking.rule.BasicMatchingRule;
import com.interview.matchmaking.rule.MatchingRule;

/**
 * @author justin01031
 *Handles how many player per each team base on the matching rule
 */
public class TeamOrganizer {
//	private int howManyTeam=0;
	private int playersPerTeam=0;
	private MatchingRule matchingRule= new BasicMatchingRule(5);
	

	/**
	 * Constructor of TeamOrganizer
	 * @param playersPerTeam how many players per team
	 * @param matchingrule the matching rule
	 */
	public TeamOrganizer(int playersPerTeam , MatchingRule matchingrule){
		this.playersPerTeam=playersPerTeam;
		this.matchingRule=matchingrule;
	}
	
	/**
	 * @param totalPlayers Searching pool 
	 * @return a arraylist of teams which is selected for the match
	 */
	public ArrayList<Set<Player>> getTeams(Set<Player> totalPlayers){
		return matchingRule.getMatching(totalPlayers);
	}


	
}

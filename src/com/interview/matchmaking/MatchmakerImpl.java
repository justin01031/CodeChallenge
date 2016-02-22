package com.interview.matchmaking;


import java.util.*;

import com.interview.matchmaking.rule.BasicMatchingRule;
import com.interview.matchmaking.rule.MatchingRule;

/**
 * The matchmaking implementation that you will write.
 */
/**
 * @author justin01031
 * totalPlayers is a set of players which contains all the player info in the search pool
 * teamorganizer is a organizer that pick how many player in the search pool through the selecting algorithm
 * log is the log file
 *
 */
public class MatchmakerImpl implements Matchmaker {
	
	private Set<Player> totalPlayers= new HashSet<Player>();
	private TeamOrganizer teamorganizer=null;
	private StringBuilder log =new StringBuilder();
	
	 @Override
    public Match findMatch(int playersPerTeam) {
	    if(playersPerTeam<=0) {
	    	log.append("playersPerTeam is less then 0");
	    	return null;
	    }
    	if(totalPlayers==null || totalPlayers.size()<playersPerTeam*2){
    		log.append("online players are too few to form a match");
    		return null;
    	}
    	//create a teamorganizer
    	// we use basicmatchingrule as a default.
    	teamorganizer= new TeamOrganizer(playersPerTeam,new BasicMatchingRule(playersPerTeam));
    	ArrayList<Set<Player>>teams=teamorganizer.getTeams(totalPlayers);
    	//ArrayList<Set<Player>>teams=matchingRule.getMatching(totalPlayers);
    		
        Match outputMatch = new Match(teams.get(0),teams.get(1));
        return outputMatch;

    }


	/**
	 * this function can update the matching rule
	 * @param playersPerTeam how many players per team
	 * @param matchingRule the matching rule administrator wants to use
	 * @return a match object
	 */
	public Match findMatch(int playersPerTeam, MatchingRule matchingRule) {
		    if(playersPerTeam<=0) {
		    	log.append("playersPerTeam is less then 0");
		    	return null;
		    }
	    	if(totalPlayers==null || totalPlayers.size()<playersPerTeam*2){
	    		log.append("online players are too few to form a match");
	    		return null;
	    	}
	    	//create a teamorganizer
	    	// 
	    	teamorganizer= new TeamOrganizer(playersPerTeam,matchingRule);
	    	ArrayList<Set<Player>>teams=teamorganizer.getTeams(totalPlayers);
	    	
	    		
	        Match outputMatch = new Match(teams.get(0),teams.get(1));
	        return outputMatch;

	}
	 
    @Override
    public void enterMatchmaking(Player player) {
        totalPlayers.add(player);
    }
    /**
     * @return the log info
     */
    public String getLog(){
    	return log.toString();
    }


}

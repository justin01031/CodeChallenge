package com.interview.matchmaking.rule;

import java.util.ArrayList;
import java.util.Set;

import com.interview.matchmaking.Player;

public interface MatchingRule {
	/**
	 * @param totalPlayers the set of players info of the search pool
	 * @return an arraylist of teams that we pick for a match.
	 */
	public ArrayList<Set<Player>> getMatching(Set<Player> totalPlayers);
}

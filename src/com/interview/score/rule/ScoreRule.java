package com.interview.score.rule;

import com.interview.matchmaking.Match;
import com.interview.matchmaking.Player;

public interface ScoreRule {

	public int getScore(Player player,Match match, int whoWin);

}

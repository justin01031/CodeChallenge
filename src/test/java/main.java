package test.java;

import java.util.List;
import java.util.Set;

import com.interview.gamehandle.GameHandler;
import com.interview.matchmaking.Player;
import com.interview.matchmaking.SampleData;
import com.interview.score.rule.BasicScoreRule;
import com.interview.matchmaking.*;

public class main {

	public static void main(String[] args) {
		int howManyMatch=100;
		int retieveHowManyPeople=200;
		// TODO Auto-generated method stub
		List<Player> onlinePlayers=SampleData.getPlayers(); //load the sample data.
		
		GameHandler gameHandler= new GameHandler(onlinePlayers , new BasicScoreRule()); //gamehandeler handles the match.
		
		for(int i=0;i<howManyMatch;i++){
			gameHandler.startMatch(3, retieveHowManyPeople);
		}

		/*for(Player now:onlinePlayers){
			System.out.println(now.getScore());
		}*/
		
	}

}

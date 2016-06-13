package rankings;

import java.util.ArrayList;
import java.util.Collections;

public class Rankings {
	public static ArrayList<Player> ranks = new ArrayList<Player>();
	
	/*
	 * This will happen after a match is confirmed.
	 * It will:
	 * 1. Set the points for each player
	 * 2. Add a win or loss to both players.
	 * 
	 * To Note:
	 * - Player 'me' is not actually me. It's just
	 * whichever player I decide to pass in first. If this
	 * becomes confusing I will consider using playerOne and playerTwo
	 */
	public static void matchReport(Player me, Player opp, int firstSetGamesMe, int firstSetGamesOpp, int secondSetGamesMe,
			int secondSetGamesOpp) {
		
		//Take care of points
		int meMaxPoints = me.getMaxPoints(); // Max points of this player
		int oppMaxPoints = opp.getMaxPoints(); //Max points of the other player
		int meGamesWon = firstSetGamesMe + secondSetGamesMe; //Games me won
		int oppGamesWon = firstSetGamesOpp + secondSetGamesOpp; //Games Opp won
		int numberOfGames = meGamesWon + oppGamesWon; //Number of games total
		
		double percentGamesWonMe = (double)meGamesWon / numberOfGames;
		double percentGamesWonOpp = (double)oppGamesWon / numberOfGames;
		int pointsToMe = (int) (percentGamesWonMe * (oppMaxPoints));
		int pointsToOpp = (int) (percentGamesWonOpp * (meMaxPoints));
		
		me.addPoints(pointsToMe);
		opp.addPoints(pointsToOpp);
		
		Rankings.organizeRanks();
	}

	@SuppressWarnings("unchecked")
	public static void organizeRanks() {
		Collections.sort(ranks);
	}
}

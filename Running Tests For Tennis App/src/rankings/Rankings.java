package rankings;

import java.util.ArrayList;
import java.util.Collections;

public class Rankings {
	public static ArrayList<Player> ranks = new ArrayList<Player>();
	
	/*
	 * The Constant for my algorithm:
	 * Constant * (ranks.size() - (rank - 1))/ranks.size()) 
	 */
	private static final int CONSTANT = 1000; 
	
	public static int getMaxPoints(Player opponent)
	{
		return CONSTANT * ((ranks.size() - (ranks.indexOf(opponent)))/ranks.size());
	}
	
	@SuppressWarnings("unchecked")
	public static void organizeRanks()
	{
		Collections.sort(ranks);
	}
}

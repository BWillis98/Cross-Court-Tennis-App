package rankings;

import java.util.Random;

public class Runner {
	public static void main(String[] args) {
		
		Player Brandon = new Player("Willis");
		Player y = new Player("Kawecki");
		Player asdf = new Player("Federer");
		Player sfk = new Player("Djokovic");
		Player aos = new Player("Isner");
		Player aso = new Player("Monfils");
		Player aosi = new Player("Wawrinka");
		
		Rankings.organizeRanks();
		
		System.out.println("Now for the match");
		Rankings.matchReport(y, Brandon, 6, 3, 6, 4);
		printRanks();
		
		/*
		 * This is a random system to do random matches.
		 * It turns out my system works and the rankings work out beautifully :)
		 * On to the next thing.
		 */
		for (int i = 0; i < 150; i++)
		{
			Random r = new Random();
			Player PlayerOne = Rankings.ranks.get(r.nextInt(Rankings.ranks.size()));
			Player PlayerTwo = Rankings.ranks.get(r.nextInt(Rankings.ranks.size()));
			
			Rankings.matchReport(PlayerOne, PlayerTwo, r.nextInt(7), r.nextInt(7), r.nextInt(7), r.nextInt(7));
		}
		printRanks();
	}
	
	public static void printRanks()
	{
		for (int i = 0; i < Rankings.ranks.size(); i++)
		{
			System.out.println((i + 1) + ". " + Rankings.ranks.get(i).name +
					" " + Rankings.ranks.get(i).points);
		}
		System.out.println();
	}
}

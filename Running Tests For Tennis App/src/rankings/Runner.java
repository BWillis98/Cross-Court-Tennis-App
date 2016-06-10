package rankings;

import java.util.Random;

public class Runner {
	public static void main(String[] args) {
		/*
		Player x = new Player("Brandon is 1", 1000);
		Player y = new Player("Should be 3", 800);
		Player asdf = new Player("Should be 5", 300);
		Player sfk = new Player("Should be 2", 950);
		Player aos = new Player("Should be 7", 0);
		Player aso = new Player("Should be 6", 150);
		Player aosi = new Player("Should be 4", 400);
		*/
		for (int i = 0; i < 10000; i++)
		{
			Random r = new Random();
			int points = r.nextInt(10000);
			new Player("Name", points);
		}
		
		System.out.println("Before:");
		printRanks();
		
		Rankings.organizeRanks();
	
		System.out.println("\nAfter:");
		printRanks();
	}
	
	public static void printRanks()
	{
		for (int i = 0; i < Rankings.ranks.size(); i++)
		{
			System.out.println(Rankings.ranks.get(i).name +
					" " + Rankings.ranks.get(i).points);
		}
	}
}

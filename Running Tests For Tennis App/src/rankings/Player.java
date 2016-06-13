package rankings;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Player implements Comparable {
	public String name;

	/*
	 * The constant is for our algorithm to decide the max points while
	 * MatchesToConsider is for how matches we will consider in their top score.
	 * Right now I want to use only the top 10 matches. This could change,
	 * however.
	 */
	private final int CONSTANT = 1000, MATCHESTOCONSIDER = 10;

	public int wins = 0, losses = 0, points;

	private Integer[] pointsAwarded = new Integer[MATCHESTOCONSIDER];

	public Player(String _name) {
		Arrays.fill(pointsAwarded, 0);
		this.name = _name;
		this.points = 0;
		Rankings.ranks.add(this);
	}
	
	public Player(String _name, int points) {
		Arrays.fill(pointsAwarded, 0);
		this.name = _name;
		this.addPoints(points);
		Rankings.ranks.add(this);
	}
	
	public int getMaxPoints() {
		Rankings.organizeRanks();
		//System.out.println("Rank of " + this.name + ": " + Rankings.ranks.indexOf(this));
		int retVal =(int) (CONSTANT * ((double)(Rankings.ranks.size() - (Rankings.ranks.indexOf(this))) / Rankings.ranks.size()));
		return retVal;
	}

	@Override
	public int compareTo(Object opponent) { // Needed this for building the
											// ranks.
		Player opp = (Player) opponent;
		return (opp.points - points);
	}

	/*
	 * Sorts the array of points and adds the points to the array if the points
	 * are enough to be worth adding.
	 */
	public void addPoints(int points) {
		Arrays.sort(pointsAwarded);

		//System.out.println("In addPoints method. Before: low to high:" + Arrays.toString(pointsAwarded));

		for (int i = pointsAwarded.length - 1; i > 0; i--) {
			if (pointsAwarded[i] < points) {
				for (int a = 0; a < i; a++) {
					pointsAwarded[a] = pointsAwarded[a + 1];
				}
				pointsAwarded[i] = points;
				break;
			}
		}
		this.points = 0;
		for (int i = 0; i < pointsAwarded.length; i++) {
			this.points += pointsAwarded[i];
		}
		//System.out.println("After: low to high:" + Arrays.toString(pointsAwarded) + "\n");
	}
}

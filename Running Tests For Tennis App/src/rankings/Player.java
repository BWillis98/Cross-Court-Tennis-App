package rankings;

@SuppressWarnings("rawtypes")
public class Player implements Comparable{
	public String name;
	
	public int wins = 0, losses = 0, points;
	
	public Player(String _name)
	{
		this.name = _name;
		this.points = 0;
		Rankings.ranks.add(this);
	}
	
	public Player(String _name, int points)
	{
		this.name = _name;
		this.points = points;
		Rankings.ranks.add(this);
	}

	@Override
	public int compareTo(Object opponent) {
		Player opp = (Player)opponent;
		return (opp.points - points);
	}
}

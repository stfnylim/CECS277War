package War;

public class Player {
	public int name;
	public Deck hand;
	public Player(int name) {
		this.name = name;
		this.hand = new Deck();
	}
	
	public String toString() {
		return "Player " + String.valueOf(name);
	}
}

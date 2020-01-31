package War;

public class WarTester {
	public static void main(String[] args) {
		// create war game
		War war = new War(2);
		// shuffle deck
		war.shuffle();

		war.deal();

		war.playAllWar();
	}
}

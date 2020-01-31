package War;

public class WarTester {
	public static void main(String[] args) {
		// create war game
		War war = new War(2);

		//System.out.println(war.deck);
		// shuffle deck
		war.shuffle();
		//System.out.println(war.deck);
		war.deal();

		war.playAllWar();
		
		System.out.println(war.diPile);
		
		
	}
}

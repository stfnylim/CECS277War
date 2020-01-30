package War;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
	public ArrayList<Card> deck = new ArrayList<Card>();
	
	// default constructor
	public Deck() {
		deck = new ArrayList<Card>();
	}
	
	//shuffle deck
	public void shuffle() {
		Collections.shuffle(deck);
	}
	//add card
	public void add(Card card){
		deck.add(card);
	}
	//remove card
	public void remove(int num) {
		deck.remove(num);
	}
	//get Card by index
	public Card get(int num) {
		return deck.get(num);
	}
	//get size
	public int size() {
		return deck.size();
	}
	
	
	
	public String toString() {
		return Arrays.toString(deck.toArray());
	}

}

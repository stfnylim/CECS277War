package War;

public class Card implements Comparable<Card>{
	
	private String suit;
	private int rank;
	private int value;
	
	//constructor
	public Card(String suit, int value) {
		this.suit = suit;
		this.rank = 0;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String toString() {
		
		if (value == 10){
			return "Jack of " + suit;
		}
		else if (value == 11){
			return "Queen of " + suit; 
		}
		else if (value == 12){
			return "King of " + suit; 
		}
		else if (value == 13){
			return "Ace of " + suit; }
		else {
			return value+1 + " of " + suit;
		}
	}

	/**
	 * 
	 */
	@Override
	public int compareTo(Card anotherCard) {
		return this.getValue() - anotherCard.getValue();
	}
	

	
	

	
	
}

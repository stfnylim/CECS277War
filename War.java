package War;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * 
 * @author stfnylim
 *
 */

public class War {
	public ArrayList<Player> players = new ArrayList<Player>();
	public Deck deck;
	public int numPlayers;
	public Deck diPile;
	
	public War() {
		diPile = new Deck();
		String[] suits = {"Hearts","Spades","Clubs","Diamonds"};
		int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		// instantiate the whole deck
		this.deck = new Deck();
		for (String suit: suits) {
			for (int value: values) {
				this.deck.add(new Card(suit, value));
			}
		}
	}
	public War(int numPlayers) {
		diPile = new Deck();
		String[] suits = {"Hearts","Spades","Clubs","Diamonds"};
		int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		// instantiate the whole deck
		this.deck = new Deck();
		for (String suit: suits) {
			for (int value: values) {
				this.deck.add(new Card(suit, value));
			}
		}
		this.numPlayers = numPlayers;
	}
	
	public void deal() {
		
		//make players
		for(int j = 1; j<(numPlayers+1);j++) {
			players.add(new Player(j));
		}
		
		// deal cards to players
		int numCardHand = this.deck.size()/numPlayers;
		
		
		for (int k = 0; k<numPlayers;k++) {
			
			for (int i =0; i<numCardHand;i++) {
				
				(players.get(k)).hand.add(this.deck.get(this.deck.size()-1));
				this.deck.remove(deck.size()-1);
			}
		}
		// dealing leftover cards to rest of players.
		/** -------------------------- WORK ON LATER --------------------------
		while (this.deck.size() != 0){
		}
		
		or 
		
		
		**/
		
	}
	public void empty() {
		
	}
	
	
	public void shuffle() {
		deck.shuffle();
	}
	
	public void playCard() {	
		for (int i = 0; i<numPlayers; i++) {
			System.out.println(players.get(i)+" played a " + players.get(i).hand.get(0));
			diPile.add(players.get(i).hand.get(0));
			players.get(i).hand.remove(0);
		}
		
		
	}
	
	public void playWar() {
		for (int i = 0; i<numPlayers; i++) {
			for (int j = 0; j <3; j++) {
				System.out.println(players.get(i)+" played a random card");
				diPile.add(players.get(i).hand.get(0));
				players.get(i).hand.remove(0);
			}
			
			
			
		}
		this.playCard();
	}
	
	public void playAllWar() {
		
		this.playCard();
		
		//while (players.size()>1) {
			// to compare the cards in the discard pile.
			if (diPile.get(0).compareTo(diPile.get(1))<0) {
				for (int i =0; i <diPile.size();i++) {
					players.get(1).hand.add(diPile.get(i));
					diPile.remove(i);
				}
				System.out.println(players.get(1) + " wins the round");
			}
			else if(diPile.get(0).compareTo(diPile.get(1))>0) {
				for (int i =0; i <diPile.size();i++) {
					players.get(0).hand.add(diPile.get(i));
					diPile.remove(i);
				}
				System.out.println(players.get(0) + " wins the round");
			}
			
			else {
				//war game start if the cards are equal
				System.out.println("War game has started.");
				this.playWar();
				
			}
			
			
			
		//}
			
		
		
		
	}
	
	
	
	public String toString() {
		return "There are " + numPlayers + " players playing this game of War.";
	}
}

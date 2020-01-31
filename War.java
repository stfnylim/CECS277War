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
	
	/**
	 * 
	 * @param numPlayers - number of players participating
	 */
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
		
	}
	
	/**
	 * isEmpty method checks whether the player's hand is empty or not.
	 * @param player - checks this player's hand
	 * @return boolean - whether player has no more cards or not
	 */
	public boolean isEmpty(Player player) {
		if (player.hand.size()==0) {
			return true;}
		else {return false;}
	}
	
	/**
	 * shuffle method shuffles the deck of the cards.
	 */
	public void shuffle() {
		deck.shuffle();
	}
	/**
	 * playCard method is plays the top card of each player's deck 
	 * and outputs the card played.
	 */
	public void playCard() {	
		for (int i = 0; i<numPlayers; i++) {
			System.out.println(players.get(i)+" played a " + players.get(i).hand.get(0));
			diPile.add(players.get(i).hand.get(0));
			players.get(i).hand.remove(0);
		}
		for (int i = 0; i<numPlayers; i++) {
			if(this.isEmpty(players.get(i))) {
				players.remove(i);
				numPlayers--;
			}
		}
		
	}
	/**
	 * playWar method plays the top 4 cards of each player's deck 
	 * and outputs the cards played.
	 */
	public void playWar() {
		for (int i = 0; i<numPlayers; i++) {
			if(this.isEmpty(players.get(i))) {
				return;
			}
			for (int j = 0; j <3; j++) {
				System.out.println(players.get(i)+" played a random card");
				diPile.add(players.get(i).hand.get(0));
				players.get(i).hand.remove(0);		
			}
		}
		this.playCard();
	}
	
	/**
	 * this function is able to let the players play until there is just 
	 * one player left. It compares their card values and initiates
	 * the playWar method in order to continue the game.
	 */
	public void playAllWar() {
		//initialize the first play and create something in the discard pile.
		this.playCard();
		//initialize the while loop until the number of players is just 1.
		while (true) {
			int dPileSize = diPile.size();
			int compare = diPile.get(dPileSize-2).compareTo(diPile.get(dPileSize-1));
			// to compare the cards in the discard pile.
			
			if (compare<0) {
				int dsize = diPile.size();
				for (int i =0; i <dsize;i++) {
					players.get(1).hand.add(diPile.get(0));
					diPile.remove(0);
				}
				System.out.println(players.get(1) + " wins the round");
				this.playCard();
				if(numPlayers == 1) {
					System.out.println(players.get(0)+" has won the game.");
					break;
				}
			}
			else if(compare>0) {
				int dsize = diPile.size();
				for (int i =0; i <dsize;i++) {
					players.get(0).hand.add(diPile.get(0));
					diPile.remove(0);
				}
				System.out.println(players.get(0) + " wins the round");
				
				this.playCard();
				if(numPlayers == 1) {
					System.out.println(players.get(0)+" has won the game.");
					break;
				}
			}
			else {
				//war game start if the cards are equal
				System.out.println("War game has started.");
				this.playWar();
				if(numPlayers == 1) {
					System.out.println(players.get(0)+" has won the game.");
					break;
				}
			}
			
		}//end while loop because numPlayers = 1
		
	}
	
	public String toString() {
		return "There are " + numPlayers + " players playing this game of War.";
	}
}

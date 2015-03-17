/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WarCardGame;

/**
 *
 * @author Shannon Ploppa
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private int size;
	Random rnd = new Random(201234);

	public Deck() {
		cards = new ArrayList<>();
		size = cards.size();
	}

	public Deck(ArrayList<Card> deck) {
		cards = deck;
		size = cards.size();
	}

	public Deck (int numberOfStandardDecks, long randomSeed) {
		this(numberOfStandardDecks, numberOfStandardDecks, randomSeed);
	}

	public Deck (int numberOfStandardDecks, int numberOfJokerPairs, long randomSeed) {
		cards = new ArrayList<Card>();
		Card addCard;
		for (int i = 0; i < numberOfStandardDecks; i++) {
			for (Face f : Face.values())
			{   if (f == Face.JOKER) {
				continue;
			}
				for (Suit s: Suit.values())
				{
					if (s == Suit.JOKER) {
						continue;
					}
					addCard = new Card(f, s);
					cards.add(addCard);
				}
			}
		}
		for(int i = 0; i < numberOfJokerPairs * 2; i++) {
			addCard = new Card(Face.JOKER, Suit.JOKER);
			cards.add(addCard);
		}
		size = cards.size();
		rnd = new Random(randomSeed);
	}

	@Override
	public String toString() {
		Iterator<Card> itr;
		Card c;
		StringBuilder sb = new StringBuilder();
		itr = cards.iterator();
		while(itr.hasNext())
		{
			Object obj = itr.next();
			c  = (Card) obj;
			sb.append(c.toString()).append(", ");
		}
		if (sb.length() > 2) {
			return sb.substring(0, sb.length() -2);
		} else {
			return sb.toString();
		}
	}

	public int getSize() {
		return size;
	}

	public void shuffleCards() {

		for (int i = size; i > 1; i--) {
			swapCards(i - 1, rnd.nextInt(i));
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void swapCards(int i, int j) {
		Card tmp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, tmp);
	}

	public static void dealCards(Deck playDeck, Deck p1, Deck p2) {
		ArrayList<Card> p1Cards = new ArrayList<>();
		p1Cards.addAll(playDeck.getCards());
		ArrayList<Card> p2Cards = new ArrayList<>();

		Iterator<Card> itr;
		Card c;
		itr = p1Cards.iterator();
		while (itr.hasNext()){
			Object obj = itr.next();
			c  = (Card) obj;
			p2Cards.add(c);
			itr.remove();
			if(itr.hasNext()) {
				itr.next();
			}
		}
		p2.addCards(p2Cards);
		p1.addCards(p1Cards);
	}

	public Card getTopCard() {
		if (size > 0 )
		{
			Card top = cards.remove(0);
			size = cards.size();
			return top;
		} else {
			return null;
		}
	}

	public void addCards(ArrayList<Card> hand) {
		cards.addAll(hand);
		size = cards.size();
	}

	public static int playDeal(Card player1, Card player2) {
		return player1.getWLT(player2);
	}

	public static void main(String args[])  {
		 Deck myDeck = new Deck(2, 4, 23);
		 System.out.println(myDeck.getSize());

	}
}
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
public class Card {
	private Face faceVal;
	private Suit cardSuit;

	public Card(Face faceValue, Suit suit) {
		faceVal = faceValue;
		cardSuit = suit;
	}

	@Override
	public String toString() {
		if (cardSuit != Suit.JOKER)
		{
			return new String(faceVal.toString() + " of " + cardSuit.toString());
 		} else {
			return faceVal.toString();
		}
	}
	public Face getFace() {
		return faceVal;
	}

	public Suit getSuit() {
		return cardSuit;
	}

	public int getWLT(Card cardMatch) {
		if (faceVal.getValue() > cardMatch.getFace().getValue()) {
			return 1;
		} else if (faceVal.getValue() == cardMatch.getFace().getValue()) {
			return 0;
		} else {
			return -1;
		}
	}
	public static void main(String[] args) {
		Card myCard = new Card(Face.FOUR, Suit.DIAMOND);
		System.out.println(myCard.toString());
		System.out.println(myCard.getFace().getValue());
	}
}
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
public enum Face {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14), JOKER(15);
	private final int value;

	private Face(int value) {
			this.value = value;
	}

	public int getValue() {
		return value;
	}
	@Override
	public String toString() {
		//only capitalize the first letter
		String s = super.toString();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
 	}
}
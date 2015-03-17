/*
 * 
 */

package WarCardGame;

/**
 *
 * @author Shannon Ploppa
 */
import java.util.ArrayList;

public class War {
	private Deck playDeck;
	private Deck player1;
	private Deck player2;
	private Card p1TopCard;
	private Card p2TopCard;
	private ArrayList<Card> playHand;
	private int handsPlayed = 0;
	private int ties = 0;
	private boolean hasWinner = false;
	private int warCount;
	public static final int DEFAULT_WAR_SIZE = 3;
        private String p1Result;
        private String p2Result;
        private String handResult;
        private String gameResult;

	public War(Deck player1Deck, Deck player2Deck) {
		playDeck = playDeck = new Deck(1, 23);
		player1 = player1Deck;
		p1TopCard = player1.getTopCard();
		player2 = player2Deck;
		p2TopCard = player2.getTopCard();
		warCount = DEFAULT_WAR_SIZE;
		playHand = new  ArrayList<>();
	}

	public War(long randomSeed, int numberOfDecks, int numberOfJokerPairs, int warSize) {
		playDeck = new Deck(numberOfDecks, numberOfJokerPairs, randomSeed);
		player1 = new Deck();
		player2 = new Deck();
		playHand = new ArrayList<>();
		warCount = warSize;
		playDeck.shuffleCards();
		Deck.dealCards(playDeck, player1, player2);
		p1TopCard = player1.getTopCard();
		p2TopCard  = player2.getTopCard();
	}

	public War (long randomSeed, int numberOfDecks, int numberOfJokerPairs) {
		this(randomSeed, numberOfDecks, numberOfJokerPairs, DEFAULT_WAR_SIZE);
	}

	public War (long randomSeed, int numberOfDecks) {
		this(randomSeed, numberOfDecks, numberOfDecks, DEFAULT_WAR_SIZE);
	}

	public War (long randomSeed) {
		this(randomSeed, 1, 1, DEFAULT_WAR_SIZE);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Deck: ").append(playDeck).append("\n\n");
		sb.append("Player 1: ");
		if (p1TopCard != null) {
			sb.append(p1TopCard).append(", ").append(player1);
		}
		sb.append("\n\n");
		sb.append("Player 2: ");
		if (p2TopCard != null){
			sb.append(p2TopCard).append(", ").append(player2);
		}
		sb.append("\n\n");
		return sb.toString();
	}

	public boolean gameOver() {
		return hasWinner;
	}

	public String printStats() {
		String returnString = "Hands played: " + handsPlayed;
		returnString = returnString.concat("Ties: " + ties);
                return returnString;
	}
        
        public String getP1Results() {
            return p1Result;
        }
        
        public String getP2Results() {
            return p2Result;
        }
        
        public void clearHand() {
            p1Result = "";
            p2Result = "";
            handResult = "";
            gameResult = "";
        
        }
        public String getGameResult() {
            return gameResult;
        }
        public String getHandResult() {
            return handResult;
        }
        public String getP1Size() {
            int size = (p1TopCard == null ? player1.getSize() :  player1.getSize() + 1);
            return Integer.toString(size);
        }
        
        public String getP2Size() {
            int size = (p2TopCard == null ? player2.getSize() :  player2.getSize() + 1);
            return Integer.toString(size);
        }
        
	public int playHand() {
		int result = Deck.playDeal(p1TopCard, p2TopCard);
                p1Result = p1Result.concat(p1TopCard.toString() + "\n");
                p2Result = p2Result.concat(p2TopCard.toString() + "\n");
		handsPlayed = (result != 0 ? ++handsPlayed : handsPlayed);
		playHand.add(p1TopCard);
		playHand.add(p2TopCard);
		if (result > 0 && !hasWinner){
			handResult = p1TopCard + " beats " +  p2TopCard;
			player1.addCards(playHand);
			playHand.clear();
			if (hasWinner()) {
				return result;
			}
		} else if (result < 0 && !hasWinner){
			handResult = p1TopCard + " loses to " + p2TopCard;
			player2.addCards(playHand);
			playHand.clear();
			if (hasWinner()) {
				return result;
			}
		} else if (result == 0){
                    p1Result = p1Result.concat("(ties)\n");
                    p2Result = p2Result.concat("(ties)\n");    
                    handResult = p1TopCard + " ties " + p2TopCard;
                    ties++;
                    for (int i = 0; i < warCount; i++) {
                            if (player1.getSize() == 0 && player2.getSize() != 0) {
                                    handsPlayed++;
                                    gameResult =  "Player 1 is out of cards.  Player 2 wins!";
                                    hasWinner = true;
                                    winPlayer2();
                                    result = -1;
                                    return result;
                            } else if (player2.getSize() == 0 && player1.getSize() != 0) {
                                    handsPlayed++;
                                    gameResult =  "Player 2 is out of cards.  Player 1 wins!";
                                    hasWinner = true;
                                    winPlayer1();
                                    result = 1;
                                    return result;
                            } else if (player1.getSize() == 0 && player2.getSize() == 0) {
                                    handsPlayed++;
                                    gameResult =  "Wow, unbelievable! The game tied!";
                                    hasWinner = true;
                                    result = -1;
                                    p1TopCard = null;
                                    p2TopCard = null;
                                    return result;
                            } else {
                                    p1TopCard = player1.getTopCard();
                                    p2TopCard = player2.getTopCard();
                                    if ( i <  warCount - 1 ) {
                                        p1Result = p1Result.concat("Add Card\n");
                                        p2Result = p2Result.concat("Add Card\n");
                                        playHand.add(p1TopCard);
                                        playHand.add(p2TopCard);
                                    }
                            }
                    }
                    return playHand();
		}

		// ready for a new hand
		p1TopCard = player1.getTopCard();
		p2TopCard  = player2.getTopCard();
		return result;
	}

	public void winPlayer1() {
		player1.addCards(playHand);
		playHand.clear();
		p1TopCard = null;
		p2TopCard = null;
		hasWinner = true;
	}

	public void winPlayer2() {
		player2.addCards(playHand);
		p1TopCard = null;
		p2TopCard = null;
		playHand.clear();
		hasWinner = true;
	}

	public boolean hasWinner() {
		if (player2.getSize() == 0){
			gameResult = "Player 2 is out of cards.  Player 1 wins!";
			winPlayer1();
			return true;
		}
		if (player1.getSize() == 0) {
			gameResult =  "Player 1 is out of cards.  Player 2 wins!";
			winPlayer2();
			return true;
		}
		return false;
	}

	public String myWarSize() {
		String returnString = "Player 1: " + getP1Size();
                returnString = returnString.concat("Player 1: " + getP2Size());
		returnString = returnString.concat(printStats());
                return returnString;
        }

	public static void WarTest() {
		ArrayList<Card> p1Cards = new ArrayList<>();
		ArrayList<Card> p2Cards = new ArrayList<>();

		p1Cards.add(new Card(Face.EIGHT, Suit.HEART));
		p1Cards.add(new Card(Face.NINE, Suit.CLUB));
		p1Cards.add(new Card(Face.SEVEN, Suit.HEART));
		p1Cards.add(new Card(Face.SIX, Suit.CLUB));
		p1Cards.add(new Card(Face.SIX, Suit.HEART));
		p1Cards.add(new Card(Face.JACK, Suit.CLUB));

		p2Cards.add(new Card(Face.EIGHT, Suit.DIAMOND));
		p2Cards.add(new Card(Face.TEN, Suit.DIAMOND));
		p2Cards.add(new Card(Face.KING, Suit.CLUB));
		p2Cards.add(new Card(Face.FIVE, Suit.HEART));
		p2Cards.add(new Card(Face.SEVEN, Suit.DIAMOND));


		Deck deck1 = new Deck(p1Cards);
		Deck deck2 = new Deck(p2Cards);
		War myWar = new War(deck1, deck2);
		myWar.playHand();
		}

    /**
     *
     * @param args
     */
    public static void main(String args[])  {
		
   }
}